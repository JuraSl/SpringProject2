package spring.beans.com;

import javax.inject.Inject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class Robot {
	
	private String id = "Default robot";
	private String speach = "Hello! ";
	
	public void setId(String id) {
		this.id = id;
	}
	public void setSpeach(String speach) {
		this.speach = speach;
	}
	public void speak(){
		System.out.println(id + " " + speach);
	}

}
