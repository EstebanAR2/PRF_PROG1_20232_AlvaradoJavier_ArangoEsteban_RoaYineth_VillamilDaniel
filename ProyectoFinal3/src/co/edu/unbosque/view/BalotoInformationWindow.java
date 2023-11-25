package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase BalotoInformationWindow representa una ventana de información sobre el juego Baloto.
 */
public class BalotoInformationWindow extends JFrame{
	
	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -9020334240802726858L;
    /** El fondo de la ventana de información de Baloto. */
    private JLabel backg;
	
    /**
     * Construye una nueva instancia de la clase BalotoInformationWindow.
     * Configura y coloca los componentes gráficos en la ventana de información de Baloto.
     */
	public BalotoInformationWindow() {
		setBounds(0, 0, 560, 583);
		setResizable(false);
		setTitle("Información sobre Baloto");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/3info.png"));
		backg.setBounds(-10, -20, 560, 583);
		
		add(backg);
	}
	
}
