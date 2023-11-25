package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase TotalBetsWindow representa la ventana de resumen de apuestas totales.
 */
public class TotalBetsWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = -3141464205829962311L;
    /** Etiqueta de fondo para la ventana. */
    private JLabel backg;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Panel que contiene la tabla de resumen de apuestas. */
    private TotalBetsTable panelTabla;

    /**
     * Construye una nueva instancia de la clase {@code TotalBetsWindow}.
     * Inicializa y configura los elementos gráficos presentes en la ventana de resumen de apuestas totales.
     */
	public TotalBetsWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/Reporte4.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new TotalBetsTable();
 
		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1100, 620, 140, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(panelTabla);
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

	public TotalBetsTable getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(TotalBetsTable panelTabla) {
		this.panelTabla = panelTabla;
	}

	
}
