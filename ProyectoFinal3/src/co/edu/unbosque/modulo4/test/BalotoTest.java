package co.edu.unbosque.modulo4.test;

import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo4.model.BalotoDTO;
import co.edu.unbosque.modulo4.model.persistence.BalotoDAO;


/**
 * Clase de prueba para los métodos de la clase BalotoDAO.
 */
public class BalotoTest {

    /** Número de la prueba actual.*/
    static int numPrueba = 1;

    /** Instancia de BalotoDAO para realizar pruebas. */
    static BalotoDAO baDAO = new BalotoDAO();

    /** Instancia de BalotoDTO para utilizar en pruebas. */
    static BalotoDTO baDTO = new BalotoDTO();

    /** Scanner para entrada de prueba. */
    static Scanner c = new Scanner(System.in);

    /**
     * Mensaje inicial antes de ejecutar todas las pruebas.
     */
    @BeforeClass
    public static void antesDeTodas() {
        System.out.println("Iniciando todas las pruebas unitarias para los metodos de BalotoDAO \n");
    }

    /**
     * Mensaje mostrado antes de cada prueba individual.
     */
    @Before
    public void mostrarMensajeEntrePruebas() {
        System.err.println("Empezando la prueba #" + numPrueba);
    }

    /**
     * Prueba para el método create de BalotoDAO.
     */
    @Test
    public void pruebaCreate() {
        baDAO.getBalotos().clear();
        System.out.println("Iniciando la prueba de crear");

        String sede = "Usaquen";
        String cc = "123456789";
        String today = "MONDAY";
        String betValue = "5700";
        String number1 = "40";
        String number2 = "17";
        String number3 = "42";
        String number4 = "7";
        String number5 = "12";
        String number6 = "10";

        baDAO.create(sede, cc, today, betValue, number1, number2, number3, number4, number5, number6);

        int size = baDAO.getBalotos().size();
        System.out.println(baDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método update de BalotoDAO.
     */
    @Test
    public void pruebaUpdate() {
        System.out.println("Iniciando la prueba de actualizar");
        int pos = 0;
        String sede = "Chia";
        String cc = "987654321";
        String today = "MONDAY";
        String betValue = "5700";
        String number1 = "8";
        String number2 = "2";
        String number3 = "7";
        String number4 = "4";
        String number5 = "12";
        String number6 = "10";
        baDAO.update(pos, sede, cc, today, betValue, number1, number2, number3, number4, number5, number6);

        int size = baDAO.getBalotos().size();
        System.out.println(baDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método readData de BalotoDAO.
     */
    @Test
    public void pruebaReadData() {
        System.out.println("Iniciando la prueba de muestra de datos");

        int size = baDAO.getBalotos().size();
        System.out.println(baDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método delete de BalotoDAO.
     */
    @Test
    public void pruebaDelete() {
        System.out.println("Iniciando la prueba de eliminacion de datos");
        int pos = 0;
        baDAO.delete(pos);
        int size = baDAO.getBalotos().size();
        System.out.println(baDAO.readData());
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
