package spring.beans.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// Creating spring-bean container
				ApplicationContext context = new ClassPathXmlApplicationContext("/springbeans/beans.xml");

				FruitBasket basket = (FruitBasket)context.getBean("fruitBasket");
				System.out.println(basket);
				
				// closing resources
				((ClassPathXmlApplicationContext)context).close();
	}

}
