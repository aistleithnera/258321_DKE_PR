package DataGeneratorRuleModelInheritance;

public class Annotation {
	
	
	private String name;
	private String label;

	
	
	public Annotation(String name) {
		this.name = name;
}

	public String toString(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	
	

}
