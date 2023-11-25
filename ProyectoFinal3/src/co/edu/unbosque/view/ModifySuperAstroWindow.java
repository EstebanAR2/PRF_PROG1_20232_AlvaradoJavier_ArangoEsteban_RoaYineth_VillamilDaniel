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
 * La clase ModifySuperAstroWindow representa la ventana de modificación para el juego SuperAstro.
 */
public class ModifySuperAstroWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -13151330271719918L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** El botón para regresar al menú anterior. */
    private JButton back;
    /** El botón para actualizar la información de SuperAstro. */
    private JButton update;
    /** El botón para eliminar la información de SuperAstro. */
    private JButton delete;
    /** El campo de texto para la ubicación de SuperAstro a eliminar. */
    private JTextField locationDelete;
    /** El campo de texto para la ubicación de SuperAstro a actualizar. */
    private JTextField locationToUpdate;
    /** La tabla que muestra la información de los sorteos de SuperAstro. */
    private SuperAstroTable panelTabla;
    /** El campo de texto para la apuesta en SuperAstro. */
    private JTextField betValue;
    /** El menú desplegable para seleccionar el signo zodiacal en SuperAstro. */
    private JComboBox<Object> signo;
    /** El spinner para seleccionar el primer número en SuperAstro. */
    private JSpinner number1;
    /** El spinner para seleccionar el segundo número en SuperAstro. */
    private JSpinner number2;
    /** El spinner para seleccionar el tercer número en SuperAstro. */
    private JSpinner number3;
    /** El spinner para seleccionar el cuarto número en SuperAstro. */
    private JSpinner number4;
    /** El modelo de spinner para el primer número en SuperAstro. */
    private SpinnerNumberModel modelo;
    /** El modelo de spinner para el segundo número en SuperAstro. */
    private SpinnerNumberModel modelo2;
    /** El modelo de spinner para el tercer número en SuperAstro. */
    private SpinnerNumberModel modelo3;
    /** El modelo de spinner para el cuarto número en SuperAstro. */
    private SpinnerNumberModel modelo4;

    /**
     * Construye una nueva instancia de la clase ModifySuperAstroWindow.
     * Configura y muestra la ventana de modificación para la información de los sorteos de Super Astro.
     */
	public ModifySuperAstroWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/20.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new SuperAstroTable();
		
		modelo = new SpinnerNumberModel(0, 0, 9, 1);
		modelo2 = new SpinnerNumberModel(0, 0, 9, 1);
		modelo3 = new SpinnerNumberModel(0, 0, 9, 1);
		modelo4 = new SpinnerNumberModel(0, 0, 9, 1);
		
		number1 = new JSpinner();
		number1.setModel(modelo);
		number1.setEditor(new JSpinner.NumberEditor(number1, "0"));
		number1.setBounds(790, 470, 60, 40);
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
		number2.setBounds(890, 470, 60, 40);
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
		number3.setBounds(990, 470, 60, 40);
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
		number4.setBounds(1090, 470, 60, 40);
		number4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
        JComponent editor4 = number4.getEditor();
        if (editor4 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor4;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        
		signo = new JComboBox<Object>();
		signo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Aries", "Tauro", "Geminis", "Cancer", 
				"Leo","Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		signo.setBounds(850, 560, 300, 35);
		signo.setBackground(Color.WHITE);
		signo.setForeground(Color.BLACK);
		signo.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		
		locationToUpdate = new JTextField();
		locationToUpdate.setEditable(true);
		locationToUpdate.setBounds(840, 250, 310, 40);
		locationToUpdate.setForeground(Color.WHITE);
		locationToUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationToUpdate.setBorder(null);
		locationToUpdate.setOpaque(false);
		locationToUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		
		betValue = new JTextField();
		betValue.setEditable(true);
		betValue.setBounds(840, 385, 310, 40);
		betValue.setForeground(Color.WHITE);
		betValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		betValue.setBorder(null);
		betValue.setOpaque(false);
		betValue.setHorizontalAlignment(SwingConstants.CENTER);
		
		locationDelete = new JTextField();
		locationDelete.setEditable(true);
		locationDelete.setBounds(840, 105, 310, 40);
		locationDelete.setForeground(Color.WHITE);
		locationDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		locationDelete.setBorder(null);
		locationDelete.setOpaque(false);
		locationDelete.setHorizontalAlignment(SwingConstants.CENTER);
		
		delete = new JButton();
		delete.setToolTipText("Click para borrar la apuesta de Super Astro en la posicion registrada");
		delete.setBounds(930, 150, 110, 40);
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);

		update = new JButton();
		update.setToolTipText("Click para actualizar la apuesta de Super Astro con los datos registrados");
		update.setBounds(870, 630, 250, 40);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(620, 630, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(betValue);
		add(signo);
		add(number1);
		add(number2);
		add(number3);
		add(number4);
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

	public SuperAstroTable getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(SuperAstroTable panelTabla) {
		this.panelTabla = panelTabla;
	}

	public JTextField getBetValue() {
		return betValue;
	}

	public void setBetValue(JTextField betValue) {
		this.betValue = betValue;
	}

	public JComboBox<Object> getSigno() {
		return signo;
	}

	public void setSigno(JComboBox<Object> signo) {
		this.signo = signo;
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
