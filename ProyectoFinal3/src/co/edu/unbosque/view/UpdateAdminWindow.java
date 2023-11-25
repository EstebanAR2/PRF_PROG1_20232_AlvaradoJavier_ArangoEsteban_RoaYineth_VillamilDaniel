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
 * La clase UpdateAdminWindow representa la ventana de actualización de datos para un administrador.
 */
public class UpdateAdminWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = 3258136856012981618L;
    /** Imagen de fondo para la ventana. */
    private JLabel backg;
    /** Campo de texto para el nombre del administrador. */
    private JTextField nombre;
    /** Campo de texto para la cédula del administrador. */
    private JTextField cedula;
    /** Campo de texto para la dirección del administrador. */
    private JTextField direccion;
    /** Campo de texto para el número de celular del administrador. */
    private JTextField celular;
    /** Campo de texto para el nombre de usuario del administrador. */
    private JTextField user;
    /** Campo de contraseña para la contraseña del administrador. */
    private JPasswordField pass;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Botón para realizar la actualización de datos. */
    private JButton update;
    /** Casilla de verificación para ocultar la contraseña. */
    private JCheckBox ocultar;

    /**
     * Construye una nueva instancia de la clase UpdateAdminWindow.
     * Inicializa y configura los elementos gráficos presentes en la ventana de actualización de datos para un administrador.
     */
	public UpdateAdminWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/8.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		nombre = new JTextField();
		nombre.setEditable(true);
		nombre.setBounds(390, 175, 700, 35);
		nombre.setForeground(Color.WHITE);
		nombre.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		nombre.setBorder(null);
		nombre.setOpaque(false);
		
		cedula = new JTextField();
		cedula.setEditable(true);
		cedula.setBounds(390, 230, 700, 35);
		cedula.setForeground(Color.WHITE);
		cedula.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		cedula.setBorder(null);
		cedula.setOpaque(false);
		
		direccion = new JTextField();
		direccion.setEditable(true);
		direccion.setBounds(390, 285, 700, 35);
		direccion.setForeground(Color.WHITE);
		direccion.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		direccion.setBorder(null);
		direccion.setOpaque(false);
		
		celular = new JTextField();
		celular.setEditable(true);
		celular.setBounds(390, 345, 700, 35);
		celular.setForeground(Color.WHITE);
		celular.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		celular.setBorder(null);
		celular.setOpaque(false);
		
		user = new JTextField();
		user.setEditable(true);
		user.setBounds(550, 428, 500, 35);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		user.setBorder(null);
		user.setOpaque(false);
		
		pass = new JPasswordField();
		pass.setEditable(true);
		pass.setBounds(550, 485, 500, 35);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		pass.setBorder(null);
		pass.setOpaque(false);
		
		ocultar = new JCheckBox();
		ocultar.setBounds(580, 570, 20, 20);
		ocultar.setContentAreaFilled(false);
		
		update = new JButton();
		update.setToolTipText("Actualizar datos de administrador");
		update.setBounds(690, 575, 280, 60);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1080, 570, 140, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(nombre);
		add(cedula);
		add(direccion);
		add(celular);
		add(user);
		add(pass);
		add(ocultar);
		add(update);
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

	public JButton getUpdate() {
		return update;
	}

	public void setUpdate(JButton update) {
		this.update = update;
	}

	public JCheckBox getOcultar() {
		return ocultar;
	}

	public void setOcultar(JCheckBox ocultar) {
		this.ocultar = ocultar;
	}

}
