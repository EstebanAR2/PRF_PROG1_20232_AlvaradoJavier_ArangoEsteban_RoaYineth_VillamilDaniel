package co.edu.unbosque.modulo4.model;

import java.io.Serializable;
import java.time.DayOfWeek;

/**
 * Clase que representa un recibo de apuesta para Chance, que hereda de la clase Receipt e implementa Serializable.
 */
public class ChanceDTO extends Receipt implements Serializable {

    /**Número de serie único para la serialización.*/
    private static final long serialVersionUID = 6664159118448864908L;

    /** Nombre de la lotería.*/
    private String name;

    /** Números seleccionados en la apuesta de Chance.*/
    private int numbers;

    /** Constructor predeterminado.*/
    public ChanceDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que establece el nombre de la lotería y los números seleccionados.
     * @param name    Nombre de la lotería.
     * @param numbers Números seleccionados.
     */
    public ChanceDTO(String name, int numbers) {
        super();
        this.name = name;
        this.numbers = numbers;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana, el valor de la apuesta,
     * el nombre de la lotería y los números seleccionados.
     *
     * @param sedeName  Nombre de la sede.
     * @param cc        Cedula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     * @param name      Nombre de la lotería.
     * @param numbers   Números seleccionados.
     */
    public ChanceDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue, String name, int numbers) {
        super(sedeName, cc, dayOfWeek, betValue);
        this.name = name;
        this.numbers = numbers;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana y el valor de la apuesta.
     * @param sedeName  Nombre de la sede.
     * @param cc        Cedula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     */
    public ChanceDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue) {
        super(sedeName, cc, dayOfWeek, betValue);
    }

    /**
     * Obtiene el nombre de la lotería.
     * @return Nombre de la lotería.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre de la lotería.
     * @param name Nombre de la lotería.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene los números seleccionados.
     * @return Números seleccionados.
     */
    public int getNumbers() {
        return numbers;
    }

    /**
     * Establece los números seleccionados.
     * @param numbers Cantidad de números seleccionados.
     */
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    /**
     * Devuelve una cadena del objeto ChanceDTO.
     * @return Cadena que representa el objeto ChanceDTO.
     */
    @Override
    public String toString() {
        return super.toString() + ", Nombre de la lotería: " + name + ", Numeros: " + numbers;
    }
}
