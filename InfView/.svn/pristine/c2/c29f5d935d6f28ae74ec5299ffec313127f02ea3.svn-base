package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
/***********************************************************************
 * Module:  GlavniProzor.java
 * Author:  Stefan Pandžić
 * Purpose: Defines the Class GlavniProzor
 ***********************************************************************/
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import korisnik.model.Korisnik;
import model.Sistem;
import podaci.MapaSaPodacima;
import stablo.Stablo;
import stablo.kontroler.KontrolerCelije;
import stablo.model.CvorSistem;
import stablo.model.MojModelStabla;

/**
 * Klasa <code>GlavniProzor</code> predstavlja osnovni izgled cele aplikacije, u
 * njemu se nalaze metode i atributi vezani za ceo rad aplikacije.
 * 
 * @author Stefan Pandzic
 */
@SuppressWarnings("serial")
public class GlavniProzor extends JFrame {
	private static GlavniProzor instance = null;
	private ProstorZaTabele prostorZaTabele;
	private Stablo stablo;
	private KontrolerCelije stabloKontroler;
	private Meni meni;
	private ArrayList<AlatnaTraka> alati;
	private String putanjaDoFajla;
	private ResourceBundle resourceBundle;
	private Connection konekcijaNaServer;
	private MapaSaPodacima podaciTabela = new MapaSaPodacima("root");
	private Korisnik aktivniKorisnik;
	private boolean editable;

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Korisnik getAktivniKorisnik() {
		return aktivniKorisnik;
	}

	public void setAktivniKorisnik(Korisnik aktivniKorisnik) {
		this.aktivniKorisnik = aktivniKorisnik;
	}

	public Connection getKonekcijaNaServer() {
		return konekcijaNaServer;
	}

	public void setKonekcijaNaServer(Connection konekcijaNaServer) {
		this.konekcijaNaServer = konekcijaNaServer;
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	public String getPutanjaDoFajla() {
		return putanjaDoFajla;
	}

	public void setPutanjaDoFajla(String putanjaDoFajla) {
		this.putanjaDoFajla = putanjaDoFajla;
	}

	public Stablo getStablo() {
		return stablo;
	}

	public void setStablo(Stablo stablo) {
		this.stablo = stablo;
	}

	public Meni getMeni() {
		return meni;
	}

	public void setMeni(Meni meni) {
		this.meni = meni;
	}

	public ArrayList<AlatnaTraka> getAlati() {
		return alati;
	}

	public void setAlati(ArrayList<AlatnaTraka> alati) {
		this.alati = alati;
	}

	public ProstorZaTabele getProstorZaTabele() {
		return prostorZaTabele;
	}

	public void setProstorZaTabele(ProstorZaTabele prostorZaTabele) {
		this.prostorZaTabele = prostorZaTabele;
	}

	private GlavniProzor() {

		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle(
				"view.lokalizacija.MessageResources", Locale.getDefault());

	}

	public static GlavniProzor getInstance() {
		if (instance == null) {
			instance = new GlavniProzor();
			instance.initGui();
		}
		return instance;
	}

	public void initGui() {
		setSize(800, 400); // Podesavamo dimenzije prozora
		setTitle("InfView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Postavljamo akciju
														// pri zatvaranju
														// prozora
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null); // postavljamo JFrame na centar ekrana
		setResizable(true);

		// ikonica
		ImageIcon icon = new ImageIcon("images/db.png");
		setIconImage(icon.getImage());	
		
		meni = new Meni();
		setJMenuBar(meni);

		AlatnaTraka toolbar = new AlatnaTraka();
		add(toolbar, BorderLayout.NORTH);

		Sistem sistem = new Sistem();
		sistem.getIme().add("Prazno");
		CvorSistem cvorSistem = new CvorSistem();
		cvorSistem.setSistem(sistem);

		MojModelStabla modelStabla = new MojModelStabla(cvorSistem);

		stablo = new Stablo(modelStabla);
		stabloKontroler = new KontrolerCelije(stablo, modelStabla);
		stablo.addTreeSelectionListener(stabloKontroler);
		prostorZaTabele = new ProstorZaTabele(
				ProstorZaTabele.TAB_SA_ZATVARANJEM);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				stablo, prostorZaTabele);
		splitPane.setDividerLocation(200);
		add(splitPane);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle(
				"view.lokalizacija.MessageResources", Locale.getDefault());
		meni.initComponents();
	}
	
	public void helpWin(){
		
		File htmlFile = new File("help/Help.htm");
		try {
		Desktop.getDesktop().browse(htmlFile.toURI());
		}
		catch (Exception io ) {
		}
	}

	public KontrolerCelije getStabloKontroler() {
		return stabloKontroler;
	}

	public void setStabloKontroler(KontrolerCelije stabloKontroler) {
		this.stabloKontroler = stabloKontroler;
	}

	public MapaSaPodacima getPodaciTabela() {
		return podaciTabela;
	}

	public void setPodaciTabela(MapaSaPodacima podaciTabela) {
		this.podaciTabela = podaciTabela;
	}

}