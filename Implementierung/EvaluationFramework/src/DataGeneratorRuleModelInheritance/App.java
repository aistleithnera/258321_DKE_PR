package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class App {
	 
	static List<String> l;
	static Module m1;
	static String var;
	
	public static void main (String [] args){
			
			Program pr = new Program();
			var = GeneratorRandomString.getRandomBigChar(1); 
	    	l = makePredicate(2);
	    	m1 = makeModel();
	        String s = "program(\"" + "m1" + "\")." +  "\n";
	        s+=m1.getI().generateOnlyFacts(1, pr);
	        for(Rule r1 : m1.getRules()) {
	        	 s  += r1.generateOnlyRules(1, pr);
	        	
	        }
	        
	        if(m1.getI().getPredicate().equals(m1.getRules().get(0).getRelationalAtomsBody().get(0).getPredicate())){
	        	RelationalAtoms output = generateOutput();
	        	m1.setO(output);
	        	
	        }
	        
	        s += m1.getO().generateOnlyFacts(1,pr);
	        System.out.println(s);
	                
	}
	
	public static List<Term> generateTerms(int nr){
		List<Term> t = new ArrayList<>();
		int count = 0;
		while(count < nr){
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t1 = new Term(GeneratorRandomString.getRandomString(randomNumber));
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String serialization = GeneratorRandomString.getRandomString(randomNumber); 
		    t1.setSerialization(serialization);
		    t.add(t1);
			count ++;
		}
		
		
		return t;
	}
	
	
	public static List<Term> generateTermsHead(int nr){
		List<Term> t = new ArrayList<>();
		int count = 0;
		while(count < nr){
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t1 = new Term(GeneratorRandomString.getRandomString(randomNumber));
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		    t1.setSerialization(var);
		    t.add(t1);
			count ++;
		}
		return t;
	}
	
	
	public static RelationalAtoms generateRelationalAtomHead(){
		
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String	predicate = GeneratorRandomString.getRandomString(randomNumber);
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			RelationalAtoms atom = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));	
			atom.setPredicate(predicate);
			List<Term>t = generateTermsHead(1); 
			atom.setTerm(t);
			return atom;
	}
	
	
	

	public static RelationalAtoms generateRelationalAtom(){
		
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
		
	
			RelationalAtoms atom = new RelationalAtoms(s);
			
			randomNumber = ThreadLocalRandom.current().nextInt(0, l.size()-1);
			atom.setPredicate(l.get(randomNumber));
			List<Term>t = generateTerms(1); 
			atom.setTerm(t);
			return atom;
		
	}
	
	
	public static RelationalAtoms generateRelationalAtomBody(){
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		
		randomNumber = ThreadLocalRandom.current().nextInt(0, l.size()-1);
		atom.setPredicate(l.get(randomNumber));
		
		List<Term>t = generateTermsHead(1);
		atom.setTerm(t);
		return atom;
	
}
	
	
	public static List<RelationalAtoms> makeRelationalAtomsList(int nr){
		List<RelationalAtoms> list = new ArrayList<>();
		int count = 0;
		while(count < nr){
			RelationalAtoms a = generateRelationalAtomBody();
			list.add(a);
			count ++;
		}
		
		return list;
		
	}
	
	
	public static List<String> makePredicate(int nr){
		List<String> l = new ArrayList<>();
		int count = 0;
		while (count < nr){
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String	s = GeneratorRandomString.getRandomString(randomNumber);
			l.add(s);
			count ++;
		}
		return l;
	}
	
	
	public static Rule makeRule(){
		
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String	s = GeneratorRandomString.getRandomString(randomNumber);
			Rule r = new Rule(s);
			
			RelationalAtoms head = generateRelationalAtomHead();
			r.setHead(head);
			List<RelationalAtoms> list = makeRelationalAtomsList(1);
			r.setBody(list);	
		
		return r;
	}
	
	public static Module makeModel() {
		Module m1 = new Module("m1");
		RelationalAtoms a = generateRelationalAtom();
	    m1.setI(a);
		Rule r = makeRule();
		List <Rule> listRule = new ArrayList<>();
		listRule.add(r);
		m1.setRules(listRule);
       
		
		return m1;
	}
	
	public static RelationalAtoms generateOutput(){
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms output = new RelationalAtoms(s);
    	output.setPredicate(m1.getRules().get(0).getHead().getPredicate());
    	randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
    	List<Term>t = m1.getI().getTerm();
		output.setTerm(t);
    	return output;
	
	}
	
}
