package Exceptions;

@SuppressWarnings("serial")
public class NegativeNumberException extends Exception{
	
	// Exception to prevent negative numbers are in the input
	public NegativeNumberException(String message) {
		super(message);
	}

}
