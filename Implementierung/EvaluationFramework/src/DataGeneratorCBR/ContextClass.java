package DataGeneratorCBR;

import java.util.ArrayList;
import java.util.List;

public class ContextClass {

	private String name;
	private List<Parameter> parameters = new ArrayList<Parameter>();
	private List <Context> contexts = new ArrayList<Context>(); 

	public List<Context> getContexts() {
		return contexts;
	}

	public void setContexts(List<Context> contexts) {
		this.contexts = contexts;
	}
	
	public void addContexts (Context context) {
		this.contexts.add(context);
	}

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
