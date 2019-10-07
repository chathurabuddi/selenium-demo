package lk.chathurabuddi.selenium.demo.dto;

import java.util.List;

public class ContactInfo implements BaseDto{
	
	private long id;
	
	private String name;
	
	private String email;
	
	private String contactNo;
	
	private String subject;
	
	private String message;
	
	
	public long getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}



	public String getEmail() {
		return email;
	}



	public String getContactNo() {
		return contactNo;
	}



	public String getSubject() {
		return subject;
	}



	public String getMessage() {
		return message;
	}



	public void mapValues(List<String> valueArr) {
		
		if(valueArr.size()>1) this.id = Long.parseLong(valueArr.get(0));
		
		if(valueArr.size()>2) this.name = valueArr.get(1);
		
		if(valueArr.size()>3) this.email = valueArr.get(2);
		
		if(valueArr.size()>4) this.contactNo = valueArr.get(3);
		
		if(valueArr.size()>5) this.subject = valueArr.get(4);
		
		if(valueArr.size()>6) this.message = valueArr.get(5);
	}

}
