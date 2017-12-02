package ynovm.modele.technique;


public class ConnexionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnexionException()
	{
		super("Nom de compte ou identifiant incorrect");
	}
	public ConnexionException(String msg)
	{
		super(msg);
	}
}
