package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase ValueBetsCustomersWindow representa la ventana de apuestas de valor para los clientes.
 */
public class ValueBetsCustomersWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = -933571967966019849L;
    /** Imagen de fondo para la ventana. */
    private JLabel backg;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Panel de tabla para mostrar información sobre las apuestas de valor. */
    private BetsCustomersTable panelTabla;

    /**
     * Construye una nueva instancia de la clase ValueBetsCustomersWindow.
     * Inicializa y configura los elementos gráficos presentes en la ventana de apuestas de valor para los clientes.
     */
	public ValueBetsCustomersWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/Reporte2.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new BetsCustomersTable();
 
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

	public BetsCustomersTable getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(BetsCustomersTable panelTabla) {
		this.panelTabla = panelTabla;
	}
	
	
}
