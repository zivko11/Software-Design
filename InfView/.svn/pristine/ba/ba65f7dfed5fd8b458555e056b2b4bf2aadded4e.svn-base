/**
 * Paket akcija vezanih za CRUD.
 */
package crud.akcije;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import tabele.model.TabelaModel;
import crud.komande.DodajSlogKomanda;

/**
 * <code>DodajSlogAkcija</code> je akcija koja sadrzi u sebi dugme
 *  koje se nalazi na alatnoj traci i instancira komandu <code>DodajSlogKomanda</code>.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class DodajSlogAkcija extends AbstractAction {
	private TabelaModel tabelaModel;
	
	public DodajSlogAkcija(TabelaModel tabelaModel) {
		super("Dodaj podatak", new ImageIcon("images/new.png"));
		putValue(SHORT_DESCRIPTION, "Dodaj podatak.");
		this.tabelaModel = tabelaModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DodajSlogKomanda komanda = new DodajSlogKomanda(tabelaModel);
		komanda.izvrsi();

	}

}
