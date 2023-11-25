package co.edu.unbosque.modulo4.model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;

/**
 * Clase una apuesta para BetPlay, que hereda de la clase Receipt e implementa Serializable.
 */
public class BetPlayDTO extends Receipt implements Serializable {

    /** Número de serie único para la serialización. */
    private static final long serialVersionUID = -7015497522274290602L;

    /** Lista de resultados de la apuesta. */
    private ArrayList<String> resultados;

    /** Constructor predeterminado. */
    public BetPlayDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que establece la lista de resultados de la apuesta.
     * @param resultados Lista de resultados de la apuesta.
     */
    public BetPlayDTO(ArrayList<String> resultados) {
        super();
        this.resultados = resultados;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana, el valor de la apuesta
     * y la lista de resultados de la apuesta.
     * @param sedeName   Nombre de la sede.
     * @param cc         Número de identificación.
     * @param dayOfWeek  Día de la semana.
     * @param betValue   Valor de la apuesta.
     * @param resultados Lista de resultados de la apuesta.
     */
    public BetPlayDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue, ArrayList<String> resultados) {
        super(sedeName, cc, dayOfWeek, betValue);
        this.resultados = resultados;
    }

    /**
     * Constructor que establece la sede, la cedula, el día de la semana y el valor de la apuesta.
     * @param sedeName  Nombre de la sede.
     * @param cc        Cedula.
     * @param dayOfWeek Día de la semana.
     * @param betValue  Valor de la apuesta.
     */
    public BetPlayDTO(String sedeName, long cc, DayOfWeek dayOfWeek, double betValue) {
        super(sedeName, cc, dayOfWeek, betValue);
    }

    /**
     * Obtiene la lista de resultados de la apuesta.
     * @return Lista de resultados de la apuesta.
     */
    public ArrayList<String> getResultados() {
        return resultados;
    }

    /**
     * Establece la lista de resultados de la apuesta.
     * @param resultados Lista de resultados de la apuesta.
     */
    public void setResultados(ArrayList<String> resultados) {
        this.resultados = resultados;
    }

    /**
     * Devuelve una representación en cadena del objeto BetPlayDTO.
     * @return Cadena que representa el objeto BetPlayDTO.
     */
    @Override
    public String toString() {
        return "Resultados=" + resultados;
    }
}
