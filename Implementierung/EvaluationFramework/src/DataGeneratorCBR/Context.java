package DataGeneratorCBR;

import java.util.ArrayList;
import java.util.List;

public class Context {
	private String ctx; 
	private String name; 
	private List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();
	private Module module; 
	private String contextClass; 
	
	public String getCtx() {
		return this.ctx;
	}
	
	public void setCtx (String n) {
		this.ctx = n; 
	}

	
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
	
	public Module getModule() {
		return this.module;
	}
	
	public void setModule (Module m) {
		this.module = m; 
	}
	
	public String getContextClass() {
		return this.contextClass;
	}
	
	public void setContextClass (String n) {
		this.contextClass = n; 
	}

}
