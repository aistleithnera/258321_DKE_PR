package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;
import Exceptions.NegativeNumberException;

public class GeneratorRuleModelInheritance {
	
	private static String RMICode; 
	private static Program program = new Program();
	
	
	private static List <String> nonRelationalAtoms;
	private static List <String> annotations;
	private static List <String> terms;


	public static String generateRMI(int rules, int facts) {

		RMICode = "";
		RMICode += generateProgram();
		RMICode += generateRules(rules);
		RMICode += generateRelationalsAtoms(rules);
		RMICode += generateNonRelationalAtoms(facts);
		RMICode += generateAnnotation(rules);
		RMICode += generateTerms();
		
		return RMICode;

	}
	
	private static String generateProgram() {
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		program.setName(GeneratorRandomString.getRandomString(randomNumber));
		return "program(" + program + ")." +  "\n";
		
	}
	
	private static String generateRules(int nrRules) {
		
		System.out.println(nrRules+" this");
		
		String generatedRules = "";
		for(int i = 0; i<nrRules; i++){
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			program.getRules().add(new Rule(GeneratorRandomString.getRandomString(randomNumber)));
		}
		
		for(Rule r: program.getRules()){
			generatedRules += "hasRule(" + program + "," + r + ")  " +  "\n";
		}

		for(Rule r:program.getRules()){
			generatedRules += "rule(" + r + ")." +  "\n";
		}
		return generatedRules;
	}
	
	private static String generateRelationalsAtoms(int nrRules) {
		String generatedRelationalAtoms = "";
		
		
		for(int i = 0; i< nrRules; i++){
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			program.getAllRelationalAtoms().add(new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber)));
		}
		
		for(RelationalAtoms r: program.getAllRelationalAtoms()){
			generatedRelationalAtoms += "relationalAtom(" + r  + ").  " +  "\n";
		}
		
		List<RelationalAtoms> list = new ArrayList<>();
		for(RelationalAtoms r: program.getAllRelationalAtoms()){
			list.add(r);				
			
		}
		
		if(nrRules == 1) {
			
			
			
			
			
		}else if(nrRules == 2) {
			
			
			
			
		}else {
			
		

		
	
		for(int i = 0; i< program.getRules().size(); i++) {
			
			
			int random = ThreadLocalRandom.current().nextInt(0, list.size()-1);
				generatedRelationalAtoms += "hasPositiveHeadAtom(" + program.getRules().get(i) +"," +  list.get(random) + ")."+  "\n";
				program.getRules().get(i).getRelationalAtomsHead().add(list.get(random));
				list.remove(random);
			
				random = (int)(Math.random() * list.size() - 1);
				int count = 0;
				while (count < 2) {
					
					generatedRelationalAtoms += "hasPositiveBodyAtom(" + program.getRules().get(i) +"," +  list.get(random) + ")."+  "\n";
					program.getRules().get(i).getRelationalAtomsBody().add(list.get(random));
					count ++;
					list.remove(random);
					random = (int)(Math.random() * list.size() - 1);

				}
				count = 0;
			}	
		}//else not 1 or 2
		
		return generatedRelationalAtoms;
	}

	private static String generateNonRelationalAtoms(int facts){
		return "";
	}
	
	private static String generateAnnotation(int nrRules){
		String generatedAnnotations = "";
		
		
		for(int i = 0; i<nrRules; i++){
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			program.getAllAnnotations().add(new Annotation(GeneratorRandomString.getRandomString(randomNumber)));
		}
		
		for(Annotation a: program.getAllAnnotations()){
			generatedAnnotations += "annotation(" + a + ")." +  "\n";
		}
	
		
		return generatedAnnotations;
	}
	
	private static String generateTerms(){
		String generatedTerms = "";
		
		
		
		return generatedTerms;
	}
}
