package co.edu.unbosque.modulo2.model;

import java.io.Serializable;

/**
 * BranchDTO representa la informacion de una sede.
 */
public class BranchDTO implements Serializable {

    /** Numero de version para la serializacion. */
    private static final long serialVersionUID = -9068228043115375394L;
    /** Ubicacion de la sede. */
    private String location;
    /** Numero de empleados en la sede. */
    private int employeesNum;

    /**
     * Constructor de BranchDTO.
     */
    public BranchDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor de BranchDTO con parametros.
     * @param location     La ubicacion de la sede.
     * @param employeesNum El numero de empleados en la sede.
     */
    public BranchDTO(String location, int employeesNum) {
        super();
        this.location = location;
        this.employeesNum = employeesNum;
    }

    /**
     * Obtiene la ubicacion de la sede.
     * @return La ubicacion de la sede.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Establece la ubicacion de la sede.
     * @param location La nueva ubicacion de la sede.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Obtiene el numero de empleados en la sede.
     * @return El numero de empleados en la sede.
     */
    public int getEmployeesNum() {
        return employeesNum;
    }

    /**
     * Establece el numero de empleados en la sede.
     * @param employeesNum El nuevo numero de empleados en la sede.
     */
    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    /**
     * Devuelve una cadena con los datos de la sede.
     * @return Una cadena que representa la sede.
     */
    @Override
    public String toString() {
        StringBuilder chain = new StringBuilder();
        chain.append("la localidad es : ").append(location).append("\n");
        chain.append("el numero de empleados es : ").append(employeesNum).append("\n");
        return chain.toString();
    }
}
