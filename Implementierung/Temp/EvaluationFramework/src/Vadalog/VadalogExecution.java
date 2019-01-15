package Vadalog;

import java.util.concurrent.ThreadLocalRandom;

import DBConnection.DBSaveEntry;
import Models.CBR;
import Models.RMI;

public class VadalogExecution {

	public static void calcCBR(CBR cbr) {
		
		double randExTime = ThreadLocalRandom.current().nextDouble(1, 500);
		boolean randNoErrors = true;
		double randCpuUsage = ThreadLocalRandom.current().nextDouble(1, 101);
		
		cbr.setExTime(randExTime);
		cbr.setErrors(randNoErrors);
		cbr.setExTime(randCpuUsage);
		
		DBSaveEntry.newCBR(cbr);
		
	}
	
	public static void calcRMI(RMI rmi) {
		
		double randExTime = ThreadLocalRandom.current().nextDouble(1, 500);
		boolean randNoErrors = false;
		double randCpuUsage = ThreadLocalRandom.current().nextDouble(1, 101);
		
		rmi.setExTime(randExTime);
		rmi.setErrors(randNoErrors);
		rmi.setExTime(randCpuUsage);
		
		DBSaveEntry.newRMI(rmi);
		
	}	
	
}