package Test;

import DataGenerators.GeneratorCBR;
import Exceptions.NegativeNumberException;

public class TestGeneratorCBR {

	public static void main(String[] args) {

		try {
			
		// String text = GeneratorRandomString.getRandomString(5);
		String text = GeneratorCBR.generateCBRCode(5);
		System.out.println(text);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			if(e.getClass().equals(NegativeNumberException.class)) {
				System.out.println("Please consider only positive numbers (including the zero).");
			}
		}

	}

}
