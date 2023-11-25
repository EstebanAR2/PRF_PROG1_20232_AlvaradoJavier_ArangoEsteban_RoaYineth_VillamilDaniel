package co.edu.unbosque.modulo1.model.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import co.edu.unbosque.modulo1.model.GameDTO;

/**
 * GameDAO implementa la interfaz CRUDOperation y gestiona la persistencia de los datos de GameDTO.
 */
public class GameDAO implements CRUDOperation {
    /** Lista que contiene los objetos GameDTO. */
    private ArrayList<GameDTO> listOfGames;
    /** Propiedades para cargar la configuracion de la casa de apuestas. */
    private Properties prop;
    /** Ruta del archivo serializado. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo1/model/persistence/juegos.dat";
    /** Índice para la posicion actual en la lista de juegos. */
    private int index = 0;

    /**
     * Constructor de la clase GameDAO.
     * Inicializa la lista de juegos y carga la configuracion desde el archivo "config.properties".
     * Si existe un archivo serializado, carga los datos almacenados en la lista de juegos.
     */
    public GameDAO() {
        listOfGames = new ArrayList<>();
        prop = new Properties();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<GameDTO> temp2 = (ArrayList<GameDTO>) temp;
            listOfGames = temp2;
        }
        try {
            prop.load(new BufferedReader(new FileReader("src/co/edu/unbosque/modulo1/model/persistence/config.properties")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribe la lista de juegos en un archivo serializado.
     */
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfGames);
    }

    /**
     * Crea un nuevo juego con los datos proporcionados y lo agrega a la lista de juegos.
     * Luego escribe la lista en el archivo serializado.
     * @param attribs Los atributos del juego a crear.
     */
    @Override
    public void create(String... attribs) {
        GameDTO newGame = new GameDTO();
        newGame.setGameName(attribs[0]);
        newGame.setGameType(attribs[1]);
        newGame.setGameEstimate(Long.parseLong(attribs[2]));
        listOfGames.add(newGame);
        writeSerializable();
    }

    /**
     * Lee y devuelve una representacion en cadena de todos los juegos en la lista.
     * @return Una cadena que representa todos los juegos en la lista.
     */
    @Override
    public String readData() {
        index = 0;
        StringBuilder sb = new StringBuilder();
        listOfGames.forEach(game -> {
            sb.append(index + " -> " + (game.toString() + "\n"));
            index++;
        });
        return sb.toString();
    }

    /**
     * Actualiza los datos de un juego en la lista en la posicion especificada.
     * @param index   La posicion del juego en la lista.
     * @param newData Los nuevos datos del juego.
     * @return true si la actualizacion fue exitosa, false si el índice esta fuera de rango.
     */
    @Override
    public boolean update(int index, String... newData) {
        if (index < 0 || index >= listOfGames.size()) {
            return false;
        } else {
            if (!newData[0].isBlank() || !newData[0].isEmpty()) {
                listOfGames.get(index).setGameName(newData[0]);
            }
            if (!newData[1].isBlank() || !newData[1].isEmpty()) {
                listOfGames.get(index).setGameType(newData[1]);
            }

            if (!newData[2].isBlank() || !newData[2].isEmpty() || !newData[2].equals("")) {
                listOfGames.get(index).setGameEstimate(Long.parseLong(newData[2]));
            }
            writeSerializable();
            return true;
        }
    }

    /**
     * Obtiene la lista de juegos.
     * @return La lista de juegos.
     */
    public ArrayList<GameDTO> getlistOfGames() {
        return listOfGames;
    }

    /**
     * Establece la lista de juegos.
     * @param listOfGames La nueva lista de juegos.
     */
    public void setlistOfGames(ArrayList<GameDTO> listOfGames) {
        this.listOfGames = listOfGames;
    }

    /**
     * Elimina un juego de la lista en la posicion especificada.
     * @param index La posicion del juego en la lista.
     * @return true si la eliminacion fue exitosa, false si el indice está fuera de rango.
     */
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= listOfGames.size()) {
            return false;
        } else {
            listOfGames.remove(index);
            writeSerializable();
            return true;
        }
    }

    /**
     * Calcula y devuelve el presupuesto total de todos los juegos en la lista.
     * @return El presupuesto total de todos los juegos.
     */
    public long calculateTotalBudget() {
        long totalGame = 0;

        for (GameDTO game : listOfGames) {
            totalGame += game.getGameEstimate();
        }
        return totalGame;
    }

}
