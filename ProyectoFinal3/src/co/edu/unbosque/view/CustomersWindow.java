package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase CustomersWindow representa la ventana de clientes.
 */
public class CustomersWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = -8393258183730465256L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Panel que contiene la tabla de clientes. */
    private CustomersTable panelTabla;

    /**
     * Construye una nueva instancia de la clase CustomersWindow.
     * Configura y coloca los componentes gráficos necesarios para mostrar la información de clientes.
     */
	public CustomersWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/Reporte.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		panelTabla = new CustomersTable();
 
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
	public CustomersTable getPanelTabla() {
		return panelTabla;
	}
	public void setPanelTabla(CustomersTable panelTabla) {
		this.panelTabla = panelTabla;
	}

}
