package parsiranje.fabrike;

import javax.swing.JOptionPane;

import model.Podsistem;
import model.Sistem;
import stablo.model.CvorPodsistem;
import stablo.model.CvorSistem;
import view.GlavniProzor;

/**
 * <code>KonkretnaFabrikaCvorSistem</code> predstavlja fabriku za kreiranje cvora sistema.
 * @author Zivko Stanisic
 *
 */
public class KonkretnaFabrikaCvorSistem implements ApstraktnaFabrikaCvor {

	@Override
	public Object kreirajCvor(Object model) {
		CvorSistem cs = new CvorSistem();
		try {
			Sistem sistem = (Sistem) model;
			cs.setSistem(sistem);

			for (Podsistem p : sistem.getPodsistemi()) {
				KonkretnaFabrikaCvorPodsistem fabrika = new KonkretnaFabrikaCvorPodsistem();
				cs.Dodaj((CvorPodsistem) fabrika.kreirajCvor(p));
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),
					GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		}
		return cs;
	}

}
