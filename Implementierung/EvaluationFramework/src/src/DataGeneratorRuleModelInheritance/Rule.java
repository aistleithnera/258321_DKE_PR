package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	
	private String name;
	private static List<RelationalAtoms> relationalAtomsHead;
	private static List<RelationalAtoms> relationalAtomsBody;
	private static List<Annotation> annotations;

	
	
	
	public Rule(String name) {
		this.name = name;

	}
	
	

	public String toString(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	public List<RelationalAtoms> getRelationalAtomsHead(){
		return this.relationalAtomsHead;
	}
	
	public List<RelationalAtoms> getRelationalAtomsBody(){
		return this.relationalAtomsBody;
	}
	
	
	

}
