package exeptions;

public class WeakPasswordException extends Exception{

	private static final long serialVersionUID = 2371864787793846353L;
	
	public WeakPasswordException() {
		super();
	}

	public WeakPasswordException(String message) {
		super(message);
	}

	public WeakPasswordException(Exception cause) {
		super(cause);
	}	

	public WeakPasswordException(String message, Exception cause) {
		super(message, cause);
	}

}
