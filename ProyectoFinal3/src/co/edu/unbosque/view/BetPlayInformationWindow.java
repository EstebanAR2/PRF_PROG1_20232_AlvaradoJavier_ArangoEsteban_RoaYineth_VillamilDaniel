package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase BetPlayInformationWindow representa una ventana que muestra información sobre BetPlay.
 */
public class BetPlayInformationWindow extends JFrame {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 2406265566177037365L;
    /** La iamgen de fondo de la ventana. */
    private JLabel backg;

    /**
     * Construye una nueva instancia de la clase BetPlayInformationWindow.
     * Configura y coloca los componentes gráficos necesarios para la ventana de información sobre BetPlay.
     */
	public BetPlayInformationWindow() {
		setBounds(0, 0, 560, 583);
		setResizable(false);
		setTitle("Información sobre BetPlay");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/4info.png"));
		backg.setBounds(-10, -20, 560, 583);
		
		add(backg);
	}
}
