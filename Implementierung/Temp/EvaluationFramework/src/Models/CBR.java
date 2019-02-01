package Models;

import java.sql.Date;
import java.sql.Time;

public class CBR { // CBR Objekt erlaubt eine bequeme Speicherung der Testdaten
	
	private Date date;
	private Time time;
	private int noParm;
	private int noParmVal;
	private int noCont;
	private int noBusCase;
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