/**
 * Paket koji sadrzi akcije i komande za prijavu.
 */
package prijava.kontroler;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * Akcija koja instancira komandu za izbor fajla.
 * 
 * @author Nikola Stojanovic
 *
 */
public class IzaberiFajlAkcija implements ActionListener {

	private JTextField fileField;
	private Window parent;

	public IzaberiFajlAkcija(JTextField fileField, Window parent) {
		this.fileField = fileField;
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IzaberiFajlKomanda ifk = new IzaberiFajlKomanda(fileField, parent);
		ifk.izvrsi();
	}

}
