package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * La clase BetDetailsWindow representa una ventana que muestra los detalles de las apuestas.
 */
public class BetDetailsWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = -360735570691765585L;
    /** La etiqueta de fondo de la ventana. */
    private JLabel backg;
    /** El área de texto que muestra los detalles de las apuestas realizadas. */
    private JTextArea details;
    /** El botón para volver al menú anterior. */
    private JButton back;
    /** El panel de desplazamiento para el área de texto. */
    private JScrollPane scrollPane;

    /**
     * Construye una nueva instancia de la clase BetDetailsWindow.
     * Configura y coloca los componentes gráficos necesarios para la ventana de detalles de la apuesta.
     */
	public BetDetailsWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/Reporte3.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		details = new JTextArea();
		details.setEditable(false);
		details.setBounds(370, 150, 600, 430);
		details.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		details.setForeground(Color.WHITE);
		details.setBorder(null);
		details.setOpaque(false);
        details.setLineWrap(true);
        details.setWrapStyleWord(true);

        scrollPane = new JScrollPane(details);
        scrollPane.setBounds(370, 150, 600, 430);
        scrollPane.setViewportView(details);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
 
		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1100, 620, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(scrollPane);
		add(back);
		add(backg);
	}

	public JLabel getBackg() {
		return backg;
	}

	public void setBackg(JLabel backg) {
		this.backg = backg;
	}

	public JTextArea getDetails() {
		return details;
	}

	public void setDetails(JTextArea details) {
		this.details = details;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	
}
