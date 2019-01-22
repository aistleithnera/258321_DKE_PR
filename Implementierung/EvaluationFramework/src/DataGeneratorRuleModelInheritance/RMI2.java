package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class RMI2 {
	
	Program program = new Program();
	public static RelationalAtoms a;   //id(weiblich), name(maja) input
	public static RelationalAtoms a1;  //id(frau), name(X)   head
	
	
	
	public static RelationalAtoms a2; //body
	
	

public static String generateOnlyFacts(int factsNum, int termsNum) {
		
		int factsCount = factsNum;
		int termsCount = termsNum;
		int termsInAtom = 0;
		
		String facts = "";
		
		//fakten generieren
		
	while(factsCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		a = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
		
		
		
		String id = GeneratorRandomString.getRandomString(randomNumber);
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String name = GeneratorRandomString.getRandomString(randomNumber);
		
		a.setName(name);
		facts += "relationalAtom(\"" + a + "\"). \n";
		facts += "hasFact(\"" + "m1" +"\",\"" + a + "\"). \n";
		facts += "hasName(\"" + a + "\",\"" + name + "\"). \n";
		
		factsCount--;
		
		termsInAtom = 0;
		
		//terms generieren
	
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			
			String predicate = GeneratorRandomString.getRandomString(randomNumber);
			t.setSerialization(predicate);
			a.setPredicate(predicate);

			facts += "term(\"" + t + "\"). \n";
			facts += "hasSerialization(\"" + t + "\",\"\"\"" +  predicate
			+ "\"\"\"). \n";
			facts += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAtom + "). \n";
			
		
		termsCount = termsNum;
	
	}//whileFacts
		return facts;
	}
	
	
	
public static String generateOnlyRules(int factsNum, int termsNum, int rulesNum) {
	
	String rules = "";
	int rulesCount = rulesNum;
	
	
	while(rulesCount > 0) {
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));
		
		rules+= "rule(\"" + r + "\").\n";
		rules+= "hasRule(\"" + "m1" + "\",\"" + r + "\").\n";
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s1 = GeneratorRandomString.getRandomString(randomNumber);
		a1 = new RelationalAtoms(s1);
		
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String name = GeneratorRandomString.getRandomString(randomNumber);
		rules+= "hasPositiveHeadAtom(\"" + r +"\",\"" + a1 + "\").\n";
		rules += "relationalAtom(\"" + a1 + "\"). \n";
		rules += "hasName(\"" + a1 + "\",\"" + name + "\"). \n";
		
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		
		
		String predicate = GeneratorRandomString.getRandomBigChar(1);
		t.setSerialization(predicate);
		a1.setName(predicate);

		rules += "term(\"" + t + "\"). \n";
		rules += "hasSerialization(\"" + t + "\",\"" +  predicate
		+ "\"). \n";
		rules += "hasArgument(\"" + a1 + "\",\"" + t + "\"," + 0 + "). \n";
		
		
	
		int factsCount = factsNum;
		
		while(factsCount > 0) {
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			
			a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules+= "hasPositiveBodyAtom(\"" + r +"\",\"" + a2 + "\").\n";
		
			
			rules += "relationalAtom(\"" + a2 + "\"). \n";
			rules += "hasName(\"" + a2 + "\",\"" + a.getName() + "\"). \n";
			
			
			Term t2 = new Term(GeneratorRandomString.getRandomString(randomNumber));
			
			t2.setSerialization(predicate);
			a1.setPredicate(predicate);

			rules += "term(\"" + t + "\"). \n";
			rules += "hasSerialization(\"" + t + "\",\"" +  a1.getPredicate()
			+ "\"). \n";
			rules += "hasArgument(\"" + a2 + "\",\"" + t + "\"," + 0 + "). \n";
			
			
			
			factsCount--;
		}
		
		rulesCount--;
	}
	
	return rules;
}//generateOnlyRules



	


	



	
	
	

}

