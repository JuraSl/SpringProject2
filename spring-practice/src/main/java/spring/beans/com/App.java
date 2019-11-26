package spring.beans.com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/beans/com/beans/beans.xml");
		
		// getting beans from container passing an id "person"
		OffersDao offersDao = (OffersDao)context.getBean("offersDao");
		
		List<Offers> list = offersDao.getOffers();
		
		for(Offers offer: list){
			System.out.println(offer);
		}
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
