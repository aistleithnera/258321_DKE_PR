package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class RMIModule {

	static String var;
	Module m1;

	public Module getModule() {
		return this.m1;
	}

	// generate base Module
	public String generateRMIModule(int rules, int facts, int in, int out) {

		Program pr = new Program();
		m1 = new Module();
		var = GeneratorRandomString.getRandomBigChar(1);

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." + "\n";

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

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		}

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		}

		s1 += a1.generateAnnotationsOutput(pr);
		// System.out.println(s1);

		return s1;

	}// generate base Module

	
	
	
	// generate inherited Module
	public String generateRMIModule(int rules, int facts, int in, int out, Module myModule) {

		Program pr = new Program();
		var = GeneratorRandomString.getRandomBigChar(1);
		m1 = new Module();

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." + "\n";

		s1 += module.generateAnnotationsModule(pr);

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation inherits = new Annotation(s);
		s1 += inherits.generateAnnotationsInheritance(pr, myModule.getName());

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
		Rule rule = generateRule(m1.getOutputPredicate(), myModule.getInputPredicate());
		r.add(rule);

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		}

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		}

		s1 += a1.generateAnnotationsOutput(pr);
		// System.out.println(s1);

		return s1;

	}// generate inherited module

	
	// generate abstract Module
	public String generateRMIModuleAbstact(int rules, int facts, int in, int out) {

		Program pr = new Program();
		var = GeneratorRandomString.getRandomBigChar(1);
		m1 = new Module();

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." + "\n";

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

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String abst = GeneratorRandomString.getRandomString(randomNumber);
		System.out.println(abst + " ************************************************");
		Rule rule = generateAbstractRule(m1.getOutputPredicate(), m1.getInputPredicate(), abst);
		r.add(rule);

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		}

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		}

		s1 += a1.generateAnnotationsOutput(pr);
		
		System.out.println("**********************************");
		System.out.println("Abstract predicate: " + abst);
		System.out.println("Abstract module: " + m1.getName() + "\n");

		return s1;
	}// generate abstract Module
	
	
	public String generateRMIModuleWithNonOmitable(int rules, int facts, int in, int out) {

		Program pr = new Program();
		m1 = new Module();
		var = GeneratorRandomString.getRandomBigChar(1);

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." + "\n";

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
		s1 += a1.generateNonOmitableInputAnnotations(pr);

		List<Rule> r = makeRule();

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		}

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		}

		s1 += a1.generateAnnotationsOutput(pr);
		// System.out.println(s1);

		return s1;

	}// generate base Module
	

	// **************************************************************************
	// the following methods are used as help methods for the above (main) methods
	// **************************************************************************

	// geneate list of input,output etc. predicates
	public static List<String> makePredicate(int nr) {
		List<String> l = new ArrayList<>();
		int count = 0;
		while (count < nr) {
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
			l.add(s);
			count++;
		}
		return l;
	}// geneate list of input,output etc. predicates

	
	
	// generate list of rules based on input/output
	public List<Rule> makeRule() {

		List<Rule> ruleList = new ArrayList<>();

		int count = m1.getInputPredicate().size();

		for (String m : m1.getOutputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
			Rule r = new Rule(s);

			RelationalAtoms head = generateRelationalAtomHead(m);
			r.setHead(head);

			List<RelationalAtoms> body = generateRelationalAtomBodyList(count);
			r.setBody(body);

			// *****************************************************
			//to do....
			if (count == 0) {
				count = m1.getInputPredicate().size();
			} else {
				count--;
			}

			ruleList.add(r);

		}

		return ruleList;
	}// generate list of rules based on input/output

	
	
	// generate the head atom of a rule
	public static RelationalAtoms generateRelationalAtomHead(String predicate) {

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		RelationalAtoms atom = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));

		atom.setPredicate(predicate);
		List<Term> t = generateTerm(1);
		atom.setTerm(t);
		return atom;
	}// generate the head atom of a rule

	
	// generate body atoms of a relational atoms
	public List<RelationalAtoms> generateRelationalAtomBodyList(int count) {
		List<RelationalAtoms> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			RelationalAtoms a = generateRelationalAtomBody(m1.getInputPredicate().get(i));
			list.add(a);
		}
		return list;
	}// generate body atoms of a relational atom

	
	// generate a single body atom of a rule (used by method above to put in the
	// list)
	public static RelationalAtoms generateRelationalAtomBody(String name) {

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		atom.setPredicate(name);
		List<Term> t = generateTerm(1);
		atom.setTerm(t);
		return atom;

	}// generate a body atom of a rule

	
	
	// generate a list of terms
	public static List<Term> generateTerm(int nr) {
		List<Term> t = new ArrayList<>();
		int count = 0;
		while (count < nr) {
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t1 = new Term(GeneratorRandomString.getRandomString(randomNumber));
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			t1.setSerialization(var);
			t.add(t1);
			count++;
		}
		return t;
	}// generate a list of terms

	
	
	// generate a list of atoms for facts
	public static List<RelationalAtoms> generateRelationalAtomFactList(int count) {
		List<RelationalAtoms> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {

			RelationalAtoms a = generateRelationalAtomFacts();
			list.add(a);

		}
		return list;
	}// generate a list of atoms/facts
	
	
	// generate a single fact (used by the method above to put in the list)
	public static RelationalAtoms generateRelationalAtomFacts() {

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);

		atom.setPredicate(s);
		List<Term> t = generateTerm(1);
		atom.setTerm(t);
		return atom;

	}// generate a single facts

	
	
	// generate a rule for inherited module based on input/output from super module)
	public Rule generateRule(List<String> output, List<String> input) {

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Rule r = new Rule(s);

		RelationalAtoms head = generateRelationalAtomHead(output.get(0));
		r.setHead(head);

		List<RelationalAtoms> body = generateRelationalAtomBodyList(input);
		r.setBody(body);

		return r;
	}// generate a rule for inherited module based on input/output from super module)
	
	
	// generate a list of relational atoms for body based on input
	public List<RelationalAtoms> generateRelationalAtomBodyList(List<String> input) {
		List<RelationalAtoms> list = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i++) {
			
			RelationalAtoms a = generateRelationalAtomBody(input.get(i));
			list.add(a);
			
		}
		return list;
	}// generate a list of relational atoms for body based on input
		
	

		// generate abstract rule
		public Rule generateAbstractRule(List<String> output, List<String> input, String abst) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
			Rule r = new Rule(s);

			RelationalAtoms head = generateRelationalAtomHead(output.get(0));
			r.setHead(head);

			List<RelationalAtoms> body = generateAbstractRelationalAtomBodyList(input, abst);
			r.setBody(body);

			return r;
		}// generate abstract rule


	
	
	// generate a list of relational atoms for body - with abstract atom
	public List<RelationalAtoms> generateAbstractRelationalAtomBodyList(List<String> input, String abst) {
		List<RelationalAtoms> list = new ArrayList<>();

		for (int i = 0; i < input.size(); i++) {

			RelationalAtoms a = generateRelationalAtomBody(input.get(i));
			list.add(a);

		}

		RelationalAtoms a = generateRelationalAtomBody(abst);
		list.add(a);
		return list;

	}// generate a list of relational atoms for body - with abstract atom

	
	
}// RMIModule
