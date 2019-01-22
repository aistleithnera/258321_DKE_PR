package Vadalog;

import java.util.concurrent.ThreadLocalRandom;

public class VadalogExecution {

	public static double calcExTime() {

		int help =  ThreadLocalRandom.current().nextInt(11, 401);
		double randExTime = help/10;
		return randExTime;

	}

	public static boolean calcNoErrors() {

		int error = ThreadLocalRandom.current().nextInt(0, 2);
		boolean randNoErrors = false;

		if (error == 0) {
			randNoErrors = false;
		} else {
			randNoErrors = true;
		}

		return randNoErrors;

	}

	public static double calcCpuUsage() {

		int help = ThreadLocalRandom.current().nextInt(101, 5001);
		double randCpuUsage = help/100; 

		return randCpuUsage;

	}

}