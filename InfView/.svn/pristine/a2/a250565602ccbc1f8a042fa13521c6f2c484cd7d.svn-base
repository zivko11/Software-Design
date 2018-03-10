/**
 * Paket sa modelom tabele.
 */
package tabele.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Kolona;
import model.Tabela;
import podaci.MapaSaPodacima;
import stablo.model.CvorTabela;
import view.GlavniProzor;
/**
 * <code>TabelaModel</code> predstavlja model tabele. U njemu se cuvaju podaci tabele.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class TabelaModel extends DefaultTableModel {

	private CvorTabela cvorTabela;

	public TabelaModel(CvorTabela cvorTabela) {
		this.cvorTabela = cvorTabela;
		UcitajKolone(cvorTabela.getTabela());
	}

	private void UcitajKolone(Tabela tabela) {
		setColumnCount(0); // brisemo kolone
		MapaSaPodacima mapaTabele = (MapaSaPodacima) GlavniProzor.getInstance()
				.getPodaciTabela().element((String) tabela.getId());
		ArrayList<ArrayList<Object>> puniKolone = new ArrayList<ArrayList<Object>>();
		int velicinaKolone = 0;
		for (Kolona k : tabela.getKolone()) {
			addColumn(k.getIme().get(0));
			if (mapaTabele != null) {
				if (mapaTabele.brojElemenata() != 0) {
					if (mapaTabele.element(k.getId()) != null) {
						@SuppressWarnings("unchecked")
						ArrayList<Object> list = (ArrayList<Object>) mapaTabele
								.element(k.getId());
						if (list != null) {
							puniKolone.add(list);
							velicinaKolone = list.size();
						}
					}

				}
			}
		}
		for (int i = 0; i < velicinaKolone; i++) {
			ArrayList<Object> list = new ArrayList<Object>();
			for (int j = 0; j < puniKolone.size(); j++) {
				list.add(puniKolone.get(j).get(i));

			}
			Object[] obj = list.toArray();
			addRow(obj);
		}
	}

	public CvorTabela getCvorTabela() {
		return cvorTabela;
	}

	public void setCvorTabela(CvorTabela cvorTabela) {
		this.cvorTabela = cvorTabela;
		UcitajKolone(cvorTabela.getTabela());
	}
}
