package Metier;

public class RayonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RayonException() {
		super("Rayon Exception");
	}
	public RayonException(String msg) {
		super("Rayon Exception : "+msg);
	}
}
