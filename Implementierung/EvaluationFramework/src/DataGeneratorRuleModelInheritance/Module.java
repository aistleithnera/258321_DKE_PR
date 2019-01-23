package DataGeneratorRuleModelInheritance;

import java.util.List;

public class Module {

	private String name;
	private Module prev;
	private static int nrOfModule = 1;
	
	List<Rule> rules;
	List<RelationalAtoms> facts;
	List<String> inputPredicate;
	List<String>outputPredicate;
	
	public Module(){
		this.name = "m" + this.nrOfModule;
		this.nrOfModule++;
		this.prev = null;
	}
	
	public void setPrev(Module m){
		this.prev = m;
	}
	
	public Module getPrev(){
		return this.prev;
	}
	
	public void setName(){
		this.name = "m" + nrOfModule;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	
	public void setInputPredicate(List<String> l){
		this.inputPredicate = l;
	}
	
	public void setOutputPredicate(List<String> l){
		this.outputPredicate = l;
	}
	
	public List<String> getInputPredicate(){
		return this.inputPredicate;
	}
	
	public List<String> getOutputPredicate(){
		return this.outputPredicate;
	}
	
	
	
	RelationalAtoms i;
	RelationalAtoms o;
	
	
	public void setI(RelationalAtoms i){
		this.i = i;
	}
	
	public void setO(RelationalAtoms o ){
		this.o = o;
	}
	
	public RelationalAtoms getI(){
		return this.i;
	}
	public RelationalAtoms getO(){
		return this.o;
	}
	
	
	
	

	Module(String name){
		this.name= name;
	}
	
	public void setRules(List<Rule>t){
		this.rules = t;
	}
	
	public List<Rule> getRules(){
		return this.rules;
	}
	
	public void setFacts(List<RelationalAtoms>t){
		this.facts = t;
	}
	
	public List<RelationalAtoms> getFacts(){
		return this.facts;
	}
	
	

}
