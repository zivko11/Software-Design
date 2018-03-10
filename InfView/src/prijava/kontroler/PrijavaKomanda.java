package prijava.kontroler;

import javax.swing.JFrame;

import baza.parsiranje.SQLParser;
import parsiranje.Komanda;
import prijava.ValidatorPrijave;
import view.GlavniProzor;

/**
 * @author Nikola Stojanovic
 * 
 *         <code>PrijavaKomanda</class> uspostavlja vezu sa bazom podataka u
 *         zavisnosti od uspesnosti prijave
 */
public class PrijavaKomanda implements Komanda {

	private ValidatorPrijave validatorPrijave;
	private JFrame parent;

	public PrijavaKomanda(JFrame parent, ValidatorPrijave validatorPrijave) {
		super();
		this.parent = parent;
		this.validatorPrijave = validatorPrijave;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see parsiranje.Komanda#izvrsi()
	 */
	public void izvrsi() {
		if (validatorPrijave.overi(validatorPrijave.getPrijava().getKorisnickoIme(),
				validatorPrijave.getPrijava().getSifra())) {
			SQLParser par = new SQLParser();
			if(GlavniProzor.getInstance().getAktivniKorisnik().isPravoPristupa()) {
				par.parsiraj(SQLParser.ADMIN);
			}else {
				par.parsiraj(SQLParser.NORMAL);
			}
			parent.setVisible(false);
			GlavniProzor.getInstance().setVisible(true);
		}
	}

}