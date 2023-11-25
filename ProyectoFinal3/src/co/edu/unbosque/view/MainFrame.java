package co.edu.unbosque.view;

import javax.swing.JFrame;


/**
 * La clase MainFrame representa el marco principal de la aplicación de la casa de apuestas.
 * Contiene instancias de las ventanas relacionadas con la aplicación. Esta clase
 * administra la visibilidad de las diferentes ventanas y su interacción.
 *
 * @version 1.0
 */
public class MainFrame extends JFrame {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = -4449356743138088832L;
    /** Instancia de la ventana principal. */
    private MainWindow mw;
    /** Instancia de la ventana de inicio de sesión de usuario. */
    private UserLoginWindow ulw;
    /** Instancia de la ventana de registro de usuario. */
    private UserRegisterWindow urw;
    /** Instancia de la ventana de inicio de sesión de administrador. */
    private AdminLoginWindow alw;
    /** Instancia de la ventana de opciones de administrador. */
    private AdminOptionsWindow aow;
    /** Instancia de la ventana de actualización de administrador. */
    private UpdateAdminWindow uaw;
    /** Instancia de la ventana de parámetros de la tienda. */
    private ShopParametersWindow spw;
    /** Instancia de la ventana de modificación de juegos. */
    private GameModWindow gmw;
    /** Instancia de la ventana de creación de sucursales. */
    private CreateBranchWindow cbw;
    /** Instancia de la ventana de opciones de sucursal. */
    private BranchOptionsWindow bow;
    /** Instancia de la ventana de opciones de usuario. */
    private UserOptionsWindow uow;
    /** Instancia de la ventana de actualización de usuario. */
    private UpdateUserWindow uuw;
    /** Instancia de la ventana de lotería. */
    private LoteriaWindow lw;
    /** Instancia de la ventana de información sobre la lotería. */
    private LotteryInformationWindow liw;
    /** Instancia de la ventana de SuperAstro. */
    private SuperAstroWindow saw;
    /** Instancia de la ventana de información sobre SuperAstro. */
    private SuperAstroInformationWindow saiw;
    /** Instancia de la ventana de Baloto. */
    private BalotoWindow bw;
    /** Instancia de la ventana de información sobre Baloto. */
    private BalotoInformationWindow biw;
    /** Instancia de la ventana de Chance. */
    private ChanceWindow cw;
    /** Instancia de la ventana de información sobre Chance. */
    private ChanceInformationWindow ciw;
    /** Instancia de la ventana de BetPlay. */
    private BetPlayWindow bpw;
    /** Instancia de la ventana de información sobre BetPlay. */
    private BetPlayInformationWindow bpiw;
    /** Instancia de la ventana de modificación de apuestas. */
    private ModifyBetWindow mbw;
    /** Instancia de la ventana de modificación de lotería. */
    private ModifyLotteryWindow mlw;
    /** Instancia de la ventana de modificación de SuperAstro. */
    private ModifySuperAstroWindow msaw;
    /** Instancia de la ventana de modificación de Chance. */
    private ModifyChanceWindow mcw;
    /** Instancia de la ventana de modificación de Baloto. */
    private ModifyBalotoWindow mbaw;
    /** Instancia de la ventana de modificación de BetPlay. */
    private ModifyBetPlayWindow mbpw;
    /** Instancia de la ventana de modificación de BetPlay (parte 2). */
    private ModifyBetPlayWindow2 mbpw2;
    /** Instancia de la ventana de clientes. */
    private CustomersWindow cuw;
    /** Instancia de la ventana de apuestas con valor. */
    private ValueBetsCustomersWindow vbcw;
    /** Instancia de la ventana de detalles de apuestas. */
    private BetDetailsWindow bdw;
    /** Instancia de la ventana de total de apuestas. */
    private TotalBetsWindow tbw;
    /** Instancia de la ventana de recibo. */
    private ReceiptWindow rw;

