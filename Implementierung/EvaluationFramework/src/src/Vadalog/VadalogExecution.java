package Vadalog;

import java.util.concurrent.ThreadLocalRandom;

public class VadalogExecution {

	public static double calcExTime() {

		double randExTime = ThreadLocalRandom.current().nextDouble(1, 500);
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

		double randCpuUsage = ThreadLocalRandom.current().nextDouble(1, 101);

		return randCpuUsage;

	}

}