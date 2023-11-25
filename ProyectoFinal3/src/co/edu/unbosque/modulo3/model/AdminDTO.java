package co.edu.unbosque.modulo3.model;

import java.io.Serializable;

/**
 * AdminDTO representa un objeto de transferencia de datos para un administrador de la casa de apuestas.
 * Implementa Serializable para permitir la serializacion de objetos.
 */
public class AdminDTO implements Serializable {

    /** Identificador unico para la serializacion. */
    private static final long serialVersionUID = -6544856102422770658L;
    /** Nombre del administrador. */
    private String nombre;
    /** Número de cedula del administrador. */
    private long cedula;
    /** Direccion del administrador. */
    private String direccion;
    /** Numero de celular del administrador. */
    private long celular;
    /** Nombre de usuario del administrador. */
    private String usuario;
    /** Contraseña del administrador. */
    private String contrasena;

    /**
     * Constructor de AdminDTO.
     */
    public AdminDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de AdminDTO.
     * @param nombre     Nombre del administrador.
     * @param cedula     Numero de cedula del administrador.
     * @param direccion  Direccion del administrador.
     * @param celular    Numero de celular del administrador.
     * @param usuario    Nombre de usuario del administrador.
     * @param contrasena Contraseña del administrador.
     */
    public AdminDTO(String nombre, long cedula, String direccion, long celular, String usuario, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.celular = celular;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del administrador.
     * @return Nombre del administrador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del administrador.
     * @param nombre Nuevo nombre del administrador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de cédula del administrador.
     * @return Numero de cédula del administrador.
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * Establece el numero de cedula del administrador.
     * @param cedula Nuevo numero de cedula del administrador.
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene la direccion del administrador.
     * @return Direccion del administrador.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion del administrador.
     * @param direccion Nueva direccion del administrador.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el numero de celular del administrador.
     * @return Número de celular del administrador.
     */
    public long getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del administrador.
     * @param celular Nuevo numero de celular del administrador.
     */
    public void setCelular(long celular) {
        this.celular = celular;
    }

    /**
     * Obtiene el nombre de usuario del administrador.
     * @return Nombre de usuario del administrador.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del administrador.
     * @param usuario Nuevo nombre de usuario del administrador.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del administrador.
     * @return Contraseña del administrador.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del administrador.
     * @param contrasena Nueva contraseña del administrador.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Genera una cadena del objeto AdminDTO.
     * @return Cadena que representa el objeto AdminDTO.
     */
    @Override
    public String toString() {
        return "Cuenta de administrador. Usuario: "+usuario+", Contrasena: "+contrasena;
    }
}
