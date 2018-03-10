package prijava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import korisnik.model.Korisnik;
import view.GlavniProzor;

/**
 * 
 * <code>ValidatorPrijave</code> overava korisnikovu prijavu na SQL bazu.
 * Predstavlja imeplementaciju <code>ValidatorPrijaveInterface</code> interfejsa
 * 
 * @author Nikola Stojanovic
 */
public class ValidatorPrijave implements ValidatorPrijaveInterface {

	public static String CONNECTION_STRING = "jdbc:jtds:sqlserver://147.91.175.155/psw-2017-tim8-3";
	public static String USER_NAME = "psw-2017-tim8-3";
	public static String PASSWORD = "tim8-316101819";

	private Prijava prijava;

	public Prijava getPrijava() {
		return prijava;
	}

	public void setPrijava(Prijava prijava) {
		this.prijava = prijava;
	}

	public ValidatorPrijave() {
		super();
	}

	/**
	 * @param korisnickoIme
	 * @param sifra
	 * @return true ako je prijava uspesna, false ako nije
	 */
	public boolean overi(String korisnickoIme, String sifra) {

		try {
			Connection konekcija = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
			GlavniProzor.getInstance().setKonekcijaNaServer(konekcija);

			Statement stmt = konekcija.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KORISNICI WHERE KR_KORISNICKO_IME='" + korisnickoIme + "'");
			if (rs.next()) {
				if (rs.getString("KR_LOZINKA").equals(sifra)) {
					Korisnik k = new Korisnik();
					k.setKorisnickoIme(korisnickoIme);
					k.setSifra(sifra);
					k.setOznaka(rs.getString("KR_OZNAKA"));
					k.setPravoPristupa(rs.getString("KR_PRAVO_PRISTUPA").equals("1"));
					GlavniProzor.getInstance().setAktivniKorisnik(k);
					GlavniProzor.getInstance().setEditable(false);
					return true;
				} else {
					JOptionPane.showMessageDialog(null,
							GlavniProzor.getInstance().getResourceBundle().getString("sifraError"),
							GlavniProzor.getInstance().getResourceBundle().getString("ErrorTitle"),
							JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null,
						GlavniProzor.getInstance().getResourceBundle().getString("korImeError"),
						GlavniProzor.getInstance().getResourceBundle().getString("ErrorTitle"),
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					GlavniProzor.getInstance().getResourceBundle().getString("SQLException"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public ValidatorPrijave(Prijava prijava) {
		super();
		this.prijava = prijava;
	}

}