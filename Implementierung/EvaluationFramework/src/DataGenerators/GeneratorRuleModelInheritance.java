package DataGenerators;

import java.util.concurrent.ThreadLocalRandom;

import Exceptions.NegativeNumberException;

public class GeneratorRuleModelInheritance {
	
	private static String RMICode; 
	private static String program;
	
	public static String generateRMI(int rules, int facts) throws NegativeNumberException {

		if (rules <= 0)
			throw new NegativeNumberException("Negative numbers not allowed!");

		RMICode = "";
		RMICode += generateProgram();
		RMICode += generateRules(rules);
		RMICode += generateRelationalsAtoms(facts);
		RMICode += generateNonRelationalAtoms(facts);
		RMICode += generateAnnotation();
		RMICode += generateTerms();
		
		return RMICode;

	}
	
	private static String generateProgram() {
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		program = GeneratorRandomString.getRandomString(randomNumber);
		return "program(" + program + ").";
		
	}
	
	private static String generateRules(int rules) {
		return "";
	}
	
	private static String generateRelationalsAtoms(int facts) {
		return "";
	}

	private static String generateNonRelationalAtoms(int facts){
		return "";
	}
	
	private static String generateAnnotation(){
		return "";
	}
	
	private static String generateTerms(){
		return "";
	}
}
