package Test;

import java.util.concurrent.ThreadLocalRandom;

import DataGenerators.GeneratorCBR;
import DataGenerators.GeneratorRandomString;

public class Test {

	public static void main(String[] args) {

		// String text = GeneratorRandomString.getRandomString(5);
		String text = GeneratorCBR.generateCBRCode(5);

		System.out.println(text);

	}

}