    /**
     * Construye una nueva instancia de la clase MainFrame.
     * Configura y muestra el marco principal con la ventana principal visible y las demás ventanas ocultas.
     */
	public MainFrame() {
		mw = new MainWindow();
		ulw = new UserLoginWindow();
		alw = new AdminLoginWindow();
		aow = new AdminOptionsWindow();
		uaw = new UpdateAdminWindow();
		spw = new ShopParametersWindow();
		gmw = new GameModWindow();
		cbw = new CreateBranchWindow();
		bow = new BranchOptionsWindow();
		urw = new UserRegisterWindow();
		uow = new UserOptionsWindow();
		uuw = new UpdateUserWindow();
		lw = new LoteriaWindow();
		liw = new LotteryInformationWindow();
		saw = new SuperAstroWindow();
		saiw = new SuperAstroInformationWindow();
		bw = new BalotoWindow();
		biw = new BalotoInformationWindow();
		cw = new ChanceWindow();
		ciw = new ChanceInformationWindow();
		bpw = new BetPlayWindow();
		bpiw = new BetPlayInformationWindow();
		mbw = new ModifyBetWindow();
		mlw = new ModifyLotteryWindow();
		msaw = new ModifySuperAstroWindow();
		mcw = new ModifyChanceWindow();
		mbaw = new ModifyBalotoWindow();
		mbpw = new ModifyBetPlayWindow();
		mbpw2 = new ModifyBetPlayWindow2();
		cuw = new CustomersWindow();
		vbcw = new ValueBetsCustomersWindow();
		bdw = new BetDetailsWindow();
		tbw = new TotalBetsWindow();
		rw = new ReceiptWindow();
		
		
		setTitle("Casa de apuestas");
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		
		add(mw).setVisible(true);
		add(ulw).setVisible(false);
		add(urw).setVisible(false);
		add(alw).setVisible(false);
		add(aow).setVisible(false);
		add(uaw).setVisible(false);
		add(spw).setVisible(false);
		add(gmw).setVisible(false);
		add(cbw).setVisible(false);
		add(bow).setVisible(false);
		add(uow).setVisible(false);
		add(uuw).setVisible(false);
		add(lw).setVisible(false);
		add(saw).setVisible(false);
		add(bw).setVisible(false);
		add(cw).setVisible(false);
		add(bpw).setVisible(false);
		add(mbw).setVisible(false);
		add(mlw).setVisible(false);
		add(msaw).setVisible(false);
		add(mcw).setVisible(false);
		add(mbaw).setVisible(false);
		add(mbpw).setVisible(false);
		add(mbpw2).setVisible(false);
		add(cuw).setVisible(false);
		add(vbcw).setVisible(false);
		add(bdw).setVisible(false);
		add(tbw).setVisible(false);
		
		
		setVisible(true);
	}

	public MainWindow getMw() {
		return mw;
	}

	public void setMw(MainWindow mw) {
		this.mw = mw;
	}

	public UserLoginWindow getUlw() {
		return ulw;
	}

	public void setUlw(UserLoginWindow ulw) {
		this.ulw = ulw;
	}

	public AdminLoginWindow getAlw() {
		return alw;
	}

	public void setAlw(AdminLoginWindow alw) {
		this.alw = alw;
	}

	public AdminOptionsWindow getAow() {
		return aow;
	}

	public void setAow(AdminOptionsWindow aow) {
		this.aow = aow;
	}

	public UpdateAdminWindow getUaw() {
		return uaw;
	}

	public void setUaw(UpdateAdminWindow uaw) {
		this.uaw = uaw;
	}

	public ShopParametersWindow getSpw() {
		return spw;
	}

	public void setSpw(ShopParametersWindow spw) {
		this.spw = spw;
	}

	public GameModWindow getGmw() {
		return gmw;
	}

	public void setGmw(GameModWindow gmw) {
		this.gmw = gmw;
	}

	public CreateBranchWindow getCbw() {
		return cbw;
	}

	public void setCbw(CreateBranchWindow cbw) {
		this.cbw = cbw;
	}

	public BranchOptionsWindow getBow() {
		return bow;
	}

	public void setBow(BranchOptionsWindow bow) {
		this.bow = bow;
	}

	public UserRegisterWindow getUrw() {
		return urw;
	}

	public void setUrw(UserRegisterWindow urw) {
		this.urw = urw;
	}

