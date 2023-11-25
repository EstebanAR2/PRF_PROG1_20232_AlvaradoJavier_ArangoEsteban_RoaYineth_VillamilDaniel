package co.edu.unbosque.modulo1.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo1.model.GameDTO;
import co.edu.unbosque.modulo1.model.persistence.GameDAO;

/**
 * GameTest contiene pruebas unitarias para los metodos de la clase GameDAO.
 */
public class GameTest {

    /** Número de prueba actual. */
    static int numPrueba = 1;
    /** Instancia de GameDAO para las pruebas. */
    static GameDAO gDAO = new GameDAO();
    /** Instancia de GameDTO para las pruebas. */
    static GameDTO gDTO = new GameDTO();
    /** Scanner para entrada de usuario. */
    static Scanner c = new Scanner(System.in);

    /**
     * Mensaje mostrado antes de todas las pruebas.
     */
    @BeforeClass
    public static void antesDeTodas() {
        System.out.println("Iniciando todas las pruebas unitarias para los metodos de GameDAO \n");
    }

    /**
     * Mensaje mostrado antes de cada prueba.
     */
    @Before
    public void mostrarMensajeEntrePruebas() {
        System.err.println("Empezando la prueba #" + numPrueba);
    }

    /**
     * Prueba unitaria para el metodo create de GameDAO.
     */
    @Test
    public void pruebaCreate() {
        System.out.println("Iniciando la prueba de crear");
        String name = "Loteria";
        String gameType = "Loteria";
        String budget = "10000";
        gDAO.create(name, gameType, budget);
        String name2 = "Baloto";
        String gameType2 = "Loteria";
        String budget2 = "10000";
        gDAO.create(name2, gameType2, budget2);
        String name3 = "BetPlay";
        String gameType3 = "Deportivo";
        String budget3 = "10000";
        gDAO.create(name3, gameType3, budget3);

        int size = gDAO.getlistOfGames().size();
        System.out.println("Nombre del juego: " + name3 + ", Tipo de juego: " + gameType3 + ", Presupuesto: " + budget3);
        assertTrue(size == 3);
    }

    /**
     * Prueba unitaria para el metodo update de GameDAO.
     */
    @Test
    public void pruebaUpdate() {
        System.out.println("Iniciando la prueba de actualizar");
        int pos = 2;
        String name3 = "Super Astro";
        String gameType3 = "Chance";
        String budget3 = "2000";
        gDAO.update(pos, name3, gameType3, budget3);

        int size = gDAO.getlistOfGames().size();
        System.out.println(gDAO.readData());
        assertTrue(size == 3);
    }

    /**
     * Prueba unitaria para el metodo readData de GameDAO.
     */
    @Test
    public void pruebaReadData() {
        System.out.println("Iniciando la prueba de muestra de datos");

        int size = gDAO.getlistOfGames().size();
        System.out.println(gDAO.readData());
        assertTrue(size == 3);
    }

    /**
     * Prueba unitaria para el metodo delete de GameDAO.
     */
    @Test
    public void pruebaDelete() {
        System.out.println("Iniciando la prueba de eliminación de datos");
        int pos = 0;
        gDAO.delete(pos);
        int size = gDAO.getlistOfGames().size();
        System.out.println(gDAO.readData());
        assertTrue(size == 2);
    }

    /**
     * Mensaje después de cada prueba.
     */
    @After
    public void mostrarMensajeLuegoPrueba() {
        System.err.println("Finalizando prueba #" + numPrueba + "\n");
        numPrueba++;
    }

    /**
     * Mensaje mostrado después de todas las pruebas.
     */
    @AfterClass
    public static void luegoDeTodas() {
        System.out.println("Finalizando las pruebas unitarias");
    }
}
