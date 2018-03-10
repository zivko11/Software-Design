package crud.komande;

import parsiranje.Komanda;
import tabele.model.TabelaModel;
import crud.DijalogSaPodacima;

/**
 * <code>IzmeniSlogKomanda</code> predstavlja komandu za izmenu selektovanog podatka iz tabele.
 * @author Zivko Stanisic
 *
 */
public class IzmeniSlogKomanda implements Komanda {
	private TabelaModel tabelaModel;

	public IzmeniSlogKomanda(TabelaModel tabelaModel) {
		this.tabelaModel = tabelaModel;
	}

	@Override
	public void izvrsi() {
		DijalogSaPodacima dijalog = new DijalogSaPodacima(tabelaModel,true);
		dijalog.setEdited(true);
		dijalog.setVisible(true);

	}

}
