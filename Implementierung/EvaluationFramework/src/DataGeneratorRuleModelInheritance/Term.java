package DataGeneratorRuleModelInheritance;

public class Term {

	// attributes
	private String name;
	private String serialization;

	// constructor
	public Term(String name) {
		this.name = name;
	}// Term

	// getter
	public String getName() {
		return this.name;
	}// getName

	public String getSerialization() {
		return this.serialization;
	}// getSerialization

	// setter
	public void setSerialization(String s) {
		this.serialization = s;
	}// setSerialization

	// toString
	public String toString() {
		return name;
	}// toString

}// Term
