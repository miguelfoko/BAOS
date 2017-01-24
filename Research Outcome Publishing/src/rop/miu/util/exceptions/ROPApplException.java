package rop.miu.util.exceptions;

public class ROPApplException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ROPApplException(String message) {
        super(message);
    }
    public ROPApplException(String message, Throwable cause) {
        super(message, cause);
    }
    public ROPApplException(Throwable cause) {
        super(cause);
    }
}
