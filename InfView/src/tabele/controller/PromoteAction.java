package tabele.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import stablo.kontroler.KontrolerCelije;
import tabele.model.TabelaModel;
import view.GlavniProzor;
import view.ProstorZaTabele;
/**
 * Promovise tabele.
 * @author Milan Vujakovic
 *
 */
@SuppressWarnings("serial")
public class PromoteAction extends AbstractAction {

	private TabelaModel model;

	public PromoteAction(TabelaModel model) {
		super("Promovisi", new ImageIcon("images/promote.png"));
		this.model = model;
		putValue(SHORT_DESCRIPTION, "Promovisi.");
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ProstorZaTabele pzt = GlavniProzor.getInstance().getProstorZaTabele();
		int selectedIndex = pzt.getSelectedIndex(); // cuvamo trenutno
													// selektovan tab

		KontrolerCelije kc = GlavniProzor.getInstance().getStabloKontroler();
		kc.setSelektovanTabelaCvor(model.getCvorTabela());
		pzt.remove(selectedIndex); // uklanjamo tab roditelja
	}
}
