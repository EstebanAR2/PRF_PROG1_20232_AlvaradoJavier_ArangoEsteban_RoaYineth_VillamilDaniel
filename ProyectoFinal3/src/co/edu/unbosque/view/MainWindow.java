package co.edu.unbosque.view;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase MainWindow representa la ventana principal de la aplicación de la casa de apuestas.
 */
public class MainWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 5363057796942130370L;
    /** Imagen de fondo. */
    private JLabel backg;
    /** Botón para acceder como administrador. */
    private JButton administrador;
    /** Botón para acceder como cliente. */
    private JButton cliente;

    /**
     * Construye una nueva instancia de la clase MainWindow.
     * Configura y muestra la ventana principal con botones para acceder como administrador o cliente.
     */
	public MainWindow() {	
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		backg = new JLabel(new ImageIcon("src/Imagenes/MainWindow.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		administrador = new JButton();
		administrador.setToolTipText("Para ingresar como administrador");
		administrador.setOpaque(false);
		administrador.setContentAreaFilled(false);
		administrador.setBorderPainted(false);
		administrador.setBounds(310, 260, 665, 140);
		
		cliente = new JButton();
		cliente.setToolTipText("Para ingresar como apostador");
		cliente.setOpaque(false);
		cliente.setContentAreaFilled(false);
		cliente.setBorderPainted(false);
		cliente.setBounds(380, 470, 530, 130);

		add(administrador);
		add(cliente);
		add(backg);
	}

	public JLabel getBackg() {
		return backg;
	}

	public void setBackg(JLabel backg) {
		this.backg = backg;
	}

	public JButton getAdministrador() {
		return administrador;
	}

	public void setAdministrador(JButton administrador) {
		this.administrador = administrador;
	}

	public JButton getCliente() {
		return cliente;
	}

	public void setCliente(JButton cliente) {
		this.cliente = cliente;
	}
	
	
}
