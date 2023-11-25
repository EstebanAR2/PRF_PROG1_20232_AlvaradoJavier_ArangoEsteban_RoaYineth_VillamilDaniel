package co.edu.unbosque.modulo4.model.persistence;

import java.time.DayOfWeek;
import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo4.model.ChanceDTO;


/**
 * Clase que implementa la interfaz CRUDOperation y representa un DAO para la clase ChanceDTO.
 */
public class ChanceDAO implements CRUDOperation {

    /**Lista que almacena objetos de tipo ChanceDTO.*/
    private ArrayList<ChanceDTO> chances;

    /**Ruta del archivo serializable donde se almacenan los datos de Chance. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo4/model/persistence/apuestas-chance.dat";

    /**Índice para realizar operaciones de actualización en la lista de chances.*/
    private int index = 0;

    /** Constructor que inicializa la lista de chances. Si existe un archivo serializable, carga los datos almacenados en él.*/
    public ChanceDAO() {
        chances = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<ChanceDTO> temp2 = (ArrayList<ChanceDTO>) temp;
            chances = temp2;
        } else {
            chances = new ArrayList<>();
        }
    }

    /** Escribe la lista de chances en un archivo serializable.*/
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, chances);
    }

    /**
     * Crea un nuevo objeto de tipo ChanceDTO y lo agrega a la lista de chances.
     * @param args Datos de tipo String necesarios para crear el objeto ChanceDTO.
     */
    @Override
    public void create(String... args) {
        ChanceDTO newChance = new ChanceDTO();
        newChance.setSedeName(args[0]);
        newChance.setCc(Long.parseLong(args[1]));
        newChance.setDayOfWeek(DayOfWeek.valueOf(args[2]));
        newChance.setBetValue(Double.parseDouble(args[3]));
        newChance.setName(args[4]);
        newChance.setNumbers(Integer.parseInt(args[5]));
        chances.add(newChance);
        writeSerializable();
    }

    /**
     * Lee los datos de la lista de chances y los devuelve como una cadena de texto.
     * @return Cadena de texto con los datos de los chances.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        chances.forEach(game -> {
            sb.append(index + " -> " + (game.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza los datos de un objeto ChanceDTO en la lista de chances.
     * @param index Índice del objeto a actualizar en la lista.
     * @param args  Nuevos datos de tipo String para actualizar el objeto.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= chances.size()) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty()) {
                chances.get(index).setSedeName(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty()) {
                chances.get(index).setCc(Long.parseLong(args[1]));
            }
            if (!args[2].isBlank() || !args[2].isEmpty() || !args[2].equals("")) {
                chances.get(index).setDayOfWeek(DayOfWeek.valueOf(args[2]));
            }
            if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
                chances.get(index).setBetValue(Double.parseDouble(args[3]));
            }
            chances.get(index).setName(args[4]);
            chances.get(index).setNumbers(Integer.parseInt(args[5]));

            writeSerializable();
            return true;
        }
    }

    /**
     * Elimina un objeto ChanceDTO de la lista de chances.
     * @param index Índice del objeto a eliminar en la lista.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= chances.size()) {
            return false;
        }
        chances.remove(index);
        writeSerializable();
        return true;
    }

    /**
     * Obtiene la lista de chances.
     * @return Lista de chances.
     */
    public ArrayList<ChanceDTO> getChances() {
        return chances;
    }

    /**
     * Establece la lista de chances.
     * @param chances Lista de chances.
     */
    public void setChances(ArrayList<ChanceDTO> chances) {
        this.chances = chances;
    }
}
