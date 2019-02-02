package DataGeneratorRandomString;

import java.security.SecureRandom;

public class GeneratorRandomString {

	// a random String made of letters is generated
	public static String getRandomString(int length) {
		String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
		final SecureRandom RANDOM = new SecureRandom();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}

	// a random String made of Big letters is generated
	public static String getRandomBigChar(int length) {
		String ALPHABET = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
		final SecureRandom RANDOM = new SecureRandom();

		StringBuilder sb = new StringBuilder();
		sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

		return sb.toString();
	}

}
