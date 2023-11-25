package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase UserOptionsWindow representa la ventana de opciones para un usuario.
 */
public class UserOptionsWindow extends JLayeredPane {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = -507989939517678151L;
    /** Botón para acceder a la lotería. */
    private JButton loteria;
    /** Botón para acceder a Super Astro. */
    private JButton superAstro;
    /** Botón para acceder a Baloto. */
    private JButton baloto;
    /** Botón para acceder a BetPlay. */
    private JButton betPlay;
    /** Botón para acceder a Chance. */
    private JButton chance;
    /** Botón para acceder a opciones de edición. */
    private JButton edit;
    /** Botón para regresar al menú anterior. */
    private JButton back;
    /** Imagen de fondo para la ventana. */
    private JLabel backg;
    /** Etiqueta que muestra el nombre de usuario. */
    private JLabel userName;

    /**
     * Construye una nueva instancia de la clase UserOptionsWindow.
     * Inicializa y configura los elementos gráficos presentes en la ventana de opciones para un usuario.
     */
	public UserOptionsWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/5.png"));
		backg.setBounds(0, -20, 1280, 720);
		
		userName = new JLabel();
		userName.setForeground(Color.WHITE);
		userName.setFont(new Font("Vivaldi", Font.PLAIN, 35));
		userName.setBounds(170, 138, 800, 40);
		
		loteria = new JButton();
		loteria.setToolTipText("Haga click para entrar a la loteria");
		loteria.setBounds(570, 250, 180, 40);
		loteria.setOpaque(false);
		loteria.setContentAreaFilled(false);
		loteria.setBorderPainted(false);
		
		superAstro = new JButton();
		superAstro.setToolTipText("Haga click para entrar a super astro");
		superAstro.setBounds(570, 320, 235, 40);
		superAstro.setOpaque(false);
		superAstro.setContentAreaFilled(false);
		superAstro.setBorderPainted(false);
		
		baloto = new JButton();
		baloto.setToolTipText("Haga click para entrar a baloto");
		baloto.setBounds(570, 390, 180, 40);
		baloto.setOpaque(false);
		baloto.setContentAreaFilled(false);
		baloto.setBorderPainted(false);
		
		betPlay = new JButton();
		betPlay.setToolTipText("Haga click para entrar a betplay");
		betPlay.setBounds(570, 460, 180, 40);
		betPlay.setOpaque(false);
		betPlay.setContentAreaFilled(false);
		betPlay.setBorderPainted(false);
		
		chance = new JButton();
		chance.setToolTipText("Haga click para entrar a chance");
		chance.setBounds(570, 530, 180, 40);
		chance.setOpaque(false);
		chance.setContentAreaFilled(false);
		chance.setBorderPainted(false);
		
		edit = new JButton();
		edit.setToolTipText("Haga click para editar su perfil");
		edit.setBounds(980, 230, 130, 130);
		edit.setOpaque(false);
		edit.setContentAreaFilled(false);
		edit.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Cerrar la sesion y volver al menu inicial");
		back.setBounds(550, 610, 160, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(edit);
		add(betPlay);
		add(chance);
		add(loteria);
		add(superAstro);
		add(baloto);
		add(back);
		add(userName);
		add(backg);
	}

	public JButton getLoteria() {
		return loteria;
	}

	public void setLoteria(JButton loteria) {
		this.loteria = loteria;
	}

	public JButton getSuperAstro() {
		return superAstro;
	}

	public void setSuperAstro(JButton superAstro) {
		this.superAstro = superAstro;
	}

	public JButton getBaloto() {
		return baloto;
	}

	public void setBaloto(JButton baloto) {
		this.baloto = baloto;
	}

	public JButton getBetPlay() {
		return betPlay;
	}

	public void setBetPlay(JButton betPlay) {
		this.betPlay = betPlay;
	}

	public JButton getChance() {
		return chance;
	}

	public void setChance(JButton chance) {
		this.chance = chance;
	}

	public JButton getEdit() {
		return edit;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JLabel getBackg() {
		return backg;
	}

	public void setBackg(JLabel backg) {
		this.backg = backg;
	}

	public JLabel getUserName() {
		return userName;
	}

	public void setUserName(JLabel userName) {
		this.userName = userName;
	}
	
}
