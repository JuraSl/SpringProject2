package spring.beans.com;

public class Person {
	
	
	private int id;
	private String name;
	private int taxId;
	private Address address; 
	
	public Person(){}
	
	public Person(int id, String name) {		
		this.id = id;
		this.name = name;
	}
	
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// init method
	public void onCreate(){
		System.out.println("Person created: " + this );
	}
	
	// destroy method
	public void onDestroy(){
		System.out.println("Person destroyed");
	}
	
	// factory method
	public static Person getInstance(int id, String name){
		System.out.println("Create an instanace using factory method");
		return new Person(id, name);
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
	}

	
	
	
	
}
