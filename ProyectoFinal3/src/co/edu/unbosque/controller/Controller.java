package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import co.edu.unbosque.modulo1.model.GameDTO;
import co.edu.unbosque.modulo1.model.persistence.GameDAO;
import co.edu.unbosque.modulo1.util.TotalBudgetException;
import co.edu.unbosque.modulo2.model.BranchDTO;
import co.edu.unbosque.modulo2.model.persistence.BranchDAO;
import co.edu.unbosque.modulo3.model.AdminDTO;
import co.edu.unbosque.modulo3.model.ApostadorDTO;
import co.edu.unbosque.modulo3.model.persistence.AdminDAO;
import co.edu.unbosque.modulo3.model.persistence.ApostadorDAO;
import co.edu.unbosque.modulo3.util.ExistingUserException;
import co.edu.unbosque.modulo3.util.MissingDataException;
import co.edu.unbosque.modulo3.util.PasswordException;
import co.edu.unbosque.modulo4.model.BalotoDTO;
import co.edu.unbosque.modulo4.model.BetPlayDTO;
import co.edu.unbosque.modulo4.model.ChanceDTO;
import co.edu.unbosque.modulo4.model.LoteriaDTO;
import co.edu.unbosque.modulo4.model.SuperAstroDTO;
import co.edu.unbosque.modulo4.model.persistence.BalotoDAO;
import co.edu.unbosque.modulo4.model.persistence.BetPlayDAO;
import co.edu.unbosque.modulo4.model.persistence.ChanceDAO;
import co.edu.unbosque.modulo4.model.persistence.LoteriaDAO;
import co.edu.unbosque.modulo4.model.persistence.SuperAstroDAO;
import co.edu.unbosque.modulo4.util.ChanceBetException;
import co.edu.unbosque.modulo4.util.SuperAstroBetException;
import co.edu.unbosque.modulo5.model.persistence.Reportes;
import co.edu.unbosque.util.CharException;
import co.edu.unbosque.util.NegativeNumbersException;
import co.edu.unbosque.util.SpecialCharactersException;
import co.edu.unbosque.view.MainFrame;

/**
 * La clase Controller actúa como el controlador principal de la aplicación.
 * Implementa la interfaz ActionListener para manejar eventos de acción de la interfaz de usuario.
 */
public class Controller implements ActionListener {
	
    /** Ruta del archivo de configuración. */
    private static final String config = "src/co/edu/unbosque/modulo1/model/persistence/config.properties";
    /** Instancia de la ventana principal. */
    private MainFrame mf;
    /** Instancia del objeto de acceso a datos para apostadores. */
    private ApostadorDAO aDAO;
    private ApostadorDTO ap;
    /** Instancia del objeto de acceso a datos para juegos. */
    private GameDAO gDAO;
    /** Instancia del objeto de acceso a datos para administradores. */
    private AdminDAO adDAO;
    private AdminDTO a;
    /** Instancia del objeto de acceso a datos para sucursales. */
    private BranchDAO bDAO;
    /** Instancia del objeto de acceso a datos para loterías. */
    private LoteriaDAO lDAO;
    /** Instancia del objeto de acceso a datos para Super Astro. */
    private SuperAstroDAO saDAO;
    /** Instancia del objeto de acceso a datos para Baloto. */
    private BalotoDAO baDAO;
    /** Instancia del objeto de acceso a datos para BetPlay. */
    private BetPlayDAO bpDAO;
    /** Instancia del objeto de acceso a datos para Chance. */
    private ChanceDAO cDAO;
    /** Instancia del objeto para generación de reportes. */
    private Reportes rep;
    /** Instancia de propiedades para cargar la configuración. */
    private Properties prop;

    /**
     * Construye una nueva instancia de la clase Controller.
     * Inicializa todas las instancias de objetos necesarias para el funcionamiento de la aplicación.
     * @throws IOException Si ocurre un error durante la lectura del archivo de configuración.
     */
	public Controller() throws IOException {
		mf = new MainFrame();
		aDAO = new ApostadorDAO();
		gDAO = new GameDAO();
		adDAO = new AdminDAO();
		prop = new Properties();
		bDAO = new BranchDAO();
		lDAO = new LoteriaDAO();
		saDAO = new SuperAstroDAO();
		baDAO = new BalotoDAO();
		bpDAO = new BetPlayDAO();
		cDAO = new ChanceDAO();
		rep = new Reportes();
		addLectures();
	}

