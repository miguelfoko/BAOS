package rop.miu.util.exceptions;

/**
 * Cette exception doit être levée pour des erreurs de cryptographie.
 * 
 * @author Ndadji Maxime
 * @version 1.0
 */
public class ROPCryptographyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ROPCryptographyException(String message) {
        super(message);
    }
    public ROPCryptographyException(String message, Throwable cause) {
        super(message, cause);
    }
    public ROPCryptographyException(Throwable cause) {
        super(cause);
    }
}
