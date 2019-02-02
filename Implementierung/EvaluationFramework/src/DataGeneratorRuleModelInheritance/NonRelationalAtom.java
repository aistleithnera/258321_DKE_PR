package DataGeneratorRuleModelInheritance;

public class NonRelationalAtom {

	//attributes
	private String name;

	// constructor
	public NonRelationalAtom(String name) {
		this.name = name;
	}//nonRelationalAtom

	//setter
	public void setName(String s) {
		this.name = s;
	}//setName
	
	public String toString() {
		return this.name;
	}//toString

}// NonRelationalAtom
