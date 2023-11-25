package co.edu.unbosque.modulo4.util;

/**
 * Excepción personalizada para manejar errores relacionados con apuestas en la clase SuperAstro.
 */
public class SuperAstroBetException extends Exception{

	 /**Identificador único para la serialización.*/
	private static final long serialVersionUID = -880382011468419961L;
	
    /**
     * Constructor predeterminado que establece un mensaje de error por defecto.
     */
	public SuperAstroBetException() {
		super("Valor de apuesta no valido");
	}
	
    /**
     * Constructor que permite establecer un mensaje de error personalizado.
     * @param message Mensaje de error personalizado.
     */
	public SuperAstroBetException(String message) {
		super(message);
	}
}
