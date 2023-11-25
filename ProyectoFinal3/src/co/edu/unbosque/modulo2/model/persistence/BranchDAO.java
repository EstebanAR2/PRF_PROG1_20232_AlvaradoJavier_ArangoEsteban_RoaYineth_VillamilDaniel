package co.edu.unbosque.modulo2.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo2.model.BranchDTO;


/**
 * BranchDAO implementa la interfaz CRUDOperation y gestiona las operaciones
 * CRUD para las sedes.
 */
public class BranchDAO implements CRUDOperation {

    /** Lista de sedes. */
    private ArrayList<BranchDTO> listaSedes;
    /** Ruta del archivo serializado. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo2/model/persistence/sedes.dat";
    /** Indice actual. */
    int index = 0;

    /**
     * Constructor de la clase BranchDAO.
     * Inicializa la lista de sedes a partir del archivo serializado si existe.
     */
    public BranchDAO() {
        listaSedes = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<BranchDTO> temp2 = (ArrayList<BranchDTO>) temp;
            listaSedes = temp2;
        } else {
            listaSedes = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de sedes en el archivo serializado.
     */
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listaSedes);
    }

    /**
     * Crea una nueva sede con la ubicacion y el numero de empleados proporcionados.
     * @param args Los atributos de la sede a crear.
     */
    @Override
    public void create(String... args) {
        BranchDTO newBranch = new BranchDTO();
        newBranch.setLocation(args[0]);
        newBranch.setEmployeesNum(Integer.parseInt(args[1]));
        listaSedes.add(newBranch);
        writeSerializable();
    }

    /**
     * Devuelve una cadena con la informacion de todas las sede.
     *
     * @return La informacion de las sedes como una cadena.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        listaSedes.forEach(sede -> {
            sb.append(index + 1).append(" -> ").append(sede.toString()).append("\n");
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza la informacion de una sede en la posición dada.
     * @param index La posicion de la sede a actualizar.
     * @param args  Nuevos datos para la sucursal.
     * @return true si la actualizacion fue exitosa, false si la posicion es inválida.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= listaSedes.size()) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty()) {
                listaSedes.get(index).setLocation(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty() || !args[1].equals("")) {
                listaSedes.get(index).setEmployeesNum(Integer.parseInt(args[1]));
            }
            writeSerializable();
            return true;
        }
    }

    /**
     * Actualiza la informacion de una sucursal por nombre.
     * @param location La ubicacion de la sede a actualizar.
     * @param args     Nuevos datos para la sucursal.
     * @return true si la actualizacion fue exitosa, false si no se encontro la sucursal.
     */
    public boolean updateByName(String location, String... args) {
        index = -1;
        for (int i = 0; i < listaSedes.size(); i++) {
            if (listaSedes.get(i).getLocation().equalsIgnoreCase(location)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty()) {
                listaSedes.get(index).setLocation(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty() || !args[1].equals("")) {
                listaSedes.get(index).setEmployeesNum(Integer.parseInt(args[1]));
            }
            writeSerializable();
            return true;
        }
    }

    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= listaSedes.size()) {
            return false;
        } else {
            listaSedes.remove(index);
            writeSerializable();
            return true;
        }
    }

    /**
     * Elimina una sede por ubicacion.
     * @param ubicacion La ubicacion de la sede a eliminar.
     * @return true si la eliminacion fue exitosa, false si no se encontro la sede.
     */
    public boolean deleteByLocation(String ubicacion) {
        index = -1;
        for (int i = 0; i < listaSedes.size(); i++) {
            if (listaSedes.get(i).getLocation().equalsIgnoreCase(ubicacion)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            listaSedes.remove(index);
            writeSerializable();
            return true;
        }
    }

    /**
     * Obtiene la lista de sede.
     * @return La lista de sede.
     */
    public ArrayList<BranchDTO> getListaSedes() {
        return listaSedes;
    }

    /**
     * Establece la lista de sedes.
     * @param listaSedes La nueva lista de sedes.
     */
    public void setListaSedes(ArrayList<BranchDTO> listaSedes) {
        this.listaSedes = listaSedes;
    }
}
