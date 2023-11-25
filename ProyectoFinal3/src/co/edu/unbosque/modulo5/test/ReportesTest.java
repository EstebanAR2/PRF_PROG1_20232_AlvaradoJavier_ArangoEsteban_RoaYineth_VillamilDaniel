package co.edu.unbosque.modulo5.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.modulo1.model.persistence.GameDAO;
import co.edu.unbosque.modulo2.model.BranchDTO;
import co.edu.unbosque.modulo2.model.persistence.BranchDAO;
import co.edu.unbosque.modulo3.model.ApostadorDTO;
import co.edu.unbosque.modulo3.model.persistence.ApostadorDAO;
import co.edu.unbosque.modulo4.model.persistence.BalotoDAO;
import co.edu.unbosque.modulo4.model.persistence.BetPlayDAO;
import co.edu.unbosque.modulo4.model.persistence.ChanceDAO;
import co.edu.unbosque.modulo4.model.persistence.LoteriaDAO;
import co.edu.unbosque.modulo4.model.persistence.SuperAstroDAO;
import co.edu.unbosque.modulo5.model.persistence.Reportes;

/**
 * Esta clase contiene pruebas unitarias para los métodos de la clase Reportes.
 */
public class ReportesTest {
    /** Variable estática para llevar el número de prueba actual*/
    static int numPrueba = 1;

    /**Objetos de acceso a datos y objeto de la clase a probar*/
	private ApostadorDAO aDAO;
	private GameDAO gDAO;
	private BranchDAO bDAO;
	private BalotoDAO baDAO;
	private SuperAstroDAO saDAO;
	private LoteriaDAO lDAO;
	private BetPlayDAO bpDAO;
	private ChanceDAO cDAO;
	static Reportes rep = new Reportes();
	static Scanner c= new Scanner(System.in);
	
    /**
     * Constructor de la clase que inicializa los objetos necesarios para las pruebas.
     */
	public ReportesTest() {
		aDAO = new ApostadorDAO();
		gDAO = new GameDAO();
		bDAO = new BranchDAO();
		baDAO = new BalotoDAO();
		saDAO = new SuperAstroDAO();
		lDAO = new LoteriaDAO();
		bpDAO = new BetPlayDAO();
		cDAO = new ChanceDAO();
	}
	
    /**
     * Mensaje inicial antes de ejecutar todas las pruebas.
     */
    @BeforeClass
    public static void antesDeTodas() {
    	System.out.println("Iniciando todas las pruebas unitarias para los metodos de Reportes \n");
    }

    /**
     * Mensaje mostrado antes de cada prueba individual.
     */
    @Before
    public void mostrarMensajeEntrePruebas() {
        System.err.println("Empezando la prueba #" + numPrueba);
    }
	
    /**
     * Prueba unitaria para verificar la lista de apostadores por sede.
     */
	@Test
	public void pruebaVerificarListaDeApostadoresPorSede()
	{	
		String name = "Chia";
		String num = "20";
		bDAO.create(name, num);
		String name2 = "Bogota";
		String num2 = "60";
		bDAO.create(name2, num2);
		String name3 = "Cali";
		String num3 = "100";
		bDAO.create(name3, num3);
		
		String nombre = "Carlos";
		String cedula = "123456789";
		String sede = "Bogota";
		String direccion = "Calle 170";
		String celular = "95175334";
		String user = "CarlitosGOD";
		String pass = "FanDeMessi7";
		aDAO.create(nombre, cedula, sede, direccion, celular, user, pass);
		
		String nombre2 = "Matias";
		String cedula2 = "789456123";
		String sede2 = "Chia";
		String direccion2 = "Calle 131";
		String celular2 = "987654321";
		String user2 = "Mateito";
		String pass2 = "Napoleon7";
		aDAO.create(nombre2, cedula2, sede2, direccion2, celular2, user2, pass2);
		
		String nombre3 = "Diego";
		String cedula3 = "321654";
		String sede3 = "Bogota";
		String direccion3 = "Calle 131";
		String celular3 = "753951";
		String user3 = "DragonSlayer";
		String pass3 = "Diego951";
		aDAO.create(nombre3, cedula3, sede3, direccion3, celular3, user3, pass3);
		
	    String sedeBuscada = "Bogota"; 
	    int cantidadApostadoresEnBogota = 0;
	    
	    for (BranchDTO sedeABuscar : bDAO.getListaSedes()) {
	    	
	        if (sedeBuscada.equalsIgnoreCase(sedeABuscar.getLocation())) {
	            ArrayList<ApostadorDTO> apostadoresEnSede = rep.obtenerApostadoresEnSede(aDAO, sedeABuscar.getLocation());
	            cantidadApostadoresEnBogota = apostadoresEnSede.size();
	            break;
	        }
	    }
		System.out.println(rep.obtenerListaApostadoresPorSede(bDAO, aDAO));
		assertTrue(cantidadApostadoresEnBogota==2);
	}
	
