package DataGeneratorRandomString;

import java.security.SecureRandom;

public class GeneratorRandomString {
	
	public static String getRandomString(int length) {
		String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
		final SecureRandom RANDOM = new SecureRandom();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}
	
	
	public static String getRandomBigChar(int length) {
		String ALPHABET = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
		final SecureRandom RANDOM = new SecureRandom();

		StringBuilder sb = new StringBuilder();
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		
		return sb.toString();
	}

}