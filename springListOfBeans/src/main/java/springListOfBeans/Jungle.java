package springListOfBeans;

import java.util.HashMap;
import java.util.Map;

public class Jungle {

	private Map<String, String> foods = new HashMap<String, String>();
	private Map<String, Animals> animals = new HashMap<String, Animals>();

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	public void setAnimals(Map<String, Animals> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		
        StringBuilder sb = new StringBuilder();
        sb.append("Property Maps" + "\n\n");
		
		for(Map.Entry<String, String> food: foods.entrySet()) {
			sb.append(food.getKey() + ": " + food.getValue() + "\n");
		}
		
		sb.append("\n" + "Arbitrary Maps as Bean Properties" + "\n\n");
		
		for(Map.Entry<String, Animals> animals: animals.entrySet()) {
			sb.append(animals.getKey() + ": " + animals.getValue() + "\n");
		}
		
		return sb.toString();

	}
	
	
}
