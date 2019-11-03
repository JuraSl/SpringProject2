package spring.beans.com;

import java.util.Random;

public class RandomText {
	
	public static String[] texts = {"Hello! ",
			"My name is Verter.",
			"I need you serial number for indentification."};
	
	public String getText(){
		Random random = new Random();
		return texts[random.nextInt(texts.length)];
	}
}
