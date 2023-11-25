package co.edu.unbosque.modulo3.util;

/**
 * Excepción personalizada que indica que la contraseña no cumple con los requisitos mínimos.
 */
public class PasswordException extends Exception {

    /**
     * Número de serie único para la serialización.
     */
    private static final long serialVersionUID = 1940851568384699728L;

    /**
     * Constructor predeterminado que establece un mensaje por defecto.
     */
    public PasswordException() {
        super("La contraseña debe tener un mínimo de 7 caracteres");
    }

    /**
     * Constructor que permite establecer un mensaje personalizado.
     * @param message Mensaje personalizado para describir la excepción.
     */
    public PasswordException(String message) {
        super(message);
    }
}
