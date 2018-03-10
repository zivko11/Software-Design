package crud.akcije;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import tabele.model.TabelaModel;
import crud.komande.ObrisiSlogKomanda;

/**
 * <code>ObrisiSlogAkcija</code> je akcija koja sadrzi u sebi dugme
 *  koje se nalazi na alatnoj traci i instancira komandu <code>ObrisiSlogKomanda</code>.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class ObrisiSlogAkcija extends AbstractAction {
	private TabelaModel tabelaModel;
	public ObrisiSlogAkcija(TabelaModel tabelaModel) {
		super("Obrisi podatak", new ImageIcon("images/delete.png"));
		this.tabelaModel = tabelaModel;
		putValue(SHORT_DESCRIPTION, "Obrisi podatak.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ObrisiSlogKomanda komanda = new ObrisiSlogKomanda(tabelaModel);
		komanda.izvrsi();

	}

}
