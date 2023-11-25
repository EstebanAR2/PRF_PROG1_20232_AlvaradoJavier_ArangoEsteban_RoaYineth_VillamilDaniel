package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase ChanceInformationWindow es una ventana que muestra información sobre el juego "Chance".
 */
public class ChanceInformationWindow extends JFrame {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 92158174554353853L;
    /** Imagen de fondo que muestra la información. */
    private JLabel backg;

    /**
     * Construye una nueva instancia de la clase ChanceInformationWindow.
     * Configura y coloca los componentes gráficos necesarios para mostrar información sobre el juego "Chance".
     */
	public ChanceInformationWindow() {
		setBounds(0, 0, 560, 583);
		setResizable(false);
		setTitle("Información sobre Chance");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/5info.png"));
		backg.setBounds(-10, -20, 560, 583);
		
		add(backg);
	}
}
