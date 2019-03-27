package spring.beans.com;

import java.util.List;

public class FruitBasket {

	private String name;
	private List<String> fruits;
	
	public FruitBasket(String name, List<String> fruits) {
		this.name = name;
		this.fruits = fruits;
	}


	public String toString() {
		
		StringBuilder list = new StringBuilder();
		list.append(name);
		list.append(" Fruit Basket contains:" + "\n");
		
		for(String fruit: fruits){
			list.append(fruit);
			list.append("\n");
		}
		
		return list.toString();
	}
	
	
}
