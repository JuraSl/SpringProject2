package spring.beans.com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {
		
		
		// Creating spring-bean container
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/beans/com/beans/beans.xml");
		
		// getting beans from container passing an id "person"
		OffersDao offersDao = (OffersDao)context.getBean("offersDao");
		try{
			List<Offers> list = offersDao.getOffers();		
		    for(Offers offer: list){
			   System.out.println(offer);
			   }
		    }
		    catch(CannotGetJdbcConnectionException ex){
		    	System.out.println(ex.getMessage());
		    }catch(DataAccessException ex){
		    	System.out.println(ex.getMessage());
		    	System.out.println(ex.getClass());
		    }
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
