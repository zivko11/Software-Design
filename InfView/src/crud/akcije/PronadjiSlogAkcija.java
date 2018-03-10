package crud.akcije;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import crud.komande.PronadjiSlogKomanda;

/**
 * <code>PronadjiSlogAkcija</code> je akcija koja sadrzi u sebi dugme
 *  koje se nalazi na alatnoj traci i instancira komandu <code>PronadjiSlogKomanda</code>.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class PronadjiSlogAkcija extends AbstractAction {
	public PronadjiSlogAkcija() {
		super("Pronadji podatak", new ImageIcon("images/zoom.png"));
		putValue(SHORT_DESCRIPTION, "Pretrazi podatke.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PronadjiSlogKomanda komanda = new PronadjiSlogKomanda();
		komanda.izvrsi();

	}

}
