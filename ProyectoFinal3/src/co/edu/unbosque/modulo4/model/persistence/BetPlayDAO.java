package co.edu.unbosque.modulo4.model.persistence;

import java.time.DayOfWeek;
import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo4.model.BetPlayDTO;



/**
 * Clase que implementa la interfaz CRUDOperation y representa un DAO para la case BetPlayDTO.
 */
public class BetPlayDAO implements CRUDOperation {

    /** Lista que almacena objetos de tipo BetPlayDTO.*/
    private ArrayList<BetPlayDTO> resultados;

    /**Lista que almacena los resultados de apuestas como cadenas de texto.*/
    private ArrayList<String> result;

    /** Lista que almacena los nuevos resultados de apuestas como cadenas de texto.*/
    private ArrayList<String> nuevosResultados;

    /** Ruta del archivo serializable donde se almacenan los datos de BetPlay.*/
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo4/model/persistence/apuestas-betplay.dat";

    /**Índice para realizar operaciones de actualización en la lista de resultados. */
    private int index = 0;

    /**Constructor que inicializa las listas de resultados. Si existe un archivo serializable, carga los datos almacenados en él.*/
    public BetPlayDAO() {
        resultados = new ArrayList<>();
        result = new ArrayList<>();
        nuevosResultados = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<BetPlayDTO> temp2 = (ArrayList<BetPlayDTO>) temp;
            resultados = temp2;
        } else {
            resultados = new ArrayList<>();
        }
    }

    /**Escribe la lista de de objetos BetPlayDTO en un archivo serializable.*/
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, resultados);
    }

    /**
     * Crea un nuevo objeto de tipo BetPlayDTO y lo agrega a la lista de resultados.
     * @param args Datos de tipo String necesarios para crear el objeto BetPlayDTO.
     */
    @Override
    public void create(String... args) {
        BetPlayDTO newBetPlay = new BetPlayDTO();
        newBetPlay.setSedeName(args[0]);
        newBetPlay.setCc(Long.parseLong(args[1]));
        newBetPlay.setDayOfWeek(DayOfWeek.valueOf(args[2]));
        newBetPlay.setBetValue(Double.parseDouble(args[3]));
        for (int i = 4; i < args.length; i++) {
            result.add(args[i]);
        }
        newBetPlay.setResultados(result);
        resultados.add(newBetPlay);
        writeSerializable();
    }

    /**
     * Lee los datos de la lista de resultados y los devuelve como una cadena de texto.
     * @return Cadena de texto con los datos de los resultados.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        resultados.forEach(game -> {
            sb.append(index + " -> " + (game.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza los datos de un objeto BetPlayDTO en la lista de resultados.
     * @param index Índice del objeto a actualizar en la lista.
     * @param args  Nuevos datos de tipo String para actualizar el objeto.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= resultados.size()) {
            return false;
        } else {
            BetPlayDTO betPlayToUpdate = resultados.get(index);

            if (!args[0].isBlank() || !args[0].isEmpty() || !args[0].equals("")) {
                resultados.get(index).setSedeName(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty() || !args[1].equals("")) {
                resultados.get(index).setCc(Long.parseLong(args[1]));
            }
            if (!args[2].isBlank() || !args[2].isEmpty() || !args[2].equals("")) {
                resultados.get(index).setDayOfWeek(DayOfWeek.valueOf(args[2]));
            }
            if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
                resultados.get(index).setBetValue(Double.parseDouble(args[3]));
            }
            for (int i = 4; i < args.length; i++) {
                nuevosResultados.add(args[i]);
            }
            betPlayToUpdate.setResultados(nuevosResultados);

            writeSerializable();
            return true;
        }
    }

    /**
     * Elimina un objeto BetPlayDTO de la lista de resultados.
     * @param index Índice del objeto a eliminar en la lista.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= resultados.size()) {
            return false;
        }
        resultados.remove(index);
        writeSerializable();
        return true;
    }

    /**
     * Obtiene la lista de resultados.
     * @return Lista de resultados.
     */
    public ArrayList<BetPlayDTO> getResultados() {
        return resultados;
    }

    /**
     * Establece la lista de resultados.
     * @param resultados Lista de resultados.
     */
    public void setResultados(ArrayList<BetPlayDTO> resultados) {
        this.resultados = resultados;
    }

    /**
     * Obtiene la lista de resultados como cadenas de texto.
     * @return Lista de resultados como cadenas de texto.
     */
    public ArrayList<String> getResult() {
        return result;
    }

    /**
     * Establece la lista de resultados como cadenas de texto.
     * @param result Lista de resultados como cadenas de texto.
     */
    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    /**
     * Obtiene la lista de nuevos resultados como cadenas de texto.
     * @return Lista de nuevos resultados como cadenas de texto.
     */
    public ArrayList<String> getNuevosResultados() {
        return nuevosResultados;
    }

    /**
     * Establece la lista de nuevos resultados como cadenas de texto.
     * @param nuevosResultados Lista de nuevos resultados como cadenas de texto.
     */
    public void setNuevosResultados(ArrayList<String> nuevosResultados) {
        this.nuevosResultados = nuevosResultados;
    }
}
