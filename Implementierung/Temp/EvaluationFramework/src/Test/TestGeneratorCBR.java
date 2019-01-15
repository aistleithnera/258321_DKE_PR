package Test;

import DataGeneratorCBR.GeneratorCBR;
import Exceptions.NegativeNumberException;

public class TestGeneratorCBR {

	public static void main(String[] args) {

//		try {
//			
//		// String text = GeneratorRandomString.getRandomString(5);
//		String text = GeneratorCBR.generateCBRCode(5);
//		System.out.println(text);
//		
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			
//			if(e.getClass().equals(NegativeNumberException.class)) {
//				System.out.println("Please consider only positive numbers (including the zero).");
//			}
//		}
		
		System.out.println(GeneratorCBR.generateCBRCode(3, 4, 5));

	}

}
