package co.edu.unbosque.modulo4.model;

import java.io.Serializable;
import java.time.DayOfWeek;

/**
 * Clase que representa un boleto de Baloto, que hereda de la clase Receipt e implementa Serializable.
 */
public class BalotoDTO extends Receipt implements Serializable {

    /** Número de serie único para la serialización. */
    private static final long serialVersionUID = -8791162625504145121L;

    /** Numeros seleccionados en el boleto de Baloto.*/
    private int numbers;

    /** Constructor predeterminado.*/
    public BalotoDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que establece la los numeros seleccionados.
     * @param numbers Numeros seleccionados.
     */
    public BalotoDTO(int numbers) {
        super();
        this.numbers = numbers;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana, el valor de la apuesta
     * y los números seleccionados.
     * @param sedeName  Nombre de la sede.
     * @param cc        Número de identificación.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     * @param numbers   Cantidad de números seleccionados.
     */
    public BalotoDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue, int numbers) {
        super(sedeName, cc, dayOfWeek, betValue);
        this.numbers = numbers;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana y el valor de la apuesta.
     * @param sedeName  Nombre de la sede.
     * @param cc        Número de identificación.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     */
    public BalotoDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue) {
        super(sedeName, cc, dayOfWeek, betValue);
    }

    /**
     * Obtiene los números seleccionados.
     * @return Cantidad de números seleccionados.
     */
    public int getNumbers() {
        return numbers;
    }

    /**
     * Establece los números seleccionados.
     *
     * @param numbers Cantidad de números seleccionados.
     */
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    /**
     * Devuelve una cadena del objeto BalotoDTO.
     * @return Cadena que representa el objeto BalotoDTO.
     */
    @Override
    public String toString() {
        return super.toString() + ", Numeros: " + numbers;
    }
}
