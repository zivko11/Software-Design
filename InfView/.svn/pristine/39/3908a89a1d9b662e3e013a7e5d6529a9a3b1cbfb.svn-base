package prijava;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import korisnik.model.Korisnik;
import view.GlavniProzor;

/**
 * <code>ValidatorJsonPrijave</code> je implementacija
 * <code>ValidatorPrijaveInterface</code> interfejsa za koristenje lokalne
 * (JSON) baze podataka
 * 
 * @author Nikola Stojanovic
 *
 */
public class ValidatorJsonPrijave implements ValidatorPrijaveInterface {

	@Override
	public boolean overi(String korisnickoIme, String sifra) {
		String path = System.getProperty("user.dir");
		path += File.separatorChar + "seme" + File.separatorChar + "mapaKorisnika.json";
		try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, Korisnik> korisnici = mapper.readValue(new File(path),
					new TypeReference<HashMap<String, Korisnik>>() {
					});

			if (korisnici.containsKey(korisnickoIme)) {
				if (korisnici.get(korisnickoIme).getSifra().equals(sifra)) {
					GlavniProzor.getInstance().setAktivniKorisnik(korisnici.get(korisnickoIme));
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

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return false;
	}

}
