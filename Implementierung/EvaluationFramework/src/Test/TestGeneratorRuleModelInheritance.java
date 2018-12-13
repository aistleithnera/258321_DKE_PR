package Test;

import DataGenerators.GeneratorCBR;
import Exceptions.NegativeNumberException;
import RuleModelInheritance.GeneratorRuleModelInheritance;

public class TestGeneratorRuleModelInheritance {
	
	
	public static void main(String[] args) {

		
		// String text = GeneratorRandomString.getRandomString(5);
		String text = GeneratorRuleModelInheritance.generateRMI(5,3);
		System.out.println(text);
		
		
		

	}
	

}
