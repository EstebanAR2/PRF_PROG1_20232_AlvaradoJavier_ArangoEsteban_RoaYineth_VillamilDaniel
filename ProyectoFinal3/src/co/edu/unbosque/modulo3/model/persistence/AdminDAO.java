package co.edu.unbosque.modulo3.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo3.model.AdminDTO;

/**
 * AdminDAO implementa operaciones CRUD para la gestión de administradores.
 * Utiliza serialización para almacenar y recuperar datos de administradores en un archivo.
 */
public class AdminDAO implements CRUDOperation {
    /** Lista que almacena objetos de tipo AdminDTO. */
    private ArrayList<AdminDTO> listaAdmins;
    /** Ruta del archivo para la serialización de datos de administradores. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo3/model/persistence/administradores.dat";
    /** Índice utilizado en operaciones de actualización y eliminación. */
    private int index = 0;

    /**
     * Constructor AdminDAO. Inicializa la lista de administradores y carga datos si existen.
     */
    public AdminDAO() {
        listaAdmins = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<AdminDTO> temp2 = (ArrayList<AdminDTO>) temp;
            listaAdmins = temp2;
        } else {
            listaAdmins = new ArrayList<>();
        }
    }

    /**
     * Método que escribe la lista de administradores en el archivo de serialización.
     */
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listaAdmins);
    }

    /**
     * Implementación del método create para agregar un nuevo administrador a la lista.
     * @param args Arreglo de cadenas con los datos del administrador: nombre, cedula, direccion, celular, usuario, contrasena.
     */
    @Override
    public void create(String... args) {
        AdminDTO newAdmin = new AdminDTO();
        newAdmin.setNombre(args[0]);
        newAdmin.setCedula(Long.parseLong(args[1]));
        newAdmin.setDireccion(args[2]);
        newAdmin.setCelular(Long.parseLong(args[3]));
        newAdmin.setUsuario(args[4]);
        newAdmin.setContrasena(args[5]);
        listaAdmins.add(newAdmin);
        writeSerializable();
    }

    /**
     * Implementación del método readData para obtener una representación en cadena de la lista de administradores.
     * @return Cadena que representa la lista de administradores.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        listaAdmins.forEach(admin -> {
            sb.append(index + 1 + " -> " + (admin.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Implementación del método update para modificar los datos de un administrador en la lista.
     * @param index Índice del administrador a actualizar.
     * @param args  Arreglo de cadenas con los nuevos datos del administrador: nombre, cedula, direccion, celular, usuario, contrasena.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= listaAdmins.size()) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty()) {
                listaAdmins.get(index).setNombre(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty() || !args[1].equals("")) {
                listaAdmins.get(index).setCedula(Long.parseLong(args[1]));
            }
            if (!args[2].isBlank() || !args[2].isEmpty() || !args[2].equals("")) {
                listaAdmins.get(index).setDireccion(args[2]);
            }
            if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
                listaAdmins.get(index).setCelular(Long.parseLong(args[3]));
            }
            if (!args[4].isBlank() || !args[4].isEmpty()) {
                listaAdmins.get(index).setUsuario(args[4]);
            }
            if (!args[5].isBlank() || !args[5].isEmpty()) {
                listaAdmins.get(index).setContrasena(args[5]);
            }
            writeSerializable();
            return true;
        }
    }

    /**
     * Implementación del método delete para eliminar un administrador de la lista.
     * @param index Índice del administrador a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= listaAdmins.size()) {
            return false;
        } else {
            listaAdmins.remove(index);
            writeSerializable();
            return true;
        }
    }

    /**
     * Método para iniciar sesión de un administrador.
     * @param usuario   Nombre de usuario del administrador.
     * @param contrasena Contraseña del administrador.
     * @return Objeto AdminDTO si las credenciales son válidas, null de lo contrario.
     */
    public AdminDTO iniciarSesion(String usuario, String contrasena) {
        for (AdminDTO a : listaAdmins) {
            if (a.getUsuario().equals(usuario) && a.getContrasena().equals(contrasena)) {
                return a; 
            } 
        }
        return null; 
    }

    /**
     * Obtiene la lista de administradores.
     * @return Lista de objetos AdminDTO.
     */
    public ArrayList<AdminDTO> getListaAdmins() {
        return listaAdmins;
    }

    /**
     * Establece la lista de administradores.
     * @param listaAdmins Nueva lista de objetos AdminDTO.
     */
    public void setListaAdmins(ArrayList<AdminDTO> listaAdmins) {
        this.listaAdmins = listaAdmins;
    }
}