package parsiranje.fabrike;

import javax.swing.JOptionPane;

import model.Paket;
import model.StraniKljuc;
import model.Tabela;
import stablo.model.CvorPaket;
import stablo.model.CvorTabela;
import view.GlavniProzor;

/**
 * <code>KonkretnaFabrikaCvorPaket</code> predstavlja fabriku za kreiranje cvora paketa.
 * @author Zivko Stanisic
 *
 */
public class KonkretnaFabrikaCvorPaket implements ApstraktnaFabrikaCvor {

	@Override
	public Object kreirajCvor(Object model) {
		CvorPaket cp = new CvorPaket();
		try {
			Paket paket = (Paket) model;
			cp.setPaket(paket);

			for (Tabela t : paket.getTabele()) {
				KonkretnaFabrikaCvorTabela fabrika = new KonkretnaFabrikaCvorTabela();
				if (t.getStraniKljuc() != null) {
					if (!t.getStraniKljuc().isEmpty()) {
						for (StraniKljuc k : t.getStraniKljuc()) {
							if (k.isJakaVeza()) {
								GlavniProzor.getInstance().getStablo()
										.getZavisneTabele().add(t);
								break;
							}
						}
					} else {
						cp.Dodaj((CvorTabela) fabrika.kreirajCvor(t));
					}
				} else {
					cp.Dodaj((CvorTabela) fabrika.kreirajCvor(t));
				}
			}

			for (Paket p : paket.getPodpaketi()) {
				KonkretnaFabrikaCvorPaket fabrika = new KonkretnaFabrikaCvorPaket();
				cp.Dodaj((CvorPaket) fabrika.kreirajCvor(p));
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					GlavniProzor.getInstance(),
					GlavniProzor.getInstance().getResourceBundle()
							.getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle()
							.getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		}

		return cp;
	}

}