    /**
     * Prueba unitaria para obtener detalles de apuestas por cliente y sede.
     */
	@Test
	public void pruebaObtenerDetallesApuestasPorClienteYSede()
	{
		bDAO.getListaSedes().clear();
		aDAO.getListaApostadores().clear();
		baDAO.getBalotos().clear();
		
		String name = "Chia";
		String num = "20";
		bDAO.create(name, num);
		String name2 = "Bogota";
		String num2 = "60";
		bDAO.create(name2, num2);
		String name3 = "Cali";
		String num3 = "100";
		bDAO.create(name3, num3);
		
		String nombre = "Carlos";
		String cedula = "123456789";
		String sede = "Bogota";
		String direccion = "Calle 170";
		String celular = "95175334";
		String user = "CarlitosGOD";
		String pass = "FanDeMessi7";
		aDAO.create(nombre, cedula, sede, direccion, celular, user, pass);
		
		String nombre2 = "Matias";
		String cedula2 = "789456123";
		String sede2 = "Chia";
		String direccion2 = "Calle 131";
		String celular2 = "987654321";
		String user2 = "Mateito";
		String pass2 = "Napoleon7";
		aDAO.create(nombre2, cedula2, sede2, direccion2, celular2, user2, pass2);
		
		String nombre3 = "Diego";
		String cedula3 = "321654";
		String sede3 = "Bogota";
		String direccion3 = "Calle 131";
		String celular3 = "753951";
		String user3 = "DragonSlayer";
		String pass3 = "Diego951";
		aDAO.create(nombre3, cedula3, sede3, direccion3, celular3, user3, pass3);
		
		String sedeBaloto	= "Bogota";
		String cc = "123456789";
		String today = "MONDAY";
		String betValue = "5700";
		String number1 = "40";
		String number2 = "17";
		String number3 = "42";
		String number4 = "7";
		String number5 = "12";
		String number6 = "10";

		baDAO.create(sedeBaloto, cc, today, betValue, number1, number2, number3, number4, number5, number6);

		System.out.println(rep.obtenerDetallesApuestasPorClienteYSede(aDAO, bDAO, baDAO, saDAO, lDAO, cDAO, bpDAO));
		assertTrue(baDAO.getBalotos().size()==1 );
	}
	
    /**
     * Prueba unitaria para obtener el total de apuestas por cliente.
     */
	@Test
	public void pruebaObtenerTotalApuestasPorCliente()
	{		
		aDAO.getListaApostadores().clear();
		baDAO.getBalotos().clear();
		lDAO.getLoterias().clear();
		
		String nombre = "Carlos";
		String cedula = "123456789";
		String sede = "Bogota";
		String direccion = "Calle 170";
		String celular = "95175334";
		String user = "CarlitosGOD";
		String pass = "FanDeMessi7";
		aDAO.create(nombre, cedula, sede, direccion, celular, user, pass);
		
		String nombre2 = "Matias";
		String cedula2 = "789456123";
		String sede2 = "Chia";
		String direccion2 = "Calle 131";
		String celular2 = "987654321";
		String user2 = "Mateito";
		String pass2 = "Napoleon7";
		aDAO.create(nombre2, cedula2, sede2, direccion2, celular2, user2, pass2);
		
		String nombre3 = "Diego";
		String cedula3 = "321654";
		String sede3 = "Bogota";
		String direccion3 = "Calle 131";
		String celular3 = "753951";
		String user3 = "DragonSlayer";
		String pass3 = "Diego951";
		aDAO.create(nombre3, cedula3, sede3, direccion3, celular3, user3, pass3);
		
		String sedeBaloto	= "Bogota";
		String cc = "789456123";
		String today = "MONDAY";
		String betValue = "5700";
		String number1 = "40";
		String number2 = "17";
		String number3 = "42";
		String number4 = "7";
		String number5 = "12";
		String number6 = "10";

		baDAO.create(sedeBaloto, cc, today, betValue, number1, number2, number3, number4, number5, number6);
		
		String sedeLoteria	= "Bogota";
		String cc2 = "789456123";
		String today2 = "TUESDAY";
		String betValue2 = "5000";
		String lotteryName = "Loteria de Bogota";
		String numberI = "1";
		String numberII = "7";
		String numberIII = "9";
		String numberIV = "2";
		String serie = "164";
		lDAO.create(sedeLoteria, cc2, today2, betValue2, lotteryName, numberI, numberII, numberIII, numberIV, serie);
		System.out.println(rep.obtenerTotalApuestasPorCliente(baDAO, saDAO, lDAO, bpDAO, cDAO));
		double loteriaValue = lDAO.getLoterias().get(0).getBetValue();
		double balotoValue = baDAO.getBalotos().get(0).getBetValue();
		double totalBudget = loteriaValue + balotoValue;
		assertTrue(totalBudget == 10700 );
	}
	
