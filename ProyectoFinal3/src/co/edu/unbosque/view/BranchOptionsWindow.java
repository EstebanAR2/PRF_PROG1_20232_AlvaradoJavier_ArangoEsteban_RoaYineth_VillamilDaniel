package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * La clase BranchOptionsWindow es un componente gráfico que muestra las opciones disponibles
 * para gestionar las sedes de la aplicación, como actualizar y borrar sedes.
 */
public class BranchOptionsWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 6324671068505454193L;
    /** Imagen de fondo. */
    private JLabel backg;
    /** Botones para borrar, actualizar y volver. */
    private JButton back, update, delete;
    /** Campos de texto para la ubicación a borrar, la sede a actualizar, el nuevo nombre y el nuevo número de empleados. */
    private JTextField locationDelete, branchToUpdate, newName, newEmployees;
    /** Panel que muestra una tabla con información sobre las sedes. */
    private BranchTable panelTabla;

    /**
     * Construye una nueva instancia de la clase BranchOptionsWindow.
     * Configura y coloca los componentes gráficos necesarios para las opciones de gestión de sedes.
     */
	public BranchOptionsWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/15.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new BranchTable();
		
		newEmployees = new JTextField();
		newEmployees.setEditable(true);
		newEmployees.setBounds(805, 455, 345, 40);
		newEmployees.setForeground(Color.WHITE);
		newEmployees.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		newEmployees.setBorder(null);
		newEmployees.setOpaque(false);
		newEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		
		newName = new JTextField();
		newName.setEditable(true);
		newName.setBounds(800, 355, 345, 40);
		newName.setForeground(Color.WHITE);
		newName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		newName.setBorder(null);
		newName.setOpaque(false);
		newName.setHorizontalAlignment(SwingConstants.CENTER);
		
		branchToUpdate = new JTextField();
		branchToUpdate.setEditable(true);
		branchToUpdate.setBounds(795, 265, 345, 40);
		branchToUpdate.setForeground(Color.WHITE);
		branchToUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		branchToUpdate.setBorder(null);
		branchToUpdate.setOpaque(false);
		branchToUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		
		locationDelete = new JTextField();
		locationDelete.setEditable(true);
		locationDelete.setBounds(790, 105, 345, 40);
		locationDelete.setForeground(Color.WHITE);
		locationDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationDelete.setBorder(null);
		locationDelete.setOpaque(false);
		locationDelete.setHorizontalAlignment(SwingConstants.CENTER);
		
		delete = new JButton();
		delete.setToolTipText("Click para borrar la sede con el nombre registrado");
		delete.setBounds(900, 160, 110, 40);
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);

		update = new JButton();
		update.setToolTipText("Click para actualizar una sede con los datos registrados");
		update.setBounds(840, 530, 270, 40);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1090, 620, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(panelTabla);
		add(locationDelete);
		add(branchToUpdate);
		add(newName);
		add(newEmployees);
		add(delete);
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

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JTextField getLocationDelete() {
		return locationDelete;
	}

	public void setLocationDelete(JTextField locationDelete) {
		this.locationDelete = locationDelete;
	}

	public JTextField getBranchToUpdate() {
		return branchToUpdate;
	}

	public void setBranchToUpdate(JTextField branchToUpdate) {
		this.branchToUpdate = branchToUpdate;
	}

	public JTextField getNewName() {
		return newName;
	}

	public void setNewName(JTextField newName) {
		this.newName = newName;
	}

	public JTextField getNewEmployees() {
		return newEmployees;
	}

	public void setNewEmployees(JTextField newEmployees) {
		this.newEmployees = newEmployees;
	}

	public BranchTable getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(BranchTable panelTabla) {
		this.panelTabla = panelTabla;
	}
	
}
