package parsiranje.fabrike;

import javax.swing.JOptionPane;

import model.Paket;
import model.Podsistem;
import model.StraniKljuc;
import model.Tabela;
import stablo.model.CvorPaket;
import stablo.model.CvorPodsistem;
import stablo.model.CvorTabela;
import view.GlavniProzor;

/**
 * <code>KonkretnaFabrikaCvorPodsistem</code> predstavlja fabriku za kreiranje cvora Podsistema.
 * @author Zivko Stanisic
 *
 */
public class KonkretnaFabrikaCvorPodsistem implements ApstraktnaFabrikaCvor {

	@Override
	public Object kreirajCvor(Object model) {
		CvorPodsistem cp = new CvorPodsistem();
		try {
			Podsistem podsistem = (Podsistem) model;
			cp.setPodsistem(podsistem);

			for (Podsistem p : podsistem.getPodsistemi()) {
				KonkretnaFabrikaCvorPodsistem fabrika = new KonkretnaFabrikaCvorPodsistem();
				cp.Dodaj((CvorPodsistem) fabrika.kreirajCvor(p));
			}

			for (Paket p : podsistem.getPaketi()) {
				KonkretnaFabrikaCvorPaket fabrika = new KonkretnaFabrikaCvorPaket();
				cp.Dodaj((CvorPaket) fabrika.kreirajCvor(p));
			}
			
			for (Tabela p : podsistem.getTabele()) {
				KonkretnaFabrikaCvorTabela fabrika = new KonkretnaFabrikaCvorTabela();
				if (!p.getStraniKljuc().isEmpty()) {
					for (StraniKljuc k : p.getStraniKljuc()) {
						if (k.isJakaVeza()) {
							GlavniProzor.getInstance().getStablo()
									.getZavisneTabele().add(p);
						} else {
							cp.Dodaj((CvorTabela) fabrika.kreirajCvor(p));
							break;
						}
					}
				} else {
					cp.Dodaj((CvorTabela) fabrika.kreirajCvor(p));
				}
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
