package co.edu.unbosque.modulo4.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo4.model.BetPlayDTO;
import co.edu.unbosque.modulo4.model.persistence.BetPlayDAO;


/**
 * Clase de prueba para los métodos de la clase BetPlayDAO.
 */
public class BetPlayTest {

    /** Número de la prueba actual.*/
    static int numPrueba = 1;

    /**Instancia de BetPlayDAO para realizar pruebas.  */
    static BetPlayDAO bpDAO = new BetPlayDAO();

    /** Instancia de BetPlayDTO para utilizar en pruebas.*/
    static BetPlayDTO bpDTO = new BetPlayDTO();

    /** Scanner para entrada de prueba.*/
    static Scanner c = new Scanner(System.in);

    /**
     * Mensaje inicial antes de ejecutar todas las pruebas.
     */
    @BeforeClass
    public static void antesDeTodas() {
        System.out.println("Iniciando todas las pruebas unitarias para los métodos de BetPlayDAO \n");
    }

    /**
     * Mensaje mostrado antes de cada prueba individual.
     */
    @Before
    public void mostrarMensajeEntrePruebas() {
        System.err.println("Empezando la prueba #" + numPrueba);
    }

    /**
     * Prueba para el método create de BetPlayDAO.
     */
    @Test
    public void pruebaCreate() {
        bpDAO.getResultados().clear();
        System.out.println("Iniciando la prueba de crear");

        String sede = "Usaquen";
        String cc = "123456789";
        String today = "SUNDAY";
        String betValue = "15000";
        String resultado = " Gana Local. Barcelona vs Real Madrid.";
        String resultado2 = " Pierde Local. Manchester United vs Manchester City.";
        String resultado3 = " Empate. Juventus vs AC Milan.";
        String resultado4 = " Empate. Paraguay vs Colombia.";
        String resultado5 = " Empate. Ecuador vs Chile.";
        String resultado6 = " Gana Local. Uruguay vs Bolivia.";
        String resultado7 = " Pierde Local. Brasil vs Argentina.";
        String resultado8 = " Pierde Local. Peru vs Venezuela.";
        String resultado9 = " Gana Local. Austria vs Alemania.";
        String resultado10 = " Gana Local. Polonia vs Letonia.";
        String resultado11 = " Pierde Local. Irlanda vs Nueva Zelanda.";
        String resultado12 = " Gana Local. Grecia vs Francia.";
        String resultado13 = " Empate. Gales vs Turkey.";
        String resultado14 = " Gana Local. Siria vs Japón.";

        bpDAO.create(sede, cc, today, betValue, resultado, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7, resultado8, resultado9, resultado10, resultado11, resultado12, resultado13, resultado14);

        int size = bpDAO.getResultados().size();
        System.out.println(bpDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método update de BetPlayDAO.
     */
    @Test
    public void pruebaUpdate() {
        System.out.println("Iniciando la prueba de actualizar");
        int pos = 0;
        String sede = "Chia";
        String cc = "987654321";
        String today = "SUNDAY";
        String betValue = "5700";
        String resultado = " Empate. Barcelona vs Real Madrid.";
        String resultado2 = " Empate. Manchester United vs Manchester City.";
        String resultado3 = " Empate. Juventus vs AC Milan.";
        String resultado4 = " Empate. Paraguay vs Colombia.";
        String resultado5 = " Empate. Ecuador vs Chile.";
        String resultado6 = " Empate. Uruguay vs Bolivia.";
        String resultado7 = " Empate. Brasil vs Argentina.";
        String resultado8 = " Pierde local. Peru vs Venezuela.";
        String resultado9 = " Empate. Austria vs Alemania.";
        String resultado10 = " Empate. Polonia vs Letonia.";
        String resultado11 = " Empate. Irlanda vs Nueva Zelanda.";
        String resultado12 = " Empate. Grecia vs Francia.";
        String resultado13 = " Empate. Gales vs Turkey.";
        String resultado14 = " Empate. Siria vs Japón.";
        bpDAO.update(pos, sede, cc, today, betValue, resultado, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7, resultado8, resultado9, resultado10, resultado11, resultado12, resultado13, resultado14);

        int size = bpDAO.getResultados().size();
        System.out.println(bpDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método readData de BetPlayDAO.
     */
    @Test
    public void pruebaReadData() {
        System.out.println("Iniciando la prueba de muestra de datos");

        int size = bpDAO.getResultados().size();
        System.out.println(bpDAO.readData());
        assertTrue(size == 1);
    }

    /**
     * Prueba para el método delete de BetPlayDAO.
     */
    @Test
    public void pruebaDelete() {
        System.out.println("Iniciando la prueba de eliminacion de datos");
        int pos = 0;
        bpDAO.delete(pos);
        int size = bpDAO.getResultados().size();
        System.out.println(bpDAO.readData());
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
