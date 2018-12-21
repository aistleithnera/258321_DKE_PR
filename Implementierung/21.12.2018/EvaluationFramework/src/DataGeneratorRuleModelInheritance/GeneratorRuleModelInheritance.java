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


	public static String generateRMI(int rules, int facts, int terms) {

		RMICode = "";
		RMICode += generateProgram();
		RMICode += generateFacts(facts, terms);
		
		return RMICode;

	}
	
	
	//programm(namen) generieren
	
	public static String generateProgram() {
		program.setName("id1");
		return "program(\"" + program + "\")." +  "\n";
	}
	

	//fakten incl. terms generieren
	
	public static String generateFacts(int factsNum, int termsNum) {
		
		int factsCount = factsNum;
		int termsCount = termsNum;
		int termsInAtom = 0;
		
		String facts = "";
		
		//fakten generieren
		
	while(factsCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		RelationalAtoms a = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
		facts += "relationalAtom(\"" + a + "\"). \n";
		facts += "hasFact(\"" + program +"\",\"" + a + "\"). \n";
		facts += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
		
		factsCount--;
		
		termsInAtom = 0;
		
		//terms generieren
		
		int maxTerms = ThreadLocalRandom.current().nextInt(1, termsNum + 1) ;
		
		
		while(maxTerms > 0) {
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			facts += "term(\"" + t + "\"). \n";
			facts += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber) 
			+ "\"\"\"). \n";
			facts += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAtom + "). \n";
			
			maxTerms--;
			termsInAtom++;
			
		}//whileTerms
		
		termsCount = termsNum;
	
	}//whileFacts
		return facts;
	}
	
	
	//fakten incl. Terms generieren 
	
		public static String generateFacts(int factsNum, int termsNum, RelationalAtoms a) {
			
			int factsCount = factsNum;
			int termsCount = termsNum;
			int termsInAtom = 0;
			
			String facts = "";
			
			//fakten generieren
			
		while(factsCount > 0) {
			
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			RelationalAtoms atom = a;
			facts += "relationalAtom(\"" + atom + "\"). \n";
			facts += "hasName(\"" + atom + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
			
			factsCount--;
			
			termsInAtom = 0;
			
			//terms generieren
			
			int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1) ;
			
			
			while(i > 0) {
				
				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

				facts += "term(\"" + t + "\"). \n";
				facts += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber) 
				+ "\"\"\"). \n";
				facts += "hasArgument(\"" + atom + "\",\"" + t + "\"," + termsInAtom + "). \n";
				
				i--;
				termsInAtom++;
				
			}//whileTerms
			
			termsCount = termsNum;
		
		}//whileFacts
			return facts;
		}
	
	
	public static String generateRules2(int facts, int terms, int rulesNum) {
		
		String rules = "";
		int rulesCount = rulesNum;
		
		
		while(rulesCount > 0) {
			
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));
			
			rules+= "rule(\"" + r + "\").\n";
			rules+= "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveHeadAtom(\"" + r +"\",\"" + a1 + "\").\n";
			rules+= generateFacts(1, terms, a1);
			
			
			int factsCount = facts;
			
			while(factsCount > 0) {
				
				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
				rules+= generateFacts(1, terms, a2);
				
				factsCount--;
			}
			
			rulesCount--;
		}
		
		return rules;
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
