package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase LotteryInformationWindow representa la ventana de información sobre la lotería.
 */
public class LotteryInformationWindow extends JFrame {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 4842434692419938345L;
    /** Imagen de fondo de la ventana de información sobre la lotería. */
    private JLabel backg;

    /**
     * Construye una nueva instancia de la clase LotteryInformationWindow.
     * Configura y muestra una ventana de información sobre la lotería con una imagen de fondo.
     */
	public LotteryInformationWindow() {
		setBounds(0, 0, 560, 583);
		setResizable(false);
		setTitle("Información sobre la loteria");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/1.png"));
		backg.setBounds(-10, -20, 560, 583);
		
		add(backg);
	}

	public JLabel getBackg() {
		return backg;
	}

	public void setBackg(JLabel backg) {
		this.backg = backg;
	}
	
}
