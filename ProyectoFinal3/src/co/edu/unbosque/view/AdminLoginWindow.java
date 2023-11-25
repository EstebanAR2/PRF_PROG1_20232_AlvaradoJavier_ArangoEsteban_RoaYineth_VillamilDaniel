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
 * La clase AdminLoginWindow representa la ventana de inicio de sesión para administradores.

 */
public class AdminLoginWindow extends JLayeredPane{
	
	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = -4667125013435882869L;
    /** El fondo de la ventana de inicio de sesión. */
    private JLabel backg;
    /** El campo de texto para el nombre de usuario. */
    private JTextField user;
    /** El campo de contraseña. */
    private JPasswordField pass;
    /** La casilla de verificación para ocultar la contraseña. */
    private JCheckBox ocultar;
    /** El botón de inicio de sesión. */
    private JButton login;
    /** El botón de retroceso. */
    private JButton back;

    /**
     * Configura y coloca los componentes gráficos en la ventana de inicio de sesión del administrador.
     */
	public AdminLoginWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/4.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		user = new JTextField();
		user.setEditable(true);
		user.setBounds(560, 160, 500, 53);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		user.setBorder(null);
		user.setOpaque(false);
		
		pass = new JPasswordField();
		pass.setEditable(true);
		pass.setBounds(560, 325, 500, 53);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		pass.setBorder(null);
		pass.setOpaque(false);
		
		ocultar = new JCheckBox();
		ocultar.setBounds(1070, 430, 20, 20);
		ocultar.setContentAreaFilled(false);
		
		login = new JButton();
		login.setToolTipText("Entrar al apartado de administradores");
		login.setBounds(460, 445, 340, 85);
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(560, 600, 160, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		add(user);
		add(pass);
		add(ocultar);
		add(login);
		add(back);
		add(backg);
	}

    /**
     * Obtiene el fondo de la ventana de inicio de sesión.

     * @return El componente JLabel que representa el fondo.
     */
    public JLabel getBackg() {
        return backg;
    }

    /**
     * Establece el fondo de la ventana de inicio de sesión.
     * @param backg El nuevo fondo representado por un componente JLabel.
     */
    public void setBackg(JLabel backg) {
        this.backg = backg;
    }

    /**
     * Obtiene el botón de retroceso.
     * @return El componente JButton que representa el botón de retroceso.
     */
    public JButton getBack() {
        return back;
    }

    /**
     * Establece el botón de retroceso.
     * @param back El nuevo botón de retroceso representado por un componente JButton.
     */
    public void setBack(JButton back) {
        this.back = back;
    }

    /**
     * Obtiene el botón de inicio de sesión.
     * @return El componente JButton que representa el botón de inicio de sesión.
     */
    public JButton getLogin() {
        return login;
    }

    /**
     * Establece el botón de inicio de sesión.
     * @param login El nuevo botón de inicio de sesión representado por un componente JButton.
     */
    public void setLogin(JButton login) {
        this.login = login;
    }

    /**
     * Obtiene el campo de texto para el nombre de usuario.
     * @return El componente JTextField que representa el campo de texto para el nombre de usuario.
     */
    public JTextField getUser() {
        return user;
    }

    /**
     * Establece el campo de texto para el nombre de usuario.
     * @param user El nuevo campo de texto para el nombre de usuario representado por un componente JTextField.
     */
    public void setUser(JTextField user) {
        this.user = user;
    }

    /**
     * Obtiene el campo de contraseña.
     * @return El componente JPasswordField que representa el campo de contraseña.
     */
    public JPasswordField getPass() {
        return pass;
    }

    /**
     * Establece el campo de contraseña.
     * @param pass El nuevo campo de contraseña representado por un componente JPasswordField.
     */
    public void setPass(JPasswordField pass) {
        this.pass = pass;
    }

    /**
     * Obtiene la casilla de verificación para ocultar la contraseña.
     * @return El componente JCheckBox que representa la casilla de verificación.
     */
    public JCheckBox getOcultar() {
        return ocultar;
    }

    /**
     * Establece la casilla de verificación para ocultar la contraseña.
     * @param ocultar La nueva casilla de verificación representada por un componente JCheckBox.
     */
    public void setOcultar(JCheckBox ocultar) {
        this.ocultar = ocultar;
    }
}