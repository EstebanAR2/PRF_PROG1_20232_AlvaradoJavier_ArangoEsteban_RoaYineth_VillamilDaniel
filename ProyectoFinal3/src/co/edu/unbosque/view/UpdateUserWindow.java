package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.edu.unbosque.modulo2.model.BranchDTO;
import co.edu.unbosque.modulo2.model.persistence.BranchDAO;

/**
 * La clase UpdateUserWindow representa la ventana de actualización de datos para un usuario.
 */
public class UpdateUserWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = -3326543552771285039L;
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
    /** Campo de texto para el nombre de usuario del usuario. */
    private JTextField user;
    /** Campo de contraseña para la contraseña del usuario. */
    private JPasswordField pass;
    /** Casilla de verificación para ocultar la contraseña. */
    private JCheckBox ocultar;
    /** Lista desplegable para seleccionar la sede del usuario. */
    private JComboBox<String> sedes;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Botón para realizar la actualización de datos del usuario. */
    private JButton update;
    /** Botón para eliminar el usuario. */
    private JButton delete;
    /** Objeto para acceder a la capa de acceso a datos de las sedes. */
    private BranchDAO bDAO;

    /**
     * Construye una nueva instancia de la clase UpdateUserWindow.
     * Inicializa y configura los elementos gráficos presentes en la ventana de actualización de datos para un usuario.
     */
	public UpdateUserWindow() {
		bDAO = new BranchDAO();
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/6.png"));
		backg.setBounds(-10, -35, 1280, 720);
		
		nombre = new JTextField();
		nombre.setEditable(true);
		nombre.setBounds(350, 155, 690, 40);
		nombre.setForeground(Color.WHITE);
		nombre.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		nombre.setBorder(null);
		nombre.setOpaque(false);
		
		cedula = new JTextField();
		cedula.setEditable(true);
		cedula.setBounds(350, 220, 690, 40);
		cedula.setForeground(Color.WHITE);
		cedula.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		cedula.setBorder(null);
		cedula.setOpaque(false);
		
		sedes = new JComboBox<>();
		sedes.setModel(new DefaultComboBoxModel<String>(getSedesArray()));
		sedes.setBounds(780, 270, 275, 40);
		sedes.setBackground(Color.BLACK);
		sedes.setForeground(Color.WHITE);
		sedes.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		sedes.setBorder(null);
		sedes.setOpaque(false);

		direccion = new JTextField();
		direccion.setEditable(true);
		direccion.setBounds(360, 332, 690, 40);
		direccion.setForeground(Color.WHITE);
		direccion.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		direccion.setBorder(null);
		direccion.setOpaque(false);
		
		celular = new JTextField();
		celular.setEditable(true);
		celular.setBounds(360, 390, 690, 40);
		celular.setForeground(Color.WHITE);
		celular.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		celular.setBorder(null);
		celular.setOpaque(false);
		
		user = new JTextField();
		user.setEditable(true);
		user.setBounds(515, 445, 525, 40);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		user.setBorder(null);
		user.setOpaque(false);
		
		pass = new JPasswordField();
		pass.setEditable(true);
		pass.setBounds(515, 505, 525, 40);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		pass.setBorder(null);
		pass.setOpaque(false);
		
		ocultar = new JCheckBox();
		ocultar.setBounds(450, 545, 20, 20);
		ocultar.setContentAreaFilled(false);
		
		delete = new JButton();
		delete.setToolTipText("Click aqui para eliminar su cuenta");
		delete.setBounds(745, 595, 240, 60);
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);
		
		update = new JButton();
		update.setToolTipText("Click aqui para actualizar sus datos");
		update.setBounds(435, 595, 240, 60);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1060, 600, 140, 62);
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
		add(delete);
		add(update);
		add(back);
		add(backg);
	}
	
    private String[] getSedesArray() {
        ArrayList<BranchDTO> sedesList = bDAO.getListaSedes();
        String[] sedesArray = new String[sedesList.size()];

        for (int i = 0; i < sedesList.size(); i++) {
            sedesArray[i] = sedesList.get(i).getLocation();
        }

        return sedesArray;
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

	public JButton getUpdate() {
		return update;
	}

	public void setUpdate(JButton update) {
		this.update = update;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}
	
}
