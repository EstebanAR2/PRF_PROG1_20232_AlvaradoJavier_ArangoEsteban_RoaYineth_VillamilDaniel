package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase SuperAstroInformationWindow representa la ventana de información sobre el juego SuperAstro.
 */
public class SuperAstroInformationWindow extends JFrame{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -4112522307698509656L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
	
    /**
     * Construye una nueva instancia de la clase SuperAstroInformationWindow.
     * Configura y muestra la ventana de información sobre el juego SuperAstro.
     */
	public SuperAstroInformationWindow() {
		setBounds(0, 0, 560, 583);
		setResizable(false);
		setTitle("Información sobre Super Astro");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/2info.png"));
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
