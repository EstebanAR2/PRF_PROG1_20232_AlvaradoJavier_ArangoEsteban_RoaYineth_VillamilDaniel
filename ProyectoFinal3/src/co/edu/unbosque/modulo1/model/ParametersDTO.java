package co.edu.unbosque.modulo1.model;

import java.io.Serializable;

/**
 * ParametersDTO representa un objeto de transferencia de datos (DTO) para los parámetros de la casa de apuestas.
 * Implementa Serializable para permitir la serialización de objetos.
 */
public class ParametersDTO implements Serializable {
    /** El número de versión para la serialización. */
    private static final long serialVersionUID = 6530554932745465344L;
    /** El nombre de la casa de apuestas */
    private String shopName;
    /** El número de sedes de la casa de apuestas */
    private int sedesNum;
    /** El presupuesto total de la casa de apuestas */
    private double totalBudget;

    /**
     * Constructor vacio de la clase ParametersDTO.
     */
    public ParametersDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un objeto ParametersDTO con valores específicos. 
     * @param shopName    El nombre de la casa de apuestas.
     * @param sedesNum    El número de sedes de la casa de apuestas.
     * @param totalBudget El presupuesto total de la casa de apuestas.
     */
    public ParametersDTO(String shopName, int sedesNum, double totalBudget) {
        super();
        this.shopName = shopName;
        this.sedesNum = sedesNum;
        this.totalBudget = totalBudget;
    }

    /**
     * Obtiene el nombre de la casa de apuestas.
     * @return El nombre de la casa de apuestas.
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Establece el nombre de la casa de apuestas.
     * @param shopName El nuevo nombre de la casa de apuestas.
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Obtiene el número de sedes de la casa de apuestas. 
     * @return El número de sedes de la casa de apuestas.
     */
    public int getSedesNum() {
        return sedesNum;
    }

    /**
     * Establece el número de sedes de la casa de apuestas.
     * @param sedesNum El nuevo número de sedes de la casa de apuestas.
     */
    public void setSedesNum(int sedesNum) {
        this.sedesNum = sedesNum;
    }

    /**
     * Obtiene el presupuesto total de la casa de apuestas.
     * @return El presupuesto total de la casa de apuestas.
     */
    public double getTotalBudget() {
        return totalBudget;
    }

    /**
     * Establece el presupuesto total de la casa de apuestas.
     * @param totalBudget El nuevo presupuesto total de la casa de apuestas.
     */
    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    /**
     * Genera una cadena String del objeto ParametersDTO.
     * @return Una cadena que representa el objeto ParametersDTO.
     */
    @Override
    public String toString() {
        return "Nombre de la casa de apuestas: " + shopName + "\nNumero de sedes: " + sedesNum + "\nPresupuesto total: " + totalBudget;
    }    
}
