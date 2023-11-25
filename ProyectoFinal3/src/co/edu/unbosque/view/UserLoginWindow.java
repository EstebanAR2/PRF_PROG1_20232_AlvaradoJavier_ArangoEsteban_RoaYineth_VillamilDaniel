package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * La clase UserLoginWindow representa la ventana de inicio de sesión para un usuario.
 */
public class UserLoginWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = -29375105785721177L;
    /** Imagen de fondo para la ventana. */
    private JLabel backg;
    /** Campo de texto para el nombre de usuario. */
    private JTextField user;
    /** Campo de contraseña para la contraseña del usuario. */
    private JPasswordField pass;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Botón para acceder al registro de usuarios. */
    private JButton register;
    /** Botón para iniciar sesión. */
    private JButton login;
    /** Casilla de verificación para ocultar la contraseña. */
    private JCheckBox ocultar;

    /**
     * Construye una nueva instancia de la clase UserLoginWindow.
     * Inicializa y configura los elementos gráficos presentes en la ventana de inicio de sesión para un usuario.
     */
	public UserLoginWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/2.png"));
		backg.setBounds(0, -20, 1280, 720);

		user = new JTextField();
		user.setEditable(true);
		user.setBounds(560, 125, 500, 53);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		user.setBorder(null);
		user.setOpaque(false);
		
		pass = new JPasswordField();
		pass.setEditable(true);
		pass.setBounds(560, 275, 500, 53);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		pass.setBorder(null);
		pass.setOpaque(false);
		
		register = new JButton();
		register.setToolTipText("Entrar al proceso de registro de cliente");
		register.setBounds(445, 530, 395, 45);
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);

		login = new JButton();
		login.setToolTipText("Iniciar sesion para ingresar al área de seleccion de apuestas");
		login.setBounds(485, 400, 340, 85);
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(560, 600, 160, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		ocultar = new JCheckBox();
		ocultar.setBounds(1070, 370, 20, 20);
		ocultar.setContentAreaFilled(false);
		
		add(user);
		add(pass);
		add(ocultar);
		add(login);
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

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JCheckBox getOcultar() {
		return ocultar;
	}

	public void setOcultar(JCheckBox ocultar) {
		this.ocultar = ocultar;
	}

	public JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}
}
