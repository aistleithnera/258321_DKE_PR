package RuleModelInheritance;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	private String name;
	private static List<Rule> rules;
	private static List<RelationalAtoms> relationalAtoms;
	private static List<Annotation> annotations;

	
	
	public Program(){
		this.rules = new ArrayList<Rule>();
		this.relationalAtoms = new ArrayList<RelationalAtoms>();
		this.annotations = new ArrayList<Annotation>();
	}
	
	
	public String toString(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	
	public List<Rule> getRules(){
		return rules;
	}
	
	public List<RelationalAtoms> getAllRelationalAtoms(){
		return relationalAtoms;
	}
	
	public List<Annotation> getAllAnnotations(){
		return annotations;
	}
	

}
