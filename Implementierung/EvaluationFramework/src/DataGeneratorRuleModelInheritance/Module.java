package DataGeneratorRuleModelInheritance;

import java.util.List;

public class Module {

	// attributes
	private String name;
	private static int nrOfModule = 1;
	List<Rule> rules;
	List<RelationalAtoms> facts;
	List<String> inputPredicate;
	List<String> outputPredicate;

	// constructors
	public Module() {
		this.name = "m" + Module.nrOfModule;
		Module.nrOfModule++;
	}// Module

	Module(String name) {
		this.name = name;
	}// Module

	// getter
	public String getName() {
		return this.name;
	}// getName

	public List<String> getInputPredicate() {
		return this.inputPredicate;
	}// getInputPredicate

	public List<String> getOutputPredicate() {
		return this.outputPredicate;
	}// getOutputPredicate

	public List<Rule> getRules() {
		return this.rules;
	}// getRules

	public List<RelationalAtoms> getFacts() {
		return this.facts;
	}// getFacts

	// setter
	public void setName() {
		this.name = "m" + nrOfModule;
	}// setName

	public void setInputPredicate(List<String> l) {
		this.inputPredicate = l;
	}// setInputPredicte

	public void setOutputPredicate(List<String> l) {
		this.outputPredicate = l;
	}// setOutputPredicate

	public void setRules(List<Rule> t) {
		this.rules = t;
	}// setRules

	public void setFacts(List<RelationalAtoms> t) {
		this.facts = t;
	}// setFacts

}// Module
