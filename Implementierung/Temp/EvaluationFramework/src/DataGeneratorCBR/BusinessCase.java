package DataGeneratorCBR;

import java.util.ArrayList;
import java.util.List;

public class BusinessCase {

	String name;
	private List<String> descProp = new ArrayList<String>();
	private List<String> parameterValues = new ArrayList<String>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDescProp() {
		return this.descProp;
	}

	public void setDescProp(List<String> descProp) {
		this.descProp = descProp;
	}
	
	
	public void addDescProp(String dp) {
		this.descProp.add(dp); 
	}

	public List<String> getParameterValues() {
		return this.parameterValues;
	}

	public void setParameterValues(List<String> parameterValues) {
		this.parameterValues = parameterValues;
	}
	
	public void addParameterValues(String v) {
		this.parameterValues.add(v); 
	}

}