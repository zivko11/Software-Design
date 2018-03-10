/**
 * Paket u kome su implementirane komande za CRUD operacije.
 */
package crud.komande;

import crud.DijalogSaPodacima;
import parsiranje.Komanda;
import tabele.model.TabelaModel;

/**
 * <code>DodajSlogKomanda</code> predstavlja komandu za dodavanje novog podatka u tabelu.
 * @author Zivko Stanisic
 *
 */
public class DodajSlogKomanda implements Komanda {
	private TabelaModel tabelaModel;
	
	public DodajSlogKomanda(TabelaModel tabelaModel) {
		this.tabelaModel = tabelaModel;
	}
	
	@Override
	public void izvrsi() {
		DijalogSaPodacima dijalog = new DijalogSaPodacima(tabelaModel, false);
		dijalog.setVisible(true);

	}

}
