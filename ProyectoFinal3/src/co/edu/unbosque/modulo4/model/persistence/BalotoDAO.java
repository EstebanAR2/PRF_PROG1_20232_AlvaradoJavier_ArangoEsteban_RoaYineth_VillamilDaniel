package co.edu.unbosque.modulo4.model.persistence;

import java.time.DayOfWeek;
import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo4.model.BalotoDTO;



/**
 * Clase que implementa la interfaz CRUDOperation y representa un DAO para la clase BalotoDTO.
 */
public class BalotoDAO implements CRUDOperation {
    
    /** Lista que almacena objetos de tipo BalotoDTO.*/
    private ArrayList<BalotoDTO> balotos;

    /** Ruta del archivo serializable donde se almacenan los datos de Baloto. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo4/model/persistence/apuestas-baloto.dat";

    /** Índice para realizar operaciones de CRUD en la lista de balotos.*/
    private int index = 0;

    /** Constructor que inicializa la lista de balotos. Si existe un archivo serializable, carga los datos almacenados en él.*/
    public BalotoDAO() {
        balotos = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<BalotoDTO> temp2 = (ArrayList<BalotoDTO>) temp;
            balotos = temp2;
        } else {
            balotos = new ArrayList<>();
        }
    }

    /** Escribe la lista de balotos en un archivo serializable. */
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, balotos);
    }

    /**
     * Crea un nuevo objeto de tipo BalotoDTO y lo agrega a la lista de balotos.
     * @param args Datos de tipo String necesarios para crear el objeto BalotoDTO.
     */
    @Override
    public void create(String... args) {
        BalotoDTO newBaloto = new BalotoDTO();
        newBaloto.setSedeName(args[0]);
        newBaloto.setCc(Long.parseLong(args[1]));
        newBaloto.setDayOfWeek(DayOfWeek.valueOf(args[2]));
        newBaloto.setBetValue(Double.parseDouble(args[3]));
        newBaloto.setNumbers(Integer.parseInt(args[4]));
        balotos.add(newBaloto);
        writeSerializable();
    }

    /**
     * Lee los datos de la lista de balotos y los devuelve como una cadena de texto.
     * @return Cadena de texto con los datos de los balotos.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        balotos.forEach(game -> {
            sb.append(index + " -> " + (game.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza los datos de un objeto BalotoDTO en la lista de balotos.
     * @param index Índice del objeto a actualizar en la lista.
     * @param args  Nuevos datos de tipo String para actualizar el objeto.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int index, String... args) {
        if (index < 0 || index >= balotos.size()) {
            return false;
        } else {
            if (!args[0].isBlank() || !args[0].isEmpty()) {
                balotos.get(index).setSedeName(args[0]);
            }
            if (!args[1].isBlank() || !args[1].isEmpty()) {
                balotos.get(index).setCc(Long.parseLong(args[1]));
            }
            if (!args[2].isBlank() || !args[2].isEmpty() || !args[2].equals("")) {
                balotos.get(index).setDayOfWeek(DayOfWeek.valueOf(args[2]));
            }
            if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
                balotos.get(index).setBetValue(Double.parseDouble(args[3]));
            }
            balotos.get(index).setNumbers(Integer.parseInt(args[4]));

            writeSerializable();
            return true;
        }
    }

    /**
     * Elimina un objeto BalotoDTO de la lista de balotos.
     * @param index Índice del objeto a eliminar en la lista.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= balotos.size()) {
            return false;
        }
        balotos.remove(index);
        writeSerializable();
        return true;
    }

    /**
     * Obtiene la lista de balotos.
     * @return Lista de balotos.
     */
    public ArrayList<BalotoDTO> getBalotos() {
        return balotos;
    }

    /**
     * Establece la lista de balotos.
     * @param balotos Lista de balotos.
     */
    public void setBalotos(ArrayList<BalotoDTO> balotos) {
        this.balotos = balotos;
    }
}