    /**
     * Prueba unitaria para generar un informe total de apuestas por sede y tipo de juego.
     */
	@Test
	public void pruebaGenerarInformeTotalApuestasPorSedeYTipoJuego()
	{		
		aDAO.getListaApostadores().clear();
		baDAO.getBalotos().clear();
		lDAO.getLoterias().clear();
		
		String name = "Chia";
		String num = "20";
		bDAO.create(name, num);
		String name2 = "Bogota";
		String num2 = "60";
		bDAO.create(name2, num2);
		String name3 = "Cali";
		String num3 = "100";
		bDAO.create(name3, num3);
		
		String nombre = "Carlos";
		String cedula = "123456789";
		String sede = "Bogota";
		String direccion = "Calle 170";
		String celular = "95175334";
		String user = "CarlitosGOD";
		String pass = "FanDeMessi7";
		aDAO.create(nombre, cedula, sede, direccion, celular, user, pass);
		
		String nombre2 = "Matias";
		String cedula2 = "789456123";
		String sede2 = "Chia";
		String direccion2 = "Calle 131";
		String celular2 = "987654321";
		String user2 = "Mateito";
		String pass2 = "Napoleon7";
		aDAO.create(nombre2, cedula2, sede2, direccion2, celular2, user2, pass2);
		
		String nombre3 = "Diego";
		String cedula3 = "321654";
		String sede3 = "Bogota";
		String direccion3 = "Calle 131";
		String celular3 = "753951";
		String user3 = "DragonSlayer";
		String pass3 = "Diego951";
		aDAO.create(nombre3, cedula3, sede3, direccion3, celular3, user3, pass3);
		
		String sedeBaloto	= "Bogota";
		String cc = "789456123";
		String today = "MONDAY";
		String betValue = "5700";
		String number1 = "40";
		String number2 = "17";
		String number3 = "42";
		String number4 = "7";
		String number5 = "12";
		String number6 = "10";

		baDAO.create(sedeBaloto, cc, today, betValue, number1, number2, number3, number4, number5, number6);
		
		String sedeLoteria	= "Bogota";
		String cc2 = "789456123";
		String today2 = "SUNDAY";
		String betValue2 = "5000";
		String lotteryName = "Loteria de Bogota";
		String numberI = "1";
		String numberII = "7";
		String numberIII = "9";
		String numberIV = "2";
		String serie = "164";
		lDAO.create(sedeLoteria, cc2, today2, betValue2, lotteryName, numberI, numberII, numberIII, numberIV, serie);
		
		System.out.println(rep.generarInformeTotalApuestasPorSedeYTipoJuego(bDAO, gDAO, aDAO, lDAO, saDAO, baDAO, bpDAO, cDAO));
		double loteriaValue = lDAO.getLoterias().get(0).getBetValue();
		double balotoValue = baDAO.getBalotos().get(0).getBetValue();
		double totalBudget = loteriaValue + balotoValue;
		aDAO.getListaApostadores().clear();
		baDAO.getBalotos().clear();
		lDAO.getLoterias().clear();
		assertTrue(totalBudget == 10700 );
	}
	
    /**
     * Mensaje después de cada prueba.
     */
    @After
    public void MostrarMensajeLuegoPrueba() {
        System.err.println("Finalizando prueba #" + numPrueba + "\n");
        numPrueba++;
    }

    /**
     * Mensaje que se ejecuta una vez después de todas las pruebas
     */
    @AfterClass
    public static void luegoDeTodas() {
        System.out.println("Finalizando las pruebas unitarias");
    }
}
