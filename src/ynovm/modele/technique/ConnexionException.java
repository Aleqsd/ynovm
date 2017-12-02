package ynovm.modele.technique;


public class ConnexionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnexionException()
	{
		super("mauvait login ou password");
	}
	public ConnexionException(String msg)
	{
		super(msg);
	}
}
