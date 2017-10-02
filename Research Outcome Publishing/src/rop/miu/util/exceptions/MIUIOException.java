package rop.miu.util.exceptions;

public class MIUIOException extends ROPApplException {

	private static final long serialVersionUID = 1L;

	public MIUIOException(String message) {
		super(message);
	}

	public MIUIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public MIUIOException(Throwable cause) {
		super(cause);
	}
}
