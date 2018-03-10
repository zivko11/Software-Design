package tabele;

import javax.swing.JTextField;
import javax.swing.JToolBar;

import tabele.controller.PromoteAction;
import tabele.model.TabelaModel;
import crud.akcije.DodajSlogAkcija;
import crud.akcije.IzmeniSlogAkcija;
import crud.akcije.ObrisiSlogAkcija;
import crud.akcije.PronadjiSlogAkcija;

/**
 * <code>SekundarnaAlatnaTraka</code> predstavlja alatnu traku za rad sa podacima unutar
 *  tabele i mogucnost postavljanja tabele u primarni panel.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class SekundarnaAlatnaTraka extends JToolBar {
	public SekundarnaAlatnaTraka(TabelaModel tabelaModel) {

		PromoteAction pa = new PromoteAction(tabelaModel);
		add(pa);
		addSeparator();

		DodajSlogAkcija noviPodatakAkcija = new DodajSlogAkcija(tabelaModel);
		add(noviPodatakAkcija);
		addSeparator();

		IzmeniSlogAkcija izmeniPodatakAkcija = new IzmeniSlogAkcija(tabelaModel);
		add(izmeniPodatakAkcija);
		addSeparator();

		ObrisiSlogAkcija obrisiPodatakAkcija = new ObrisiSlogAkcija(tabelaModel);
		add(obrisiPodatakAkcija);
		addSeparator();

		JTextField text = new JTextField(20);
		text.setMaximumSize(text.getPreferredSize());

		PronadjiSlogAkcija pretraziPodatakAkcija = new PronadjiSlogAkcija();

		add(text);
		add(pretraziPodatakAkcija);
	}
}
