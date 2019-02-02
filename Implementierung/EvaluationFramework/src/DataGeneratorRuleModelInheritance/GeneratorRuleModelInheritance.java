package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import DataGeneratorRandomString.GeneratorRandomString;

public class GeneratorRuleModelInheritance {

	//attributes
	private static Program program = new Program();
	private static List<Program> programs;
	private static List<String> modules = new ArrayList<>();
	public static Map<Integer, String> moduleFacts = new HashMap<>();
	static int countModule = 0;

	// generate program name

	public static String generateProgram() {
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		program = new Program();
		program.setName(GeneratorRandomString.getRandomString(randomNumber));
		programs = new ArrayList<Program>();
		programs.add(program);
		return "program(\"" + program + "\")." + "\n";
	}// end generateProgram

	// generate facts with terms
	public static String generateOnlyFacts(int factsNum, int termsNum) {

		int factsCount = factsNum;
		int termsInAtom = 0;

		String facts = "";

		// generate facts
		while (factsCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			RelationalAtoms a = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));

			String s1 = GeneratorRandomString.getRandomString(randomNumber);
			a.setName(s1);
			facts += "relationalAtom(\"" + a + "\"). \n";
			facts += "hasFact(\"" + program + "\",\"" + a + "\"). \n";
			facts += "hasName(\"" + a + "\",\"" + s1 + "\"). \n";
			factsCount--;
			termsInAtom = 0;

			// generate terms

			int maxTerms = ThreadLocalRandom.current().nextInt(1, termsNum + 1);

