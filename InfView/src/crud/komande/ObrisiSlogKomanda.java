package crud.komande;

import java.util.ArrayList;

import model.Kolona;
import model.Tabela;
import parsiranje.Komanda;
import podaci.MapaSaPodacima;
import stablo.model.CvorTabela;
import tabele.TabelaView;
import tabele.model.TabelaModel;
import view.GlavniProzor;

/**
 * <code>ObrisiSlogKomanda</code> predstavlja komandu za brisanje selektovanog podatka iz tabele.
 * @author Zivko Stanisic
 *
 */
public class ObrisiSlogKomanda implements Komanda {
	private TabelaModel tabelaModel;

	public ObrisiSlogKomanda(TabelaModel tabelaModel) {
		this.tabelaModel = tabelaModel;
	}

	@Override
	public void izvrsi() {
		CvorTabela cvorTabela = tabelaModel.getCvorTabela();
		Tabela tabela = cvorTabela.getTabela();

		MapaSaPodacima mapaTabele = (MapaSaPodacima) GlavniProzor.getInstance()
				.getPodaciTabela().element(tabela.getId());
		for (Kolona k : tabela.getKolone()) {
			if (mapaTabele.element(k.getId()) != null) {
				 
				@SuppressWarnings("unchecked")
				ArrayList<Object> list = (ArrayList<Object>) mapaTabele
						.element(k.getId());
				list.remove(TabelaView.selectedRow);
				GlavniProzor.getInstance().getProstorZaTabele().removeAll();
			}
		}

	}

}
