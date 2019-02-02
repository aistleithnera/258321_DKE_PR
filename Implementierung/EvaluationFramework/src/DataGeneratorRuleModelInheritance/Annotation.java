package DataGeneratorRuleModelInheritance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class Annotation {

	// attributes
	private String name;
	private String term;
	List<String> inputPredicate;
	List<String> outputPredicate;

	// constructor
	public Annotation(String name) {
		this.name = name;
	}// annotation

	// getter
	public List<String> getInputPredicate() {
		return this.inputPredicate;
	}// getInputPredicate

	public List<String> getOutputPredicate() {
		return this.outputPredicate;
	}// getOutputPredicate

	public String getTerm() {
		return this.term;
	}// getTerm

	// setter
	public void setInputPredicate(List<String> l) {
		this.inputPredicate = l;
	}// setInputPredicate

	public void setOutputPredicate(List<String> l) {
		this.outputPredicate = l;
	}// setOutputPredicate

	public void setTerm(String t) {
		this.term = t;
	}// setTerm

	public void setName(String s) {
		this.name = s;
	}// setName

	public String toString() {
		return this.name;
	}// toString

	// generate Meta-Code

	public String generateAnnotationsModule(Program pr) {

		String generatedAnnotations = "";

		// generate annotation
		generatedAnnotations += "annotation(\"" + this + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + this + "\"). \n";
		generatedAnnotations += "hasName(\"" + this + "\",\"" + "module" + "\"). \n";

		// generate termns
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "term(\"" + t + "\"). \n";
		generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getTerm() + "\"\"\"). \n";
		generatedAnnotations += "hasArgument(\"" + this + "\",\"" + t + "\"," + 0 + "). \n";

		return generatedAnnotations;
	}// generateAnnotationModule

	// generate meta code for input
	public String generateAnnotationsInput(Program pr) {

		String generatedAnnotations = "";

		for (String s : this.getInputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "input" + "\"). \n";

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // for
		return generatedAnnotations;
	}// generateAnnotationsInput

	// generate input with restriction- nonOmitable
	public String generateNonOmitableInputAnnotations(Program pr) {

		String generatedAnnotations = "";

		for (String s : this.getInputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "non_omitable" + "\"). \n";

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // for
		return generatedAnnotations;
	}// generateNonOmitableInputAnnotation

	// generate annotation with inheritance
	public String generateAnnotationsInheritance(Program pr, String modulename) {

		String generatedAnnotations = "";

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String m = GeneratorRandomString.getRandomString(randomNumber);

		generatedAnnotations += "annotation(\"" + m + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
		generatedAnnotations += "hasName(\"" + m + "\",\"" + "inherits" + "\"). \n";

		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "term(\"" + t + "\"). \n";
		generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + modulename + "\"\"\"). \n";
		generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		return generatedAnnotations;
	}// generateAnnoatationsInheritance

	// generate annotation for output
	public String generateAnnotationsOutput(Program pr) {

		String generatedAnnotations = "";

		for (String s : this.getOutputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);
			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "output" + "\"). \n";

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // for
		return generatedAnnotations;
	}// generateAnnotationsOutput

	// generate annotation for label
	public String generateAnnotationsLabel(String ruleId) {

		String generatedAnnotations = "";

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		generatedAnnotations += "annotation(\"" + this + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + ruleId + "\",\"" + this + "\"). \n";
		generatedAnnotations += "hasName(\"" + this + "\",\"" + "label" + "\"). \n";

		// terms generieren
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "term(\"" + t + "\"). \n";
		generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this + "\"\"\"). \n";
		generatedAnnotations += "hasArgument(\"" + this + "\",\"" + t + "\"," + 0 + "). \n";

		return generatedAnnotations;
	}// generateAnnotatiionsLabel

	// generate annotation with restriction- nonGrownable
	public String generateNonGrownableAnnotations(Program pr) {

		String generatedAnnotations = "";

		for (int i = 0; i < this.getOutputPredicate().size() / 2; i++) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "non_growable" + "\"). \n";

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getOutputPredicate().get(i)
					+ "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // for
		return generatedAnnotations;
	}// generateNonGrownableAnnotations

	// generate annotation with restriction- nonShrinkableAnnotations
	public String generateNonShrinkableAnnotations(Program pr) {

		String generatedAnnotations = "";

		for (int i = this.getOutputPredicate().size() / 2; i < this.getOutputPredicate().size(); i++) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "non_shrinkable" + "\"). \n";

			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getOutputPredicate().get(i)
					+ "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // for
		return generatedAnnotations;
	}// generateNonShrinkableAnnotations

	// generate annotation- resultSet
	public String generateAnnotationResultSet(Program pr) {

		String generatedAnnotations = "";

		generatedAnnotations += "annotation(\"" + this + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + this + "\"). \n";
		generatedAnnotations += "hasName(\"" + this + "\",\"" + "resultset" + "\"). \n";

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "term(\"" + t + "\"). \n";
		generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getTerm() + "\"\"\"). \n";
		generatedAnnotations += "hasArgument(\"" + this + "\",\"" + t + "\"," + 0 + "). \n";

		return generatedAnnotations;
	}// generateAnnotationsResultSet

}// Annotation