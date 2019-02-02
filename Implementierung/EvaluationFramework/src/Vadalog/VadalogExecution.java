package Vadalog;

import java.util.concurrent.ThreadLocalRandom;

public class VadalogExecution {

	// Dummy Method to get the Execution Time of the Vadalog Execution
	public static double calcExTime() {

		int help = ThreadLocalRandom.current().nextInt(11, 401);
		double randExTime = help / 10;
		return randExTime;

	}

	// Dummy Method to get if there were Erros of the Vadalog Execution
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

	// Dummy Method to get the CPU Usage of the Vadalog Execution
	public static double calcCpuUsage() {

		int help = ThreadLocalRandom.current().nextInt(101, 5001);
		double randCpuUsage = help / 100;

		return randCpuUsage;

	}

}