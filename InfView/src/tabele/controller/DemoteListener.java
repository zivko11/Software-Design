/**
 * Paket sa kontrolerima za tabele.
 */
package tabele.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import stablo.kontroler.KontrolerCelije;
import stablo.model.CvorTabela;
import tabele.model.TabelaModel;
import view.GlavniProzor;
import view.ProstorZaTabele;
/**
 * Kontroler za snizavanje.
 * @author Milan Vujakovic
 *
 */
public class DemoteListener extends MouseAdapter {
	
	private TabelaModel model;
	
	public DemoteListener(TabelaModel model) {
		
		this.model = model;
	}

	public TabelaModel getModel() {
		return model;
	}

	public void setModel(TabelaModel model) {
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ProstorZaTabele pzt = GlavniProzor.getInstance().getProstorZaTabele();
		int selectedIndex = pzt.getSelectedIndex(); // cuvamo trenutno selektovan tab
		
		KontrolerCelije kc = GlavniProzor.getInstance().getStabloKontroler();
		ArrayList<CvorTabela> listaTabela = kc.getSveCvoroveRoditelja(model.getCvorTabela());
		if(listaTabela == null){
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Ova tabela nema roditelja.");
			return;
		} else if(listaTabela.size() == 1) {
			kc.setSelektovanTabelaCvor(listaTabela.get(0));
			pzt.remove(selectedIndex); // uklanjamo tab roditelja
		} else {
			JPopupMenu pm = new JPopupMenu();
			for(CvorTabela ct : listaTabela) {
				JMenuItem jmi = new JMenuItem(ct.getTabela().getIme().get(0));
				jmi.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						kc.setSelektovanTabelaCvor(ct);
						pzt.remove(selectedIndex); // uklanjamo tab roditelja
					}
				});
				pm.add(jmi);
				System.out.println(ct.getTabela().getIme().get(0));
			}
			pm.show(e.getComponent(), e.getX(), e.getY());
		}
		
		
	}
}
