package Test;

import DataGeneratorCBR.GeneratorCBR;
import DataGeneratorRuleModelInheritance.GeneratorRuleModelInheritance;
import Exceptions.NegativeNumberException;

public class TestGeneratorRuleModelInheritance {
	
	
	public static void main(String[] args) {

		String text = GeneratorRuleModelInheritance.generateProgram() + 
				      GeneratorRuleModelInheritance.generateRules2(2,4,2);
		
		System.out.println(text);
		
		
		
	
		
		
		

	}
	

}
