package editor;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

import parsiranje.Komanda;
import parsiranje.Parser;
import validator.ValidatorSintakse;
import view.Editor;
import view.GlavniProzor;

/**
 *
 * Komanda za cuvanje seme.
 * 
 * @author Nikola Stojanovic
 *
 */
public class SacuvajSemuKomanda implements Komanda {
	private Editor e;

	/**
	 * Definise konstruktor klase <code>SacuvajSemuKomanda</code>
	 * 
	 * @param e
	 *            Editor iz kojeg se poziva akcija cuvanja seme
	 */
	public SacuvajSemuKomanda(Editor e) {
		super();
		this.e = e;
	}

	@Override
	public void izvrsi() {
		ValidatorSintakse vs = e.getValidatorSintakse();
		Parser p = e.getParser();
		if (!vs.overi(e.getTekstEditor().getText())) {
			JOptionPane.showMessageDialog(e, GlavniProzor.getInstance().getResourceBundle().getString("JSONErrorMsg"),
					GlavniProzor.getInstance().getResourceBundle().getString("JSONErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		} else if (!p.parsiraj(e.getTekstEditor().getText())) {
			JOptionPane.showMessageDialog(e, GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorMsg"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				BufferedWriter fileOut = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(GlavniProzor.getInstance().getPutanjaDoFajla()), "UTF-8"));
				e.getTekstEditor().write(fileOut);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.setVisible(false);
		}
	}

}
