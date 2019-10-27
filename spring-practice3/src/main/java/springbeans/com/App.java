package springbeans.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	public static void main(String[] args) {
		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_Beans/beans.xml");

		Logger log = (Logger) context.getBean("logger");
				
		log.printToConsole("Printing ");
		log.printToFile("Printing ");
				
		// closing resources
		((ClassPathXmlApplicationContext)context).close();


	}

}
