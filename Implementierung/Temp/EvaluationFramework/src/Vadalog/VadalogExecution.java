package Vadalog;

import java.util.concurrent.ThreadLocalRandom;

public class VadalogExecution {

	public static double calcExTime() {
		
		double randExTime = ThreadLocalRandom.current().nextDouble(1, 500);
		
		return randExTime;
		
	}
	
	public static boolean calcNoErrors() {
		
		boolean randNoErrors = false;

		return randNoErrors;
		
	}
	
	public static double calcCpuUsage() {
		
		double randCpuUsage = ThreadLocalRandom.current().nextDouble(1, 101);
		
		return randCpuUsage;
		
	}
	
}