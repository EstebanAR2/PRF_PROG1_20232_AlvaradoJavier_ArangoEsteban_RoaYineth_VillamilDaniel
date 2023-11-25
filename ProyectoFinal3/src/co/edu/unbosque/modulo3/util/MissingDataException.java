package co.edu.unbosque.modulo3.util;

/**
 * Excepción personalizada que indica que faltan datos obligatorios por rellenar.
 */
public class MissingDataException extends Exception {

    /**
     * Número de serie único para la serialización.
     */
    private static final long serialVersionUID = -2882475010249808285L;

    /**
     * Constructor predeterminado que establece un mensaje por defecto.
     */
    public MissingDataException() {
        super("Faltan datos obligatorios por rellenar");
    }

    /**
     * Constructor que permite establecer un mensaje personalizado.
     * @param message Mensaje personalizado para describir la excepción.
     */
    public MissingDataException(String message) {
        super(message);
    }
}
