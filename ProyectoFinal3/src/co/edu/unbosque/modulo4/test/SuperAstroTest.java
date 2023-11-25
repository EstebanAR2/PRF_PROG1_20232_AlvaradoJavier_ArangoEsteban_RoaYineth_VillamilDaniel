package co.edu.unbosque.modulo4.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo4.model.SuperAstroDTO;
import co.edu.unbosque.modulo4.model.persistence.SuperAstroDAO;

/**
 * Clase de prueba para los métodos de la clase SuperAstroDAO.
 */
public class SuperAstroTest {

	static int numPrueba = 1;
	static SuperAstroDAO saDAO = new SuperAstroDAO();
	static SuperAstroDTO saDTO = new SuperAstroDTO();
	static Scanner c= new Scanner(System.in);
	
	@BeforeClass
	public static void antesDeTodas() 
	{
		System.out.println("Iniciando todas las pruebas unitarias para los metodos de SuperAstroDAO \n");
	}
	
	
	@Before
	public void mostrarMensajeEntrePruebas() 
	{
		System.err.println("Empezando la prueba #"+numPrueba);
	}
	
	@Test
	public void pruebaCreate()
	{
		saDAO.getSuperAstros().clear();
		System.out.println("Iniciando la prueba de crear");
		
		String sede	= "Bogota";
		String cc = "123456789";
		String today = "WEDNESDAY";
		String betValue = "10000";
		String number1 = "5";
		String number2 = "1";
		String number3 = "9";
		String number4 = "7";
		String signo = "Libra";

		saDAO.create(sede, cc, today, betValue, number1, number2, number3, number4, signo);

		int size = saDAO.getSuperAstros().size();
		System.out.println(saDAO.readData());
		assertTrue(size==1);
	}
	@Test
	public void pruebaUpdate()
	{
		System.out.println("Iniciando la prueba de actualizar");
		int pos = 0;
		String sede	= "Chia";
		String cc = "987654321";
		String today = "WEDNESDAY";
		String betValue = "5000";
		String number1 = "8";
		String number2 = "2";
		String number3 = "7";
		String number4 = "4";
		String signo = "Virgo";
		saDAO.update(pos, sede, cc, today, betValue, number1, number2, number3, number4, signo);

		int size = saDAO.getSuperAstros().size();
		System.out.println(saDAO.readData());
		assertTrue(size==1);
	}
	@Test
	public void pruebaReadData()
	{
		System.out.println("Iniciando la prueba de muestra de datos");

		int size = saDAO.getSuperAstros().size();
		System.out.println(saDAO.readData());
		assertTrue(size==1);
	}
	@Test
	public void pruebaDelete()
	{
		System.out.println("Iniciando la prueba de eliminacion de datos");
		int pos = 0;
		saDAO.delete(pos);
		int size = saDAO.getSuperAstros().size();
		System.out.println(saDAO.readData());
		assertTrue(size==0);
	}
	
	@After
	public void MostrarMensajeLuegoPrueba() 
	{
		System.err.println("Finalizando prueba #"+numPrueba+"\n");
		numPrueba++;
	}
	
	@AfterClass
	public static void luegoDeTodas() 
	{
		System.out.println("Finalizando las pruebas unitarias");
	}
}
