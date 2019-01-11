package DataGeneratorCBR;

import java.util.ArrayList;
import java.util.List;

public class Parameter {
	
	private String name;
	private List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();
	private String descProp; 
	
	public String getName() {
		return this.name;
	}
	
	public void setName (String n) {
		this.name = n; 
	}

	public List<ParameterValue> getParameterValues() {
		return this.parameterValues;
	}
	
	public void addParameterValues(ParameterValue v) {
		this.parameterValues.add(v); 
	}
	
	public String getDescProp() {
		return this.descProp;
	}
	
	public void setDescProp (String n) {
		this.descProp = n; 
	}

}
