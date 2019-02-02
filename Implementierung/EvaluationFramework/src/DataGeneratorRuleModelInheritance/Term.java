package DataGeneratorRuleModelInheritance;

public class Term {
	
	private String name;
	private String serialization;
	
	public Term(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	

	public void setSerialization(String s){
		this.serialization = s;
	}
	
	public String getName(){
		return this.name; 
		
	}
	
	public String getSerialization(){
		return this.serialization;
	}
	
}
