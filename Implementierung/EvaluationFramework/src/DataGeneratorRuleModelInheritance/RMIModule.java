package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class RMIModule {

	// attributes
	static String var;
	Module m1;

	// getter
	public Module getModule() {
		return this.m1;
	}// getModule

	// generate base Module (META CODE)
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

		List<String> input = generatePredicate(in);
		List<String> output = generatePredicate(out);

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);

		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);

		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);

		s1 += a1.generateAnnotationsInput(pr);

		List<Rule> r = generateRule();

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		} // for

		int subRuleNum = 0;
		if (rules > out) {
			subRuleNum = rules - out;
			List<Rule> r2 = generateSubRule(subRuleNum);

			for (Rule r1 : r2) {
				s1 += r1.generateOnlyRules(1, pr);

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				s = GeneratorRandomString.getRandomString(randomNumber);
				Annotation label = new Annotation(s);
				s1 += label.generateAnnotationsLabel(r1.getName());
				r1.setAnnotation(label.toString());

			} // for
		} // if

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // for

		s1 += a1.generateAnnotationsOutput(pr);

		return s1;

	}// generate base Module

	// generate inherited Module (META-CODE)
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

		List<String> input = generatePredicate(in);
		List<String> output = generatePredicate(out);

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);

		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);

		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);

		s1 += a1.generateAnnotationsInput(pr);

		List<Rule> r = generateRule();
		Rule rule = generateRule(m1.getOutputPredicate(), myModule.getInputPredicate());
		r.add(rule);

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		} // for

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // for

		s1 += a1.generateAnnotationsOutput(pr);

		return s1;

	}// generate inherited module

	// generate abstract Module (META-CODE)
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

		List<String> input = generatePredicate(in);
		List<String> output = generatePredicate(out);

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);

		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);

		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);

		s1 += a1.generateAnnotationsInput(pr);

		List<Rule> r = generateRule();

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String abst = GeneratorRandomString.getRandomString(randomNumber);
		Rule rule = generateAbstractRule(m1.getOutputPredicate(), m1.getInputPredicate(), abst);
		r.add(rule);

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		} // for

		int subRuleNum = 0;
		if (rules > out) {
			subRuleNum = rules - out;
			List<Rule> r2 = generateSubRule(subRuleNum);

			for (Rule r1 : r2) {
				s1 += r1.generateOnlyRules(1, pr);

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				s = GeneratorRandomString.getRandomString(randomNumber);
				Annotation label = new Annotation(s);
				s1 += label.generateAnnotationsLabel(r1.getName());
				r1.setAnnotation(label.toString());

			} // for
		} // if

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // for

		s1 += a1.generateAnnotationsOutput(pr);

		return s1;
	}// generate abstract RMI Module

	// generate RMIModule with non omitable (META-CODE)
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

		List<String> input = generatePredicate(in);
		List<String> output = generatePredicate(out);

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);

		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);

		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);

		s1 += a1.generateAnnotationsInput(pr);
		s1 += a1.generateNonOmitableInputAnnotations(pr);

		List<Rule> r = generateRule();

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		} // for

		int subRuleNum = 0;
		if (rules > out) {
			subRuleNum = rules - out;
			List<Rule> r2 = generateSubRule(subRuleNum);

			for (Rule r1 : r2) {
				s1 += r1.generateOnlyRules(1, pr);

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				s = GeneratorRandomString.getRandomString(randomNumber);
				Annotation label = new Annotation(s);
				s1 += label.generateAnnotationsLabel(r1.getName());
				r1.setAnnotation(label.toString());

			} // for
		} // if

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // for

		s1 += a1.generateAnnotationsOutput(pr);

		return s1;

	}// generate RMI Module with non omitable

	// generate static RMI Module (META-CODE)
	public String generateRMIModuleStatic(int rules, int facts, int in, int out) {

		Program pr = new Program();
		m1 = new Module();
		var = GeneratorRandomString.getRandomBigChar(1);

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." + "\n";

		s1 += module.generateAnnotationsModule(pr);

		List<String> input = generatePredicate(in);
		List<String> output = generatePredicate(out);

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation a1 = new Annotation(s);

		a1.setInputPredicate(input);
		a1.setOutputPredicate(output);

		m1.setInputPredicate(input);
		m1.setOutputPredicate(output);

		s1 += a1.generateAnnotationsInput(pr);
		s1 += a1.generateNonOmitableInputAnnotations(pr);
		s1 += a1.generateNonGrownableAnnotations(pr);
		s1 += a1.generateNonShrinkableAnnotations(pr);

		List<Rule> r = generateRule();

		for (Rule r1 : r) {
			s1 += r1.generateOnlyRules(1, pr);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			s = GeneratorRandomString.getRandomString(randomNumber);
			Annotation label = new Annotation(s);
			s1 += label.generateAnnotationsLabel(r1.getName());
			r1.setAnnotation(label.toString());

		} // for

		int subRuleNum = 0;
		if (rules > out) {
			subRuleNum = rules - out;
			List<Rule> r2 = generateSubRule(subRuleNum);

			for (Rule r1 : r2) {
				s1 += r1.generateOnlyRules(1, pr);

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				s = GeneratorRandomString.getRandomString(randomNumber);
				Annotation label = new Annotation(s);
				s1 += label.generateAnnotationsLabel(r1.getName());
				r1.setAnnotation(label.toString());

			} // for
		} // if

		List<RelationalAtoms> factsList = generateRelationalAtomFactList(facts);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // for

		s1 += a1.generateAnnotationsOutput(pr);

		return s1;

	}// generate static RMI Module

	// generate dynamic RMI Module
	public String generateRMIModuleDynamic() {

		Program pr = new Program();
		m1 = new Module();

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s);
		module.setTerm(m1.getName());
		String s1 = "program(\"" + pr + "\")." + "\n";

		s1 += module.generateAnnotationsModule(pr);

		return s1;

	}// generateRMIModuleDynamic

	// generate dynamic RMI Module
	public String generateRMIModuleDynamic(Module myModule) {

		Program pr = new Program();
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
		return s1;

	}// generate inherited module dynamic

	// generate ResultSet of module(dynamic)
	public String generateRMIModuleDynamicResultset(Module myModul, int nrResultSet) {

		Program pr = new Program();

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		String s1 = "program(\"" + pr + "\")." + "\n";

		Annotation result = new Annotation(s);
		result.setTerm(myModul.getName());
		s1 += result.generateAnnotationResultSet(pr);

		List<RelationalAtoms> factsList = generateRelationalAtomFactListDynamic(nrResultSet);

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // end for

		myModul.setFacts(factsList);
		return s1;

	}// generate resultSet dynamic

	// generate resultSet dynamic with inheritance
	public String generateRMIModuleDynamicResultsetInheritance(Module myModul, Module superModul) {

		Program pr = new Program();

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		String s1 = "program(\"" + pr + "\")." + "\n";

		Annotation result = new Annotation(s);
		result.setTerm(myModul.getName());
		s1 += result.generateAnnotationResultSet(pr);

		List<RelationalAtoms> factsList = generateRelationalAtomFactListDynamicInherits(superModul.getFacts());

		for (RelationalAtoms a : factsList) {
			s1 += a.generateOnlyFacts(1, pr);
		} // for

		myModul.setFacts(factsList);
		return s1;

	}// generate resultSet dynamic

	// **************************************************************************
	// the following methods are used as help methods for the above (main)
	// methods
	// **************************************************************************

	// geneate list of input,output etc. predicates
	public static List<String> generatePredicate(int nr) {
		List<String> l = new ArrayList<>();
		int count = 0;
		while (count < nr) {
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
			l.add(s);
			count++;
		} // while
		return l;
	}// geneate list of input,output etc. predicates

	// generate list of rules based on input/output
	public List<Rule> generateRule() {

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

			count--;
			ruleList.add(r);
		} // for
		return ruleList;
	}// generate list of rules based on input/output

	// generate list of subRules
	public List<Rule> generateSubRule(int subRules) {
		List<Rule> ruleList = new ArrayList<>();

		int count = subRules;
		while (count > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
			Rule r = new Rule(s);

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s1 = GeneratorRandomString.getRandomString(randomNumber);

			randomNumber = ThreadLocalRandom.current().nextInt(0, m1.getOutputPredicate().size());
			RelationalAtoms head = generateRelationalAtomHead(s1);
			r.setHead(head);

			List<RelationalAtoms> body = generateRelationalAtomBodyListForSubRule(3);
			r.setBody(body);

			ruleList.add(r);
			count--;
		} // while
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

	// generate body atoms of a relational atom
	public List<RelationalAtoms> generateRelationalAtomBodyList(int count) {
		List<RelationalAtoms> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			RelationalAtoms a = generateRelationalAtomBody(m1.getInputPredicate().get(i));
			list.add(a);
		} // for
		return list;
	}// generate body atoms of a relational atom

	// generate body atoms of a relational atom for sub rule
	public List<RelationalAtoms> generateRelationalAtomBodyListForSubRule(int count) {
		List<RelationalAtoms> list = new ArrayList<>();

		List<String> predicateList = generatePredicate(count);
		for (int i = 0; i < count; i++) {
			RelationalAtoms a = generateRelationalAtomBody(predicateList.get(i));
			list.add(a);
		} // for
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
		} // while
		return t;
	}// generate a list of terms

	// generate a list of atoms for facts
	public static List<RelationalAtoms> generateRelationalAtomFactList(int count) {
		List<RelationalAtoms> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {

			RelationalAtoms a = generateRelationalAtomFacts();
			list.add(a);

		} // for
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

	// generate a list of atoms for facts dynamic
	public static List<RelationalAtoms> generateRelationalAtomFactListDynamic(int count) {
		List<RelationalAtoms> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			RelationalAtoms a = generateRelationalAtomFactsDynamic();
			list.add(a);
		} // for
		return list;
	}// generate a list of atoms/facts dynamic

	// generate a single fact dynamic (used by the method above to put in the
	// list)
	public static RelationalAtoms generateRelationalAtomFactsDynamic() {
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		atom.setPredicate(s);
		List<Term> t = generateTermDynamic(1);
		atom.setTerm(t);
		return atom;
	}// generate a single facts

	// generate a list of terms
	public static List<Term> generateTermDynamic(int nr) {
		List<Term> t = new ArrayList<>();
		int count = 0;
		while (count < nr) {
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t1 = new Term(GeneratorRandomString.getRandomString(randomNumber));
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String s = GeneratorRandomString.getRandomString(randomNumber);
			t1.setSerialization(s);
			t.add(t1);
			count++;
		} // while
		return t;
	}// generate a list of terms

	// generate a list of atoms for facts dynamic
	public static List<RelationalAtoms> generateRelationalAtomFactListDynamicInherits(List<RelationalAtoms> l) {
		List<RelationalAtoms> list = new ArrayList<>();

		int count = ThreadLocalRandom.current().nextInt(4, 8);

		for (int i = 0; i < count; i++) {

			RelationalAtoms a = generateRelationalAtomFactsDynamic(l);
			list.add(a);

		} // for
		return list;
	}// generate a list of atoms/facts dynamic

	// generate a single fact dynamic (used by the method above to put in the
	// list)
	public static RelationalAtoms generateRelationalAtomFactsDynamic(List<RelationalAtoms> l) {

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		RelationalAtoms atom = new RelationalAtoms(s);
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		s = GeneratorRandomString.getRandomString(randomNumber);
		randomNumber = ThreadLocalRandom.current().nextInt(0, l.size() - 1);
		atom.setPredicate(l.get(randomNumber).getPredicate());
		List<Term> t = generateTermDynamic(1);
		atom.setTerm(t);
		return atom;

	}// generate a single facts

	// generate a rule for inherited module based on input/output from super
	// module)
	public Rule generateRule(List<String> output, List<String> input) {

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s = GeneratorRandomString.getRandomString(randomNumber);
		Rule r = new Rule(s);

		RelationalAtoms head = generateRelationalAtomHead(output.get(0));
		r.setHead(head);

		List<RelationalAtoms> body = generateRelationalAtomBodyList(input);
		r.setBody(body);

		return r;
	}// generate a rule for inherited module based on input/output from super
		// module)

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

		} // for

		RelationalAtoms a = generateRelationalAtomBody(abst);
		list.add(a);
		return list;

	}// generate a list of relational atoms for body - with abstract atom

}// RMIModule
