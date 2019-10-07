package lk.chathurabuddi.selenium.demo;


import java.io.IOException;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lk.chathurabuddi.selenium.demo.dto.ContactInfo;
import lk.chathurabuddi.selenium.demo.util.CsvUtil;

public class ContactPageTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/chathurabuddi/chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	@Test(dataProvider = "userData")
    public void testContactForm(ContactInfo contactInfo) {
       System.out.println("testing data id=" + contactInfo.getId());
       
       driver.navigate().to("http://www.anomaopticians.lk/contact-us.html");
       
       driver.findElement(By.id("name")).sendKeys(contactInfo.getName());
       driver.findElement(By.id("email")).sendKeys(contactInfo.getEmail());
       driver.findElement(By.id("phone")).sendKeys(contactInfo.getContactNo());
       driver.findElement(By.id("subject")).sendKeys(contactInfo.getSubject());
       driver.findElement(By.id("inquiry")).sendKeys(contactInfo.getMessage());
       
       driver.findElement(By.id("submit")).click();
       
       Assertions.assertThat(driver.findElement(By.id("name"))).isEqualTo("Chathuri");
    }
	
	
	@DataProvider(name = "userData")
    public Object[][] contactInfoDataProvider() throws IOException, InstantiationException, IllegalAccessException {
		
		List<ContactInfo> contactInfoData = new CsvUtil<ContactInfo>().getCsvData("data.csv", ContactInfo.class);
 
        Object[][] arr = new Object[contactInfoData.size()][1];
 
        for(int i =0; i < contactInfoData.size();i++){
            arr[i][0] = contactInfoData.get(i);
        }
 
        return arr;
    }
	
}
