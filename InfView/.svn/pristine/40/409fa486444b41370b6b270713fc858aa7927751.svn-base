package parsiranje.fabrike;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Kolona;
import model.Tabela;
import podaci.MapaSaPodacima;
import stablo.model.CvorTabela;
import view.GlavniProzor;

/**
 * <code>KonkretnaFabrikaCvorTabela</code> predstavlja fabriku za kreiranje cvora tabele.
 * @author Zivko Stanisic
 *
 */
public class KonkretnaFabrikaCvorTabela implements ApstraktnaFabrikaCvor {

	@Override
	public Object kreirajCvor(Object model) {
		CvorTabela ct = new CvorTabela();
		try {
			Tabela tabela = (Tabela) model;
			MapaSaPodacima mapaTabele = new MapaSaPodacima(tabela.getId());
			for (Kolona kolona : tabela.getKolone()) {
				ArrayList<Object> list = new ArrayList<Object>();
				mapaTabele.dodajElement(kolona.getId(), list);
			}
			GlavniProzor.getInstance().getPodaciTabela().dodajElement(tabela.getId(), mapaTabele);
			ct.setTabela(tabela);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),
					GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);

		}
		return ct;
	}

}
