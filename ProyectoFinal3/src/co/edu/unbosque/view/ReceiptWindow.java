package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * La clase ReceiptWindow representa la ventana de recibo que muestra la información de una apuesta.
 */
public class ReceiptWindow extends JFrame{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = 5453165584751636416L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** El campo de texto para mostrar la sede. */
    private JTextField sede;
    /** El campo de texto para mostrar la cédula del jugador. */
    private JTextField cedula;
    /** El campo de texto para mostrar el día de la apuesta. */
    private JTextField day;
    /** El campo de texto para mostrar el valor de la apuesta. */
    private JTextField betValue;
    /** El área de texto para mostrar los detalles de la apuesta. */
    private JTextArea details;
	
    /**
     * Construye una nueva instancia de la clase ReceiptWindow.
     * Configura y muestra la ventana de recibo para mostrar la información de una apuesta.
     */
	public ReceiptWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 432, 1080);
		setResizable(false);
		setTitle("Recibo de la apuesta");
		setLayout(null);
		
		sede = new JTextField();
		sede.setEditable(false);
		sede.setBounds(190, 155, 200, 40);
		sede.setForeground(Color.BLACK);
		sede.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		sede.setBorder(null);
		sede.setOpaque(false);
		
		cedula = new JTextField();
		cedula.setEditable(false);
		cedula.setBounds(190, 225, 200, 40);
		cedula.setForeground(Color.BLACK);
		cedula.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		cedula.setBorder(null);
		cedula.setOpaque(false);
		
		day = new JTextField();
		day.setEditable(false);
		day.setBounds(190, 295, 200, 40);
		day.setForeground(Color.BLACK);
		day.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		day.setBorder(null);
		day.setOpaque(false);
		
		betValue = new JTextField();
		betValue.setEditable(false);
		betValue.setBounds(190, 375, 200, 40);
		betValue.setForeground(Color.BLACK);
		betValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		betValue.setBorder(null);
		betValue.setOpaque(false);
		
		details = new JTextArea();
		details.setEditable(false);
		details.setBounds(40, 520, 360, 335);
		details.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		details.setForeground(Color.BLACK);
		details.setBorder(null);
		details.setOpaque(false);
		details.setLineWrap(true);
		details.setWrapStyleWord(true);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/ReciboProyF1.png"));
		backg.setBounds(0, -20, 432, 1080);
		
		add(sede);
		add(cedula);
		add(day);
		add(betValue);
		add(details);
		add(backg);
		
	}

	public JLabel getBackg() {
		return backg;
	}

	public void setBackg(JLabel backg) {
		this.backg = backg;
	}

	public JTextField getSede() {
		return sede;
	}

	public void setSede(JTextField sede) {
		this.sede = sede;
	}

	public JTextField getCedula() {
		return cedula;
	}

	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public JTextField getDay() {
		return day;
	}

	public void setDay(JTextField day) {
		this.day = day;
	}

	public JTextField getBetValue() {
		return betValue;
	}

	public void setBetValue(JTextField betValue) {
		this.betValue = betValue;
	}

	public JTextArea getDetails() {
		return details;
	}

	public void setDetails(JTextArea details) {
		this.details = details;
	}
	
	
}
