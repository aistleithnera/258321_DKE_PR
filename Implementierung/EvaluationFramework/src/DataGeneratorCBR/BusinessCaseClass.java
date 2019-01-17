package DataGeneratorCBR;

import java.util.ArrayList;
import java.util.List;

public class BusinessCaseClass {

	private String name;
	private List<BusinessCase> businessCases = new ArrayList<BusinessCase>();

	public String getName() {
		return this.name;
	}

	public List<BusinessCase> getBusinessCases() {
		return businessCases;
	}

	public void setBusinessCases(List<BusinessCase> businessCases) {
		this.businessCases = businessCases;
	}

	public void addBusinessCase(BusinessCase bc) {
		this.businessCases.add(bc);
	}

	public void setName(String n) {
		this.name = n;
	}

}
