package co.edu.unbosque.modulo3.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo3.model.AdminDTO;
import co.edu.unbosque.modulo3.model.persistence.AdminDAO;

/**
 * Esta clase contiene casos de prueba JUnit para los métodos en la clase AdminDAO.
 * Incluye pruebas para los métodos create, update, readData y delete.
 */
public class AdminTest {
		
	static int numPrueba = 1;
	static AdminDAO aDAO = new AdminDAO();
	static AdminDTO aDTO = new AdminDTO();
	static Scanner c= new Scanner(System.in);
	
	
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
     * Prueba unitaria para el metodo create de AdminDAO.
     */
	@Test
	public void pruebaCreate()
	{
		System.out.println("Iniciando la prueba de crear");
		String nombre = "Carlos";
		String cedula = "123456789";
		String direccion = "Calle 170";
		String celular = "95175334";
		String user = "CarlitosGOD";
		String pass = "FanDeMessi7";
		aDAO.create(nombre, cedula, direccion, celular, user, pass);
		
		String nombre2 = "Matias";
		String cedula2 = "789456123";
		String direccion2 = "Calle 131";
		String celular2 = "987654321";
		String user2 = "Mateito";
		String pass2 = "Napoleon7";
		aDAO.create(nombre2, cedula2, direccion2, celular2, user2, pass2);
		
		String nombre3 = "Diego";
		String cedula3 = "321654";
		String direccion3 = "Calle 131";
		String celular3 = "753951";
		String user3 = "DragonSlayer";
		String pass3 = "Diego951";
		aDAO.create(nombre3, cedula3, direccion3, celular3, user3, pass3);

		int size = aDAO.getListaAdmins().size();
		System.out.println(aDAO.readData());
		assertTrue(size==3);
	}
	
    /**
     * Prueba unitaria para el metodo update de AdminDAO.
     */
	public void pruebaUpdate()
	{
		System.out.println("Iniciando la prueba de actualizar");
		int pos = 2;
		String nombre3 = "Juanito";
		String cedula3 = "321654";
		String direccion3 = "Calle 131";
		String celular3 = "753951";
		String user3 = "DemonSlayer";
		String pass3 = "Juancholas123";
		aDAO.update(pos, nombre3, cedula3, direccion3, celular3, user3, pass3);

		int size = aDAO.getListaAdmins().size();
		System.out.println(aDAO.readData());
		assertTrue(size==3);
	}
	
    /**
     * Prueba unitaria para el metodo readData de AdminDAO.
     */
	public void pruebaReadData()
	{
		System.out.println("Iniciando la prueba de muestra de datos");

		int size = aDAO.getListaAdmins().size();
		System.out.println(aDAO.readData());
		assertTrue(size==3);
	}
	
    /**
     * Prueba unitaria para el metodo delete de AdminDAO.
     */
	public void pruebaDelete()
	{
		System.out.println("Iniciando la prueba de eliminacion de datos");
		int pos = 0;
		aDAO.delete(pos);
		int size = aDAO.getListaAdmins().size();
		System.out.println(aDAO.readData());
		assertTrue(size==2);
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
