package exception;


public class InvalidInputOutputException extends FrameworkException {
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidInputOutputException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidInputOutputException(String message, Throwable cause) {
		super(message, cause);
	}
}
