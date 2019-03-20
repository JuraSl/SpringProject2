package spring.beans.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/beans/com/beans/beans.xml");
		
		// getting beans from container passing an id "person"
		Person person1 = (Person)context.getBean("person");
		Person person2 = (Person)context.getBean("person");
		person1.speak();
		person1.setTaxId(777);
		System.out.println(person2);
		
		/*
		Address address = (Address)context.getBean("address");
		System.out.println(address);*/
		
		// closing resources
		((ClassPathXmlApplicationContext)context).close();
	}

}
