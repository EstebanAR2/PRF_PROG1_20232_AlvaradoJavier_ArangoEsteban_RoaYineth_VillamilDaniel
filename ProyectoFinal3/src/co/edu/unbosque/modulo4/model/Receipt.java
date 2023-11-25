package co.edu.unbosque.modulo4.model;

import java.io.Serializable;
import java.time.DayOfWeek;

/**
 * Clase abstracta que representa un recibo de apuesta, implementa Serializable.
 */
public abstract class Receipt implements Serializable {

    /**Número de serie único para la serialización.*/
    private static final long serialVersionUID = -6852391181403812953L;

    /**Nombre de la sede.*/
    private String sedeName;

    /** Cedula. */
    private long cc;

    /** Día de la semana. */
    private DayOfWeek dayOfWeek;

    /**Valor de la apuesta. */
    private double betValue;

    /**Constructor predeterminado. */
    public Receipt() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana y el valor de la apuesta.
     * @param sedeName  Nombre de la sede.
     * @param cc        Cedula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     */
    public Receipt(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue) {
        super();
        this.sedeName = sedeName;
        this.cc = cc;
        this.dayOfWeek = dayOfWeek;
        this.betValue = betValue;
    }

    /**
     * Obtiene el nombre de la sede.
     * @return Nombre de la sede.
     */
    public String getSedeName() {
        return sedeName;
    }

    /**
     * Establece el nombre de la sede.
     * @param sedeName Nombre de la sede.
     */
    public void setSedeName(String sedeName) {
        this.sedeName = sedeName;
    }

    /**
     * Obtiene la cedula.
     * @return Cedula.
     */
    public long getCc() {
        return cc;
    }

    /**
     * Establece la cedula.
     * @param cc Cedula.
     */
    public void setCc(long cc) {
        this.cc = cc;
    }

    /**
     * Obtiene el día de la semana.
     * @return Día de la semana.
     */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Establece el día de la semana.
     * @param dayOfWeek Día de la semana.
     */
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Obtiene el valor de la apuesta.
     * @return Valor de la apuesta.
     */
    public double getBetValue() {
        return betValue;
    }

    /**
     * Establece el valor de la apuesta.
     * @param betValue Valor de la apuesta.
     */
    public void setBetValue(double betValue) {
        this.betValue = betValue;
    }

    /**
     * Devuelve una representación en cadena del objeto Receipt.
     * @return Cadena que representa el objeto Receipt.
     */
    @Override
    public String toString() {
        return "Sede: " + sedeName + ", Cedula: " + cc + ", Dia: " + dayOfWeek + ", Valor apostado: " + betValue + " COP";
    }
}
