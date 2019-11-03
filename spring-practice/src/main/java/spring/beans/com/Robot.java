package spring.beans.com;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class Robot {
	
	private int id = 0;
	private String speach = "Hello! ";
	
	@Autowired
	public void setId(@Value("#{111}")int id) {
		this.id = id;
	}
	@Autowired
	public void setSpeach(@Value("#{new java.util.Date().toString()}")String speach) {
		this.speach = speach;
	}
	public void speak(){
		System.out.println(id + " " + speach);
	}

}
