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


	
	//programm(namen) generieren
	
	public static String generateProgram() {
		program.setName("id1");
		return "program(\"" + program + "\")." +  "\n";
	}
	

	//fakten incl. terms generieren
	
	public static String generateOnlyFacts(int factsNum, int termsNum) {
		
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
	
		public static String generateFactsFromRules(int factsNum, int termsNum, RelationalAtoms a) {
			
			int factsCount = factsNum;
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
			
		
		
		}//whileFacts
			return facts;
		}//fakten incl. Terms generieren 
		
		
		
		//fakten incl. Terms generieren 
		
			public static String generateNonRelationalFactsFromRules(int factsNum, int termsNum, NonRelationalAtom a) {
				
				int factsCount = factsNum;
				int termsInAtom = 0;
				
				String facts = "";
				
				//fakten generieren
				
			while(factsCount > 0) {
				
				int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				NonRelationalAtom atom = a;
				facts += "nonRelationalAtom(\"" + atom + "\"). \n";
				facts += "hasName(\"" + atom + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
				
				factsCount--;
				
				termsInAtom = 0;
				
				//terms generieren
				
				int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1) ;
				
				
				while(i > 0) {
					
					randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
					
					facts += "hasSerialization(\"" + atom + "\",\"" + GeneratorRandomString.getRandomBigChar(1) + "=" + "\"\"" + 
					                                               GeneratorRandomString.getRandomString(randomNumber) + "\"\"\"). \n";
					
					
					i--;
					termsInAtom++;
					
				}//whileTerms
				
			
			
			}//whileFacts
				return facts;
			}//generateNonRelationalFactsFromRules
		
		
			public static String generateFactsFromAnnotations(int termsNum, Annotation anno) {
				
				
				int termsInAtom = 0;
				
				String facts = "";
				
				//fakten generieren
				
		
				int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
	
				Annotation a = anno;
				RelationalAtoms atom = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				
				facts += "relationalAtom(\"" + a + "\"). \n";
				facts += "hasName(\"" + atom + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
				facts += "hasFact(\"" + program +"\",\"" + atom + "\"). \n";
				
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
				
				facts += "hasAnnotation(\"" + atom + "\",\"" + a + "\"). \n";
				facts += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
				
				return facts;
			}
		
		

		
	public static String generateOnlyRules(int factsNum, int termsNum, int rulesNum) {
		
		String rules = "";
		int rulesCount = rulesNum;
		
		
		while(rulesCount > 0) {
			
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));
			
			rules+= "rule(\"" + r + "\").\n";
			rules+= "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveHeadAtom(\"" + r +"\",\"" + a1 + "\").\n";
			rules+= generateFactsFromRules(1, termsNum, a1);
			
			
			int factsCount = factsNum;
			
			while(factsCount > 0) {
				
				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
				rules+= generateFactsFromRules(1, termsNum, a2);
				
				factsCount--;
			}
			
			rulesCount--;
		}
		
		return rules;
	}//generateOnlyRules
	
	
public static String generatePositiveAndNegativeRules(int rulesNum, int termsNum, int positiveBodyNum, int negativeBodyNum) {
		
		String rules = "";
		int rulesCount = rulesNum;
		int positiveBodyCount = positiveBodyNum;
		int negativeBodyCount = negativeBodyNum;
		
		
		while(rulesCount > 0) {
			
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));
			
			rules+= "rule(\"" + r + "\").\n";
			rules+= "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveHeadAtom(\"" + r +"\",\"" + a1 + "\").\n";
			rules+= generateFactsFromRules(1, termsNum, a1);
			
			while(positiveBodyCount > 0) {
				
				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
				rules+= generateFactsFromRules(1, termsNum, a2);
				
				positiveBodyCount--;
			}
			
            while(negativeBodyCount > 0) {
				
				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules+= "hasNegativeBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
				rules+= generateFactsFromRules(1, termsNum, a2);
				
				negativeBodyCount--;
			}
			
			rulesCount--;
		}
		
		return rules;
	}//generatePositiveAndNegativeRules


