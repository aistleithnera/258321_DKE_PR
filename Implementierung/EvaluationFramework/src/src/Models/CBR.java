package Models;

public class CBR {
	
	private int id;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int second;
	private int noParm;
	private int noParmVal;
	private int noCont;
	private int noBusCase;
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
	public int getNoParm() {
		return noParm;
	}
	public void setNoParm(int noParm) {
		this.noParm = noParm;
	}
	public int getNoParmVal() {
		return noParmVal;
	}
	public void setNoParmVal(int noParmVal) {
		this.noParmVal = noParmVal;
	}
	public int getNoCont() {
		return noCont;
	}
	public void setNoCont(int noCont) {
		this.noCont = noCont;
	}
	public int getNoBusCase() {
		return noBusCase;
	}
	public void setNoBusCase(int noBusCase) {
		this.noBusCase = noBusCase;
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