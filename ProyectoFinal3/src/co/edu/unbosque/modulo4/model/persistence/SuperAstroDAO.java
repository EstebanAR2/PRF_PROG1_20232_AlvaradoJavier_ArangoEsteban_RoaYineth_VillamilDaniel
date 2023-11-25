package co.edu.unbosque.modulo4.model.persistence;

import java.time.DayOfWeek;
import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo4.model.SuperAstroDTO;


/**
 * Clase que implementa la interfaz CRUDOperation y representa un DAO para la clase SuperAstroDTO.
 */
public class SuperAstroDAO implements CRUDOperation {

    /**Lista que almacena objetos de tipo SuperAstroDTO. */
    private ArrayList<SuperAstroDTO> superAstros;

    /** Ruta del archivo serializable donde se almacenan los datos de SuperAstro.*/
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo4/model/persistence/apuestas-superastro.dat";

    /** Índice para realizar operaciones de actualización en la lista de superAstros. */
    private int index = 0;

    /**Constructor que inicializa la lista de superAstros. Si existe un archivo serializable, carga los datos almacenados en él. */
    public SuperAstroDAO() {
        superAstros = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<SuperAstroDTO> temp2 = (ArrayList<SuperAstroDTO>) temp;
            superAstros = temp2;
        } else {
            superAstros = new ArrayList<>();
        }
    }

    /** Escribe la lista de superAstros en un archivo serializable.*/
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, superAstros);
    }

    /**
     * Crea un nuevo objeto de tipo SuperAstroDTO y lo agrega a la lista de superAstros.
     * @param args Datos de tipo String necesarios para crear el objeto SuperAstroDTO.
     */
    @Override
    public void create(String... args) {
        SuperAstroDTO newSuper = new SuperAstroDTO();
        newSuper.setSedeName(args[0]);
        newSuper.setCc(Long.parseLong(args[1]));
        newSuper.setDayOfWeek(DayOfWeek.valueOf(args[2]));
        newSuper.setBetValue(Double.parseDouble(args[3]));
        newSuper.setNumbers(Integer.parseInt(args[4]));
        newSuper.setSignoZodiacal(args[5]);
        superAstros.add(newSuper);
        writeSerializable();
    }

    /**
     * Lee los datos de la lista de superAstros y los devuelve como una cadena de texto.
     * @return Cadena de texto con los datos de los superAstros.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        superAstros.forEach(game -> {
            sb.append(index + " -> " + (game.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza los datos de un objeto SuperAstroDTO en la lista de superAstros.
     * @param index Índice del objeto a actualizar en la lista.
     * @param args  Nuevos datos de tipo String para actualizar el objeto.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= superAstros.size()) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty()) {
                superAstros.get(index).setSedeName(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty()) {
                superAstros.get(index).setCc(Long.parseLong(args[1]));
            }
            if (!args[2].isBlank() || !args[2].isEmpty() || !args[2].equals("")) {
                superAstros.get(index).setDayOfWeek(DayOfWeek.valueOf(args[2]));
            }
            if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
                superAstros.get(index).setBetValue(Double.parseDouble(args[3]));
            }
            superAstros.get(index).setNumbers(Integer.parseInt(args[4]));
            if (!args[5].isBlank() || !args[5].isEmpty()) {
                superAstros.get(index).setSignoZodiacal(args[5]);
            }
            writeSerializable();
            return true;
        }
    }

    /**
     * Elimina un objeto SuperAstroDTO de la lista de superAstros.
     * @param index Índice del objeto a eliminar en la lista.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= superAstros.size()) {
            return false;
        }
        superAstros.remove(index);
        writeSerializable();
        return true;
    }

    /**
     * Obtiene la lista de superAstros.
     * @return Lista de superAstros.
     */
    public ArrayList<SuperAstroDTO> getSuperAstros() {
        return superAstros;
    }

    /**
     * Establece la lista de superAstros.
     * @param superAstros Lista de superAstros.
     */
    public void setSuperAstros(ArrayList<SuperAstroDTO> superAstros) {
        this.superAstros = superAstros;
    }
}
