package DataGeneratorRuleModelInheritance;

public class Program {

	// attributes
	private String name;
	private static int nrOfPr = 1;

	// constructor
	public Program() {
		this.name = "program" + Program.nrOfPr;
		nrOfPr++;
	}// Program

	// setter
	public void setName(String s) {
		this.name = s;
	}// setName

	// toString
	public String toString() {
		return this.name;
	}// toString

}// Program
