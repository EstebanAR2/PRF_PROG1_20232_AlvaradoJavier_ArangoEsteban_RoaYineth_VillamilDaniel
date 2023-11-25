package co.edu.unbosque.modulo4.model.persistence;

import java.time.DayOfWeek;
import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo4.model.LoteriaDTO;

/**
 * Clase que implementa la interfaz CRUDOperation y representa un DAO para la clase LoteriaDTO.
 */
public class LoteriaDAO implements CRUDOperation {

    /**Lista que almacena objetos de tipo LoteriaDTO.*/
    private ArrayList<LoteriaDTO> loterias;

    /** Ruta del archivo serializable donde se almacenan los datos de Loteria. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo4/model/persistence/apuestas-loteria.dat";

    /** Índice para realizar operaciones de actualización en la lista de loterias. */
    private int index = 0;

    /** Constructor que inicializa la lista de loterias. Si existe un archivo serializable, carga los datos almacenados en él. */
    public LoteriaDAO() {
        loterias = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<LoteriaDTO> temp2 = (ArrayList<LoteriaDTO>) temp;
            loterias = temp2;
        } else {
            loterias = new ArrayList<>();
        }
    }

    /** Escribe la lista de loterias en un archivo serializable. */
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, loterias);
    }

    /**
     * Crea un nuevo objeto de tipo LoteriaDTO y lo agrega a la lista de loterias.
     * @param args Datos de tipo String necesarios para crear el objeto LoteriaDTO.
     */
    @Override
    public void create(String... args) {
        LoteriaDTO newLoteria = new LoteriaDTO();
        newLoteria.setSedeName(args[0]);
        newLoteria.setCc(Long.parseLong(args[1]));
        newLoteria.setDayOfWeek(DayOfWeek.valueOf(args[2]));
        newLoteria.setBetValue(Double.parseDouble(args[3]));
        newLoteria.setName(args[4]);
        newLoteria.setNumbers(Integer.parseInt(args[5]));
        newLoteria.setSerie(Integer.parseInt(args[6]));
        loterias.add(newLoteria);
        writeSerializable();
    }

    /**
     * Lee los datos de la lista de loterias y los devuelve como una cadena de texto.
     * @return Cadena de texto con los datos de las loterias.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        loterias.forEach(game -> {
            sb.append(index + " -> " + (game.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza los datos de un objeto LoteriaDTO en la lista de loterias.
     * @param index Índice del objeto a actualizar en la lista.
     * @param args  Nuevos datos de tipo String para actualizar el objeto.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= loterias.size()) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty() || !args[0].equals("")) {
                loterias.get(index).setSedeName(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty() || !args[1].equals("")) {
                loterias.get(index).setCc(Long.parseLong(args[1]));
            }
            if (!args[2].isBlank() || !args[2].isEmpty() || !args[2].equals("")) {
                loterias.get(index).setDayOfWeek(DayOfWeek.valueOf(args[2]));
            }
            if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
                loterias.get(index).setBetValue(Double.parseDouble(args[3]));
            }
            if (!args[4].isBlank() || !args[4].isEmpty()) {
                loterias.get(index).setName(args[4]);
            }
            loterias.get(index).setNumbers(Integer.parseInt(args[5]));
            loterias.get(index).setSerie(Integer.parseInt(args[6]));
            writeSerializable();
            return true;
        }
    }

    /**
     * Elimina un objeto LoteriaDTO de la lista de loterias.
     * @param index Índice del objeto a eliminar en la lista.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= loterias.size()) {
            return false;
        }
        loterias.remove(index);
        writeSerializable();
        return true;
    }

    /**
     * Obtiene la lista de loterias.
     * @return Lista de loterias.
     */
    public ArrayList<LoteriaDTO> getLoterias() {
        return loterias;
    }

    /**
     * Establece la lista de loterias.
     * @param loterias Lista de loterias.
     */
    public void setLoterias(ArrayList<LoteriaDTO> loterias) {
        this.loterias = loterias;
    }
}