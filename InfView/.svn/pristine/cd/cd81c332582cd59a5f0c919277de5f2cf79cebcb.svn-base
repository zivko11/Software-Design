package parsiranje;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pomocna klasa za iskljucivanje dijaloga
 * 
 * @author Nikola Stojanovic
 *
 */
public class OdustaniAkcija implements ActionListener {
	private Window parent;

	/**
	 * Definise konstruktor
	 * 
	 * @param dialog
	 *            Dijalog koji ce biti iskljucen
	 */
	public OdustaniAkcija(Window parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		parent.setVisible(false);
	}

}
