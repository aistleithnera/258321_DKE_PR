package Models;

import java.sql.Date;
import java.sql.Time;

public class RMI { // RMI Objekt erlaubt eine bequeme Speicherung der Testdaten
	
	private Date date;
	private Time time;
	private int testType;
	private int noRules;
	private int noFacts;
	private int noInPr;
	private int noOutPr;
	private double exTime;
	private boolean errors;
	private double cpuUsage;
	
	// Getter und Setter Methoden

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
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