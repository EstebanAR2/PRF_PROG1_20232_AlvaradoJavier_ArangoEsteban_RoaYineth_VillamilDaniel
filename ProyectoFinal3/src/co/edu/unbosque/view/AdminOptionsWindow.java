package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase AdminOptionsWindow representa la ventana de opciones para el administrador.

 */
public class AdminOptionsWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = 1349567592377461117L;
    /** El fondo de la ventana de opciones del administrador. */
    private JLabel backg;
    /** El botón para modificar los parámetros de la casa de apuestas. */
    private JButton modifyPara;
    /** El botón para ver la lista de clientes en cada sede. */
    private JButton listClients;
    /** El botón para ver las apuestas realizadas por cada cliente. */
    private JButton betsClient;
    /** El botón para ver las apuestas realizadas por cliente y sede. */
    private JButton betsClientHeadquarters;
    /** El botón para ver el total de apuestas realizadas por cliente. */
    private JButton totalBets;
    /** El botón para editar el perfil del administrador. */
    private JButton edit;
    /** El botón para modificar o borrar apuestas en algún juego. */
    private JButton modifyGame;
    /** El botón de retroceso. */
    private JButton back;
	
    /**
     * Construye una nueva instancia de la clase AdminOptionsWindow.
     * Configura y coloca los componentes gráficos en la ventana de opciones del administrador.
     */
	public AdminOptionsWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/7.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		modifyPara = new JButton();
		modifyPara.setToolTipText("Haga click para ver y/o modificar los parametros de la casa de apuestas");
		modifyPara.setBounds(90, 257, 545, 42);
		modifyPara.setOpaque(false);
		modifyPara.setContentAreaFilled(false);
		modifyPara.setBorderPainted(false);
		
		modifyGame = new JButton();
		modifyGame.setToolTipText("Haga click para modificar o borrar apuestas en algún juego");
		modifyGame.setBounds(105, 455, 545, 42);
		modifyGame.setOpaque(false);
		modifyGame.setContentAreaFilled(false);
		modifyGame.setBorderPainted(false);
		
		listClients = new JButton();
		listClients.setToolTipText("Haga click para ver la lista de clientes que hay en cada sede");
		listClients.setBounds(685, 255, 550, 40);
		listClients.setOpaque(false);
		listClients.setContentAreaFilled(false);
		listClients.setBorderPainted(false);
		
		betsClient = new JButton();
		betsClient.setToolTipText("Haga click para ver lo apostado por cada cliente");
		betsClient.setBounds(685, 330, 550, 40);
		betsClient.setOpaque(false);
		betsClient.setContentAreaFilled(false);
		betsClient.setBorderPainted(false);
		
		betsClientHeadquarters = new JButton();
		betsClientHeadquarters.setToolTipText("Haga click para las apuestas de cliente por sede");
		betsClientHeadquarters.setBounds(685, 410, 550, 40);
		betsClientHeadquarters.setOpaque(false);
		betsClientHeadquarters.setContentAreaFilled(false);
		betsClientHeadquarters.setBorderPainted(false);
		
		totalBets = new JButton();
		totalBets.setToolTipText("Haga click para las apuestas de cliente por sede");
		totalBets.setBounds(685, 490, 550, 40);
		totalBets.setOpaque(false);
		totalBets.setContentAreaFilled(false);
		totalBets.setBorderPainted(false);
		
		edit = new JButton();
		edit.setToolTipText("Haga click para editar su perfil");
		edit.setBounds(990, 25, 130, 110);
		edit.setOpaque(false);
		edit.setContentAreaFilled(false);
		edit.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Cerrar la sesion y volver al menu inicial");
		back.setBounds(560, 610, 160, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(edit);
		add(totalBets);
		add(betsClientHeadquarters);
		add(listClients);
		add(betsClient);
		add(modifyPara);
		add(modifyGame);
		add(back);
		add(backg);
	}
	
    /**
     * Obtiene el fondo de la ventana de opciones del administrador.
     * @return El componente JLabel que representa el fondo.
     */
    public JLabel getBackg() {
        return backg;
    }

    /**
     * Establece el fondo de la ventana de opciones del administrador.
     * @param backg El nuevo fondo representado por un componente JLabel.
     */
    public void setBackg(JLabel backg) {
        this.backg = backg;
    }

    /**
     * Obtiene el botón de retroceso.
     * @return El componente JButton que representa el botón de retroceso.
     */
    public JButton getBack() {
        return back;
    }

    /**
     * Establece el botón de retroceso.
     * @param back El nuevo botón de retroceso representado por un componente JButton.
     */
    public void setBack(JButton back) {
        this.back = back;
    }

    /**
     * Obtiene el botón para modificar los parámetros de la casa de apuestas.
     * @return El componente JButton que representa el botón de modificar parámetros.
     */
    public JButton getModifyPara() {
        return modifyPara;
    }

    /**
     * Establece el botón para modificar los parámetros de la casa de apuestas.
     * @param modifyPara El nuevo botón de modificar parámetros representado por un componente JButton.
     */
    public void setModifyPara(JButton modifyPara) {
        this.modifyPara = modifyPara;
    }

    /**
     * Obtiene el botón para ver la lista de clientes en cada sede.
     * @return El componente JButton que representa el botón de ver lista de clientes.
     */
    public JButton getListClients() {
        return listClients;
    }

    /**
     * Establece el botón para ver la lista de clientes en cada sede.
     * @param listClients El nuevo botón de ver lista de clientes representado por un componente JButton.
     */
    public void setListClients(JButton listClients) {
        this.listClients = listClients;
    }

    /**
     * Obtiene el botón para ver las apuestas realizadas por cada cliente.
     * @return El componente JButton que representa el botón de ver apuestas de clientes.
     */
    public JButton getBetsClient() {
        return betsClient;
    }

    /**
     * Establece el botón para ver las apuestas realizadas por cada cliente.
     * @param betsClient El nuevo botón de ver apuestas de clientes representado por un componente JButton.
     */
    public void setBetsClient(JButton betsClient) {
        this.betsClient = betsClient;
    }

    /**
     * Obtiene el botón para ver las apuestas realizadas por cliente y sede.
     * @return El componente JButton que representa el botón de ver apuestas de clientes por sede.
     */
    public JButton getBetsClientHeadquarters() {
        return betsClientHeadquarters;
    }

    /**
     * Establece el botón para ver las apuestas realizadas por cliente y sede.
     * @param betsClientHeadquarters El nuevo botón de ver apuestas de clientes por sede representado por un componente JButton.
     */
    public void setBetsClientHeadquarters(JButton betsClientHeadquarters) {
        this.betsClientHeadquarters = betsClientHeadquarters;
    }

    /**
     * Obtiene el botón para ver el total de apuestas realizadas por cliente.
     * @return El componente JButton que representa el botón de ver total de apuestas.
     */
    public JButton getTotalBets() {
        return totalBets;
    }

    /**
     * Establece el botón para ver el total de apuestas realizadas por cliente.
     * @param totalBets El nuevo botón de ver total de apuestas representado por un componente JButton.
     */
    public void setTotalBets(JButton totalBets) {
        this.totalBets = totalBets;
    }

    /**
     * Obtiene el botón para editar el perfil del administrador.
     * @return El componente JButton que representa el botón de editar perfil.
     */
    public JButton getEdit() {
        return edit;
    }

    /**
     * Establece el botón para editar el perfil del administrador.
     * @param edit El nuevo botón de editar perfil representado por un componente JButton.
     */
    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    /**
     * Obtiene el botón para modificar o borrar apuestas en algún juego.
     * @return El componente JButton que representa el botón de modificar/borrar apuestas en juego.
     */
    public JButton getModifyGame() {
        return modifyGame;
    }

    /**
     * Establece el botón para modificar o borrar apuestas en algún juego.
     * @param modifyGame El nuevo botón de modificar/borrar apuestas en juego representado por un componente JButton.
     */
    public void setModifyGame(JButton modifyGame) {
        this.modifyGame = modifyGame;
    }
}
