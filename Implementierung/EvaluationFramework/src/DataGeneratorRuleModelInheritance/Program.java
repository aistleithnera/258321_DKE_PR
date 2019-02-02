package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	private String name;
	private static int nrOfPr = 1;
	private static List<Rule> rules;
	private static List<RelationalAtoms> relationalAtoms;
	private static List<Annotation> annotations;

	
	
	public Program(){
		Program.rules = new ArrayList<Rule>();
		Program.relationalAtoms = new ArrayList<RelationalAtoms>();
		Program.annotations = new ArrayList<Annotation>();
		
		this.name= "program" + Program.nrOfPr;
		nrOfPr++;		
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