public static String generateRulesWithNonRelationalAtoms(int rulesNum, int termsNum, int relationalAtomNum, int nonRelationalAtomNum) {
	
	String rules = "";
	int rulesCount = rulesNum;
	int relationalAtomCount = relationalAtomNum;
	int nonRelationalAtomCount = nonRelationalAtomNum;
	
	
	while(rulesCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));
		
		rules+= "rule(\"" + r + "\").\n";
		rules+= "hasRule(\"" + program + "\",\"" + r + "\").\n";
		RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
		rules+= "hasPositiveHeadAtom(\"" + r +"\",\"" + a1 + "\").\n";
		rules+= generateFactsFromRules(1, termsNum, a1);
		
		while(relationalAtomCount > 0) {
			
			RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
			rules+= generateFactsFromRules(1, termsNum, a2);
			
			relationalAtomCount--;
		}
		
        while(nonRelationalAtomCount > 0) {
			
			NonRelationalAtom a2 = new NonRelationalAtom(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
			rules+= generateNonRelationalFactsFromRules(1, termsNum, a2);
			
			nonRelationalAtomCount--;
		}
		
		rulesCount--;
	}
	
	return rules;
}//generateRulesNonRelationalAtoms
	
	
    public static String generateAnnotationsFromRules(int factsNum, int termsNum, Annotation a) {
		
		String rules = "";

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));
			
			rules+= "rule(\"" + r + "\").\n";
			rules+= "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveHeadAtom(\"" + r +"\",\"" + a1 + "\").\n";
			rules+= generateFactsFromRules(1, termsNum, a1);
			
			
			int factsCount = factsNum;
			
			while(factsCount > 0) {
				
				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
				rules+= generateFactsFromRules(1, termsNum, a2);
				
				factsCount--;
			}
			
			rules += "hasAnnotation(\"" + r + "\",\"" + a + "\"). \n";
			rules += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
		
		
		return rules;
	}
	
	
	public static String generateOnlyAnnotations(int annoNum, int termsNum){
		
		int annoCount = annoNum;
		
		String generatedAnnotations = "";
		
		while(annoCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "annotation(\"" + a + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + program +"\",\"" + a + "\"). \n";
		generatedAnnotations += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
		

		annoCount--;
		
		
		//terms generieren
		
		int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1) ;
		int termsInAnno = 0;
		
		while(i > 0) {
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber) 
			+ "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAnno + "). \n";
			
			i--;
			termsInAnno++;
			
		}//whileTerms
		

		}//whileAnnoCount
		

		return generatedAnnotations;
	}

	//generate linked Annotations (with Facts, rules etc.)
	
    public static String generateAnnotationsWithFacts(int annoNum, int annoTermNum, int factTermNum){
		
		int annoCount = annoNum;
		
		String generatedAnnotations = "";
		
		while(annoCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "annotation(\"" + a + "\"). \n";
		
		generatedAnnotations += generateFactsFromAnnotations(factTermNum, a);
		
		annoCount--;
		
		
		//terms generieren
		
		int i = ThreadLocalRandom.current().nextInt(1, factTermNum + 1) ;
		int termsInAnno = 0;
		
		while(i > 0) {
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber) 
			+ "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAnno + "). \n";
			
			i--;
			termsInAnno++;
			
		}//whileTerms
		

		}//whileAnnoCount
		

		return generatedAnnotations;
	}

	
//generate linked Annotations (with Facts, rules etc.)
	
    public static String generateAnnotationsWithRules(int annoNum, int terms, int ruleFacts){
		
		int annoCount = annoNum;
		
		String generatedAnnotations = "";
		
		while(annoCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "annotation(\"" + a + "\"). \n";
		
		generatedAnnotations += generateAnnotationsFromRules(ruleFacts, terms, a);
		
		annoCount--;
		
		
		//terms generieren
		
		int i = ThreadLocalRandom.current().nextInt(1, terms + 1) ;
		int termsInAnno = 0;
		
		while(i > 0) {
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber) 
			+ "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAnno + "). \n";
			
			i--;
			termsInAnno++;
			
		}//whileTerms
		

		}//whileAnnoCount
		

		return generatedAnnotations;
		
	}//generateAnnotationsWithRules
    
    
    
    
    
    
    
    
    
    
    
    
    
	/*
	 * old methods!
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
	
	*/ // old methods
	
}
