package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * La clase ShopParametersWindow representa la ventana de parámetros de la tienda de apuestas.
 */
public class ShopParametersWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = 6466564678738825201L;
    /** La etiqueta que muestra la imagen de fondo de la ventana. */
    private JLabel backg;
    /** El botón para volver al menú anterior. */
    private JButton back;
    /** El botón para actualizar los parámetros de la tienda. */
    private JButton update;
    /** El botón para crear una nueva sucursal. */
    private JButton createBranch;
    /** El botón para acceder a las opciones de sucursal. */
    private JButton branchOptions;
    /** El botón para acceder a la configuración de parámetros de juego. */
    private JButton gameParameters;
    /** El campo de texto para ingresar el nombre de la tienda. */
    private JTextField shopName;
    /** El campo de texto para ingresar el nombre de la sucursal. */
    private JTextField branch;
    /** El campo de texto para ingresar el presupuesto de la tienda. */
    private JTextField budget;
	
    /**
     * Construye una nueva instancia de la clase ShopParametersWindow.
     * Configura y muestra la ventana de parámetros de la casa de apuestas.
     */
	public ShopParametersWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/14.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		shopName = new JTextField();
		shopName.setEditable(true);
		shopName.setBounds(75, 300, 345, 45);
		shopName.setForeground(Color.WHITE);
		shopName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		shopName.setBorder(null);
		shopName.setOpaque(false);
		shopName.setHorizontalAlignment(SwingConstants.CENTER);
		
		branch = new JTextField();
		branch.setEditable(true);
		branch.setBounds(75, 400, 345, 45);
		branch.setForeground(Color.WHITE);
		branch.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		branch.setBorder(null);
		branch.setOpaque(false);
		branch.setHorizontalAlignment(SwingConstants.CENTER);
		
		budget = new JTextField();
		budget.setEditable(true);
		budget.setBounds(75, 490, 345, 45);
		budget.setForeground(Color.WHITE);
		budget.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		budget.setBorder(null);
		budget.setOpaque(false);
		budget.setHorizontalAlignment(SwingConstants.CENTER);
		
		branchOptions = new JButton();
		branchOptions.setToolTipText("Ver sedes actuales, modificarlas o borrarlas");
		branchOptions.setBounds(495, 345, 320, 45);
		branchOptions.setOpaque(false);
		branchOptions.setContentAreaFilled(false);
		branchOptions.setBorderPainted(false);
		
		createBranch = new JButton();
		createBranch.setToolTipText("Ingresar a la creación de sedes");
		createBranch.setBounds(495, 250, 320, 45);
		createBranch.setOpaque(false);
		createBranch.setContentAreaFilled(false);
		createBranch.setBorderPainted(false);
		
		gameParameters = new JButton();
		gameParameters.setToolTipText("Para ver y/o modificar los parametros de los juegos manejados");
		gameParameters.setBounds(875, 280, 340, 55);
		gameParameters.setOpaque(false);
		gameParameters.setContentAreaFilled(false);
		gameParameters.setBorderPainted(false);

		update = new JButton();
		update.setToolTipText("Actualizar parametros de la casa de apuestas");
		update.setBounds(150, 610, 200, 60);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(580, 600, 140, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(gameParameters);
		add(shopName);
		add(branch);
		add(budget);
		add(branchOptions);
		add(createBranch);
		add(update);
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


	public JButton getUpdate() {
		return update;
	}


	public void setUpdate(JButton update) {
		this.update = update;
	}


	public JTextField getShopName() {
		return shopName;
	}


	public void setShopName(JTextField shopName) {
		this.shopName = shopName;
	}

	public JTextField getBranch() {
		return branch;
	}


	public void setBranch(JTextField branch) {
		this.branch = branch;
	}


	public JTextField getBudget() {
		return budget;
	}


	public void setBudget(JTextField budget) {
		this.budget = budget;
	}


	public JButton getCreateBranch() {
		return createBranch;
	}


	public void setCreateBranch(JButton createBranch) {
		this.createBranch = createBranch;
	}


	public JButton getBranchOptions() {
		return branchOptions;
	}


	public void setBranchOptions(JButton branchOptions) {
		this.branchOptions = branchOptions;
	}

	public JButton getGameParameters() {
		return gameParameters;
	}


	public void setGameParameters(JButton gameParameters) {
		this.gameParameters = gameParameters;
	}
	
}
