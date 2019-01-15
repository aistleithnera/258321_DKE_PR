package DataGeneratorCBR;

import java.util.ArrayList;
import java.util.List;

public class ContextClass {

	private String name;
	private List<Parameter> parameters = new ArrayList<Parameter>();

	public String getName() {
		return this.name;
	}
	
	public void setName (String n) {
		this.name = n; 
	}

	public List<Parameter> getParameters() {
		return this.parameters;
	}
	
	public void addParameters(Parameter p) {
		this.parameters.add(p); 
	}

}
