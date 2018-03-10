package tabele;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import tabele.controller.DemoteListener;
import tabele.model.TabelaModel;
import crud.akcije.DodajSlogAkcija;
import crud.akcije.IzmeniSlogAkcija;
import crud.akcije.ObrisiSlogAkcija;
import crud.akcije.PronadjiSlogAkcija;

/**
 * <code>PrimarnaAlatnaTraka</code> predstavlja alatnu traku za rad sa podacima unutar
 *  tabele i mogucnost postavljanja tabele u sekundarni panel.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class PrimarnaAlatnaTraka extends JToolBar {
	public PrimarnaAlatnaTraka(TabelaModel tabelaModel) {
		JButton demoteBtn = new JButton();
		demoteBtn.setToolTipText("Snizi.");
		demoteBtn.setIcon(new ImageIcon("images/demote.png"));

		DemoteListener dl = new DemoteListener(tabelaModel);
		demoteBtn.addMouseListener(dl);

		add(demoteBtn);
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