			while (maxTerms > 0) {

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
				String s = GeneratorRandomString.getRandomString(randomNumber);
				t.setSerialization(s);
				facts += "term(\"" + t + "\"). \n";
				facts += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
				facts += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAtom + "). \n";
				maxTerms--;
				termsInAtom++;

			} // whileTerms

		} // whileFacts
		return facts;
	}// end generateOnlyFacts

	// generate facts with terms

	public static String generateFactsFromRules(int factsNum, int termsNum, RelationalAtoms a) {

		int factsCount = factsNum;
		int termsInAtom = 0;

		String facts = "";

		// generate facts

		while (factsCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			RelationalAtoms atom = a;
			facts += "relationalAtom(\"" + atom + "\"). \n";
			facts += "hasName(\"" + atom + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";

			factsCount--;

			termsInAtom = 0;

			// generate terms

			int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1);

			while (i > 0) {

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

				facts += "term(\"" + t + "\"). \n";
				facts += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber)
						+ "\"\"\"). \n";
				facts += "hasArgument(\"" + atom + "\",\"" + t + "\"," + termsInAtom + "). \n";

				i--;
				termsInAtom++;

			} // whileTerms

		} // whileFacts
		return facts;
	}// end generateFactsFromRules

	// generate rules with nonRelationalAtoms

	public static String generateNonRelationalFactsFromRules(int factsNum, int termsNum, NonRelationalAtom a) {

		int factsCount = factsNum;

		String facts = "";

		// generate facts

		while (factsCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			NonRelationalAtom atom = a;
			facts += "nonRelationalAtom(\"" + atom + "\"). \n";
			facts += "hasName(\"" + atom + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";

			factsCount--;

			int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1);

			while (i > 0) {

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

				facts += "hasSerialization(\"" + atom + "\",\"" + GeneratorRandomString.getRandomBigChar(1) + "="
						+ "\"\"" + GeneratorRandomString.getRandomString(randomNumber) + "\"\"\"). \n";

				i--;

			} // whileTerms

		} // whileFacts
		return facts;
	}// generateNonRelationalFactsFromRules

	// generate annotation
	public static String generateFactsFromAnnotations(int termsNum, Annotation anno) {

		int termsInAtom = 0;

		String facts = "";

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

		Annotation a = anno;
		RelationalAtoms atom = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));

		facts += "relationalAtom(\"" + a + "\"). \n";
		facts += "hasName(\"" + atom + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";
		facts += "hasFact(\"" + program + "\",\"" + atom + "\"). \n";

		termsInAtom = 0;

		int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1);

		while (i > 0) {

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			facts += "term(\"" + t + "\"). \n";
			facts += "hasSerialization(\"" + t + "\",\"\"\"" + GeneratorRandomString.getRandomString(randomNumber)
					+ "\"\"\"). \n";
			facts += "hasArgument(\"" + atom + "\",\"" + t + "\"," + termsInAtom + "). \n";

			i--;
			termsInAtom++;

		} // whileTerms

		facts += "hasAnnotation(\"" + atom + "\",\"" + a + "\"). \n";
		facts += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";

		return facts;
	}// end generateFactsFromAnnotation

	// generate rules
	public static String generateOnlyRules(int factsNum, int termsNum, int rulesNum) {

		String rules = "";
		int rulesCount = rulesNum;

		while (rulesCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));

			rules += "rule(\"" + r + "\").\n";
			rules += "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules += "hasPositiveHeadAtom(\"" + r + "\",\"" + a1 + "\").\n";
			rules += generateFactsFromRules(1, termsNum, a1);

			int factsCount = factsNum;

			while (factsCount > 0) {

				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules += "hasPositiveBodyAtom(\"" + r + "\",\"" + a2 + "\").\n";
				rules += generateFactsFromRules(1, termsNum, a2);

				factsCount--;
			} // end while

			rulesCount--;
		} // end while

		return rules;
	}// generateOnlyRules

	// generate rule with positive and negative relationalAtoms
	// (positive/negative body atoms)
	public static String generatePositiveAndNegativeRules(int rulesNum, int termsNum, int positiveBodyNum,
			int negativeBodyNum) {

		String rules = "";
		int rulesCount = rulesNum;
		int positiveBodyCount = positiveBodyNum;
		int negativeBodyCount = negativeBodyNum;

		while (rulesCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));

			rules += "rule(\"" + r + "\").\n";
			rules += "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules += "hasPositiveHeadAtom(\"" + r + "\",\"" + a1 + "\").\n";
			rules += generateFactsFromRules(1, termsNum, a1);

			while (positiveBodyCount > 0) {

				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules += "hasPositiveBodyAtom(\"" + r + "\",\"" + a2 + "\").\n";
				rules += generateFactsFromRules(1, termsNum, a2);

				positiveBodyCount--;
			} // while

			while (negativeBodyCount > 0) {

				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules += "hasNegativeBodyAtom(\"" + r + "\",\"" + a2 + "\").\n";
				rules += generateFactsFromRules(1, termsNum, a2);

				negativeBodyCount--;
			} // while

			rulesCount--;
		} // while

		return rules;
	}// generatePositiveAndNegativeRules

	// generate rule with nonRelationalAtoms
	public static String generateRulesWithNonRelationalAtoms(int rulesNum, int termsNum, int relationalAtomNum,
			int nonRelationalAtomNum) {

		String rules = "";
		int rulesCount = rulesNum;
		int relationalAtomCount = relationalAtomNum;
		int nonRelationalAtomCount = nonRelationalAtomNum;

		while (rulesCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));

			rules += "rule(\"" + r + "\").\n";
			rules += "hasRule(\"" + program + "\",\"" + r + "\").\n";
			RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules += "hasPositiveHeadAtom(\"" + r + "\",\"" + a1 + "\").\n";
			rules += generateFactsFromRules(1, termsNum, a1);

			while (relationalAtomCount > 0) {

				RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
				rules += "hasPositiveBodyAtom(\"" + r + "\",\"" + a2 + "\").\n";
				rules += generateFactsFromRules(1, termsNum, a2);

				relationalAtomCount--;
			} // while

			while (nonRelationalAtomCount > 0) {

				NonRelationalAtom a2 = new NonRelationalAtom(GeneratorRandomString.getRandomString(randomNumber));
				rules += "hasPositiveBodyAtom(\"" + r + "\",\"" + a2 + "\").\n";
				rules += generateNonRelationalFactsFromRules(1, termsNum, a2);

				nonRelationalAtomCount--;
			} // while

			rulesCount--;
		} // while

		return rules;
	}// generateRulesNonRelationalAtoms

	// generate annotation with rules
	public static String generateAnnotationsFromRules(int factsNum, int termsNum, Annotation a) {

		String rules = "";

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Rule r = new Rule(GeneratorRandomString.getRandomString(randomNumber));

		rules += "rule(\"" + r + "\").\n";
		rules += "hasRule(\"" + program + "\",\"" + r + "\").\n";
		RelationalAtoms a1 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
		rules += "hasPositiveHeadAtom(\"" + r + "\",\"" + a1 + "\").\n";
		rules += generateFactsFromRules(1, termsNum, a1);

		int factsCount = factsNum;

		while (factsCount > 0) {

			RelationalAtoms a2 = new RelationalAtoms(GeneratorRandomString.getRandomString(randomNumber));
			rules += "hasPositiveBodyAtom(\"" + r + "\",\"" + a2 + "\").\n";
			rules += generateFactsFromRules(1, termsNum, a2);

			factsCount--;
		} // while

		rules += "hasAnnotation(\"" + r + "\",\"" + a + "\"). \n";
		rules += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber)) + "\"). \n";

		return rules;
	}// generateAnnotationFromRules

	// generate annotation
	public static String generateOnlyAnnotations(int annoNum, int termsNum) {

		int annoCount = annoNum;

		String generatedAnnotations = "";

		while (annoCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "annotation(\"" + a + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + program + "\",\"" + a + "\"). \n";
			generatedAnnotations += "hasName(\"" + a + "\",\"" + (GeneratorRandomString.getRandomString(randomNumber))
					+ "\"). \n";

			annoCount--;

			// generate terms

			int i = ThreadLocalRandom.current().nextInt(1, termsNum + 1);
			int termsInAnno = 0;

			while (i > 0) {

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

				generatedAnnotations += "term(\"" + t + "\"). \n";
				generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\""
						+ GeneratorRandomString.getRandomString(randomNumber) + "\"\"\"). \n";
				generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAnno + "). \n";

				i--;
				termsInAnno++;

			} // whileTerms

		} // whileAnnoCount

		return generatedAnnotations;
	}// generate OnlyAnnotation

	// generate linked Annotations (with Facts, rules etc.)

	public static String generateAnnotationsWithFacts(int annoNum, int annoTermNum, int factTermNum) {

		int annoCount = annoNum;

		String generatedAnnotations = "";

		while (annoCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "annotation(\"" + a + "\"). \n";

			generatedAnnotations += generateFactsFromAnnotations(factTermNum, a);

			annoCount--;

			// generate terms

			int i = ThreadLocalRandom.current().nextInt(1, factTermNum + 1);
			int termsInAnno = 0;

			while (i > 0) {

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

				generatedAnnotations += "term(\"" + t + "\"). \n";
				generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\""
						+ GeneratorRandomString.getRandomString(randomNumber) + "\"\"\"). \n";
				generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAnno + "). \n";

				i--;
				termsInAnno++;

			} // whileTerms

		} // whileAnnoCount

		return generatedAnnotations;
	}// generateAnnoationWithFacts

	// generate linked Annotations (with Facts, rules etc.)

	public static String generateAnnotationsWithRules(int annoNum, int terms, int ruleFacts) {

		int annoCount = annoNum;

		String generatedAnnotations = "";

		while (annoCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "annotation(\"" + a + "\"). \n";

			generatedAnnotations += generateAnnotationsFromRules(ruleFacts, terms, a);

			annoCount--;

			// generate terms

			int i = ThreadLocalRandom.current().nextInt(1, terms + 1);
			int termsInAnno = 0;

			while (i > 0) {

				randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
				Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

				generatedAnnotations += "term(\"" + t + "\"). \n";
				generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\""
						+ GeneratorRandomString.getRandomString(randomNumber) + "\"\"\"). \n";
				generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + termsInAnno + "). \n";

				i--;
				termsInAnno++;

			} // whileTerms

		} // whileAnnoCount

		return generatedAnnotations;

	}// generateAnnotationsWithRules

	// generate Module
	public static String generateModule(int annoNum) {

		int annoCount = annoNum;

		String generatedAnnotations = "";

		while (annoCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "annotation(\"" + a + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + program + "\",\"" + a + "\"). \n";
			generatedAnnotations += "hasName(\"" + a + "\",\"" + "module" + "\"). \n";

			annoCount--;

			// generate terms

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			generatedAnnotations += "term(\"" + t + "\"). \n";
			String s = GeneratorRandomString.getRandomString(randomNumber);
			modules.add(s);
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + 0 + "). \n";

		} // end while
		return generatedAnnotations;

	}// generateModule

	// generate module with inheritance
	public static String generateModuleInheritance(int annoNum) {

		int annoCount = annoNum;

		String generatedAnnotations = "";

		while (annoCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "annotation(\"" + a + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + program + "\",\"" + a + "\"). \n";
			generatedAnnotations += "hasName(\"" + a + "\",\"" + "inherits" + "\"). \n";

			annoCount--;

			// generate terms

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			generatedAnnotations += "term(\"" + t + "\"). \n";
			String s = modules.get(0);
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + 0 + "). \n";

		} // end while
		return generatedAnnotations;

	}// generateModuleInheritance

	// generate annotation ResultSet
	public static String generateAnnotationResultSet(int annoNum) {

		int annoCount = annoNum;

		String generatedAnnotations = "";

		while (annoCount > 0) {

			int randomNumber = ThreadLocalRandom.current().nextInt(2, 4);
			Annotation a = new Annotation(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "annotation(\"" + a + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + program + "\",\"" + a + "\"). \n";
			generatedAnnotations += "hasName(\"" + a + "\",\"" + "resultset" + "\"). \n";

			annoCount--;

			// terms generieren

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));

			generatedAnnotations += "term(\"" + t + "\"). \n";
			String s = modules.get(countModule);
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + a + "\",\"" + t + "\"," + 0 + "). \n";

		} // end while
		return generatedAnnotations;

	}// end gennerateAnnotationResultSet

	// generate module
	public static String generateModuleResultSet() {
		String generateModuleResultSet = "";
		String generatedFacts = null;
		program = new Program();
		program.setName(modules.get(countModule));
		programs = new ArrayList<Program>();
		programs.add(program);
		generateModuleResultSet += "program(\"" + program + "\")." + "\n";
		generatedFacts = generateOnlyFacts(2, 1);
		generateModuleResultSet += generatedFacts;
		moduleFacts.put(countModule, generatedFacts);
		generateModuleResultSet += generateAnnotationResultSet(1);
		countModule++;
		return generateModuleResultSet;
	}// generateModuleResuleSet

}// end GeneratorRuleModellInheritance