	public UserOptionsWindow getUow() {
		return uow;
	}

	public void setUow(UserOptionsWindow uow) {
		this.uow = uow;
	}

	public UpdateUserWindow getUuw() {
		return uuw;
	}

	public void setUuw(UpdateUserWindow uuw) {
		this.uuw = uuw;
	}

	public LoteriaWindow getLw() {
		return lw;
	}

	public void setLw(LoteriaWindow lw) {
		this.lw = lw;
	}

	public LotteryInformationWindow getLiw() {
		return liw;
	}

	public void setLiw(LotteryInformationWindow liw) {
		this.liw = liw;
	}

	public SuperAstroWindow getSaw() {
		return saw;
	}

	public void setSaw(SuperAstroWindow saw) {
		this.saw = saw;
	}

	public SuperAstroInformationWindow getSaiw() {
		return saiw;
	}

	public void setSaiw(SuperAstroInformationWindow saiw) {
		this.saiw = saiw;
	}

	public BalotoWindow getBw() {
		return bw;
	}

	public void setBw(BalotoWindow bw) {
		this.bw = bw;
	}

	public BalotoInformationWindow getBiw() {
		return biw;
	}

	public void setBiw(BalotoInformationWindow biw) {
		this.biw = biw;
	}

	public ChanceWindow getCw() {
		return cw;
	}

	public void setCw(ChanceWindow cw) {
		this.cw = cw;
	}

	public ChanceInformationWindow getCiw() {
		return ciw;
	}

	public void setCiw(ChanceInformationWindow ciw) {
		this.ciw = ciw;
	}

	public BetPlayWindow getBpw() {
		return bpw;
	}

	public void setBpw(BetPlayWindow bpw) {
		this.bpw = bpw;
	}

	public BetPlayInformationWindow getBpiw() {
		return bpiw;
	}

	public void setBpiw(BetPlayInformationWindow bpiw) {
		this.bpiw = bpiw;
	}

	public ModifyBetWindow getMbw() {
		return mbw;
	}

	public void setMbw(ModifyBetWindow mbw) {
		this.mbw = mbw;
	}

	public ModifyLotteryWindow getMlw() {
		return mlw;
	}

	public void setMlw(ModifyLotteryWindow mlw) {
		this.mlw = mlw;
	}

	public ModifySuperAstroWindow getMsaw() {
		return msaw;
	}

	public void setMsaw(ModifySuperAstroWindow msaw) {
		this.msaw = msaw;
	}

	public ModifyChanceWindow getMcw() {
		return mcw;
	}

	public void setMcw(ModifyChanceWindow mcw) {
		this.mcw = mcw;
	}

	public ModifyBalotoWindow getMbaw() {
		return mbaw;
	}

	public void setMbaw(ModifyBalotoWindow mbaw) {
		this.mbaw = mbaw;
	}

	public ModifyBetPlayWindow getMbpw() {
		return mbpw;
	}

	public void setMbpw(ModifyBetPlayWindow mbpw) {
		this.mbpw = mbpw;
	}

	public ModifyBetPlayWindow2 getMbpw2() {
		return mbpw2;
	}

	public void setMbpw2(ModifyBetPlayWindow2 mbpw2) {
		this.mbpw2 = mbpw2;
	}

	public CustomersWindow getCuw() {
		return cuw;
	}

	public void setCuw(CustomersWindow cuw) {
		this.cuw = cuw;
	}

	public ValueBetsCustomersWindow getVbcw() {
		return vbcw;
	}

	public void setVbcw(ValueBetsCustomersWindow vbcw) {
		this.vbcw = vbcw;
	}

	public BetDetailsWindow getBdw() {
		return bdw;
	}

	public void setBdw(BetDetailsWindow bdw) {
		this.bdw = bdw;
	}

	public TotalBetsWindow getTbw() {
		return tbw;
	}

	public void setTbw(TotalBetsWindow tbw) {
		this.tbw = tbw;
	}

	public ReceiptWindow getRw() {
		return rw;
	}

	public void setRw(ReceiptWindow rw) {
		this.rw = rw;
	}
	
}
