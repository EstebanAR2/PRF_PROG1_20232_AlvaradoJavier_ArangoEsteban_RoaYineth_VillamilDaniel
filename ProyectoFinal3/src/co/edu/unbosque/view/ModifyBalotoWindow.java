package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



/**
 * La clase ModifyBalotoWindow representa la ventana de modificación para la lotería Baloto.
 */
public class ModifyBalotoWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 434724770829073441L;
    /** Etiqueta para la imagen de fondo. */
    private JLabel backg;
    /** Botón para volver al menú anterior. */
    private JButton back;
    /** Botón para actualizar los datos de Baloto. */
    private JButton update;
    /** Botón para eliminar los datos de Baloto. */
    private JButton delete;
    /** Campo de texto para la ubicación a eliminar. */
    private JTextField locationDelete;
    /** Campo de texto para la ubicación a actualizar. */
    private JTextField locationToUpdate;
    /** Tabla de datos de Baloto. */
    private BalotoTable panelTabla;
    /** Lista desplegable para el primer número de Baloto. */
    private JComboBox<Object> number1;
    /** Lista desplegable para el segundo número de Baloto. */
    private JComboBox<Object> number2;
    /** Lista desplegable para el tercer número de Baloto. */
    private JComboBox<Object> number3;
    /** Lista desplegable para el cuarto número de Baloto. */
    private JComboBox<Object> number4;
    /** Lista desplegable para el quinto número de Baloto. */
    private JComboBox<Object> number5;
    /** Lista desplegable para el sexto número de Baloto. */
    private JComboBox<Object> number6;
    /** Modelo para la lista desplegable del primer número. */
    private DefaultComboBoxModel<Object> model;
    /** Modelo para la lista desplegable del segundo número. */
    private DefaultComboBoxModel<Object> model2;
    /** Modelo para la lista desplegable del tercer número. */
    private DefaultComboBoxModel<Object> model3;
    /** Modelo para la lista desplegable del cuarto número. */
    private DefaultComboBoxModel<Object> model4;
    /** Modelo para la lista desplegable del quinto número. */
    private DefaultComboBoxModel<Object> model5;
    /** Modelo para la lista desplegable del sexto número. */
    private DefaultComboBoxModel<Object> model6;

    /**
     * Construye una nueva instancia de la clase ModifyBalotoWindow.
     * Configura y muestra la ventana de modificación para la lotería Baloto.
     */
	public ModifyBalotoWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/17.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new BalotoTable();
		
		number1 = new JComboBox<Object>();
		model = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model.addElement(String.valueOf(i));
		}
		number1.setModel(model);
		number1.setBounds(780, 460, 60, 40);
		number1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number1.setBackground(Color.YELLOW);
        
		number2 = new JComboBox<Object>();
		model2 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model2.addElement(String.valueOf(i));
		}
		number2.setModel(model2);
		number2.setBounds(850, 460, 60, 40);
		number2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number2.setBackground(Color.YELLOW);
        
		number3 = new JComboBox<Object>();
		model3 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model3.addElement(String.valueOf(i));
		}
		number3.setModel(model3);
		number3.setBounds(920, 460, 60, 40);
		number3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number3.setBackground(Color.YELLOW);
		
		number4 = new JComboBox<Object>();
		model4 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model4.addElement(String.valueOf(i));
		}
		number4.setModel(model4);
		number4.setBounds(990, 460, 60, 40);
		number4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number4.setBackground(Color.YELLOW);
		
		number5 = new JComboBox<Object>();
		model5 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model5.addElement(String.valueOf(i));
		}
		number5.setModel(model5);
		number5.setBounds(1060, 460, 60, 40);
		number5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number5.setBackground(Color.YELLOW);
		
		number6 = new JComboBox<Object>();
		model6 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model6.addElement(String.valueOf(i));
		}
		number6.setModel(model6);
		number6.setBounds(1130, 460, 60, 40);
		number6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number6.setBackground(Color.YELLOW);

		
		locationToUpdate = new JTextField();
		locationToUpdate.setEditable(true);
		locationToUpdate.setBounds(840, 250, 310, 40);
		locationToUpdate.setForeground(Color.WHITE);
		locationToUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationToUpdate.setBorder(null);
		locationToUpdate.setOpaque(false);
		locationToUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		
		locationDelete = new JTextField();
		locationDelete.setEditable(true);
		locationDelete.setBounds(840, 105, 310, 40);
		locationDelete.setForeground(Color.WHITE);
		locationDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationDelete.setBorder(null);
		locationDelete.setOpaque(false);
		locationDelete.setHorizontalAlignment(SwingConstants.CENTER);
		
		delete = new JButton();
		delete.setToolTipText("Click para borrar la apuesta de Baloto en la posicion registrada");
		delete.setBounds(930, 150, 110, 40);
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);

		update = new JButton();
		update.setToolTipText("Click para actualizar la apuesta de Baloto con los datos registrados");
		update.setBounds(870, 620, 250, 40);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(620, 630, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(number1);
		add(number2);
		add(number3);
		add(number4);
		add(number5);
		add(number6);
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
	public BalotoTable getPanelTabla() {
		return panelTabla;
	}
	public void setPanelTabla(BalotoTable panelTabla) {
		this.panelTabla = panelTabla;
	}
	public JComboBox<Object> getNumber1() {
		return number1;
	}
	public void setNumber1(JComboBox<Object> number1) {
		this.number1 = number1;
	}
	public JComboBox<Object> getNumber2() {
		return number2;
	}
	public void setNumber2(JComboBox<Object> number2) {
		this.number2 = number2;
	}
	public JComboBox<Object> getNumber3() {
		return number3;
	}
	public void setNumber3(JComboBox<Object> number3) {
		this.number3 = number3;
	}
	public JComboBox<Object> getNumber4() {
		return number4;
	}
	public void setNumber4(JComboBox<Object> number4) {
		this.number4 = number4;
	}
	public JComboBox<Object> getNumber5() {
		return number5;
	}
	public void setNumber5(JComboBox<Object> number5) {
		this.number5 = number5;
	}
	public JComboBox<Object> getNumber6() {
		return number6;
	}
	public void setNumber6(JComboBox<Object> number6) {
		this.number6 = number6;
	}
	public DefaultComboBoxModel<Object> getModel() {
		return model;
	}
	public void setModel(DefaultComboBoxModel<Object> model) {
		this.model = model;
	}
	public DefaultComboBoxModel<Object> getModel2() {
		return model2;
	}
	public void setModel2(DefaultComboBoxModel<Object> model2) {
		this.model2 = model2;
	}
	public DefaultComboBoxModel<Object> getModel3() {
		return model3;
	}
	public void setModel3(DefaultComboBoxModel<Object> model3) {
		this.model3 = model3;
	}
	public DefaultComboBoxModel<Object> getModel4() {
		return model4;
	}
	public void setModel4(DefaultComboBoxModel<Object> model4) {
		this.model4 = model4;
	}
	public DefaultComboBoxModel<Object> getModel5() {
		return model5;
	}
	public void setModel5(DefaultComboBoxModel<Object> model5) {
		this.model5 = model5;
	}
	public DefaultComboBoxModel<Object> getModel6() {
		return model6;
	}
	public void setModel6(DefaultComboBoxModel<Object> model6) {
		this.model6 = model6;
	}
	

}
