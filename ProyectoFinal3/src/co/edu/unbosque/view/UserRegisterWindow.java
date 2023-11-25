package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.edu.unbosque.modulo2.model.persistence.BranchDAO;


/**
 * La clase UserRegisterWindow representa la ventana de registro para un usuario.
 */
public class UserRegisterWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = 1392197808022593927L;
    /** Imagen de fondo para la ventana. */
    private JLabel backg;
    /** Campo de texto para el nombre del usuario. */
    private JTextField nombre;
    /** Campo de texto para la cédula del usuario. */
    private JTextField cedula;
    /** Campo de texto para la dirección del usuario. */
    private JTextField direccion;
    /** Campo de texto para el número de celular del usuario. */
    private JTextField celular;
    /** Campo de texto para el nombre de usuario. */
    private JTextField user;
    /** Campo de contraseña para el usuario. */
    private JPasswordField pass;
    /** Lista desplegable para seleccionar la sede del usuario. */
    private JComboBox<String> sedes;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Botón para realizar el registro del usuario. */
    private JButton register;
    /** Casilla de verificación para ocultar la contraseña. */
    private JCheckBox ocultar;
    /** Objeto para acceder a operaciones relacionadas con las sedes. */
    private BranchDAO bDAO;

    /**
     * Construye una nueva instancia de la clase UserRegisterWindow.
     * Inicializa y configura los elementos gráficos presentes en la ventana de registro para un usuario.
     */
	public UserRegisterWindow() {
		bDAO = new BranchDAO();
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/3.png"));
		backg.setBounds(-10, -35, 1280, 720);
		
		nombre = new JTextField();
		nombre.setEditable(true);
		nombre.setBounds(340, 200, 690, 45);
		nombre.setForeground(Color.WHITE);
		nombre.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		nombre.setBorder(null);
		nombre.setOpaque(false);
		
		cedula = new JTextField();
		cedula.setEditable(true);
		cedula.setBounds(340, 260, 690, 45);
		cedula.setForeground(Color.WHITE);
		cedula.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		cedula.setBorder(null);
		cedula.setOpaque(false);
		
		sedes = new JComboBox<>();
		sedes.setBounds(770, 315, 270, 45);
		sedes.setBackground(Color.BLACK);
		sedes.setForeground(Color.WHITE);
		sedes.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		sedes.setBorder(null);
		sedes.setOpaque(false);

		direccion = new JTextField();
		direccion.setEditable(true);
		direccion.setBounds(345, 370, 690, 45);
		direccion.setForeground(Color.WHITE);
		direccion.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		direccion.setBorder(null);
		direccion.setOpaque(false);
		
		celular = new JTextField();
		celular.setEditable(true);
		celular.setBounds(345, 425, 690, 45);
		celular.setForeground(Color.WHITE);
		celular.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		celular.setBorder(null);
		celular.setOpaque(false);
		
		user = new JTextField();
		user.setEditable(true);
		user.setBounds(505, 480, 505, 45);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		user.setBorder(null);
		user.setOpaque(false);
		
		pass = new JPasswordField();
		pass.setEditable(true);
		pass.setBounds(505, 540, 505, 45);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		pass.setBorder(null);
		pass.setOpaque(false);
		
		ocultar = new JCheckBox();
		ocultar.setBounds(470, 605, 20, 20);
		ocultar.setContentAreaFilled(false);
		
		register = new JButton();
		register.setToolTipText("Click aqui al terminar de rellenar los datos para registrarse");
		register.setBounds(725, 610, 240, 60);
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1080, 600, 140, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(nombre);
		add(cedula);
		add(sedes);
		add(direccion);
		add(celular);
		add(user);
		add(pass);
		add(ocultar);
		add(register);
		add(back);
		add(backg);
	}
    
	public JLabel getBackg() {
		return backg;
	}

	public void setBackg(JLabel backg) {
		this.backg = backg;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getCedula() {
		return cedula;
	}

	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public JTextField getDireccion() {
		return direccion;
	}

	public void setDireccion(JTextField direccion) {
		this.direccion = direccion;
	}

	public JTextField getCelular() {
		return celular;
	}

	public void setCelular(JTextField celular) {
		this.celular = celular;
	}

	public JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JComboBox<String> getSedes() {
		return sedes;
	}

	public void setSedes(JComboBox<String> sedes) {
		this.sedes = sedes;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JButton getRegister() {
		return register;
	}

	public void setRegister(JButton register) {
		this.register = register;
	}

	public JCheckBox getOcultar() {
		return ocultar;
	}

	public void setOcultar(JCheckBox ocultar) {
		this.ocultar = ocultar;
	}

	public BranchDAO getbDAO() {
		return bDAO;
	}

	public void setbDAO(BranchDAO bDAO) {
		this.bDAO = bDAO;
	}
    
}
