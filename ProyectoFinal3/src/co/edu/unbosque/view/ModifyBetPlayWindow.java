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
 * La clase ModifyBetPlayWindow representa la ventana de modificación para la apuesta de juegos.
 */
public class ModifyBetPlayWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = 596507685214980876L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** El botón para volver al menú anterior. */
    private JButton back;
    /** El botón para actualizar parámetros de la apuesta. */
    private JButton update;
    /** El botón para eliminar datos de la apuesta. */
    private JButton delete;
    /** El campo de texto para la ubicación a eliminar. */
    private JTextField locationDelete;
    /** El campo de texto para la ubicación a actualizar. */
    private JTextField locationToUpdate;
    /** La tabla que muestra los datos de las apuestas de juegos. */
    private BetPlayTable panelTabla;

    /**
     * Construye una nueva instancia de la clase ModifyBetPlayWindow.
     * Configura y muestra la ventana de modificación para las apuestas de juegos.
     */
	public ModifyBetPlayWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/21.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new BetPlayTable();
		
		locationToUpdate = new JTextField();
		locationToUpdate.setEditable(true);
		locationToUpdate.setBounds(840, 545, 310, 40);
		locationToUpdate.setForeground(Color.WHITE);
		locationToUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationToUpdate.setBorder(null);
		locationToUpdate.setOpaque(false);
		locationToUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		
		locationDelete = new JTextField();
		locationDelete.setEditable(true);
		locationDelete.setBounds(150, 545, 310, 40);
		locationDelete.setForeground(Color.WHITE);
		locationDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationDelete.setBorder(null);
		locationDelete.setOpaque(false);
		locationDelete.setHorizontalAlignment(SwingConstants.CENTER);
		
		delete = new JButton();
		delete.setToolTipText("Click para borrar la apuesta de BetPlay en la posicion registrada");
		delete.setBounds(240, 590, 110, 40);
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);

		update = new JButton();
		update.setToolTipText("Click para actualizar la apuesta de BetPlay con los datos registrados");
		update.setBounds(870, 590, 270, 40);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(580, 615, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		add(panelTabla);
		add(locationDelete);
		add(locationToUpdate);
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

	public JTextField getLocationToUpdate() {
		return locationToUpdate;
	}

	public void setLocationToUpdate(JTextField locationToUpdate) {
		this.locationToUpdate = locationToUpdate;
	}

	public BetPlayTable getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(BetPlayTable panelTabla) {
		this.panelTabla = panelTabla;
	}
	
	
}
