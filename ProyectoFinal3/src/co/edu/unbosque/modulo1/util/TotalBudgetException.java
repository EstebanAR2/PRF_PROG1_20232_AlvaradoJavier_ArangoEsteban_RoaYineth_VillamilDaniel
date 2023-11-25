package co.edu.unbosque.modulo1.util;

/**
 * TotalBudgetException es una excepción lanzada cuando se excede el presupuesto total de la casa de apuestas.
 */
public class TotalBudgetException extends Exception {

    /** Numero de version para la serializacion. */
    private static final long serialVersionUID = 3837609603520011045L;

    /**
     * Constructor de TotalBudgetException.
     * Lanza la excepcion con un mensaje predeterminado indicando que se ha excedido el presupuesto total.
     */
    public TotalBudgetException() {
        super("Se ha excedido el presupuesto total");
    }

    /**
     * Constructor de TotalBudgetException con un mensaje personalizado.
     * @param message El mensaje de la excepción.
     */
    public TotalBudgetException(String message) {
        super(message);
    }
}
