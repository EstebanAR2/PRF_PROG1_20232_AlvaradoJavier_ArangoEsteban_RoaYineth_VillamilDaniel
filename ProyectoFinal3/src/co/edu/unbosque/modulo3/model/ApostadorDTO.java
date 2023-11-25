package co.edu.unbosque.modulo3.model;

import java.io.Serializable;

/**
 * La clase ApostadorDTO representa un objeto de transferencia de datos para un apostador.
 * Implementa Serializable para permitir la serialización de objetos.
 */
public class ApostadorDTO implements Serializable {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = 364353791552755624L;
    /** Nombre del apostador. */
    private String nombre;
    /** Número de cédula del apostador. */
    private long cedula;
    /** Sede del apostador. */
    private String sede;
    /** Dirección del apostador. */
    private String direccion;
    /** Número de celular del apostador. */
    private long celular;
    /** Nombre de usuario del apostador. */
    private String usuario;
    /** Contraseña del apostador. */
    private String contrasena;
    
    /**
     * Constructor de ApostadorDTO.
     */
    public ApostadorDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de ApostadorDTO.
     *
     * @param nombre     Nombre del apostador.
     * @param cedula     Número de cédula del apostador.
     * @param sede       Sede del apostador.
     * @param direccion  Dirección del apostador.
     * @param celular    Número de celular del apostador.
     * @param usuario    Nombre de usuario del apostador.
     * @param contrasena Contraseña del apostador.
     */
    public ApostadorDTO(String nombre, long cedula, String sede, String direccion, long celular, String usuario,
            String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sede = sede;
        this.direccion = direccion;
        this.celular = celular;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del apostador.
     * @return Nombre del apostador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del apostador.
     * @param nombre Nuevo nombre del apostador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de cédula del apostador.
     * @return Número de cédula del apostador.
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * Establece el número de cédula del apostador.
     * @param cedula Nuevo número de cédula del apostador.
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene la sede del apostador.
     * @return Sede del apostador.
     */
    public String getSede() {
        return sede;
    }

    /**
     * Establece la sede del apostador.
     * @param sede Nueva sede del apostador.
     */
    public void setSede(String sede) {
        this.sede = sede;
    }

    /**
     * Obtiene la dirección del apostador.
     * @return Dirección del apostador.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del apostador.
     * @param direccion Nueva dirección del apostador.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de celular del apostador.
     * @return Número de celular del apostador.
     */
    public long getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del apostador.
     * @param celular Nuevo número de celular del apostador.
     */
    public void setCelular(long celular) {
        this.celular = celular;
    }

    /**
     * Obtiene el nombre de usuario del apostador.
     * @return Nombre de usuario del apostador.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del apostador.
     * @param usuario Nuevo nombre de usuario del apostador.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del apostador.
     * @return Contraseña del apostador.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del apostador.
     * @param contrasena Nueva contraseña del apostador.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Genera una cadena del objeto ApostadorDTO.
     * @return Cadena que representa el objeto ApostadorDTO.
     */
    @Override
    public String toString() {
        return "ApostadorDTO [nombre=" + nombre + ", cedula=" + cedula + ", sede=" + sede + ", direccion=" + direccion
                + ", celular=" + celular + " usuario: " + usuario + " Contrasena: " + contrasena;
    }
}
