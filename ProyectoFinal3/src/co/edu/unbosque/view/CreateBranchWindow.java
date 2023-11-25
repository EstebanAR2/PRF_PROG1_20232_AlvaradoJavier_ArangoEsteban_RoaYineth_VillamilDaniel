package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

/**
 * La clase CreateBranchWindow representa la ventana para crear una nueva sede.
 */
public class CreateBranchWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 7349422409476435697L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** Botones para acciones como regresar y crear la sede. */
    private JButton back, create;
    /** Campo de texto para ingresar la ubicación de la sede. */
    private JTextField locationBranch;
    /** Campo de texto para ingresar el número de empleados de la sede. */
    private JTextField employeesNum;

    /**
     * Construye una nueva instancia de la clase CreateBranchWindow.
     * Configura y coloca los componentes gráficos necesarios para crear una nueva sede.
     */
	public CreateBranchWindow() {
		setBounds(0, 0, 528, 550);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/ProyF5.png"));
		backg.setBounds(0, -20, 528, 550);
		
		locationBranch = new JTextField();
		locationBranch.setEditable(true);
		locationBranch.setBounds(145, 153, 260, 35);
		locationBranch.setForeground(Color.WHITE);
		locationBranch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		locationBranch.setBorder(null);
		locationBranch.setOpaque(false);
		
		employeesNum = new JTextField();
		employeesNum.setEditable(true);
		employeesNum.setBounds(145, 230, 260, 35);
		employeesNum.setForeground(Color.WHITE);
		employeesNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		employeesNum.setBorder(null);
		employeesNum.setOpaque(false);

		create = new JButton();
		create.setToolTipText("Click para crear una sede con los datos registrados");
		create.setBounds(165, 305, 230, 35);
		create.setOpaque(false);
		create.setContentAreaFilled(false);
		create.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(210, 440, 120, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(locationBranch);
		add(employeesNum);
		add(create);
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

	public JButton getCreate() {
		return create;
	}

	public void setCreate(JButton create) {
		this.create = create;
	}

	public JTextField getLocationBranch() {
		return locationBranch;
	}
	
	public void setLocationBranch(JTextField locationBranch) {
		this.locationBranch = locationBranch;
	}
	
	public JTextField getEmployeesNum() {
		return employeesNum;
	}

	public void setEmployeesNum(JTextField employeesNum) {
		this.employeesNum = employeesNum;
	}
	
}
