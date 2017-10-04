package rop.miu.util;

/**
 * Cette exception doit �tre lev�e si un �l�ment requis n'a pas �t� trouv�.
 * 
 * @author Ndadji Maxime
 * @version 1.0
 */
public class ROPElementNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ROPElementNotFoundException(String message) {
        super( message );
    }
    public ROPElementNotFoundException(String message, Throwable cause) {
        super( message, cause );
    }
    public ROPElementNotFoundException(Throwable cause) {
        super( cause );
    }
}
