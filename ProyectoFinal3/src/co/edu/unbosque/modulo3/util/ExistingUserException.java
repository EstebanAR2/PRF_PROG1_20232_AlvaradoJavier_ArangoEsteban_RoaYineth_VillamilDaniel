package co.edu.unbosque.modulo3.util;

/**
 * Excepción personalizada que indica que el usuario o la cédula ya están registrados.
 */
public class ExistingUserException extends Exception {

    /**
     * Número de serie único para la serialización.
     */
    private static final long serialVersionUID = -3498816050047526204L;

    /**
     * Constructor que establece un mensaje por defecto.
     */
    public ExistingUserException() {
        super("El usuario o la cédula registrada ya están en uso");
    }

    /**
     * Constructor que permite establecer un mensaje personalizado.
     * @param message Mensaje personalizado para describir la excepción.
     */
    public ExistingUserException(String message) {
        super(message);
    }
}
