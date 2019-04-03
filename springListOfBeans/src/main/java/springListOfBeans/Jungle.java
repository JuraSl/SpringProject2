package springListOfBeans;

import java.util.HashMap;
import java.util.Map;

public class Jungle {

	private Map<String, String> foods = new HashMap<String, String>();

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		
        StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<String, String> food: foods.entrySet()) {
			sb.append(food.getKey() + ": " + food.getValue() + "\n");
		}
		
		return sb.toString();

	}
	
	
}
