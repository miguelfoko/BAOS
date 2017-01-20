package rop.miu.util;

/**
 * Cette exception doit être levée pour des erreurs d'accès aux données.
 * 
 * @author garrik brel
 * @version 1.0
 */
public class ROPDaoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ROPDaoException(String message) {
        super( message );
    }
    public ROPDaoException(String message, Throwable cause) {
        super( message, cause );
    }
    public ROPDaoException(Throwable cause) {
        super( cause );
    }
}