    /**
     * Agrega las lecturas necesarias para los elementos de la interfaz de usuario.
     */
	public void addLectures() {
		// MainWindow
		mf.getMw().getAdministrador().addActionListener(this);
		mf.getMw().getAdministrador().setActionCommand("Adm");

		mf.getMw().getCliente().addActionListener(this);
		mf.getMw().getCliente().setActionCommand("Apo");

		// UserLoginWindow
		mf.getUlw().getRegister().addActionListener(this);
		mf.getUlw().getRegister().setActionCommand("UserRegister");

		mf.getUlw().getLogin().addActionListener(this);
		mf.getUlw().getLogin().setActionCommand("UserLogin");

		mf.getUlw().getBack().addActionListener(this);
		mf.getUlw().getBack().setActionCommand("UserBack");

		mf.getUlw().getOcultar().addActionListener(this);
		mf.getUlw().getOcultar().setActionCommand("UserCon");

		// UserRegisterWindow
		mf.getUrw().getRegister().addActionListener(this);
		mf.getUrw().getRegister().setActionCommand("UserRegister2");

		mf.getUrw().getBack().addActionListener(this);
		mf.getUrw().getBack().setActionCommand("UserRegisterBack");

		mf.getUrw().getOcultar().addActionListener(this);
		mf.getUrw().getOcultar().setActionCommand("UserRegisterCon");
		
		//UserOptionsWindow
		mf.getUow().getLoteria().addActionListener(this);
		mf.getUow().getLoteria().setActionCommand("Loteria");

		mf.getUow().getSuperAstro().addActionListener(this);
		mf.getUow().getSuperAstro().setActionCommand("SuperAstro");

		mf.getUow().getBaloto().addActionListener(this);
		mf.getUow().getBaloto().setActionCommand("Baloto");

		mf.getUow().getBetPlay().addActionListener(this);
		mf.getUow().getBetPlay().setActionCommand("BetPlay");

		mf.getUow().getChance().addActionListener(this);
		mf.getUow().getChance().setActionCommand("Chance");

		mf.getUow().getEdit().addActionListener(this);
		mf.getUow().getEdit().setActionCommand("editUser");

		mf.getUow().getBack().addActionListener(this);
		mf.getUow().getBack().setActionCommand("UserOptionsBack");
		
		//UpdateUserWindow
		mf.getUuw().getBack().addActionListener(this);
		mf.getUuw().getBack().setActionCommand("UpdateUserBack");
		
		mf.getUuw().getDelete().addActionListener(this);
		mf.getUuw().getDelete().setActionCommand("DeleteUser");
		
		mf.getUuw().getUpdate().addActionListener(this);
		mf.getUuw().getUpdate().setActionCommand("UpdateUser");
		
		mf.getUuw().getOcultar().addActionListener(this);
		mf.getUuw().getOcultar().setActionCommand("UpdateUserCon");

		// AdminLoginWindow
		mf.getAlw().getLogin().addActionListener(this);
		mf.getAlw().getLogin().setActionCommand("AdminLogin");

		mf.getAlw().getBack().addActionListener(this);
		mf.getAlw().getBack().setActionCommand("AdminBack");

		mf.getAlw().getOcultar().addActionListener(this);
		mf.getAlw().getOcultar().setActionCommand("AdminCon");

		// AdminOptionsWindow
		mf.getAow().getModifyPara().addActionListener(this);
		mf.getAow().getModifyPara().setActionCommand("ModifyPara");

		mf.getAow().getListClients().addActionListener(this);
		mf.getAow().getListClients().setActionCommand("ListClients");

		mf.getAow().getBetsClient().addActionListener(this);
		mf.getAow().getBetsClient().setActionCommand("BetsClients");

		mf.getAow().getBetsClientHeadquarters().addActionListener(this);
		mf.getAow().getBetsClientHeadquarters().setActionCommand("BetsClHe");

		mf.getAow().getTotalBets().addActionListener(this);
		mf.getAow().getTotalBets().setActionCommand("TotalBets");
		
		mf.getAow().getModifyGame().addActionListener(this);
		mf.getAow().getModifyGame().setActionCommand("MenuModifyGame");

		mf.getAow().getEdit().addActionListener(this);
		mf.getAow().getEdit().setActionCommand("edit");

		mf.getAow().getBack().addActionListener(this);
		mf.getAow().getBack().setActionCommand("ParaBack");
		
		// ModifyBetWindow
		mf.getMbw().getLoteria().addActionListener(this);
		mf.getMbw().getLoteria().setActionCommand("ModifyLoteria");

		mf.getMbw().getSuperAstro().addActionListener(this);
		mf.getMbw().getSuperAstro().setActionCommand("ModifySuperAstro");

		mf.getMbw().getBaloto().addActionListener(this);
		mf.getMbw().getBaloto().setActionCommand("ModifyBaloto");

		mf.getMbw().getBetPlay().addActionListener(this);
		mf.getMbw().getBetPlay().setActionCommand("ModifyBetPlay");

		mf.getMbw().getChance().addActionListener(this);
		mf.getMbw().getChance().setActionCommand("ModifyChance");

		mf.getMbw().getBack().addActionListener(this);
		mf.getMbw().getBack().setActionCommand("ModifyBetBack");

		// UpdateAdminWindow
		mf.getUaw().getUpdate().addActionListener(this);
		mf.getUaw().getUpdate().setActionCommand("UpdAdmin");

		mf.getUaw().getBack().addActionListener(this);
		mf.getUaw().getBack().setActionCommand("UpdBack");

		mf.getUaw().getOcultar().addActionListener(this);
		mf.getUaw().getOcultar().setActionCommand("UpdAdminCon");

		// ShopParametersWindow
		mf.getSpw().getBack().addActionListener(this);
		mf.getSpw().getBack().setActionCommand("ShopParaBack");

		mf.getSpw().getUpdate().addActionListener(this);
		mf.getSpw().getUpdate().setActionCommand("ShopParaUpd");

		mf.getSpw().getCreateBranch().addActionListener(this);
		mf.getSpw().getCreateBranch().setActionCommand("ToBranch");

		mf.getSpw().getBranchOptions().addActionListener(this);
		mf.getSpw().getBranchOptions().setActionCommand("BranchOptions");
		
		mf.getSpw().getGameParameters().addActionListener(this);
		mf.getSpw().getGameParameters().setActionCommand("ModifyGame");

		// CreateBranchWindow
		mf.getCbw().getBack().addActionListener(this);
		mf.getCbw().getBack().setActionCommand("CreateBranchBack");

		mf.getCbw().getCreate().addActionListener(this);
		mf.getCbw().getCreate().setActionCommand("CreateBranch");

		// BranchOptionsWindow
		mf.getBow().getBack().addActionListener(this);
		mf.getBow().getBack().setActionCommand("BranchOptionsBack");

		mf.getBow().getUpdate().addActionListener(this);
		mf.getBow().getUpdate().setActionCommand("UpdBranch");

		mf.getBow().getDelete().addActionListener(this);
		mf.getBow().getDelete().setActionCommand("DelBranch");

		// GameModWindow
		mf.getGmw().getBack().addActionListener(this);
		mf.getGmw().getBack().setActionCommand("GameModBack");

		mf.getGmw().getUpdate().addActionListener(this);
		mf.getGmw().getUpdate().setActionCommand("GameModUpd");
		
		// LoteriaWindow
		mf.getLw().getBack().addActionListener(this);
		mf.getLw().getBack().setActionCommand("LotteryBack");
		
		mf.getLw().getStake().addActionListener(this);
		mf.getLw().getStake().setActionCommand("LotteryStake");
		
		mf.getLw().getInformation().addActionListener(this);
		mf.getLw().getInformation().setActionCommand("LotteryInformation");
		
		// ModifyLotteryWindow
		mf.getMlw().getBack().addActionListener(this);
		mf.getMlw().getBack().setActionCommand("ModifyLotteryBack");

		mf.getMlw().getUpdate().addActionListener(this);
		mf.getMlw().getUpdate().setActionCommand("UpdLottery");

		mf.getMlw().getDelete().addActionListener(this);
		mf.getMlw().getDelete().setActionCommand("DelLottery");
		
		// SuperAstroWindow
		mf.getSaw().getBack().addActionListener(this);
		mf.getSaw().getBack().setActionCommand("SuperAstroBack");
		
		mf.getSaw().getStake().addActionListener(this);
		mf.getSaw().getStake().setActionCommand("SuperAstroStake");
		
		mf.getSaw().getInformation().addActionListener(this);
		mf.getSaw().getInformation().setActionCommand("SuperAstroInformation");
		
		//ModifySuperAstro
		mf.getMsaw().getBack().addActionListener(this);
		mf.getMsaw().getBack().setActionCommand("ModifySuperBack");

		mf.getMsaw().getUpdate().addActionListener(this);
		mf.getMsaw().getUpdate().setActionCommand("UpdSuper");

		mf.getMsaw().getDelete().addActionListener(this);
		mf.getMsaw().getDelete().setActionCommand("DelSuper");
		
		// BalotoWindow
		mf.getBw().getBack().addActionListener(this);
		mf.getBw().getBack().setActionCommand("BalotoBack");
		
		mf.getBw().getStake().addActionListener(this);
		mf.getBw().getStake().setActionCommand("BalotoStake");
		
		mf.getBw().getInformation().addActionListener(this);
		mf.getBw().getInformation().setActionCommand("BalotoInformation");
		
		//ModifyBalotoWindow
		mf.getMbaw().getBack().addActionListener(this);
		mf.getMbaw().getBack().setActionCommand("ModifyBalotoBack");

		mf.getMbaw().getUpdate().addActionListener(this);
		mf.getMbaw().getUpdate().setActionCommand("UpdBaloto");

		mf.getMbaw().getDelete().addActionListener(this);
		mf.getMbaw().getDelete().setActionCommand("DelBaloto");
		
		//BetPlayWindow
		mf.getBpw().getBack().addActionListener(this);
		mf.getBpw().getBack().setActionCommand("BetPlayBack");
		
		mf.getBpw().getStake().addActionListener(this);
		mf.getBpw().getStake().setActionCommand("BetPlayStake");
		
		mf.getBpw().getInformation().addActionListener(this);
		mf.getBpw().getInformation().setActionCommand("BetPlayInformation");
		
		//ModifyBetPlay
		mf.getMbpw().getBack().addActionListener(this);
		mf.getMbpw().getBack().setActionCommand("ModifyBetPlayBack");

		mf.getMbpw().getUpdate().addActionListener(this);
		mf.getMbpw().getUpdate().setActionCommand("UpdBetPlay");

		mf.getMbpw().getDelete().addActionListener(this);
		mf.getMbpw().getDelete().setActionCommand("DelBetPlay");
		
		//ModifyBetPlay2	
		mf.getMbpw2().getBack().addActionListener(this);
		mf.getMbpw2().getBack().setActionCommand("ModifyBetPlayBack2");

		mf.getMbpw2().getUpdate().addActionListener(this);
		mf.getMbpw2().getUpdate().setActionCommand("UpdBetPlay2");
		
		// ChanceWindow
		mf.getCw().getBack().addActionListener(this);
		mf.getCw().getBack().setActionCommand("ChanceBack");
		
		mf.getCw().getStake().addActionListener(this);
		mf.getCw().getStake().setActionCommand("ChanceStake");
		
		mf.getCw().getInformation().addActionListener(this);
		mf.getCw().getInformation().setActionCommand("ChanceInformation");
		
		//ModifyChanceWindow
		mf.getMcw().getBack().addActionListener(this);
		mf.getMcw().getBack().setActionCommand("ModifyChanceBack");

		mf.getMcw().getUpdate().addActionListener(this);
		mf.getMcw().getUpdate().setActionCommand("UpdChance");

		mf.getMcw().getDelete().addActionListener(this);
		mf.getMcw().getDelete().setActionCommand("DelChance");
		
		//CustomersWindow
		mf.getCuw().getBack().addActionListener(this);
		mf.getCuw().getBack().setActionCommand("CustomersBack");
		
		//ValueBetsCustomersWindow	
		mf.getVbcw().getBack().addActionListener(this);
		mf.getVbcw().getBack().setActionCommand("ValueCustomersBack");
		
		//BetDetailsWindow
		mf.getBdw().getBack().addActionListener(this);
		mf.getBdw().getBack().setActionCommand("BetsDetailsBack");
		
		//TotalBetsWindow
		mf.getTbw().getBack().addActionListener(this);
		mf.getTbw().getBack().setActionCommand("TotalBetsBack");
	}

