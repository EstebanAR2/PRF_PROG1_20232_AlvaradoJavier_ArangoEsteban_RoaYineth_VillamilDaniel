package co.edu.unbosque.modulo4.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo4.model.ChanceDTO;
import co.edu.unbosque.modulo4.model.persistence.ChanceDAO;

/**
 * Clase de prueba para los métodos de la clase ChanceDAO.
 */
public class ChanceTest {

    /** Número de la prueba actual.*/
    static int numPrueba = 1;

    /**Instancia de ChanceDAO para realizar pruebas. */
    static ChanceDAO cDAO = new ChanceDAO();

    /**Instancia de ChanceDTO para utilizar en pruebas. */
    static ChanceDTO cDTO = new ChanceDTO();

    /** Scanner para entrada de prueba. */
    static Scanner c = new Scanner(System.in);

    /** Mensaje inicial antes de ejecutar todas las pruebas.*/
    @BeforeClass
    public static void antesDeTodas() {
        System.out.println("Iniciando todas las pruebas unitarias para los métodos de ChanceDAO \n");
    }

    /** Mensaje mostrado antes de cada prueba individual.*/
    @Before
    public void mostrarMensajeEntrePruebas() {
        System.err.println("Empezando la prueba #" + numPrueba);
    }

    /**
     * Prueba para el método create de ChanceDAO.
     */
    @Test
    public void pruebaCreate() {
        cDAO.getChances().clear();
        System.out.println("Iniciando la prueba de crear");
        String sede = "Bogota";
        String cc = "123456789";
        String today = "SATURDAY";
        String betValue = "5000";
        String lotteryName = "Loteria de Bogota";
        String number1 = "1";
        String number2 = "7";
        String number3 = "9";
        String number4 = "2";
        cDAO.create(sede, cc, today, betValue, lotteryName, number1, number2, number3, number4);

        int size = cDAO.getChances().size();
        System.out.println(cDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método update de ChanceDAO.
     */
    @Test
    public void pruebaUpdate() {
        System.out.println("Iniciando la prueba de actualizar");
        int pos = 0;
        String sede = "Chia";
        String cc = "987654321";
        String today = "SATURDAY";
        String betValue = "5000";
        String lotteryName = "Loteria de Cundinamarca";
        String number1 = "8";
        String number2 = "2";
        String number3 = "7";
        String number4 = "4";
        cDAO.update(pos, sede, cc, today, betValue, lotteryName, number1, number2, number3, number4);

        int size = cDAO.getChances().size();
        System.out.println(cDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método readData de ChanceDAO.
     */
    @Test
    public void pruebaReadData() {
        System.out.println("Iniciando la prueba de muestra de datos");

        int size = cDAO.getChances().size();
        System.out.println(cDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método delete de ChanceDAO.
     */
    @Test
    public void pruebaDelete() {
        System.out.println("Iniciando la prueba de eliminacion de datos");
        int pos = 0;
        cDAO.delete(pos);
        int size = cDAO.getChances().size();
        System.out.println(cDAO.readData());
        assertTrue(size == 0);
    }

    /**
     * Mensaje mostrado después de cada prueba individual.
     */
    @After
    public void MostrarMensajeLuegoPrueba() {
        System.err.println("Finalizando prueba #" + numPrueba + "\n");
        numPrueba++;
    }

    /**
     * Mensaje final después de ejecutar todas las pruebas.
     */
    @AfterClass
    public static void luegoDeTodas() {
        System.out.println("Finalizando las pruebas unitarias");
    }
}
