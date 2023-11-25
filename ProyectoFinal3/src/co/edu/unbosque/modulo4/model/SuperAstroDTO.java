package co.edu.unbosque.modulo4.model;

import java.io.Serializable;
import java.time.DayOfWeek;

/**
 * Clase que representa una apuesta para SuperAstro, que hereda de la clase Receipt e implementa Serializable.
 */
public class SuperAstroDTO extends Receipt implements Serializable {

    /**Número de serie único para la serialización. */
    private static final long serialVersionUID = 8883753544414660935L;

    /**Numeros seleccionados en la apuesta de SuperAstro.*/
    private int numbers;

    /**Signo zodiacal asociado a la apuesta de SuperAstro. */
    private String signoZodiacal;

    /** Constructor predeterminado. */
    public SuperAstroDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que establece los numeros seleccionados y el signo zodiacal.
     * @param numbers        Numeros seleccionados.
     * @param signoZodiacal Signo zodiacal asociado a la apuesta de SuperAstro.
     */
    public SuperAstroDTO(int numbers, String signoZodiacal) {
        super();
        this.numbers = numbers;
        this.signoZodiacal = signoZodiacal;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana, el valor de la apuesta,
     * los numeros seleccionados y el signo zodiacal.
     * @param sedeName       Nombre de la sede.
     * @param cc             Cédula.
     * @param dayOfWeek      Día de la semana.
     * @param betValue       Valor de la apuesta.
     * @param numbers        Numeros seleccionados.
     * @param signoZodiacal Signo zodiacal asociado a la apuesta de SuperAstro.
     */
    public SuperAstroDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue, int numbers,
                         String signoZodiacal) {
        super(sedeName, cc, dayOfWeek, betValue);
        this.numbers = numbers;
        this.signoZodiacal = signoZodiacal;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana y el valor de la apuesta.
     * @param sedeName  Nombre de la sede.
     * @param cc        Cédula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     */
    public SuperAstroDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue) {
        super(sedeName, cc, dayOfWeek, betValue);
    }

    /**
     * Obtiene los numeros seleccionados.
     * @return Numeros seleccionados.
     */
    public int getNumbers() {
        return numbers;
    }

    /**
     * Establece los numeros seleccionados.
     * @param numbers Numeros seleccionados.
     */
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    /**
     * Obtiene el signo zodiacal asociado a la apuesta de SuperAstro.
     * @return Signo zodiacal.
     */
    public String getSignoZodiacal() {
        return signoZodiacal;
    }

    /**
     * Establece el signo zodiacal asociado a la apuesta de SuperAstro.
     * @param signoZodiacal Signo zodiacal.
     */
    public void setSignoZodiacal(String signoZodiacal) {
        this.signoZodiacal = signoZodiacal;
    }

    /**
     * Devuelve una representación en cadena del objeto SuperAstroDTO.
     * @return Cadena que representa el objeto SuperAstroDTO.
     */
    @Override
    public String toString() {
        return super.toString() + ". Numeros: " + numbers + ", Signo del zodiaco: " + signoZodiacal;
    }
}
