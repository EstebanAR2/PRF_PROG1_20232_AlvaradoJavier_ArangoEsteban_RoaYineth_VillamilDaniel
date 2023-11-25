package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase BalotoWindow representa la ventana principal del juego Baloto.
 */
public class BalotoWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -769680791092189359L;
	/** La etiqueta de fondo de la ventana. */
    private JLabel backg;
    /** El botón para regresar al menú anterior. */
    private JButton back;
    /** El botón para realizar la apuesta. */
    private JButton stake;
    /** El botón para ver la información del juego. */
    private JButton information;
    /** El primer número seleccionado para la apuesta. */
    private JComboBox<Object> number1;
    /** El segundo número seleccionado para la apuesta. */
    private JComboBox<Object> number2;
    /** El tercer número seleccionado para la apuesta. */
    private JComboBox<Object> number3;
    /** El cuarto número seleccionado para la apuesta. */
    private JComboBox<Object> number4;
    /** El quinto número seleccionado para la apuesta. */
    private JComboBox<Object> number5;
    /** El sexto número seleccionado para la apuesta. */
    private JComboBox<Object> number6;
    /** El modelo para el primer número. */
    private DefaultComboBoxModel<Object> model;
    /** El modelo para el segundo número. */
    private DefaultComboBoxModel<Object> model2;
    /** El modelo para el tercer número. */
    private DefaultComboBoxModel<Object> model3;
    /** El modelo para el cuarto número. */
    private DefaultComboBoxModel<Object> model4;
    /** El modelo para el quinto número. */
    private DefaultComboBoxModel<Object> model5;
    /** El modelo para el sexto número. */
    private DefaultComboBoxModel<Object> model6;
	
    /**
     * Construye una nueva instancia de la clase BalotoWindow.
     * Configura y coloca los componentes gráficos necesarios para la ventana principal del juego Baloto.
     */
	public BalotoWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/11.png"));
		backg.setBounds(0, -30, 1280, 720);
		
		number1 = new JComboBox<Object>();
		model = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model.addElement(String.valueOf(i));
		}
		number1.setModel(model);
		number1.setBounds(200, 400, 60, 40);
		number1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number1.setBackground(Color.YELLOW);
        
		number2 = new JComboBox<Object>();
		model2 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model2.addElement(String.valueOf(i));
		}
		number2.setModel(model2);
		number2.setBounds(390, 400, 60, 40);
		number2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number2.setBackground(Color.YELLOW);
        
		number3 = new JComboBox<Object>();
		model3 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model3.addElement(String.valueOf(i));
		}
		number3.setModel(model3);
		number3.setBounds(550, 400, 60, 40);
		number3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number3.setBackground(Color.YELLOW);
		
		number4 = new JComboBox<Object>();
		model4 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model4.addElement(String.valueOf(i));
		}
		number4.setModel(model4);
		number4.setBounds(700, 400, 60, 40);
		number4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number4.setBackground(Color.YELLOW);
		
		number5 = new JComboBox<Object>();
		model5 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model5.addElement(String.valueOf(i));
		}
		number5.setModel(model5);
		number5.setBounds(850, 400, 60, 40);
		number5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number5.setBackground(Color.YELLOW);
		
		number6 = new JComboBox<Object>();
		model6 = new DefaultComboBoxModel<>();
		for (int i = 1; i <= 45; i++) {
		    model6.addElement(String.valueOf(i));
		}
		number6.setModel(model6);
		number6.setBounds(1000, 400, 60, 40);
		number6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number6.setBackground(Color.YELLOW);
        
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
		add(number5);
		add(number6);
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
