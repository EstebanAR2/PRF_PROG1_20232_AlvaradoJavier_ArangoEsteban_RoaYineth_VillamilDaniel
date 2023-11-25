package co.edu.unbosque.modulo2.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo2.model.BranchDTO;
import co.edu.unbosque.modulo2.model.persistence.BranchDAO;


/**
 * BranchTest contiene pruebas unitarias para los metodos de la clase BranchDAO.
 */
public class BranchTest {

    /** Numero de prueba actual. */
    static int numPrueba = 1;
    /** Instancia de BranchDAO para realizar las pruebas. */
    static BranchDAO bDAO = new BranchDAO();
    /** Instancia de BranchDTO para utilizar en las pruebas. */
    static BranchDTO bDTO = new BranchDTO();
    /** Scanner para la entrada de datos durante las pruebas. */
    static Scanner c = new Scanner(System.in);

    /**
     * Mensaje que se ejecuta antes de todas las pruebas.
     */
    @BeforeClass
    public static void antesDeTodas() {
        System.out.println("Iniciando todas las pruebas unitarias para los métodos de BranchDAO \n");
    }

    /**
     * Mensaje que se ejecuta antes de cada prueba.
     */
    @Before
    public void mostrarMensajeEntrePruebas() {
        System.err.println("Empezando la prueba #" + numPrueba);
    }

    /**
     * Prueba unitaria para el metodo create de BranchDAO.
     */
    @Test
    public void pruebaCreate() {
        System.out.println("Iniciando la prueba de crear");
        String name = "Chia";
        String num = "20";
        bDAO.create(name, num);
        String name2 = "Bogota";
        String num2 = "60";
        bDAO.create(name2, num2);
        String name3 = "Cali";
        String num3 = "100";
        bDAO.create(name3, num3);

        int size = bDAO.getListaSedes().size();
        System.out.println("Ubicación de la sede: " + name3 + ", número de empleados: " + num3);
        assertTrue(size == 3);
    }

    /**
     * Prueba unitaria para el metodo update de BranchDAO.
     */
    @Test
    public void pruebaUpdate() {
        System.out.println("Iniciando la prueba de actualizar");
        int pos = 2;
        String name3 = "El Bosque";
        String num3 = "50";
        bDAO.update(pos, name3, num3);

        int size = bDAO.getListaSedes().size();
        System.out.println(bDAO.readData());
        assertTrue(size == 3);
    }

    /**
     * Prueba unitaria para el metodo readData de BranchDAO.
     */
    @Test
    public void pruebaReadData() {
        System.out.println("Iniciando la prueba de muestra de datos");

        int size = bDAO.getListaSedes().size();
        System.out.println(bDAO.readData());
        assertTrue(size == 3);
    }

    /**
     * Prueba unitaria para el metodo delete de BranchDAO.
     */
    @Test
    public void pruebaDelete() {
        System.out.println("Iniciando la prueba de eliminación de datos");
        int pos = 0;
        bDAO.delete(pos);
        int size = bDAO.getListaSedes().size();
        System.out.println(bDAO.readData());
        assertTrue(size == 2);
    }

    /**
     * Mensaje que se ejecuta despues de cada prueba.
     */
    @After
    public void MostrarMensajeLuegoPrueba() {
        System.err.println("Finalizando prueba #" + numPrueba + "\n");
        numPrueba++;
    }

    /**
     * Mensaje que se ejecuta despues de todas las pruebas.
     */
    @AfterClass
    public static void luegoDeTodas() {
        System.out.println("Finalizando las pruebas unitarias");
    }
}
