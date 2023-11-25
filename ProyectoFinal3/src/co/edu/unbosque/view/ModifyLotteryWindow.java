package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * La clase ModifyLotteryWindow representa la ventana de modificación para las loterías.
 */
public class ModifyLotteryWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = 2146300726854699242L;
    /** La etiqueta que muestra la imagen de fondo de la ventana. */
    private JLabel backg;
    /** El botón para regresar al menú anterior. */
    private JButton back;
    /** El botón para actualizar la información de la lotería. */
    private JButton update;
    /** El botón para eliminar la información de la lotería. */
    private JButton delete;
    /** El campo de texto para la ubicación de la lotería a eliminar. */
    private JTextField locationDelete;
    /** El campo de texto para el nombre de la lotería a actualizar. */
    private JTextField lotteryToUpdate;
    /** La tabla que muestra la información de las loterías. */
    private LotteryTable panelTabla;
    /** El menú desplegable para seleccionar la serie de la lotería. */
    private JComboBox<Object> serie;
    /** El menú desplegable para seleccionar el nombre de la lotería. */
    private JComboBox<Object> lotteryName;
    /** El spinner para seleccionar el primer número de la lotería. */
    private JSpinner number1;
    /** El spinner para seleccionar el segundo número de la lotería. */
    private JSpinner number2;
    /** El spinner para seleccionar el tercer número de la lotería. */
    private JSpinner number3;
    /** El spinner para seleccionar el cuarto número de la lotería. */
    private JSpinner number4;
    /** El modelo de spinner para el primer número. */
    private SpinnerNumberModel modelo;
    /** El modelo de spinner para el segundo número. */
    private SpinnerNumberModel modelo2;
    /** El modelo de spinner para el tercer número. */
    private SpinnerNumberModel modelo3;
    /** El modelo de spinner para el cuarto número. */
    private SpinnerNumberModel modelo4;

    /**
     * Construye una nueva instancia de la clase ModifyLotteryWindow.
     * Configura y muestra la ventana de modificación para la información de las loterías.
     */
	public ModifyLotteryWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/18.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new LotteryTable();

		lotteryName = new JComboBox<Object>();
		lotteryName.setModel(new DefaultComboBoxModel<Object>(new String[] {"Lotería de Bogotá", "Lotería de Medellín", "Lotería del Valle", "Lotería del Cauca", 
				"Lotería de Boyacá","Lotería de Cundinamarca", "Lotería Cruz Roja"}));
		lotteryName.setBounds(840, 340, 300, 35);
		lotteryName.setBackground(Color.WHITE);
		lotteryName.setForeground(Color.BLACK);
		lotteryName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		modelo = new SpinnerNumberModel(0, 0, 9, 1);
		modelo2 = new SpinnerNumberModel(0, 0, 9, 1);
		modelo3 = new SpinnerNumberModel(0, 0, 9, 1);
		modelo4 = new SpinnerNumberModel(0, 0, 9, 1);
		
		number1 = new JSpinner();
		number1.setModel(modelo);
		number1.setEditor(new JSpinner.NumberEditor(number1, "0"));
		number1.setBounds(790, 430, 60, 40);
		number1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
        JComponent editor = number1.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        
		number2 = new JSpinner();
		number2.setModel(modelo2);
		number2.setEditor(new JSpinner.NumberEditor(number2, "0"));
		number2.setBounds(890, 430, 60, 40);
		number2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
        JComponent editor2 = number2.getEditor();
        if (editor2 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor2;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        
		number3 = new JSpinner();
		number3.setModel(modelo3);
		number3.setEditor(new JSpinner.NumberEditor(number3, "0"));
		number3.setBounds(990, 430, 60, 40);
		number3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
        JComponent editor3 = number3.getEditor();
        if (editor3 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor3;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
		
		number4 = new JSpinner();
		number4.setModel(modelo4);
		number4.setEditor(new JSpinner.NumberEditor(number4, "0"));
		number4.setBounds(1090, 430, 60, 40);
		number4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
        JComponent editor4 = number4.getEditor();
        if (editor4 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor4;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        
		serie = new JComboBox<Object>();
		serie.setModel(new DefaultComboBoxModel<Object>(new String[] {"031", "062", "103", "180", 
				"194","215", "264", "328", "392", "444", "464"}));
		serie.setBounds(940, 540, 80, 35);
		serie.setBackground(Color.WHITE);
		serie.setForeground(Color.BLACK);
		serie.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		
		lotteryToUpdate = new JTextField();
		lotteryToUpdate.setEditable(true);
		lotteryToUpdate.setBounds(840, 250, 310, 40);
		lotteryToUpdate.setForeground(Color.WHITE);
		lotteryToUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lotteryToUpdate.setBorder(null);
		lotteryToUpdate.setOpaque(false);
		lotteryToUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		
		locationDelete = new JTextField();
		locationDelete.setEditable(true);
		locationDelete.setBounds(840, 105, 310, 40);
		locationDelete.setForeground(Color.WHITE);
		locationDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationDelete.setBorder(null);
		locationDelete.setOpaque(false);
		locationDelete.setHorizontalAlignment(SwingConstants.CENTER);
		
		delete = new JButton();
		delete.setToolTipText("Click para borrar la loteria en la posicion registrada");
		delete.setBounds(930, 150, 110, 40);
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);

		update = new JButton();
		update.setToolTipText("Click para actualizar una apuesta de loteria con los datos registrados");
		update.setBounds(870, 620, 250, 40);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(620, 620, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(serie);
		add(lotteryName);
		add(number1);
		add(number2);
		add(number3);
		add(number4);
		add(panelTabla);
		add(locationDelete);
		add(lotteryToUpdate);
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

	public JTextField getLotteryToUpdate() {
		return lotteryToUpdate;
	}

	public void setLotteryToUpdate(JTextField lotteryToUpdate) {
		this.lotteryToUpdate = lotteryToUpdate;
	}

	public LotteryTable getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(LotteryTable panelTabla) {
		this.panelTabla = panelTabla;
	}

	public JComboBox<Object> getSerie() {
		return serie;
	}

	public void setSerie(JComboBox<Object> serie) {
		this.serie = serie;
	}

	public JComboBox<Object> getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(JComboBox<Object> lotteryName) {
		this.lotteryName = lotteryName;
	}

	public JSpinner getNumber1() {
		return number1;
	}

	public void setNumber1(JSpinner number1) {
		this.number1 = number1;
	}

	public JSpinner getNumber2() {
		return number2;
	}

	public void setNumber2(JSpinner number2) {
		this.number2 = number2;
	}

	public JSpinner getNumber3() {
		return number3;
	}

	public void setNumber3(JSpinner number3) {
		this.number3 = number3;
	}

	public JSpinner getNumber4() {
		return number4;
	}

	public void setNumber4(JSpinner number4) {
		this.number4 = number4;
	}

	public SpinnerNumberModel getModelo() {
		return modelo;
	}

	public void setModelo(SpinnerNumberModel modelo) {
		this.modelo = modelo;
	}

	public SpinnerNumberModel getModelo2() {
		return modelo2;
	}

	public void setModelo2(SpinnerNumberModel modelo2) {
		this.modelo2 = modelo2;
	}

	public SpinnerNumberModel getModelo3() {
		return modelo3;
	}

	public void setModelo3(SpinnerNumberModel modelo3) {
		this.modelo3 = modelo3;
	}

	public SpinnerNumberModel getModelo4() {
		return modelo4;
	}

	public void setModelo4(SpinnerNumberModel modelo4) {
		this.modelo4 = modelo4;
	}
	
}
