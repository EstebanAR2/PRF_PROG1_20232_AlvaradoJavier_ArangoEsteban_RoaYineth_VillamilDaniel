package co.edu.unbosque.util;

/**
 * SpecialCharactersException se encarga de que no haya caracteres especiales
 */
public class SpecialCharactersException extends Exception{

	private static final long serialVersionUID = 383619337313974282L;
	
	/**
	 * Excepcion con mensaje predeterminado
	 */
	public SpecialCharactersException() {
		
		super ("Los caracteres especiales son invalidos en la casilla de nombre");
	}
	
	/**
	 * Excepcion con mensaje customizado
	 */
	public SpecialCharactersException(String message) {
		
		super(message);
	}
	

}
