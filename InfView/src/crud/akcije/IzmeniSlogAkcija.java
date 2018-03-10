package crud.akcije;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import tabele.model.TabelaModel;
import crud.komande.IzmeniSlogKomanda;

/**
 * <code>IzmeniSlogAkcija</code> je akcija koja sadrzi u sebi dugme
 *  koje se nalazi na alatnoj traci i instancira komandu <code>IzmeniSlogKomanda</code>.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class IzmeniSlogAkcija extends AbstractAction {
	private TabelaModel tabelaModel;
	public IzmeniSlogAkcija(TabelaModel tabelaModel) {
		super("Izmeni podatak", new ImageIcon("images/edit.png"));
		this.tabelaModel = tabelaModel;
		putValue(SHORT_DESCRIPTION, "Izmeni podatak.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IzmeniSlogKomanda komanda = new IzmeniSlogKomanda(tabelaModel);
		komanda.izvrsi();

	}

}