    /**
     * Inicia la ejecución de la aplicación.
     */
	public void run() {
		try {
			prop.load(new BufferedReader(new FileReader("src/co/edu/unbosque/modulo1/model/persistence/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mf.setTitle("Casa de apuestas - " + prop.getProperty("NombreCasaDeApuestas"));
		mf.setVisible(true);
		System.out.println(adDAO.readData());
    }
	
	/**
	 * Maneja eventos de acción para la interfaz de usuario.
	 * @param e El evento de acción que se ha producido.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		// MainWindow

		case "Apo":
			mf.getMw().setVisible(false);
			mf.getUlw().setVisible(true);
			break;

		case "Adm":
			mf.getMw().setVisible(false);
			mf.getAlw().setVisible(true);
			break;

		// UserWindow
		case "UserBack":
			mf.getUlw().setVisible(false);
			mf.getMw().setVisible(true);
			break;

		case "UserRegister":
			mf.getUlw().setVisible(false);
			mf.getUrw().getSedes().setModel(new DefaultComboBoxModel<String>(getSedesArray()));
			mf.getUrw().setVisible(true);
			break;

		case "UserLogin":
			String user = mf.getUlw().getUser().getText();
			String pass = mf.getUlw().getPass().getText();
			ap = aDAO.iniciarSesion(user, pass);
			if (ap != null) {
				mf.getUlw().setVisible(false);
				mf.getUlw().getUser().setText("");
				mf.getUlw().getPass().setText("");
				mf.getUow().getUserName().setText("Bienvenido/a, "+ap.getNombre());
				mf.getUow().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(mf, "Usuario o contraseña inválidos");
			}
			break;

		case "UserCon":
			JCheckBox checkBox1 = mf.getUlw().getOcultar();
			JPasswordField passwordField1 = mf.getUlw().getPass();

			if (checkBox1.isSelected()) {
				passwordField1.setEchoChar((char) 0);
			} else {
				passwordField1.setEchoChar('●');
			}
			break;

		// UserRegisterWindow
		case "UserRegisterBack":
			mf.getUrw().setVisible(false);
			mf.getUrw().getNombre().setText("");
			mf.getUrw().getCedula().setText("");
			mf.getUrw().getDireccion().setText("");
			mf.getUrw().getCelular().setText("");
			mf.getUrw().getUser().setText("");
			mf.getUrw().getPass().setText("");
			mf.getUlw().setVisible(true);
			break;

		case "UserRegister2": {
			try {
				String nombre = mf.getUrw().getNombre().getText();
				String cedula = mf.getUrw().getCedula().getText();
				String sede = mf.getUrw().getSedes().getModel().getSelectedItem().toString();
				String direccion = mf.getUrw().getDireccion().getText();
				String celular = mf.getUrw().getCelular().getText();
				String user2 = mf.getUrw().getUser().getText();
				String pass2 = mf.getUrw().getPass().getText();
				checkRegisterAndLogin(nombre, cedula, sede, direccion, celular, user2, pass2);
				checkPassword(pass2);
				checkCedulaAndUser(user2, cedula);
				checkNameSpecialCharacters(nombre);
				checkNegativeNumbers(cedula);
				checkCharException(cedula);	
				aDAO.create(nombre, cedula, sede, direccion, celular, user2, pass2);
				JOptionPane.showMessageDialog(mf,
						"Usuario registrado exitosamente. Por favor proceda a iniciar sesión con su usuario y contraseña");
				mf.getUrw().setVisible(false);
				mf.getUrw().getNombre().setText("");
				mf.getUrw().getCedula().setText("");
				mf.getUrw().getDireccion().setText("");
				mf.getUrw().getCelular().setText("");
				mf.getUrw().getUser().setText("");
				mf.getUrw().getPass().setText("");
				mf.getUlw().setVisible(true);

			} catch (SpecialCharactersException e1) {
				JOptionPane.showMessageDialog(mf,
						"No están permitidos los caracteres especiales o númericos en casillas que no sean las correspondientes");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"El documento y el celular no puede tener letras ni caracteres especiales");
			} catch (PasswordException e1) {
				JOptionPane.showMessageDialog(mf,
						"La contraseña debe tener mínimo 7 caracteres, al menos una mayúscula, una minúscula y un número");
			} catch (MissingDataException e1) {
				JOptionPane.showMessageDialog(mf,
						"Faltan datos obligatorios por rellenar");
			} catch (ExistingUserException e1) {
				JOptionPane.showMessageDialog(mf,
						"La cedula o usuario registrados ya se encuentran en uso");
			}catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"La cedula y el celular solo pueden contener números");
			}
			break;
		}
		case "UserRegisterCon":
			JCheckBox checkBox2 = mf.getUrw().getOcultar();
			JPasswordField passwordField2 = mf.getUrw().getPass();

			if (checkBox2.isSelected()) {
				passwordField2.setEchoChar((char) 0);
			} else {
				passwordField2.setEchoChar('●');
			}
			break;
			
		//UserOptionsWindow
		case "UserOptionsBack":
			mf.getUow().setVisible(false);
			mf.getUlw().setVisible(true);
			break;
		
		case "editUser":
			mf.getUow().setVisible(false);
			mf.getUuw().getSedes().setModel(new DefaultComboBoxModel<String>(getSedesArray()));
			mf.getUuw().getNombre().setText(ap.getNombre());
			mf.getUuw().getCedula().setText(""+ap.getCedula());
			mf.getUuw().getSedes().getModel().setSelectedItem(ap.getSede());
			mf.getUuw().getDireccion().setText(ap.getDireccion());
			mf.getUuw().getCelular().setText(""+ap.getCelular());
			mf.getUuw().getUser().setText(ap.getUsuario());
			mf.getUuw().getPass().setText(ap.getContrasena());
			mf.getUuw().setVisible(true);
			break;
		
		case "Loteria":
			mf.getUow().setVisible(false);
			mf.getLw().setVisible(true);
			break;
		
		case "SuperAstro":
			mf.getUow().setVisible(false);
			mf.getSaw().getBetValue().setText("");
			mf.getSaw().setVisible(true);
			break;
		
		case "Baloto":
			mf.getUow().setVisible(false);
			mf.getBw().setVisible(true);
			break;
		
		case "BetPlay":
			mf.getUow().setVisible(false);
			mf.getBpw().getBetValue().setText("");
			mf.getBpw().setVisible(true);
			break;
		
		case "Chance":
			mf.getUow().setVisible(false);
			mf.getCw().getBetValue().setText("");
			mf.getCw().setVisible(true);
			break;
			
		// LoteriaWindow
		case "LotteryBack":
			mf.getLw().setVisible(false);
			mf.getUow().setVisible(true);
			break;
		case "LotteryStake":{
			String sede	= ap.getSede();
			String cc = ""+ap.getCedula();
			DayOfWeek dia = LocalDate.now().getDayOfWeek();
			String today = ""+dia;
			String betValue = "5000";
			String lotteryName = mf.getLw().getLotteryName().getSelectedItem().toString();
			String number1 = mf.getLw().getNumber1().getValue().toString();
			String number2 = mf.getLw().getNumber2().getValue().toString();
			String number3 = mf.getLw().getNumber3().getValue().toString();
			String number4 = mf.getLw().getNumber4().getValue().toString();
			String numbers = number1+number2+number3+number4;
			String serie = mf.getLw().getSerie().getSelectedItem().toString();
			int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de realizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
	        if (opcion == JOptionPane.YES_OPTION) {
				lDAO.create(sede, cc, today, betValue, lotteryName, numbers, serie);
				mf.getRw().getSede().setText(sede);
				mf.getRw().getCedula().setText(cc);
				mf.getRw().getDay().setText(today);
				mf.getRw().getBetValue().setText(betValue+" COP");
				mf.getRw().getDetails().setText("Lotería: "+lotteryName+"\nNúmeros: "+numbers+"\nSerie: "+serie);
				mf.getRw().setVisible(true);
	        }
			break;
			}
		case "LotteryInformation":
			mf.getLiw().setVisible(true);	
			break;	
		// MofifyLotteryWindow
			
		case "ModifyLotteryBack":
			mf.getMlw().setVisible(false);
			mf.getMbw().setVisible(true);
			break;
			
		case "UpdLottery":
			try {
				String index = mf.getMlw().getLotteryToUpdate().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				if (pos < 0 || pos >= lDAO.getLoterias().size()) {
					JOptionPane.showMessageDialog(mf,
							"No existe ninguna apuesta en esa posición.");
				}else {
				String sede = "";
				String cc = "";
				String day = "";
				String betValue = "";
				String lottery = mf.getMlw().getLotteryName().getSelectedItem().toString();
				String number1 = mf.getMlw().getNumber1().getValue().toString();
				String number2 = mf.getMlw().getNumber2().getValue().toString();
				String number3 = mf.getMlw().getNumber3().getValue().toString();
				String number4 = mf.getMlw().getNumber4().getValue().toString();
				String numbers = number1+number2+number3+number4;
				String serie = mf.getMlw().getSerie().getSelectedItem().toString();
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de actualizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
		        	lDAO.update(pos, sede, cc, day, betValue, lottery, numbers, serie);
		        	showLottery();
					JOptionPane.showMessageDialog(mf, "Datos de la apuesta actualizados con exito");

		        }}

			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "La posicion solo puede contener números");
			}
			
			break;
			
		case "DelLottery":{
			try {
				String index = mf.getMlw().getLocationDelete().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de eliminar esta loteria?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
					if (lDAO.delete(pos)) {
						showLottery();
						JOptionPane.showMessageDialog(mf, "Loteria eliminada");
					} else {
						JOptionPane.showMessageDialog(mf, "Loteria no encontrada");
					}

		        }

			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");

			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "Solo es válido colocar números en esta casilla");
			}
			break;
		}
			
		//SuperAstroWindow	
		case "SuperAstroBack":
			mf.getSaw().setVisible(false);
			mf.getUow().setVisible(true);
			break;
		case "SuperAstroStake":{
			try {
				String sede	= ap.getSede();
				String cc = ""+ap.getCedula();
				DayOfWeek dia = LocalDate.now().getDayOfWeek();
				String today = ""+dia;
				String betValue = mf.getSaw().getBetValue().getText();
				checkNegativeNumbers(betValue);
				checkCharException(betValue);	
				checkSuperAstroBetValue(Double.parseDouble(betValue));
				String number1 = mf.getSaw().getNumber1().getValue().toString();
				String number2 = mf.getSaw().getNumber2().getValue().toString();
				String number3 = mf.getSaw().getNumber3().getValue().toString();
				String number4 = mf.getSaw().getNumber4().getValue().toString();
				String numbers = number1+number2+number3+number4;
				String signo = mf.getSaw().getSigno().getSelectedItem().toString();
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de realizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					saDAO.create(sede, cc, today, betValue, numbers, signo);
					mf.getRw().getSede().setText(sede);
					mf.getRw().getCedula().setText(cc);
					mf.getRw().getDay().setText(today);
					mf.getRw().getBetValue().setText(betValue+" COP");
					mf.getRw().getDetails().setText("Números: "+numbers+"\nSigno zodiacal: "+signo);
					mf.getRw().setVisible(true);
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"Solo se admiten números en la casilla de valor de apuesta");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"Solo se admiten números en la casilla de valor de apuesta");
			}catch (SuperAstroBetException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta debe ser entre 500 y 10000 pesos colombianos (COP)");
			}
			break;
			}
		case "SuperAstroInformation":
			mf.getSaiw().setVisible(true);	
			break;	
		//ModifySuperAstro
		case "ModifySuperBack":
			mf.getMsaw().setVisible(false);
			mf.getMbw().setVisible(true);
			break;
			
		case "UpdSuper":
			try {
				String index = mf.getMsaw().getLocationToUpdate().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				if (pos < 0 || pos >= saDAO.getSuperAstros().size()) {
					JOptionPane.showMessageDialog(mf,
							"No existe ninguna apuesta en esa posición.");
				}else {
				String sede = "";
				String cc = "";
				String day = "";
				String betValue = mf.getMsaw().getBetValue().getText();
				checkSuperAstroBetValue(Double.parseDouble(betValue));
				String number1 = mf.getMsaw().getNumber1().getValue().toString();
				String number2 = mf.getMsaw().getNumber2().getValue().toString();
				String number3 = mf.getMsaw().getNumber3().getValue().toString();
				String number4 = mf.getMsaw().getNumber4().getValue().toString();
				String numbers = number1+number2+number3+number4;
				String signo = mf.getMsaw().getSigno().getSelectedItem().toString();
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de actualizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
		        	saDAO.update(pos, sede, cc, day, betValue, numbers, signo);
		        	showSuperAstro();
					JOptionPane.showMessageDialog(mf, "Datos de la apuesta actualizados con exito");

		        }}

			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "No se admiten letras o caracteres especiales. Solo numeros");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta y las posiciones de actualizar o eliminar solo pueden contener números");
			} catch (SuperAstroBetException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta debe ser entre 500 y 10000 pesos colombianos (COP)");
			}
			
			break;
			
		case "DelSuper":{
			try {
				String index = mf.getMsaw().getLocationDelete().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de eliminar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
					if (saDAO.delete(pos)) {
						showSuperAstro();
						JOptionPane.showMessageDialog(mf, "Apuesta eliminada");
					} else {
						JOptionPane.showMessageDialog(mf, "Apuesta no encontrada");
					}

		        }

			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");

			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "Solo es válido colocar números en esta casilla");
			}
			break;
		}	
			
		//BalotoWindow
		case "BalotoBack":
			mf.getBw().setVisible(false);
			mf.getUow().setVisible(true);
			break;
		case "BalotoStake":{
				String sede	= ap.getSede();
				String cc = ""+ap.getCedula();
				DayOfWeek dia = LocalDate.now().getDayOfWeek();
				String today = ""+dia;
				String betValue = "5700";
				String number1 = mf.getBw().getNumber1().getSelectedItem().toString();
				String number2 = mf.getBw().getNumber2().getSelectedItem().toString();
				String number3 = mf.getBw().getNumber3().getSelectedItem().toString();
				String number4 = mf.getBw().getNumber4().getSelectedItem().toString();
				String number5 = mf.getBw().getNumber5().getSelectedItem().toString();
				String number6 = mf.getBw().getNumber6().getSelectedItem().toString();
				String numbers = number1+number2+number3+number4+number5+number6;
			    Set<String> numeros = new HashSet<>();
			    numeros.add(number1);
			    numeros.add(number2);
			    numeros.add(number3);
			    numeros.add(number4);
			    numeros.add(number5);
			    numeros.add(number6);

			    if (numeros.size() != 6) {
			    	JOptionPane.showMessageDialog(mf, "Los números no pueden repetirse.", "Error", JOptionPane.ERROR_MESSAGE);
			    } else {
					int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de realizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						baDAO.create(sede, cc, today, betValue, numbers);
						mf.getRw().getSede().setText(sede);
						mf.getRw().getCedula().setText(cc);
						mf.getRw().getDay().setText(today);
						mf.getRw().getBetValue().setText(betValue+" COP");
						mf.getRw().getDetails().setText("Números seleccionados: "+numbers);
						mf.getRw().setVisible(true);
					}
			    }

			
			break;
			}
		case "BalotoInformation":
			mf.getBiw().setVisible(true);	
			break;	
			
		//ModifyBalotoWindow
		case "ModifyBalotoBack":
			mf.getMbaw().setVisible(false);
			mf.getMbw().setVisible(true);
			break;
			
		case "UpdBaloto":
			try {
				String index = mf.getMbaw().getLocationToUpdate().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				if (pos < 0 || pos >= baDAO.getBalotos().size()) {
					JOptionPane.showMessageDialog(mf,
							"No existe ninguna apuesta en esa posición.");
				} else {
				String sede = "";
				String cc = "";
				String day = "";
				String betValue = "5700";
				String number1 = mf.getMbaw().getNumber1().getSelectedItem().toString();
				String number2 = mf.getMbaw().getNumber2().getSelectedItem().toString();
				String number3 = mf.getMbaw().getNumber3().getSelectedItem().toString();
				String number4 = mf.getMbaw().getNumber4().getSelectedItem().toString();
				String number5 = mf.getMbaw().getNumber5().getSelectedItem().toString();
				String number6 = mf.getMbaw().getNumber6().getSelectedItem().toString();
				String numbers = number1+number2+number3+number4+number5+number6;
			    Set<String> numeros = new HashSet<>();
			    numeros.add(number1);
			    numeros.add(number2);
			    numeros.add(number3);
			    numeros.add(number4);
			    numeros.add(number5);
			    numeros.add(number6);

			    if (numeros.size() != 6) {
			    	JOptionPane.showMessageDialog(mf, "Los números no pueden repetirse.", "Error", JOptionPane.ERROR_MESSAGE);
			    }else {
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de actualizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
		        	baDAO.update(pos, sede, cc, day, betValue, numbers);
		        	showBaloto();
					JOptionPane.showMessageDialog(mf, "Datos de la apuesta actualizados con exito");
		        }}}
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "No es válido tener letras ni caracteres especiales. Solo valores numericos");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"Las posiciones de actualizar y eliminar solo pueden contener números");
			}
			
			break;
			
		case "DelBaloto":{
			try {
				String index = mf.getMbaw().getLocationDelete().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de eliminar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
					if (baDAO.delete(pos)) {
						showBaloto();
						JOptionPane.showMessageDialog(mf, "Apuesta eliminada");
					} else {
						JOptionPane.showMessageDialog(mf, "Apuesta no encontrada");
					}

		        }

			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");

			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "Solo es válido colocar números en esta casilla");
			}
			break;
		}	
			
		//BetPlayWindow
		case "BetPlayBack":
			mf.getBpw().setVisible(false);
			mf.getUow().setVisible(true);
			break;
			
		case "BetPlayStake":{
			try {
				String sede	= ap.getSede();
				String cc = ""+ap.getCedula();
				DayOfWeek dia = LocalDate.now().getDayOfWeek();
				String today = ""+dia;
				String betValue = mf.getBpw().getBetValue().getText();
				checkNegativeNumbers(betValue);
				checkCharException(betValue);	
				String resultado = mf.getBpw().getResultado().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos().get(0).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(0).getText();
				String resultado2 = mf.getBpw().getResultado2().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos().get(1).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(1).getText();
				String resultado3 = mf.getBpw().getResultado3().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos().get(2).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(2).getText();
				String resultado4 = mf.getBpw().getResultado4().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos().get(3).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(3).getText();
				String resultado5 = mf.getBpw().getResultado5().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos().get(4).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(4).getText();
				String resultado6 = mf.getBpw().getResultado6().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos().get(5).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(5).getText();
				String resultado7 = mf.getBpw().getResultado7().getValue().toString()+"."+ mf.getBpw().getLabelsEnfrentamientos().get(6).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos2().get(6).getText();
				String resultado8 = mf.getBpw().getResultado8().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(0).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(0).getText();
				String resultado9 = mf.getBpw().getResultado9().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(1).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(1).getText();
				String resultado10 = mf.getBpw().getResultado10().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(2).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(2).getText();
				String resultado11 = mf.getBpw().getResultado11().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(3).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(3).getText();
				String resultado12 = mf.getBpw().getResultado12().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(4).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(4).getText();
				String resultado13 = mf.getBpw().getResultado13().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(5).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(5).getText();
				String resultado14 = mf.getBpw().getResultado14().getValue().toString()+"."+mf.getBpw().getLabelsEnfrentamientos3().get(6).getText()+" VS "+mf.getBpw().getLabelsEnfrentamientos4().get(6).getText();
				
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de realizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					bpDAO.create(sede, cc, today, betValue, resultado, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7, resultado8, resultado9, resultado10, resultado11, resultado12, resultado13, resultado14);	
					mf.getRw().getSede().setText(sede);
					mf.getRw().getCedula().setText(cc);
					mf.getRw().getDay().setText(today);
					mf.getRw().getBetValue().setText(betValue+" COP");
					mf.getRw().getDetails().setText("Resultados:"+resultado+"\n"+resultado2+"\n"+resultado3+"\n"+resultado4+"\n"+resultado5+"\n"+resultado6+"\n"+resultado7+"\n"+resultado8+"\n"+resultado9+"\n"+resultado10+"\n"+resultado11+"\n"+resultado12+"\n"+resultado13+"\n"+resultado4+"\n");
					mf.getRw().setVisible(true);
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"Solo se admiten números en la casilla de valor de la apuesta");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"Solo se admiten números en la casilla de valor de apuesta");
			}
			break;
		}
			
		case "BetPlayInformation":
			mf.getBpiw().setVisible(true);	
			break;	
			
			//ModifyBetPlayWindow
					case "ModifyBetPlayBack":
						mf.getMbpw().setVisible(false);
						mf.getMbw().setVisible(true);
						break;
						
					case "UpdBetPlay":
						try {
							String index = mf.getMbpw().getLocationToUpdate().getText();
							checkNegativeNumbers(index);
							checkCharException(index);
							int pos = Integer.parseInt(index)-1;
							if (pos < 0 || pos >= bpDAO.getResultados().size()) {
								JOptionPane.showMessageDialog(mf,
										"No existe ninguna apuesta en esa posición.");
							} else {
								mf.getMbpw().setVisible(false);
								mf.getMbpw2().setVisible(true);	
								}
						} catch (NegativeNumbersException e1) {
							JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
						} catch (CharException e1) {
							JOptionPane.showMessageDialog(mf, "No es válido tener letras ni caracteres especiales. Solo valores numericos");
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(mf,
									"El valor de la apuesta y las posiciones de actualizar o eliminar solo pueden contener números");
						} 
						
						break;
					//ModifyBetPlayWindow2
					case "ModifyBetPlayBack2":
						mf.getMbpw2().setVisible(false);
						mf.getMbpw().setVisible(true);
						break;
					case "UpdBetPlay2":
					try {
						String index = mf.getMbpw().getLocationToUpdate().getText();
						checkNegativeNumbers(index);
						checkCharException(index);
						int pos = Integer.parseInt(index)-1;
						String sede	= "";
						String cc = "";
						String today = "";
						String betValue = mf.getMbpw2().getBetValue().getText();
						checkNegativeNumbers(betValue);
						checkCharException(betValue);	
						String resultado = mf.getMbpw2().getResultado().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(0).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(0).getText();
						String resultado2 = mf.getMbpw2().getResultado2().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(1).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(1).getText();
						String resultado3 = mf.getMbpw2().getResultado3().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(2).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(2).getText();
						String resultado4 = mf.getMbpw2().getResultado4().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(3).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(3).getText();
						String resultado5 = mf.getMbpw2().getResultado5().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(4).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(4).getText();
						String resultado6 = mf.getMbpw2().getResultado6().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(5).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(5).getText();
						String resultado7 = mf.getMbpw2().getResultado7().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos().get(6).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos2().get(6).getText();
						String resultado8 = mf.getMbpw2().getResultado8().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(0).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(0).getText();
						String resultado9 = mf.getMbpw2().getResultado9().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(1).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(1).getText();
						String resultado10 = mf.getMbpw2().getResultado10().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(2).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(2).getText();
						String resultado11 = mf.getMbpw2().getResultado11().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(3).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(3).getText();
						String resultado12 = mf.getMbpw2().getResultado12().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(4).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(4).getText();
						String resultado13 = mf.getMbpw2().getResultado13().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(5).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(5).getText();
						String resultado14 = mf.getMbpw2().getResultado14().getValue().toString()+". "+mf.getMbpw2().getLabelsEnfrentamientos3().get(6).getText()+" VS "+mf.getMbpw2().getLabelsEnfrentamientos4().get(6).getText();
						
						int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de actualizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
						if (opcion == JOptionPane.YES_OPTION) {
							bpDAO.update(pos, sede, cc, today, betValue, resultado, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7, resultado8, resultado9, resultado10, resultado11, resultado12, resultado13, resultado14);
							mf.getMbpw2().setVisible(false);
							showBetPlay();
							mf.getMbpw().setVisible(true);
						}
					} catch (NegativeNumbersException e1) {
						JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
					} catch (CharException e1) {
						JOptionPane.showMessageDialog(mf,
								"Solo se admiten números en la casilla de valor de apuesta");
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(mf,
								"El valor de la apuesta y las posiciones de actualizar o eliminar solo pueden contener números");
					} 
						
						break;
						
					case "DelBetPlay":{
						try {
							String index = mf.getMbpw().getLocationDelete().getText();
							checkNegativeNumbers(index);
							checkCharException(index);
							int pos = Integer.parseInt(index)-1;
							int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de eliminar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
					        if (opcion == JOptionPane.YES_OPTION) {
								if (bpDAO.delete(pos)) {
									showBetPlay();
									JOptionPane.showMessageDialog(mf, "Apuesta eliminada");
								} else {
									JOptionPane.showMessageDialog(mf, "Apuesta no encontrada");
								}

					        }

						} catch (NegativeNumbersException e1) {
							JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");

						} catch (CharException e1) {
							JOptionPane.showMessageDialog(mf, "Solo es válido colocar números en esta casilla");
						}
						break;
					}		
			
		//ChanceWindow
		case "ChanceBack":
			mf.getCw().setVisible(false);
			mf.getUow().setVisible(true);
			break;
		case "ChanceStake":{
			try {
				String sede	= ap.getSede();
				String cc = ""+ap.getCedula();
				DayOfWeek dia = LocalDate.now().getDayOfWeek();
				String today = ""+dia;
				String betValue = mf.getCw().getBetValue().getText();
				checkNegativeNumbers(betValue);
				checkCharException(betValue);	
				checkChanceBetValue(Double.parseDouble(betValue));
				String lotteryName = mf.getCw().getLotteryName().getSelectedItem().toString();
				String number1 = mf.getCw().getNumber1().getValue().toString();
				String number2 = mf.getCw().getNumber2().getValue().toString();
				String number3 = mf.getCw().getNumber3().getValue().toString();
				String number4 = mf.getCw().getNumber4().getValue().toString();
				String numbers = number1+number2+number3+number4;
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de realizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					cDAO.create(sede, cc, today, betValue, lotteryName, numbers);
					mf.getRw().getSede().setText(sede);
					mf.getRw().getCedula().setText(cc);
					mf.getRw().getDay().setText(today);
					mf.getRw().getBetValue().setText(betValue+" COP");
					mf.getRw().getDetails().setText("Lotería: "+lotteryName+"\nNúmeros: "+numbers);
					mf.getRw().setVisible(true);
				}
			} catch (ChanceBetException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta debe ser entre 500 y 20000 pesos colombianos (COP)");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"Solo se admiten números en la casilla de valor de apuesta");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta solo puede contener números");
			} 
			break;
			}
		case "ChanceInformation":
			mf.getCiw().setVisible(true);	
			break;	
			
		//ModifyChanceWindow
		case "ModifyChanceBack":
			mf.getMcw().setVisible(false);
			mf.getMbw().setVisible(true);
			break;
			
		case "UpdChance":
			try {
				String index = mf.getMcw().getLocationToUpdate().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				if (pos < 0 || pos >= cDAO.getChances().size()) {
					JOptionPane.showMessageDialog(mf,
							"No existe ninguna apuesta en esa posición.");
				} else {
				String sede = "";
				String cc = "";
				String day = "";
				String betValue = mf.getMcw().getBetValue().getText();
				checkChanceBetValue(Double.parseDouble(betValue));
				String name = mf.getMcw().getLotteryName().getSelectedItem().toString();
				String number1 = mf.getMcw().getNumber1().getValue().toString();
				String number2 = mf.getMcw().getNumber2().getValue().toString();
				String number3 = mf.getMcw().getNumber3().getValue().toString();
				String number4 = mf.getMcw().getNumber4().getValue().toString();
				String numbers = number1+number2+number3+number4;
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de actualizar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
		        	cDAO.update(pos, sede, cc, day, betValue, name, numbers);
		        	showChance();
					JOptionPane.showMessageDialog(mf, "Datos de la apuesta actualizados con exito");
		        }}
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "No es válido tener letras ni caracteres especiales. Solo valores numericos");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta y las posiciones de actualizar o eliminar solo pueden contener números");
			} catch (ChanceBetException e1) {
				JOptionPane.showMessageDialog(mf,
						"El valor de la apuesta debe ser entre 500 y 20000 pesos colombianos (COP)");
			}
			
			break;
			
		case "DelChance":{
			try {
				String index = mf.getMcw().getLocationDelete().getText();
				checkNegativeNumbers(index);
				checkCharException(index);
				int pos = Integer.parseInt(index)-1;
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de eliminar esta apuesta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
					if (cDAO.delete(pos)) {
						showChance();
						JOptionPane.showMessageDialog(mf, "Apuesta eliminada");
					} else {
						JOptionPane.showMessageDialog(mf, "Apuesta no encontrada");
					}

		        }

			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");

			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf, "Solo es válido colocar números en esta casilla");
			}
			break;
		}		
			
		//UpdateUserWindow
		case "UpdateUserBack":
			mf.getUuw().setVisible(false);
			mf.getUow().setVisible(true);
			break;
			
		case "DeleteUser":{
			int userIndex = aDAO.obtenerPosicionApostador(ap); 
				int opcion = JOptionPane.showConfirmDialog(mf, "¿Estás seguro de eliminar tu cuenta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (opcion == JOptionPane.YES_OPTION) {
		        	aDAO.delete(userIndex);
					JOptionPane.showMessageDialog(mf,
							"Su cuenta ha sido borrada");
					mf.getUuw().setVisible(false);
					mf.getMw().setVisible(true);
		        } else if (opcion == JOptionPane.NO_OPTION) {
		        	JOptionPane.showMessageDialog(mf,
							"Nos alegramos que siga con nuestra casa de apuestas");
		        }	
			break;
		}
		case "UpdateUser":
			try {
				int userIndex = aDAO.obtenerPosicionApostador(ap);
				String nombre = mf.getUuw().getNombre().getText();
				String cedula = mf.getUuw().getCedula().getText();			
				String sede = mf.getUuw().getSedes().getModel().getSelectedItem().toString();
				String direccion = mf.getUuw().getDireccion().getText();
				String celular = mf.getUuw().getCelular().getText();
				String user2 = mf.getUuw().getUser().getText();
				String pass2 = mf.getUuw().getPass().getText();
				checkRegisterAndLogin(nombre, cedula, sede, direccion, celular, user2, pass2);
				checkPassword(pass2);
				checkNameSpecialCharacters(nombre);
				checkNegativeNumbers(cedula);
				checkNegativeNumbers(celular);
				checkCharException(cedula);	
				aDAO.update(userIndex, nombre, cedula, sede, direccion, celular, user2, pass2);
				JOptionPane.showMessageDialog(mf,
						"Usuario actualizado exitosamente");
			} catch (SpecialCharactersException e1) {
				JOptionPane.showMessageDialog(mf,
						"No están permitidos los caracteres especiales o númericos en casillas que no sean las correspondientes");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"El documento y el celular no puede tener letras ni caracteres especiales");
			} catch (PasswordException e1) {
				JOptionPane.showMessageDialog(mf,
						"La contraseña debe tener mínimo 7 caracteres, al menos una mayúscula, una minúscula y un número");
			} catch (MissingDataException e1) {
				JOptionPane.showMessageDialog(mf,
						"Faltan datos obligatorios por rellenar");
			}catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"La cedula y el celular solo pueden contener números");
			} 
			break;
			
		case "UpdateUserCon":
			JCheckBox checkBox5 = mf.getUuw().getOcultar();
			JPasswordField passwordField5 = mf.getUuw().getPass();

			if (checkBox5.isSelected()) {
				passwordField5.setEchoChar((char) 0);
			} else {
				passwordField5.setEchoChar('●');
			}
			break;	
			
		// AdminWindow
		case "AdminBack":
			mf.getAlw().setVisible(false);
			mf.getAlw().getUser().setText("");
			mf.getAlw().getPass().setText("");
			mf.getMw().setVisible(true);
			break;

		case "AdminLogin":
			String adminUser = mf.getAlw().getUser().getText();
			String adminPass = mf.getAlw().getPass().getText();
			a = adDAO.iniciarSesion(adminUser, adminPass);
			if (a != null) {
				mf.getAlw().setVisible(false);
				mf.getAlw().getUser().setText("");
				mf.getAlw().getPass().setText("");
				mf.getAow().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(mf, "Usuario o contraseña inválidos");
			}
			break;

		case "AdminCon":
			JCheckBox checkBox3 = mf.getAlw().getOcultar();
			JPasswordField passwordField3 = mf.getAlw().getPass();

			if (checkBox3.isSelected()) {
				passwordField3.setEchoChar((char) 0);
			} else {
				passwordField3.setEchoChar('●');
			}
			break;

		// AdminOptionsWindow
		case "ModifyPara":
			mf.getAow().setVisible(false);
			mf.getSpw().getShopName().setText(prop.getProperty("NombreCasaDeApuestas"));
			mf.getSpw().getBranch().setText(prop.getProperty("NumeroDeSedes"));
			mf.getSpw().getBudget().setText(prop.getProperty("PresupuestoDisponibleTotal"));
			mf.getSpw().setVisible(true);
			break;
			
		case "MenuModifyGame":
			mf.getAow().setVisible(false);
			mf.getMbw().setVisible(true);
			break;

		case "ListClients":
			mf.getAow().setVisible(false);
			showApostadoresPorSede(bDAO, aDAO);
			mf.getCuw().setVisible(true);	
			break;

		case "BetsClients":
			mf.getAow().setVisible(false);
			showObtenerTotalApuestasPorCliente(baDAO, saDAO, lDAO, bpDAO, cDAO);
			mf.getVbcw().setVisible(true);
			break;
		case "BetsClHe":
			mf.getAow().setVisible(false);
			mf.getBdw().getDetails().setText(rep.obtenerDetallesApuestasPorClienteYSede(aDAO, bDAO, baDAO, saDAO, lDAO, cDAO, bpDAO));
			mf.getBdw().setVisible(true);
			break;
		case "TotalBets":
			mf.getAow().setVisible(false);
			showTotalBets(bDAO, gDAO, aDAO, lDAO, saDAO, baDAO, bpDAO, cDAO);
			mf.getTbw().setVisible(true);
			break;
		case "edit":
			mf.getAow().setVisible(false);
			mf.getUaw().getNombre().setText(a.getNombre());
			mf.getUaw().getCedula().setText("" + a.getCedula());
			mf.getUaw().getDireccion().setText(a.getDireccion());
			mf.getUaw().getCelular().setText("" + a.getCelular());
			mf.getUaw().getUser().setText(a.getUsuario());
			mf.getUaw().getPass().setText(a.getContrasena());
			mf.getUaw().setVisible(true);
			break;
		case "ParaBack":
			mf.getAow().setVisible(false);
			mf.getMw().setVisible(true);
			break;

		//CustomersWindow
		case "CustomersBack":
			mf.getCuw().setVisible(false);
			mf.getAow().setVisible(true);
			break;
		
		//ValueBetsCustomersWindow	
		case "ValueCustomersBack":
			mf.getVbcw().setVisible(false);
			mf.getAow().setVisible(true);
			break;
			
		//BetDetailsWindow
		case "BetsDetailsBack":
			mf.getBdw().setVisible(false);
			mf.getAow().setVisible(true);
			break;
		// ModifyBetWindow
		case "ModifyBetBack":
			mf.getMbw().setVisible(false);
			mf.getAow().setVisible(true);
			break;
			
		//TotalBetsWindow
		case "TotalBetsBack":
			mf.getTbw().setVisible(false);
			mf.getAow().setVisible(true);
			break;
		
		case "ModifyLoteria":
			mf.getMbw().setVisible(false);
			showLottery();
			mf.getMlw().getLocationDelete().setText("");
			mf.getMlw().getLotteryToUpdate().setText("");
			mf.getMlw().setVisible(true);
			break;
		
		case "ModifySuperAstro":
			mf.getMbw().setVisible(false);
			showSuperAstro();
			mf.getMsaw().getLocationDelete().setText("");
			mf.getMsaw().getLocationToUpdate().setText("");
			mf.getMsaw().getBetValue().setText("");
			mf.getMsaw().setVisible(true);
			break;
		
		case "ModifyBaloto":
			mf.getMbw().setVisible(false);
			showBaloto();
			mf.getMbaw().getLocationDelete().setText("");
			mf.getMbaw().getLocationToUpdate().setText("");
			mf.getMbaw().setVisible(true);
			break;
		
		case "ModifyBetPlay":
			mf.getMbw().setVisible(false);
			showBetPlay();
			mf.getMbpw().getLocationDelete().setText("");
			mf.getMbpw().getLocationToUpdate().setText("");
			mf.getMbpw().setVisible(true);
			break;
		
		case "ModifyChance":
			mf.getMbw().setVisible(false);
			showChance();
			mf.getMcw().getLocationDelete().setText("");
			mf.getMcw().getLocationToUpdate().setText("");
			mf.getMcw().getBetValue().setText("");
			mf.getMcw().setVisible(true);
			break;
			
			
		// UpdateAdminWindow
		case "UpdAdmin":
			try {
				int index = 0;

				String name = mf.getUaw().getNombre().getText();
				checkNameSpecialCharacters(name);
				String document = mf.getUaw().getCedula().getText();
				checkNegativeNumbers(document);
				checkCharException(document);
				String direccion = mf.getUaw().getDireccion().getText();
				String celular = mf.getUaw().getCelular().getText();
				checkNegativeNumbers(celular);
				checkCharException(celular);
				String adminU = mf.getUaw().getUser().getText();
				String adminP = mf.getUaw().getPass().getText();
				checkPassword(adminP);	
				adDAO.update(index, name, document, direccion, celular, adminU, adminP);
				JOptionPane.showMessageDialog(mf, "Datos de administrador actualizados exitosamente");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (SpecialCharactersException e1) {
				JOptionPane.showMessageDialog(mf, "Los nombres no pueden llevar caracteres especiales");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"El documento y el celular no puede tener letras ni caracteres especiales");
			} catch (PasswordException e1) {
				JOptionPane.showMessageDialog(mf,
						"La contraseña debe tener mínimo 7 caracteres, al menos una mayúscula, una minúscula y un número");
			}catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(mf,
						"La cedula y el celular solo pueden contener numeros");
			}  
			mf.getUaw().getNombre().setText(a.getNombre());
			mf.getUaw().getCedula().setText("" + a.getCedula());
			mf.getUaw().getDireccion().setText(a.getDireccion());
			mf.getUaw().getCelular().setText("" + a.getCelular());
			mf.getUaw().getUser().setText(a.getUsuario());
			mf.getUaw().getPass().setText(a.getContrasena());
			break;

		case "UpdBack":
			mf.getUaw().setVisible(false);
			mf.getAow().setVisible(true);
			break;

		case "UpdAdminCon":
			JCheckBox checkBox4 = mf.getUaw().getOcultar();
			JPasswordField passwordField4 = mf.getUaw().getPass();

			if (checkBox4.isSelected()) {
				passwordField4.setEchoChar((char) 0);
			} else {
				passwordField4.setEchoChar('●');
			}
			break;

		// ShopParametersWindow
		case "ShopParaBack":
			mf.getSpw().setVisible(false);
			mf.getAow().setVisible(true);
			break;
		case "ShopParaUpd":

			try {
				String comment2 = "Se han modificado los parametros con exito";
				prop.load(new FileReader(config));

				String nameBS = mf.getSpw().getShopName().getText();
				prop.setProperty("NombreCasaDeApuestas", nameBS);
				prop.store(new FileWriter(config), comment2);
				String branchesBS = mf.getSpw().getBranch().getText();
				checkNegativeNumbers(branchesBS);
				checkCharException(branchesBS);
				prop.setProperty("NumeroDeSedes", branchesBS);
				prop.store(new FileWriter(config), comment2);
				String estimateBS = mf.getSpw().getBudget().getText();
				checkNegativeNumbers(estimateBS);
				checkCharException(estimateBS);
				prop.setProperty("PresupuestoDisponibleTotal", estimateBS);
				prop.store(new FileWriter(config), comment2);
				mf.setTitle("Casa de apuestas - " + nameBS);

				mf.getSpw().getShopName().setText(nameBS);
				mf.getSpw().getBranch().setText(branchesBS);
				mf.getSpw().getBudget().setText(estimateBS);
				JOptionPane.showMessageDialog(mf, "Parametros actualizados con éxito");
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"El presupuesto y la cantidad de sedes solo pueden contener números");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf,
						"El presupuesto y la cantidad de sedes solo pueden contener números");
			} 
			break;
		case "ToBranch":
			mf.getSpw().setVisible(false);
			mf.setBounds(0, 0, 528, 550);
			mf.setLocationRelativeTo(null);
			mf.getCbw().setVisible(true);
			break;
		case "BranchOptions":
			mf.getSpw().setVisible(false);
			showBranchs();
			mf.getBow().setVisible(true);
			break;
			
		case "ModifyGame":
			mf.getSpw().setVisible(false);
			mf.getGmw().getGame1().setText(gDAO.getlistOfGames().get(0).getGameName());
			mf.getGmw().getGame2().setText(gDAO.getlistOfGames().get(1).getGameName());
			mf.getGmw().getGame3().setText(gDAO.getlistOfGames().get(2).getGameName());
			mf.getGmw().getGame4().setText(gDAO.getlistOfGames().get(3).getGameName());
			mf.getGmw().getGame5().setText(gDAO.getlistOfGames().get(4).getGameName());
			mf.getGmw().getType1().setText(gDAO.getlistOfGames().get(0).getGameType());
			mf.getGmw().getType2().setText(gDAO.getlistOfGames().get(1).getGameType());
			mf.getGmw().getType3().setText(gDAO.getlistOfGames().get(2).getGameType());
			mf.getGmw().getType4().setText(gDAO.getlistOfGames().get(3).getGameType());
			mf.getGmw().getType5().setText(gDAO.getlistOfGames().get(4).getGameType());
			mf.getGmw().getBudget1().setText("" + gDAO.getlistOfGames().get(0).getGameEstimate());
			mf.getGmw().getBudget2().setText("" + gDAO.getlistOfGames().get(1).getGameEstimate());
			mf.getGmw().getBudget3().setText("" + gDAO.getlistOfGames().get(2).getGameEstimate());
			mf.getGmw().getBudget4().setText("" + gDAO.getlistOfGames().get(3).getGameEstimate());
			mf.getGmw().getBudget5().setText("" + gDAO.getlistOfGames().get(4).getGameEstimate());
			mf.getGmw().setVisible(true);
			break;
			
			// GameModWindow
			case "GameModUpd":
				try {

					int pos1 = 0;
					String gameName1 = mf.getGmw().getGame1().getText();
					String gameType1 = mf.getGmw().getType1().getText();
					checkNameSpecialCharacters(gameName1);
					checkNameSpecialCharacters(gameType1);
					String gameBudget1 = mf.getGmw().getBudget1().getText();
					checkCharException(gameBudget1);
					checkNegativeNumbers(gameBudget1);

					int pos2 = 1;
					String gameName2 = mf.getGmw().getGame2().getText();
					String gameType2 = mf.getGmw().getType2().getText();
					checkNameSpecialCharacters(gameName2);
					checkNameSpecialCharacters(gameType2);
					String gameBudget2 = mf.getGmw().getBudget2().getText();
					checkCharException(gameBudget2);
					checkNegativeNumbers(gameBudget2);

					int pos3 = 2;
					String gameName3 = mf.getGmw().getGame3().getText();
					String gameType3 = mf.getGmw().getType3().getText();
					checkNameSpecialCharacters(gameName3);
					checkNameSpecialCharacters(gameType3);
					String gameBudget3 = mf.getGmw().getBudget3().getText();
					checkCharException(gameBudget3);
					checkNegativeNumbers(gameBudget3);

					int pos4 = 3;
					String gameName4 = mf.getGmw().getGame4().getText();
					String gameType4 = mf.getGmw().getType4().getText();
					checkNameSpecialCharacters(gameName4);
					checkNameSpecialCharacters(gameType4);
					String gameBudget4 = mf.getGmw().getBudget4().getText();
					checkCharException(gameBudget4);
					checkNegativeNumbers(gameBudget4);				
					
					int pos5 = 4;
					String gameName5 = mf.getGmw().getGame5().getText();
					String gameType5 = mf.getGmw().getType5().getText();
					checkNameSpecialCharacters(gameName5);
					checkNameSpecialCharacters(gameType5);
					String gameBudget5 = mf.getGmw().getBudget5().getText();
					checkCharException(gameBudget5);
					checkNegativeNumbers(gameBudget5);
					checkTotalBudget(Long.parseLong(gameBudget1) , Long.parseLong(gameBudget2) ,Long.parseLong(gameBudget3) ,Long.parseLong(gameBudget4), Long.parseLong(gameBudget5));
					
					gDAO.update(pos1, gameName1, gameType1, gameBudget1);
					gDAO.update(pos2, gameName2, gameType2, gameBudget2);
					gDAO.update(pos3, gameName3, gameType3, gameBudget3);
					gDAO.update(pos4, gameName4, gameType4, gameBudget4);
					gDAO.update(pos5, gameName5, gameType5, gameBudget5);
					
					JOptionPane.showMessageDialog(mf, "Parametros actualizados con éxito");
				} catch (CharException e1) {
					JOptionPane.showMessageDialog(mf,
							"Solo se admiten numeros en las casillas de presupuesto");
				}
				 catch (NumberFormatException e1) {
					 JOptionPane.showMessageDialog(mf,
								"Solo se admiten numeros en las casillas de presupuesto");
				} catch (TotalBudgetException e1) {
					JOptionPane.showMessageDialog(mf,
							"El presupuesto propuesto es superior al total de la casa de apuestas, el presupuesto total es: "
									+ prop.getProperty("PresupuestoDisponibleTotal") + " COP");
				} catch (NegativeNumbersException e1) {
					JOptionPane.showMessageDialog(mf,
							"En la casilla de no se admiten números negativos");
				} catch (SpecialCharactersException e1) {
					JOptionPane.showMessageDialog(mf, "Los nombres y tipos de juego no pueden llevar caracteres especiales");
				}
				break;

			case "GameModBack":
				mf.getGmw().setVisible(false);
				mf.getSpw().setVisible(true);
				break;
			
		// CreateBranchWindow
		case "CreateBranch":
			try {
				int numBranches = Integer.parseInt(prop.getProperty("NumeroDeSedes"));
				if (bDAO.getListaSedes().size() < numBranches) {
					String location = mf.getCbw().getLocationBranch().getText();
					checkNameSpecialCharacters(location);
					String employeesNum = mf.getCbw().getEmployeesNum().getText();
					checkNegativeNumbers(employeesNum);
					checkCharException(employeesNum);
					bDAO.create(location, employeesNum);
					JOptionPane.showMessageDialog(mf, "Sede creada con exito");
				} else {
					JOptionPane.showMessageDialog(mf,
							"No es posible crear más sedes. La cantidad de sedes según los parametros de la casa de apuestas son: "
									+ numBranches);
				}
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (SpecialCharactersException e1) {
				JOptionPane.showMessageDialog(mf, "Los nombres de sede no pueden llevar caracteres especiales");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"El número de empleados no puede tener letras ni caracteres especiales");
			} catch (NumberFormatException e1) {
				 JOptionPane.showMessageDialog(mf,
							"Solo se admiten numeros en las casilla de empleados");
			}
			break;

		case "CreateBranchBack":
			mf.getCbw().setVisible(false);
			mf.getCbw().getLocationBranch().setText("");
			mf.getCbw().getEmployeesNum().setText("");
			mf.setBounds(0, 0, 1280, 720);
			mf.setLocationRelativeTo(null);
			mf.getSpw().getShopName().setText(prop.getProperty("NombreCasaDeApuestas"));
			mf.getSpw().getBranch().setText(prop.getProperty("NumeroDeSedes"));
			mf.getSpw().getBudget().setText(prop.getProperty("PresupuestoDisponibleTotal"));
			mf.getSpw().setVisible(true);
			break;

		// BranchOptionsWindow
		case "UpdBranch":

			try {
				String loc = mf.getBow().getBranchToUpdate().getText();
				checkNameSpecialCharacters(loc);
				String newLoc = mf.getBow().getNewName().getText();
				checkNameSpecialCharacters(newLoc);
				String newNumEmp = mf.getBow().getNewEmployees().getText();
				checkNegativeNumbers(newNumEmp);
				checkCharException(newNumEmp);
				if (bDAO.updateByName(loc, newLoc, newNumEmp)) {
					showBranchs();
					JOptionPane.showMessageDialog(mf, "La sede ha sido modificada exitosamente");
				} else {
					JOptionPane.showMessageDialog(mf, "La sede a modificar no ha sido encontrada");
				}
			} catch (SpecialCharactersException e1) {
				JOptionPane.showMessageDialog(mf, "Las nombres de sede no pueden llevar caracteres especiales");
			} catch (NegativeNumbersException e1) {
				JOptionPane.showMessageDialog(mf, "No es valido poner numeros negativos");
			} catch (CharException e1) {
				JOptionPane.showMessageDialog(mf,
						"El número de empleados no puede tener letras ni caracteres especiales");
			} catch (NumberFormatException e1) {
				 JOptionPane.showMessageDialog(mf,
							"Solo se admiten numeros en las casilla de empleados");
			}
			break;
		case "DelBranch":
			try {
				String location = mf.getBow().getLocationDelete().getText();
				checkNameSpecialCharacters(location);
				if (bDAO.deleteByLocation(location)) {
					showBranchs();
					JOptionPane.showMessageDialog(mf, "Sede eliminada correctamente");
				} else {
					JOptionPane.showMessageDialog(mf, "Sede no encontrada");
				}
			} catch (SpecialCharactersException e1) {
				JOptionPane.showMessageDialog(mf, "Las nombres de sede no pueden llevar caracteres especiales");
			}
			break;
		case "BranchOptionsBack":
			mf.getBow().setVisible(false);
			mf.getBow().getLocationDelete().setText("");
			mf.getBow().getBranchToUpdate().setText("");
			mf.getBow().getNewName().setText("");
			mf.getBow().getNewEmployees().setText("");
			mf.getSpw().getShopName().setText(prop.getProperty("NombreCasaDeApuestas"));
			mf.getSpw().getBranch().setText(prop.getProperty("NumeroDeSedes"));
			mf.getSpw().getBudget().setText(prop.getProperty("PresupuestoDisponibleTotal"));
			mf.getSpw().setVisible(true);
			break;
			

			
		}
	}

	/**
	 * Muestra la información de las sedes en la tabla correspondiente en la interfaz.
	 */
	public void showBranchs() {
		mf.getBow().getPanelTabla().getModel().setRowCount(0);
		bDAO.getListaSedes().forEach(sedes -> mf.getBow().getPanelTabla().getModel()
				.addRow(new Object[] {sedes.getLocation(), sedes.getEmployeesNum() }));
	}
	
	/**
	 * Obtiene un array con los nombres de las sedes.
	 * @return Un array con los nombres de las sedes.
	 */
    private String[] getSedesArray() {
        ArrayList<BranchDTO> sedesList = bDAO.getListaSedes();
        String[] sedesArray = new String[sedesList.size()];

        for (int i = 0; i < sedesList.size(); i++) {
            sedesArray[i] = sedesList.get(i).getLocation();
        }

        return sedesArray;
    }
	
    /**
     * Muestra la información de las loterías en la tabla correspondiente en la interfaz.
     */
	public void showLottery() {
	    mf.getMlw().getPanelTabla().getModel().setRowCount(0);
	    
	    int contador = 1; 
	    
	    for (LoteriaDTO l : lDAO.getLoterias()) {
	        mf.getMlw().getPanelTabla().getModel().addRow(
	                new Object[] {String.valueOf(contador), l.getSedeName(), l.getCc(), l.getDayOfWeek(), l.getBetValue(), l.getName(), String.format("%04d", l.getNumbers()), String.format("%03d", l.getSerie())} 
	        );

	        contador++;
	    }
	    
	}
	
	/**
	 * Muestra la información de los sorteos de Super Astro en la tabla correspondiente en la interfaz.
	 */
	public void showSuperAstro() {
		mf.getMsaw().getPanelTabla().getModel().setRowCount(0);
		
		int contador = 1; 
		
		for (SuperAstroDTO l : saDAO.getSuperAstros()) {
			mf.getMsaw().getPanelTabla().getModel().addRow(
					new Object[] {String.valueOf(contador), l.getSedeName(), l.getCc(), l.getDayOfWeek(), l.getBetValue(), String.format("%04d", l.getNumbers()), l.getSignoZodiacal() }
					);
			
			contador++; 
		}
	}
	
	/**
	 * Muestra la información de los sorteos de Chance en la tabla correspondiente en la interfaz.
	 */
	public void showChance() {
		mf.getMcw().getPanelTabla().getModel().setRowCount(0);
		
		int contador = 1; 
		
		for (ChanceDTO l : cDAO.getChances()) {
			mf.getMcw().getPanelTabla().getModel().addRow(
					new Object[] {String.valueOf(contador), l.getSedeName(), l.getCc(), l.getDayOfWeek(), l.getBetValue(), l.getName(), String.format("%04d", l.getNumbers()) }
					);
			
			contador++; 
		}
	}
	
	/**
	 * Muestra la información de los sorteos de BetPlay en la tabla correspondiente en la interfaz.
	 */
	public void showBetPlay() {
		mf.getMbpw().getPanelTabla().getModel().setRowCount(0);
		
		int contador = 1; 
		
		for (BetPlayDTO l : bpDAO.getResultados()) {
			mf.getMbpw().getPanelTabla().getModel().addRow(
					new Object[] {String.valueOf(contador), l.getSedeName(), l.getCc(), l.getDayOfWeek(), l.getBetValue(), 
							l.getResultados().get(0), l.getResultados().get(1), l.getResultados().get(2),
							l.getResultados().get(3), l.getResultados().get(4), l.getResultados().get(5), 
							l.getResultados().get(6), l.getResultados().get(7), l.getResultados().get(8), 
							l.getResultados().get(9), l.getResultados().get(10), l.getResultados().get(11), 
							l.getResultados().get(12), l.getResultados().get(13)}
					);
			
			contador++; 
		}
	}
	
	/**
	 * Muestra la información de los sorteos de Baloto en la tabla correspondiente en la interfaz.
	 */
	public void showBaloto() {
		mf.getMbaw().getPanelTabla().getModel().setRowCount(0);
		
		int contador = 1; 
		
		for (BalotoDTO l : baDAO.getBalotos()) {
			mf.getMbaw().getPanelTabla().getModel().addRow(
					new Object[] {String.valueOf(contador), l.getSedeName(), l.getCc(), l.getDayOfWeek(), l.getBetValue(), l.getNumbers() }
					);
			
			contador++; 
		}
	}
	
	/**
	 * Muestra los apostadores por sede en la tabla correspondiente de la ventana de clientes.
	 *
	 * @param bDAO Objeto BranchDAO que proporciona acceso a la información de las sedes.
	 * @param aDAO Objeto ApostadorDAO que proporciona acceso a la información de los apostadores.
	 */
	public void showApostadoresPorSede(BranchDAO bDAO, ApostadorDAO aDAO) {
	    mf.getCuw().getPanelTabla().getModel().setRowCount(0);

	    for (BranchDTO sede : bDAO.getListaSedes()) {
	        ArrayList<ApostadorDTO> apostadoresEnSede = rep.obtenerApostadoresEnSede(aDAO, sede.getLocation());

	        for (ApostadorDTO apostador : apostadoresEnSede) {
	            // Agrega una nueva fila con los datos correspondientes
	            mf.getCuw().getPanelTabla().getModel().addRow(new Object[]{sede.getLocation(), apostador.getNombre(), apostador.getCedula()});
	        }
	    }
	}
	
	/**
	 * Muestra en la tabla correspondiente de la ventana de apuestas la información sobre el valor total de apuestas realizadas
	 * por cada cliente en los diferentes tipos de juegos (Baloto, Super Astro, Lotería, BetPlay, Chance).
	 * @param baDAO Objeto BalotoDAO que proporciona acceso a la información de apuestas de Baloto.
	 * @param saDAO Objeto SuperAstroDAO que proporciona acceso a la información de apuestas de SuperAstro.
	 * @param lDAO  Objeto LoteriaDAO que proporciona acceso a la información de apuestas de Lotería.
	 * @param bpDAO Objeto BetPlayDAO que proporciona acceso a la información de apuestas de BetPlay.
	 * @param cDAO  Objeto ChanceDAO que proporciona acceso a la información de apuestas de Chance.
	 */
	public void showObtenerTotalApuestasPorCliente(BalotoDAO baDAO, SuperAstroDAO saDAO, LoteriaDAO lDAO, BetPlayDAO bpDAO, ChanceDAO cDAO) {
	    mf.getVbcw().getPanelTabla().getModel().setRowCount(0);

	    Map<Long, Double> totalApuestasPorCliente = new HashMap<>();

	    for (BalotoDTO baloto : baDAO.getBalotos()) {
	        rep.actualizarTotalApuestasPorCliente(totalApuestasPorCliente, baloto.getCc(), baloto.getBetValue());
	    }

	    for (SuperAstroDTO superAstro : saDAO.getSuperAstros()) {
	    	rep.actualizarTotalApuestasPorCliente(totalApuestasPorCliente, superAstro.getCc(), superAstro.getBetValue());
	    }

	    for (LoteriaDTO loteria : lDAO.getLoterias()) {
	    	rep.actualizarTotalApuestasPorCliente(totalApuestasPorCliente, loteria.getCc(), loteria.getBetValue());
	    }

	    for (BetPlayDTO betPlay : bpDAO.getResultados()) {
	    	rep.actualizarTotalApuestasPorCliente(totalApuestasPorCliente, betPlay.getCc(), betPlay.getBetValue());
	    }

	    for (ChanceDTO chance : cDAO.getChances()) {
	    	rep.actualizarTotalApuestasPorCliente(totalApuestasPorCliente, chance.getCc(), chance.getBetValue());
	    }

	    for (Map.Entry<Long, Double> entry : totalApuestasPorCliente.entrySet()) {
	        mf.getVbcw().getPanelTabla().getModel().addRow(new Object[]{entry.getKey(), entry.getValue()});
	    }
	}
	
	/**
	 * Muestra en la tabla correspondiente de la ventana de apuestas el total de la cantidad de apuestas realizadas 
	 * por cada sede en cada tipo de juego.
	 * @param bDAO  Objeto BranchDAO que proporciona acceso a la información de sucursales.
	 * @param gDAO  Objeto GameDAO que proporciona acceso a la información de juegos.
	 * @param aDAO  Objeto ApostadorDAO que proporciona acceso a la información de apostadores.
	 * @param lDAO  Objeto LoteriaDAO que proporciona acceso a la información de apuestas de Lotería.
	 * @param saDAO Objeto SuperAstroDAO que proporciona acceso a la información de apuestas de Super Astro.
	 * @param baDAO Objeto BalotoDAO que proporciona acceso a la información de apuestas de Baloto.
	 * @param bpDAO Objeto BetPlayDAO que proporciona acceso a la información de apuestas de BetPlay.
	 * @param cDAO  Objeto ChanceDAO que proporciona acceso a la información de apuestas de Chance.
	 */
	public void showTotalBets(BranchDAO bDAO, GameDAO gDAO, ApostadorDAO aDAO, LoteriaDAO lDAO, SuperAstroDAO saDAO, BalotoDAO baDAO, BetPlayDAO bpDAO, ChanceDAO cDAO) {
	    mf.getTbw().getPanelTabla().getModel().setRowCount(0);

	    for (BranchDTO sede : bDAO.getListaSedes()) {

	        for (GameDTO juego : gDAO.getlistOfGames()) {
	            String tipoJuego = juego.getGameType();

	            long totalApuestas = 0;

	            for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
	                for (LoteriaDTO loteria : lDAO.getLoterias()) {
	                    if (loteria.getCc() == apostador.getCedula() && loteria.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Loteria")) {
	                        totalApuestas++;
	                    }
	                }

	                for (SuperAstroDTO superAstro : saDAO.getSuperAstros()) {
	                    if (superAstro.getCc() == apostador.getCedula() && superAstro.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Super Astro")) {
	                        totalApuestas++;
	                    }
	                }

	                for (BalotoDTO baloto : baDAO.getBalotos()) {
	                    if (baloto.getCc() == apostador.getCedula() && baloto.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Baloto")) {
	                        totalApuestas++;
	                    }
	                }

	                for (BetPlayDTO betPlay : bpDAO.getResultados()) {
	                    if (betPlay.getCc() == apostador.getCedula() && betPlay.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("BetPlay")) {
	                        totalApuestas++;
	                    }
	                }

	                for (ChanceDTO chance : cDAO.getChances()) {
	                    if (chance.getCc() == apostador.getCedula() && chance.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Chance")) {
	                        totalApuestas++;
	                    }
	                }
	            }

	            mf.getTbw().getPanelTabla().getModel().addRow(new Object[]{sede.getLocation(), juego.getGameName(), tipoJuego, totalApuestas});
	        }
	    }
	}
    
	/**
	 * checkNegativeNumbers: funcion que se encarga de verificar si el numero
	 * ingresado, no es negativo
	 * @param number Numero
	 * @throws NegativeNumbersException El numero es negativo
	 */
	public void checkNegativeNumbers(String number) throws NegativeNumbersException {
		if (Integer.parseInt(number) < 0) {
			throw new NegativeNumbersException();
		}
	}

	/**
	 * checkNameSpecialCharacters: funcion que se encarga de verificar si el nombre
	 * tiene caracteres especiales o numeros
	 * @param name: nombre
	 * @throws SpecialCharactersException Hay caracteres especiales o numeros
	 */
	public void checkNameSpecialCharacters(String name) throws SpecialCharactersException {
		for (char c : name.toCharArray()) {
			if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
				throw new SpecialCharactersException();
			}
		}
	}

	/**
	 * checkNameSpecialCharacters2: funcion que se encarga de verificar si el nombre
	 * tiene caracteres especiales o numeros
	 * @param name Nombre
	 * @throws SpecialCharactersException Hay caracteres especiales o numeros
	 */
	public void checkNameSpecialCharacters2(String name) throws SpecialCharactersException {
		for (char c : name.toCharArray()) {
			if (!Character.isAlphabetic(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
				throw new SpecialCharactersException();
			}
		}
	}

	/**
	 * checkCharException: funcion que se encarga de verificar si se ha ingresado un
	 * numero y no letras o caracteres especiales
	 * @param number: numeros
	 * @throws CharException Hay caracteres especiales o letras
	 */
	public void checkCharException(String number) throws CharException {
		if (!number.matches("\\d+")) {
			throw new CharException();
		}
	}

	/**
	 * checkPasswordException: funcion que se encarga de verificar si se han
	 * ingresado la cantidad y el tipo de caracteres requeridos para la contraseña
	 * @param pass: Numeros
	 * @throws PasswordException Hay caracteres especiales o letras
	 */
	public void checkPassword(String pass) throws PasswordException {
		if (pass.length() < 7 || !pass.matches(".*[A-Z].*") || !pass.matches(".*[a-z].*") || !pass.matches(".*\\d.*")) {
			throw new PasswordException();
		}
	}

	/**
	 * Verifica si la suma de los presupuestos de los juegos supera el presupuesto total disponible de la casa de apuesta.
	 * @param budget  Primer presupuesto a verificar.
	 * @param budget2 Segundo presupuesto a verificar.
	 * @param budget3 Tercer presupuesto a verificar.
	 * @param budget4 Cuarto presupuesto a verificar.
	 * @param budget5 Quinto presupuesto a verificar.
	 * @throws TotalBudgetException Se lanza si la suma de los presupuestos supera el presupuesto total disponible.
	 */
	public void checkTotalBudget(long budget, long budget2, long budget3, long budget4, long budget5) throws TotalBudgetException {
		if (budget+ budget2+ budget3+ budget4+ budget5 > Long
				.parseLong(prop.getProperty("PresupuestoDisponibleTotal"))) {
			throw new TotalBudgetException();
		}
	}
	
	/**
	 * Verifica si hay datos faltantes en el registro y el inicio de sesión.
	 * @param st Arreglo de cadenas que representan los datos a verificar.
	 * @throws MissingDataException Se lanza si hay datos faltantes en el registro o el inicio de sesión.
	 */
	public void checkRegisterAndLogin(String... st) throws MissingDataException {
        if (st[0] == "" || st[0].isBlank() || st[0].isEmpty()|| st[1] == "" || st[1].isBlank() || st[1].isEmpty() |st[2] == "" || st[2].isBlank() || st[2].isEmpty()||
        		st[3] == "" || st[3].isBlank() || st[3].isEmpty()||st[4] == "" || st[4].isBlank() || st[4].isEmpty()|| st[5] == "" || st[5].isBlank() 
        		|| st[5].isEmpty()|| st[6] == "" || st[6].isBlank() || st[6].isEmpty()) {
            throw new MissingDataException();
        } 
	}
	
	/**
	 * Verifica si ya existe un usuario con la misma cédula.
	 * @param user   Usuario a verificar.
	 * @param cedula Cédula del usuario a verificar.
	 * @throws ExistingUserException Se lanza si ya existe un usuario con la misma cédula.
	 */
	public void checkCedulaAndUser(String user, String cedula) throws ExistingUserException {
		if(aDAO.comprobarRegistro(user, Long.parseLong(cedula))){
			 throw new ExistingUserException();
		}
	}
	
	/**
	 * Verifica si el valor de la apuesta en SuperAstro está dentro del rango permitido.
	 * @param value Valor de la apuesta en Super Astro a verificar.
	 * @throws SuperAstroBetException Se lanza si el valor de la apuesta en Super Astro está fuera del rango permitido.
	 */
	public void checkSuperAstroBetValue(double value) throws SuperAstroBetException{
		if (value < 500 || value > 10000) {
			throw new SuperAstroBetException();
		}
	}
	
	/**
	 * Verifica si el valor de la apuesta en Chance está dentro del rango permitido.
	 * @param value Valor de la apuesta en Chance a verificar.
	 * @throws ChanceBetException Se lanza si el valor de la apuesta en Chance está fuera del rango permitido.
	 */
	public void checkChanceBetValue(double value) throws ChanceBetException{
		if (value < 500 || value > 20000) {
			throw new ChanceBetException();
		}
	}
}
