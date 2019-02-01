package Models;

import java.util.Date;

public class RMI {
	
	private int id;
	private Date date;
	private long time;
	private int testType;
	private int noRules;
	private int noFacts;
	private int noInPr;
	private int noOutPr;
	private double exTime;
	private boolean errors;
	private double cpuUsage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getTime(Date date) {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getTestType() {
		return testType;
	}
	public void setTestType(int testType) {
		this.testType = testType;
	}
	public int getNoRules() {
		return noRules;
	}
	public void setNoRules(int noRules) {
		this.noRules = noRules;
	}
	public int getNoFacts() {
		return noFacts;
	}
	public void setNoFacts(int noFacts) {
		this.noFacts = noFacts;
	}
	public int getNoInPr() {
		return noInPr;
	}
	public void setNoInPr(int noInPr) {
		this.noInPr = noInPr;
	}
	public int getNoOutPr() {
		return noOutPr;
	}
	public void setNoOutPr(int noOutPr) {
		this.noOutPr = noOutPr;
	}
	public double getExTime() {
		return exTime;
	}
	public void setExTime(double exTime) {
		this.exTime = exTime;
	}
	public boolean isErrors() {
		return errors;
	}
	public void setErrors(boolean errors) {
		this.errors = errors;
	}
	public double getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

}