package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Editor;

/**
 * <code>SacuvajSemuAkcija</code> instancira klasu <code>SacuvajSemuKomanda</code>
 * 
 * @author Nikola Stojanovic
 *
 */
public class SacuvajSemuAkcija implements ActionListener {

	Editor e;

	/**
	 * Definise konstruktor klase <code>SacuvajSemuAkcija</code>
	 * @param e Editor iz kojeg se poziva ova akcija
	 */
	public SacuvajSemuAkcija(Editor e) {
		super();
		this.e = e;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		SacuvajSemuKomanda ssk = new SacuvajSemuKomanda(e);
		ssk.izvrsi();
	}

}
