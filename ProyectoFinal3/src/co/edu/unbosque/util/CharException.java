package co.edu.unbosque.util;

/**
 * CharException se encarga de comprobar que los numeros digitados sean validos
 */
public class CharException extends Exception {

	private static final long serialVersionUID = 3277611978001724662L;

	/**
	 * Excepcion con mensaje predeterminado
	 */
	public CharException() {
		super("Los caracteres tanto especiales como alfabeticos no son validos en esta casilla");
	}

	/**
	 * Excepcion con mensaje customizado
	 */
	public CharException(String message) {
		super(message);
	}

}
