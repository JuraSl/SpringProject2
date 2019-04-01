package springListOfBeans;

import java.util.List;

public class Jungle {

	private Animals largest;
	private List<Animals> animals;

	public Animals getLargest() {
		return largest;
	}

	public void setLargest(Animals largest) {
		this.largest = largest;
	}

	public List<Animals> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animals> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		
        StringBuilder sb = new StringBuilder();
		
		sb.append("Largest: " + largest);
		sb.append("\n");
		sb.append("Others:\n");
		
		for(Animals animal: animals) {
			sb.append(animal);
			sb.append("\n");
		}
		
		return sb.toString();

	}
	
	
}
