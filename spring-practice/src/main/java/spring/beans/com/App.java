package spring.beans.com;

import java.util.ArrayList;
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
		OffersDao offersDao = (OffersDao) context.getBean("offersDao");
/*
		Offers updatedOffer = new Offers(11, "Olga", "olga@gmail.com", "Payroll services");
		if(offersDao.update(updatedOffer)){
			System.out.println("Offer updated succesfully");
		}else{
			System.out.println("Offer did not updated");
		}*/
		try {
			
			List<Offers> offerList = new ArrayList<Offers>();
			offerList.add(new Offers(1, "Anastacia", "anastacia@gmail.com", "design creator"));
			offerList.add(new Offers(2, "Alina", "alina@gmail.com", "web rendering"));
			
			int[] circuit = offersDao.create(offerList);
			for(int value: circuit){
				System.out.println("Updated " + value + " row");
			}
			
			/*
			// Getting Placeholder Values from Beans by adding constructors to
			// Offers object and creating new
			// method.create to update table list
			Offers offer1 = new Offers("Sergei", "sergei@gamil.com", "Testing code");
			Offers offer2 = new Offers("Andrew", "andrew@gamil.com", "Writes javascript");
			if (offersDao.create(offer1)) {
				System.out.println("Created offer1");
			}
			;
			if (offersDao.create(offer2)) {
				System.out.println("Created offer2");
			};

			// deleting data(row) from the table
			offersDao.delete(9);

			// list of objects
			List<Offers> list = offersDao.getOffers();
			for (Offers offer : list) {
				System.out.println(offer);
			}

			// just getting an object from the table by sending a query using an
			// id
			Offers offer = offersDao.getOffer(2);
			System.out.println("Offer for Mick " + offer);*/

		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println(ex.getMessage());
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
