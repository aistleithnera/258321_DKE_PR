package Models;

public class RMI {
	
	private int id;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int second;
	private String testType;
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
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