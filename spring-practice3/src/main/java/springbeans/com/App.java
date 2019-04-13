package springbeans.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	public static void main(String[] args) {
		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_Beans/beans.xml");

	    Logger logger = (Logger)context.getBean("logger");
		//System.out.println(logger);
				
		logger.writeConsole("Hello!");
		logger.writeFile("Hello again");
				
		// closing resources
		((ClassPathXmlApplicationContext)context).close();


	}

}
