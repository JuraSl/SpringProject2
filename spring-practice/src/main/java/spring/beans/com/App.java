package spring.beans.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// Beans - normal java obects
		// Creates spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/beans/com/beans/beans.xml");
		
		// get beans from container passing an id "person"
		Person person = (Person)context.getBean("person");
		person.speak();
		
		System.out.println(person);
		// close resources
		((ClassPathXmlApplicationContext)context).close();
	}

}
