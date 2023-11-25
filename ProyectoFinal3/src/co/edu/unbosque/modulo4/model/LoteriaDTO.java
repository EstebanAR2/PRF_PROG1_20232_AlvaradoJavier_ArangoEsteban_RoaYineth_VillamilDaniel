package co.edu.unbosque.modulo4.model;

import java.io.Serializable;
import java.time.DayOfWeek;

/**
 * Clase que representa la apuesta para una lotería, que hereda de la clase Receipt e implementa Serializable.
 */
public class LoteriaDTO extends Receipt implements Serializable {

    /** Número de serie único para la serialización.*/
    private static final long serialVersionUID = 8376445203910868828L;

    /**Nombre de la lotería. */
    private String name;

    /**Cantidad de números seleccionados en la apuesta de la lotería.*/
    private int numbers;

    /** Número de serie de la apuesta de la lotería.*/
    private int serie;

    /** Constructor predeterminado.*/
    public LoteriaDTO() {
    }

    /**
     * Constructor que establece el nombre de la lotería, los números seleccionados y la serie.
     * @param name    Nombre de la lotería.
     * @param numbers Números seleccionados.
     * @param serie   Número de serie.
     */
    public LoteriaDTO(String name, int numbers, int serie) {
        super();
        this.name = name;
        this.numbers = numbers;
        this.serie = serie;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana, el valor de la apuesta,
     * el nombre de la lotería, los números seleccionados y la serie.
     * @param sedeName  Nombre de la sede.
     * @param cc        Cedula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     * @param name      Nombre de la lotería.
     * @param numbers   Números seleccionados.
     * @param serie     Número de serie.
     */
    public LoteriaDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue, String name, int numbers,
                      int serie) {
        super(sedeName, cc, dayOfWeek, betValue);
        this.name = name;
        this.numbers = numbers;
        this.serie = serie;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana y el valor de la apuesta.
     *
     * @param sedeName  Nombre de la sede.
     * @param cc        Cedula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     */
    public LoteriaDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue) {
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
     * @param numbers Números seleccionados.
     */
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    /**
     * Obtiene el número de serie.
     * @return Número de serie.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Establece el número de serie.
     * @param serie Número de serie.
     */
    public void setSerie(int serie) {
        this.serie = serie;
    }

    /**
     * Devuelve una representación en cadena del objeto LoteriaDTO.
     * @return Cadena que representa el objeto LoteriaDTO.
     */
    @Override
    public String toString() {
        return super.toString() + " Nombre de la lotería: " + name + ", Numeros: " + numbers + ", Serie: " + serie;
    }
}
