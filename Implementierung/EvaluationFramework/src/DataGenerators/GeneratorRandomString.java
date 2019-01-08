package DataGenerators;

import java.security.SecureRandom;

public class GeneratorRandomString {
	
	public static String getRandomString(int length) {
		String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final SecureRandom RANDOM = new SecureRandom();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}

}
