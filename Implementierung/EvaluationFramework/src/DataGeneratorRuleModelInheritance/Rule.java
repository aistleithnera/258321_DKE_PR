package DataGeneratorRuleModelInheritance;

import java.util.List;


public class Rule {
	
	private String name;
	private  RelationalAtoms head;
	private List<RelationalAtoms> relationalAtomsBody;
	private String annotation;
	

	public Rule(String name) {
		this.name = name;

	}
	
	public String getAnnotation(){
		return this.annotation;
	}
	
	public void setAnnotation(String a){
		this.annotation= a;
	}
	
		
	
	public RelationalAtoms getHead(){
		return this.head;
	}
	
	public String getName(){
		return this.name;
	}
	
	

	public String toString(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	
	public void setHead(RelationalAtoms a){
		this.head = a;
		
	}
	
	public void setBody(List<RelationalAtoms> a){
		this.relationalAtomsBody = a;
	}
	
	
	public RelationalAtoms getRelationalAtomsHead(){
		return this.head;
	}
	
	public List<RelationalAtoms> getRelationalAtomsBody(){
		return this.relationalAtomsBody;
	}
	
	
	
	public  String generateOnlyRules(int rulesCount, Program pr) {
		
		String rules = "";
		

		while(rulesCount > 0) {
			
			
			rules+= "rule(\"" + this.getName() + "\").\n";
			rules+= "hasRule(\"" + pr + "\",\"" + this.getName() + "\").\n";
			rules+= "hasPositiveHeadAtom(\"" + this.getName() +"\",\"" + this.getRelationalAtomsHead().getId() + "\").\n";
			rules += "relationalAtom(\"" + this.getRelationalAtomsHead().getId() + "\"). \n";
			rules += "hasName(\"" + this.getRelationalAtomsHead().getId() + "\",\"" + this.getRelationalAtomsHead().getPredicate() + "\"). \n";
		
			rules += "term(\"" + this.getRelationalAtomsHead().getTerm().get(0).getName() + "\"). \n";
			rules += "hasSerialization(\"" + this.getRelationalAtomsHead().getTerm().get(0).getName() + "\",\"" +  this.getRelationalAtomsHead().getTerm().get(0).getSerialization()
			+ "\"). \n";
			rules += "hasArgument(\"" + this.getRelationalAtomsHead().getId() + "\",\"" + this.getRelationalAtomsHead().getTerm().get(0).getName() + "\"," + 0 + "). \n";
			
			
		
				for(RelationalAtoms a : this.getRelationalAtomsBody()) {
				rules+= "hasPositiveBodyAtom(\"" + this.getName() +"\",\"" + a.getId() + "\").\n";
			
				rules += "relationalAtom(\"" + a.getId() + "\"). \n";
				rules += "hasName(\"" + a.getId() + "\",\"" + a.getPredicate() + "\"). \n";
	
				for(Term t : a.getTerm()) {
				
				rules += "term(\"" + t.getName() + "\"). \n";
				rules += "hasSerialization(\"" + t.getName() + "\",\"" +  t.getSerialization()
				+ "\"). \n";
				rules += "hasArgument(\"" + a.getId() + "\",\"" + t.getName() + "\"," + 0 + "). \n";
				
				}
				
			}
				
		rulesCount--;
			
	
		}
		
	return rules;
	}//generateOnlyRules
	
}
