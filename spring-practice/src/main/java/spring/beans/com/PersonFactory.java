package spring.beans.com;

public class PersonFactory {

	public Person createPerson(int id, String name){
		System.out.println("Create Person using factory class");
		return new Person(id, name);
	}
}
