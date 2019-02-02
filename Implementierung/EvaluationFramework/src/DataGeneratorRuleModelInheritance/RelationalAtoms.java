package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;

public class RelationalAtoms {

	// attributes
	List<Term> t;
	private String name;
	private String id;
	private String predicate;

	// constructor
	public RelationalAtoms(String id) {
		this.id = id;
		t = new ArrayList<>();
	}// RelationalAtoms

	// getter
	public String getName() {
		return this.name;
	}// getName

	public String getPredicate() {
		return this.predicate;
	}// getPredicate

	public List<Term> getTerm() {
		return this.t;
	}// getTerm

	public String getId() {
		return this.id;
	}// getId

	// setter
	public void setName(String s) {
		this.name = s;
	}// setName

	public void setPredicate(String s) {
		this.predicate = s;
	}// setPredicate

	public void setTerm(List<Term> t) {
		this.t = t;
	}// setTerm

	// toString
	public String toString() {
		return this.id;
	}

	// generate Meta-Code facts
	public String generateOnlyFacts(int factsNum, Program pr) {

		int factsCount = factsNum;
		int termsInAtom = 0;

		String facts = "";

		while (factsCount > 0) {

			facts += "relationalAtom(\"" + this.getId() + "\"). \n";
			facts += "hasFact(\"" + pr + "\",\"" + this.getId() + "\"). \n";
			facts += "hasName(\"" + this.getId() + "\",\"" + this.predicate + "\"). \n";

			factsCount--;

			termsInAtom = 0;

			for (Term i : this.getTerm()) {

				facts += "term(\"" + i.getName() + "\"). \n";
				facts += "hasSerialization(\"" + i.getName() + "\",\"\"\"" + i.getSerialization() + "\"\"\"). \n";
				facts += "hasArgument(\"" + this.getId() + "\",\"" + i.getName() + "\"," + termsInAtom + "). \n";

			} // for

		} // whileFacts
		return facts;
	}// generateOnlyFacts

}// RelationalAtoms
