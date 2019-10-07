package lk.chathurabuddi.selenium.demo.dto;

import java.util.List;

public class User implements BaseDto{
	
	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void mapValues(List<String> valueArr) {
		if(valueArr.size() > 0) this.email = valueArr.get(0);
		
		if(valueArr.size() > 1) this.password = valueArr.get(1);
	}

}
