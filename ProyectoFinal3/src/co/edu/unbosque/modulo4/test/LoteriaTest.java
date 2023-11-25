package co.edu.unbosque.modulo4.test;

import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo4.model.LoteriaDTO;
import co.edu.unbosque.modulo4.model.persistence.LoteriaDAO;

/**
 * Clase de prueba para los métodos de la clase LoteriaDAO.
 */
public class LoteriaTest {
	
	static int numPrueba = 1;
	static LoteriaDAO lDAO = new LoteriaDAO();
	static LoteriaDTO lDTO = new LoteriaDTO();
	static Scanner c= new Scanner(System.in);
	
	@BeforeClass
	public static void antesDeTodas() 
	{
		System.out.println("Iniciando todas las pruebas unitarias para los metodos de LoteriaDAO \n");
	}
	
	
	@Before
	public void mostrarMensajeEntrePruebas() 
	{
		System.err.println("Empezando la prueba #"+numPrueba);
	}
	
	@Test
	public void pruebaCreate()
	{
		lDAO.getLoterias().clear();
		System.out.println("Iniciando la prueba de crear");
		String sede	= "Bogota";
		String cc = "123456789";
		String today = "TUESDAY";
		String betValue = "5000";
		String lotteryName = "Loteria de Bogota";
		String number1 = "1";
		String number2 = "7";
		String number3 = "9";
		String number4 = "2";
		String serie = "164";
		lDAO.create(sede, cc, today, betValue, lotteryName, number1, number2, number3, number4, serie);

		int size = lDAO.getLoterias().size();
		System.out.println(lDAO.readData());
		assertTrue(size==1);
	}
	@Test
	public void pruebaUpdate()
	{
		System.out.println("Iniciando la prueba de actualizar");
		int pos = 0;
		String sede	= "Chia";
		String cc = "987654321";
		String today = "TUESDAY";
		String betValue = "5000";
		String lotteryName = "Loteria de Cundinamarca";
		String number1 = "8";
		String number2 = "2";
		String number3 = "7";
		String number4 = "4";
		String serie = "164";
		lDAO.update(pos, sede, cc, today, betValue, lotteryName, number1, number2, number3, number4, serie);

		int size = lDAO.getLoterias().size();
		System.out.println(lDAO.readData());
		assertTrue(size==1);
	}
	@Test
	public void pruebaReadData()
	{
		lDAO.getLoterias().clear();
		System.out.println("Iniciando la prueba de muestra de datos");
		System.out.println("Iniciando la prueba de crear");
		String sede	= "Bogota";
		String cc = "123456789";
		String today = "TUESDAY";
		String betValue = "5000";
		String lotteryName = "Loteria de Bogota";
		String number1 = "1";
		String number2 = "7";
		String number3 = "9";
		String number4 = "2";
		String serie = "164";
		lDAO.create(sede, cc, today, betValue, lotteryName, number1, number2, number3, number4, serie);
		int size = lDAO.getLoterias().size();
		System.out.println(lDAO.readData());
		assertTrue(size==1);
	}
	@Test
	public void pruebaDelete()
	{
		System.out.println("Iniciando la prueba de eliminacion de datos");
		int pos = 0;
		lDAO.delete(pos);
		int size = lDAO.getLoterias().size();
		System.out.println(lDAO.readData());
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
