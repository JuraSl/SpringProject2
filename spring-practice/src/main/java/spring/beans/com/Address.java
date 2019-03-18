package spring.beans.com;

public class Address {

	private String address;
	private String index;
	public Address(String address, String index) {
		super();
		this.address = address;
		this.index = index;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", index=" + index + "]";
	}
	
	
}
