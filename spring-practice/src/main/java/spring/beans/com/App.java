package spring.beans.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/beans/com/beans/beans.xml");
		
		// getting beans from container passing an id "person"
		Person person = (Person)context.getBean("person");
		
		person.setTaxId(777);
		System.out.println(person);
		
		
		Address address = (Address)context.getBean("address2");
		System.out.println("\n" + address);
		
		// closing resources
		((ClassPathXmlApplicationContext)context).close();
	}

}
