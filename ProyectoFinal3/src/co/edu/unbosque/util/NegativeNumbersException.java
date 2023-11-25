package co.edu.unbosque.util;

/**
 * NegativeNumbersException se encarga de comprobar que el numero digitado no sea negativo
 */
public class NegativeNumbersException extends Exception{

	private static final long serialVersionUID = -3751624680495201635L;
	
	/**
	 * Excepcion con mensaje predeterminado
	 */
	public NegativeNumbersException() {
		super("Los numeros negativos no estan permitidos");
	}

	/**
	 * Excepcion con mensaje customizado
	 */
	public NegativeNumbersException(String message) {
		super(message);
	}

}
