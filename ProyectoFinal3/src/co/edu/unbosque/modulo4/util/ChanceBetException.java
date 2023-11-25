package co.edu.unbosque.modulo4.util;

/**
 * Excepción personalizada para manejar errores relacionados con apuestas en la clase Chance.
 */
public class ChanceBetException extends Exception {

    /**Identificador único para la serialización.*/
    private static final long serialVersionUID = -1666280306851394096L;

    /**
     * Constructor predeterminado que establece un mensaje de error por defecto.
     */
    public ChanceBetException() {
        super("La apuesta solo está disponible para una cantidad entre 500 y 20000 COP");
    }

    /**
     * Constructor que permite establecer un mensaje de error personalizado.
     * @param message Mensaje de error personalizado.
     */
    public ChanceBetException(String message) {
        super(message);
    }
}
