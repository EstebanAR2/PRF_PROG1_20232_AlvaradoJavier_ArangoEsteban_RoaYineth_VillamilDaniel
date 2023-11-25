package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase ModifyBetWindow representa la ventana de modificación para la selección de juegos de apuestas.
 */
public class ModifyBetWindow extends JLayeredPane{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -3227944547957993069L;
    /** El botón para modificar apuestas en la lotería. */
    private JButton loteria;
    /** El botón para modificar apuestas en Super Astro. */
    private JButton superAstro;
    /** El botón para modificar apuestas en Baloto. */
    private JButton baloto;
    /** El botón para modificar apuestas en BetPlay. */
    private JButton betPlay;
    /** El botón para modificar apuestas en Chance. */
    private JButton chance;
    /** El botón para regresar al menú anterior. */
    private JButton back;
    /** La etiqueta que muestra la imagen de fondo de la ventana. */
    private JLabel backg;

    /**
     * Construye una nueva instancia de la clase {@code ModifyBetWindow}.
     * Configura y muestra la ventana de modificación para la selección de juegos de apuestas.
     */
	public ModifyBetWindow() {
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/5mo.png"));
		backg.setBounds(0, -20, 1280, 720);
		
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

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(550, 610, 160, 62);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(betPlay);
		add(chance);
		add(loteria);
		add(superAstro);
		add(baloto);
		add(back);
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
	
}
