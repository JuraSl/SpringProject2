package springListOfBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("springBeans/beans.xml");

		Jungle jungle = (Jungle)context.getBean("jungle");
		System.out.println(jungle);
		
		// closing resources
		((ClassPathXmlApplicationContext)context).close();

	}

}
