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
import javax.swing.SpinnerNumberModel;

/**
 * La clase LoteriaWindow representa la ventana de la lotería.
 */
public class LoteriaWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 6667314888818902559L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Botón para realizar una apuesta. */
    private JButton stake;
    /** Botón para obtener información del juego. */
    private JButton information;
    /** Cuadro  para seleccionar la serie de la lotería. */
    private JComboBox<Object> serie;
    /** Cuadro para seleccionar el nombre de la lotería. */
    private JComboBox<Object> lotteryName;
    /** Campos de números para la apuesta. */
    private JSpinner number1, number2, number3, number4;
    /** Modelos de spinner para los campos de números. */
    private SpinnerNumberModel modelo, modelo2, modelo3, modelo4;

    /**
     * Construye una nueva instancia de la clase LoteriaWindow.
     * Configura y coloca los componentes gráficos necesarios para realizar apuestas, obtener información y regresar al menú anterior.
     */
	public LoteriaWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/9.png"));
		backg.setBounds(0, -30, 1280, 720);
		
		lotteryName = new JComboBox<Object>();
		lotteryName.setModel(new DefaultComboBoxModel<Object>(new String[] {"Lotería de Bogotá", "Lotería de Medellín", "Lotería del Valle", "Lotería del Cauca", 
				"Lotería de Boyacá","Lotería de Cundinamarca", "Lotería Cruz Roja"}));
		lotteryName.setBounds(515, 230, 300, 35);
		lotteryName.setBackground(Color.BLACK);
		lotteryName.setForeground(Color.WHITE);
		lotteryName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lotteryName.setBorder(null);
		lotteryName.setOpaque(false);
		
		serie = new JComboBox<Object>();
		serie.setModel(new DefaultComboBoxModel<Object>(new String[] {"031", "062", "103", "180", 
				"194","215", "264", "328", "392", "444", "464"}));
		serie.setBounds(755, 510, 80, 35);
		serie.setBackground(Color.BLACK);
		serie.setForeground(Color.WHITE);
		serie.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		serie.setBorder(null);
		serie.setOpaque(false);
		
		modelo = new SpinnerNumberModel(0, 0, 9, 1);
		modelo2 = new SpinnerNumberModel(0, 0, 9, 1);
		modelo3 = new SpinnerNumberModel(0, 0, 9, 1);
		modelo4 = new SpinnerNumberModel(0, 0, 9, 1);
		
		number1 = new JSpinner();
		number1.setModel(modelo);
		number1.setEditor(new JSpinner.NumberEditor(number1, "0"));
		number1.setBounds(200, 400, 60, 40);
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
		number2.setBounds(500, 400, 60, 40);
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
		number3.setBounds(780, 400, 60, 40);
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
		number4.setBounds(1060, 400, 60, 40);
		number4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
        JComponent editor4 = number4.getEditor();
        if (editor4 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor4;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        
		information = new JButton();
		information.setToolTipText("Click aqui para ver la información del juego");
		information.setBounds(750, 90, 310, 60);
		information.setOpaque(false);
		information.setContentAreaFilled(false);
		information.setBorderPainted(false);
		
		stake = new JButton();
		stake.setToolTipText("Click aqui para realizar su apuesta");
		stake.setBounds(505, 610, 280, 60);
		stake.setOpaque(false);
		stake.setContentAreaFilled(false);
		stake.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1040, 610, 150, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		
		add(number1);
		add(number2);
		add(number3);
		add(number4);
		add(serie);
		add(lotteryName);
		add(information);
		add(stake);
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


	public JButton getStake() {
		return stake;
	}


	public void setStake(JButton stake) {
		this.stake = stake;
	}


	public JButton getInformation() {
		return information;
	}


	public void setInformation(JButton information) {
		this.information = information;
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
