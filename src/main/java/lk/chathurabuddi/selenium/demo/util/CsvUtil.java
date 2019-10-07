package lk.chathurabuddi.selenium.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import lk.chathurabuddi.selenium.demo.dto.BaseDto;

public class CsvUtil<T extends BaseDto> {
	
	public List<T> getCsvData(String fileName, Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException {

        List<T> userData = new ArrayList<T>();
 
        BufferedReader bReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + fileName)));
 
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(bReader);
        
        for (CSVRecord record : records) {
        	
        	List<String> values = new ArrayList<String>();
        	
        	Iterator<String> recordIterator = record.iterator();
        	while (recordIterator.hasNext()) {
        		values.add(recordIterator.next());
        	}
        	
        	
        	T dto = clazz.newInstance();
        	
        	dto.mapValues(values);
        	userData.add(dto);
        }
        return userData;
    }
}
