package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class RMIModule {
	
	static String var;
	Module m1;
	
	public Module getModule(){
		return this.m1;
	}
	
	
	
	
	public String generateRMIModule(int rules,int facts, int in, int out){
		
		Program pr = new Program();
		m1 = new Module();
		var = GeneratorRandomString.getRandomBigChar(1);
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." +  "\n";
	
		s1 += module.generateAnnotationsModule(pr);
		
		List<String> input = makePredicate(in);
		List<String> output = makePredicate(out);
		
		
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);
		
		
		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);
		
		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);
		
		s1 += a1.generateAnnotationsInput(pr);
		
		
		List<Rule> r = makeRule();
		
		
		for(Rule r1: r){
			s1 += r1.generateOnlyRules(1, pr);
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());
			
		}
		
		List<RelationalAtoms> factsList = makeRelationalAtomsListFacts(facts);
		
		for(RelationalAtoms a: factsList){
			s1 += a.generateOnlyFacts(1, pr);
		}
		
		s1 += a1.generateAnnotationsOutput(pr);
		//System.out.println(s1);
	
		return s1;
			
	}
	
	
	
	
public String generateRMIModule(int rules,int facts, int in, int out, Module myModule){
		
		Program pr = new Program();
		m1 = myModule;
		var = GeneratorRandomString.getRandomBigChar(1);
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." +  "\n";
	
		s1 += module.generateAnnotationsModule(pr);
		
		
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation inherits = new Annotation(s);
		s1 += inherits.generateAnnotationsInheritance(pr, m1.getPrev().getName());
		
		
	
		
		List<String> input = makePredicate(in);
		List<String> output = makePredicate(out);
		
		
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);
		
		
		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);
		
		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);
		
		s1 += a1.generateAnnotationsInput(pr);
		
		
		List<Rule> r = makeRule();
		
		
		for(Rule r1: r){
			s1 += r1.generateOnlyRules(1, pr);
			
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());
			
		}
		
		List<RelationalAtoms> factsList = makeRelationalAtomsListFacts(facts);
		
		for(RelationalAtoms a: factsList){
			s1 += a.generateOnlyFacts(1, pr);
		}
		
		s1 += a1.generateAnnotationsOutput(pr);
		//System.out.println(s1);
	
		return s1;
			
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
	
	
	
	
	public List<Rule> makeRule(){
		
		List<Rule> ruleList = new ArrayList<>();
		
		int count = m1.getInputPredicate().size();
		
		for(String m : m1.getOutputPredicate()){
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s = GeneratorRandomString.getRandomString(randomNumber);
		Rule r = new Rule(s);
	
		RelationalAtoms head = generateRelationalAtomHead(m);
		r.setHead(head);
		
		//1.Fall 
		
			List<RelationalAtoms> body = makeRelationalAtomsList(count);
			r.setBody(body);
			
			if(count == 0) {
				count = m1.getInputPredicate().size();
			}else{
				count --;
				
			}
			
		ruleList.add(r);
		
		}
	
	return ruleList;
}
	
	
	public static RelationalAtoms generateRelationalAtomHead(String predicate){
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		RelationalAtoms atom = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));	
		
		atom.setPredicate(predicate);
		List<Term>t = generateTermsHead(1); 
		atom.setTerm(t);
		return atom;
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
	
	
	
	public List<RelationalAtoms> makeRelationalAtomsList(int count){
		List<RelationalAtoms> list = new ArrayList<>();	
					
		for(int i = 0; i< count; i++) {
				
			RelationalAtoms a = generateRelationalAtomBody(m1.getInputPredicate().get(i));
			list.add(a);

		}
		
		return list;
		
	}
	
	public static RelationalAtoms generateRelationalAtomBody(String name){
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		atom.setPredicate(name);
		List<Term>t = generateTermsHead(1);
		atom.setTerm(t);
		return atom;
	
}
	
	
	

	public static List<RelationalAtoms> makeRelationalAtomsListFacts(int count){
		List<RelationalAtoms> list = new ArrayList<>();	
					
		for(int i = 0; i< count; i++) {
				
			RelationalAtoms a = generateRelationalAtomFacts();
			list.add(a);

		}
		
		return list;
		
	}
	
	
	
	
	public static RelationalAtoms generateRelationalAtomFacts(){
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		
		atom.setPredicate(s);
		List<Term>t = generateTermsHead(1);
		atom.setTerm(t);
		return atom;
	
}

	
	
}
