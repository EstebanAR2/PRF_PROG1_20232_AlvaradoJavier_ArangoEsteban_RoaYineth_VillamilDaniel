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
 * La clase GameModWindow representa la ventana de modificación de parámetros de juego.
 */
public class GameModWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = -3417662794923592073L;
    /** Imagen de fondo de la ventana. */
    private JLabel backg;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Botón para actualizar los parámetros de los juegos. */
    private JButton update;
    /** Campos de texto para el primer juego. */
    private JTextField game1, type1, budget1;
    /** Campos de texto para el segundo juego. */
    private JTextField game2, type2, budget2;
    /** Campos de texto para el tercer juego. */
    private JTextField game3, type3, budget3;
    /** Campos de texto para el cuarto juego. */
    private JTextField game4, type4, budget4;
    /** Campos de texto para el quinto juego. */
    private JTextField game5, type5, budget5;

    /**
     * Construye una nueva instancia de la clase GameModWindow.
     * Configura y coloca los componentes gráficos necesarios para modificar los parámetros de juego.
     */
	public GameModWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/16.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		game1 = new JTextField();
		game1.setEditable(true);
		game1.setBounds(180, 245, 235, 45);
		game1.setForeground(Color.WHITE);
		game1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		game1.setBorder(null);
		game1.setOpaque(false);
		game1.setHorizontalAlignment(SwingConstants.CENTER);
		
		type1 = new JTextField();
		type1.setEditable(true);
		type1.setBounds(180, 329, 235, 45);
		type1.setForeground(Color.WHITE);
		type1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		type1.setBorder(null);
		type1.setOpaque(false);
		type1.setHorizontalAlignment(SwingConstants.CENTER);
		
		budget1 = new JTextField();
		budget1.setEditable(true);
		budget1.setBounds(180, 405, 235, 45);
		budget1.setForeground(Color.WHITE);
		budget1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		budget1.setBorder(null);
		budget1.setOpaque(false);
		budget1.setHorizontalAlignment(SwingConstants.CENTER);
		
		game2 = new JTextField();
		game2.setEditable(true);
		game2.setBounds(590, 95, 235, 45);
		game2.setForeground(Color.WHITE);
		game2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		game2.setBorder(null);
		game2.setOpaque(false);
		game2.setHorizontalAlignment(SwingConstants.CENTER);
		
		type2 = new JTextField();
		type2.setEditable(true);
		type2.setBounds(590, 168, 235, 45);
		type2.setForeground(Color.WHITE);
		type2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		type2.setBorder(null);
		type2.setOpaque(false);
		type2.setHorizontalAlignment(SwingConstants.CENTER);
		
		budget2 = new JTextField();
		budget2.setEditable(true);
		budget2.setBounds(590, 245, 235, 45);
		budget2.setForeground(Color.WHITE);
		budget2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		budget2.setBorder(null);
		budget2.setOpaque(false);
		budget2.setHorizontalAlignment(SwingConstants.CENTER);
		
		game3 = new JTextField();
		game3.setEditable(true);
		game3.setBounds(595, 410, 235, 45);
		game3.setForeground(Color.WHITE);
		game3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		game3.setBorder(null);
		game3.setOpaque(false);
		game3.setHorizontalAlignment(SwingConstants.CENTER);
		
		type3 = new JTextField();
		type3.setEditable(true);
		type3.setBounds(595, 487, 235, 45);
		type3.setForeground(Color.WHITE);
		type3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		type3.setBorder(null);
		type3.setOpaque(false);
		type3.setHorizontalAlignment(SwingConstants.CENTER);
		
		budget3 = new JTextField();
		budget3.setEditable(true);
		budget3.setBounds(595, 564, 235, 45);
		budget3.setForeground(Color.WHITE);
		budget3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		budget3.setBorder(null);
		budget3.setOpaque(false);
		budget3.setHorizontalAlignment(SwingConstants.CENTER);

		game4 = new JTextField();
		game4.setEditable(true);
		game4.setBounds(955, 92, 235, 45);
		game4.setForeground(Color.WHITE);
		game4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		game4.setBorder(null);
		game4.setOpaque(false);
		game4.setHorizontalAlignment(SwingConstants.CENTER);
		
		type4 = new JTextField();
		type4.setEditable(true);
		type4.setBounds(960, 167, 235, 45);
		type4.setForeground(Color.WHITE);
		type4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		type4.setBorder(null);
		type4.setOpaque(false);
		type4.setHorizontalAlignment(SwingConstants.CENTER);
		
		budget4 = new JTextField();
		budget4.setEditable(true);
		budget4.setBounds(960, 248, 235, 45);
		budget4.setForeground(Color.WHITE);
		budget4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		budget4.setBorder(null);
		budget4.setOpaque(false);
		budget4.setHorizontalAlignment(SwingConstants.CENTER);
		
		game5 = new JTextField();
		game5.setEditable(true);
		game5.setBounds(955, 410, 235, 45);
		game5.setForeground(Color.WHITE);
		game5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		game5.setBorder(null);
		game5.setOpaque(false);
		game5.setHorizontalAlignment(SwingConstants.CENTER);
		
		type5 = new JTextField();
		type5.setEditable(true);
		type5.setBounds(955, 488, 235, 45);
		type5.setForeground(Color.WHITE);
		type5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		type5.setBorder(null);
		type5.setOpaque(false);
		type5.setHorizontalAlignment(SwingConstants.CENTER);
		
		budget5 = new JTextField();
		budget5.setEditable(true);
		budget5.setBounds(955, 563, 235, 45);
		budget5.setForeground(Color.WHITE);
		budget5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		budget5.setBorder(null);
		budget5.setOpaque(false);
		budget5.setHorizontalAlignment(SwingConstants.CENTER);
		
		update = new JButton();
		update.setToolTipText("Actualizar parametros de los juegos");
		update.setBounds(200, 510, 180, 56);
		update.setOpaque(false);
		update.setContentAreaFilled(false);
		update.setBorderPainted(false);
		
		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(60, 600, 130, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(game1);
		add(type1);
		add(budget1);
		add(game2);
		add(type2);
		add(budget2);
		add(game3);
		add(game4);
		add(game5);
		add(type3);
		add(type4);
		add(type5);
		add(budget3);
		add(budget4);
		add(budget5);
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

	public JTextField getGame1() {
		return game1;
	}

	public void setGame1(JTextField game1) {
		this.game1 = game1;
	}

	public JTextField getType1() {
		return type1;
	}

	public void setType1(JTextField type1) {
		this.type1 = type1;
	}

	public JTextField getBudget1() {
		return budget1;
	}

	public void setBudget1(JTextField budget1) {
		this.budget1 = budget1;
	}

	public JTextField getGame2() {
		return game2;
	}

	public void setGame2(JTextField game2) {
		this.game2 = game2;
	}

	public JTextField getType2() {
		return type2;
	}

	public void setType2(JTextField type2) {
		this.type2 = type2;
	}

	public JTextField getBudget2() {
		return budget2;
	}

	public void setBudget2(JTextField budget2) {
		this.budget2 = budget2;
	}

	public JTextField getGame3() {
		return game3;
	}

	public void setGame3(JTextField game3) {
		this.game3 = game3;
	}

	public JTextField getType3() {
		return type3;
	}

	public void setType3(JTextField type3) {
		this.type3 = type3;
	}

	public JTextField getBudget3() {
		return budget3;
	}

	public void setBudget3(JTextField budget3) {
		this.budget3 = budget3;
	}

	public JTextField getGame4() {
		return game4;
	}

	public void setGame4(JTextField game4) {
		this.game4 = game4;
	}

	public JTextField getType4() {
		return type4;
	}

	public void setType4(JTextField type4) {
		this.type4 = type4;
	}

	public JTextField getBudget4() {
		return budget4;
	}

	public void setBudget4(JTextField budget4) {
		this.budget4 = budget4;
	}

	public JTextField getGame5() {
		return game5;
	}

	public void setGame5(JTextField game5) {
		this.game5 = game5;
	}

	public JTextField getType5() {
		return type5;
	}

	public void setType5(JTextField type5) {
		this.type5 = type5;
	}

	public JTextField getBudget5() {
		return budget5;
	}

	public void setBudget5(JTextField budget5) {
		this.budget5 = budget5;
	}
	
}
