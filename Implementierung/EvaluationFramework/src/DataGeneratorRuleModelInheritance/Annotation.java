package DataGeneratorRuleModelInheritance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class Annotation {

	private String name;
	private String term;
	List<String> inputPredicate;
	List<String> outputPredicate;

	public void setInputPredicate(List<String> l) {
		this.inputPredicate = l;
	}

	public void setOutputPredicate(List<String> l) {
		this.outputPredicate = l;
	}

	public List<String> getInputPredicate() {
		return this.inputPredicate;
	}

	public List<String> getOutputPredicate() {
		return this.outputPredicate;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String t) {
		this.term = t;
	}

	public Annotation(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public void setName(String s) {
		this.name = s;
	}

	
	public String generateAnnotationsModule(Program pr) {

		String generatedAnnotations = "";

		// annotation generieren
		generatedAnnotations += "annotation(\"" + this + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + this + "\"). \n";
		generatedAnnotations += "hasName(\"" + this + "\",\"" + "module" + "\"). \n";

		// terms generieren
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "term(\"" + t + "\"). \n";
		generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getTerm() + "\"\"\"). \n";
		generatedAnnotations += "hasArgument(\"" + this + "\",\"" + t + "\"," + 0 + "). \n";

		return generatedAnnotations;
	}

	
	// für jeden input annotations generieren
	public String generateAnnotationsInput(Program pr) {

		String generatedAnnotations = "";

		for (String s : this.getInputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "input" + "\"). \n";

			// terms generieren
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // whileAnnoCoun
		return generatedAnnotations;
	}

	
	//für jeden input non omitable annotations generieren
	public String generateNonOmitableInputAnnotations(Program pr) {

		String generatedAnnotations = "";

		for (String s : this.getInputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "non_omitable" + "\"). \n";

			// terms generieren
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // whileAnnoCoun
		return generatedAnnotations;
	}


	// iheritance annotations generieren
	public String generateAnnotationsInheritance(Program pr, String modulename) {

		String generatedAnnotations = "";

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String m = GeneratorRandomString.getRandomString(randomNumber);

		generatedAnnotations += "annotation(\"" + m + "\"). \n";
		generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
		generatedAnnotations += "hasName(\"" + m + "\",\"" + "inherits" + "\"). \n";

		// terms generieren
		randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
		generatedAnnotations += "term(\"" + t + "\"). \n";
		generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + modulename + "\"\"\"). \n";
		generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		return generatedAnnotations;
	}

	//für jeden output annotations generieren
	public String generateAnnotationsOutput(Program pr) {

		String generatedAnnotations = "";

		for (String s : this.getOutputPredicate()) {

			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);
			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "output" + "\"). \n";

			// terms generieren
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + s + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // whileAnnoCoun
		return generatedAnnotations;
	}

	// label annotations generieren
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
	}
	
	// non growable annotations generieren
	public String generateNonGrownableAnnotations(Program pr) {

		String generatedAnnotations = "";
		
		
		for(int i=0; i<this.getOutputPredicate().size()/2; i ++) {

		
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "non_growable" + "\"). \n";

			// terms generieren
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getOutputPredicate().get(i) + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // whileAnnoCoun
		return generatedAnnotations;
	}

	
	// non shrinkable annotations generieren
	public String generateNonShrinkableAnnotations(Program pr) {

		String generatedAnnotations = "";
		
		
		for(int i=this.getOutputPredicate().size()/2; i<this.getOutputPredicate().size(); i ++) {

		
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			String m = GeneratorRandomString.getRandomString(randomNumber);

			generatedAnnotations += "annotation(\"" + m + "\"). \n";
			generatedAnnotations += "hasAnnotation(\"" + pr + "\",\"" + m + "\"). \n";
			generatedAnnotations += "hasName(\"" + m + "\",\"" + "non_shrinkable" + "\"). \n";

			// terms generieren
			randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			Term t = new Term(GeneratorRandomString.getRandomString(randomNumber));
			generatedAnnotations += "term(\"" + t + "\"). \n";
			generatedAnnotations += "hasSerialization(\"" + t + "\",\"\"\"" + this.getOutputPredicate().get(i) + "\"\"\"). \n";
			generatedAnnotations += "hasArgument(\"" + m + "\",\"" + t + "\"," + 0 + "). \n";

		} // whileAnnoCoun
		return generatedAnnotations;
	}

}