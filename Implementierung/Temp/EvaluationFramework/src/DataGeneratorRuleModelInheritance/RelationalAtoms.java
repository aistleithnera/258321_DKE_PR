package DataGeneratorRuleModelInheritance;

import java.util.ArrayList;
import java.util.List;

public class RelationalAtoms {

	List<Term> t;
	private String name;
	private String id;
	private String predicate;

	public RelationalAtoms(String id) {
		this.id = id;
		t = new ArrayList<>();
	}

	public String toString() {
		return this.id;
	}

	public void setName(String s) {
		this.name = s;
	}

	public void setPredicate(String s) {
		this.predicate = s;
	}

	public String getName() {
		return this.name;
	}

	public String getPredicate() {
		return this.predicate;
	}

	public void setTerm(List<Term> t) {
		this.t = t;
	}

	public List<Term> getTerm() {
		return this.t;
	}

	public String getId() {
		return this.id;
	}

	
	// fakten generieren
	public String generateOnlyFacts(int factsNum, Program pr) {

		int factsCount = factsNum;
		int termsInAtom = 0;

		String facts = "";

		// fakten generieren

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

			}

		} // whileFacts
		return facts;
	}

}
