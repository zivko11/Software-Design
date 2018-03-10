package stablo;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.TreeNode;

import model.Tabela;
import parsiranje.fabrike.KonkretnaFabrikaCvorTabela;
import stablo.model.CvorPaket;
import stablo.model.CvorPodsistem;
import stablo.model.CvorSistem;
import stablo.model.CvorTabela;
/**
 * <code>Stablo</code> je vizualni prikaz modela u vidu stabla.
 * @author Zivko Stanisic
 */
import stablo.model.MojModelStabla;
import view.GlavniProzor;

@SuppressWarnings("serial")
public class Stablo extends JTree {
	private MojModelStabla modelStabla;
	private ArrayList<Tabela> zavisneTabele;
	private ArrayList<CvorTabela> cvoroviTabela;

	public Stablo(MojModelStabla modelStabla) {
		cvoroviTabela = new ArrayList<CvorTabela>();
		zavisneTabele = new ArrayList<Tabela>();
		this.modelStabla = modelStabla;

		setModel(modelStabla);
		setCellEditor(new EditorCelije(this, new RenderCelije()));
		setCellRenderer(new RenderCelije());
		setEditable(false);
	}

	public MojModelStabla getModelStabla() {
		return modelStabla;
	}

	public ArrayList<Tabela> getZavisneTabele() {
		return zavisneTabele;
	}

	public void setZavisneTabele(ArrayList<Tabela> zavisneTabele) {
		this.zavisneTabele = zavisneTabele;
	}

	/**
	 * Direktno ubacivanje modela u stablo.
	 * 
	 * @param modelStabla
	 */
	public void setModelStabla(MojModelStabla modelStabla) {
		this.modelStabla = modelStabla;
		setModel(modelStabla);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(GlavniProzor.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prolazi kroz celo stablo i dodaje zavisne tabele.
	 * 
	 * @param cvor
	 * @return
	 */
	private TreeNode prodjiKrozStablo(TreeNode cvor) {
		TreeNode ret = null;
		if (cvor instanceof CvorSistem) {
			for (int i = 0; i < cvor.getChildCount(); i++) {
				ret = prodjiKrozStablo((TreeNode) cvor.getChildAt(i));
			}
		} else if (cvor instanceof CvorPodsistem) {
			for (int i = 0; i < cvor.getChildCount(); i++) {
				ret = prodjiKrozStablo((TreeNode) cvor.getChildAt(i));
			}
		} else if (cvor instanceof CvorPaket) {
			for (int i = 0; i < cvor.getChildCount(); i++) {
					ret = prodjiKrozStablo((TreeNode) cvor.getChildAt(i));
			}
		} else if (cvor instanceof CvorTabela) {
			CvorTabela cvorI = (CvorTabela) cvor;
			Tabela tabelaI = cvorI.getTabela();
			for (CvorTabela pom : cvoroviTabela) {
				Tabela tabelaPom = pom.getTabela();
				for (int p = 0; p < tabelaPom.getStraniKljuc().size(); p++) {
					if (tabelaPom.getStraniKljuc().get(p)
							.getIdReferenciraneTabele()
							.equals(tabelaI.getId())) {
						cvorI.Dodaj(pom);
						break;
					}
				}

			}
			
		}
		return ret;
	}

	/**
	 * Dodaje sve zavisne tabele u stablo. Pre dodavanja izveze sve zavisne
	 * tabele medjusobno.
	 */
	public void dodajZavisneTabele() {
		zavisneTabele = new ArrayList<Tabela>(new LinkedHashSet<Tabela>(zavisneTabele));
		for (int i = 0; i < zavisneTabele.size(); i++) {
			KonkretnaFabrikaCvorTabela fabrika = new KonkretnaFabrikaCvorTabela();
			CvorTabela ct = (CvorTabela) fabrika.kreirajCvor((Tabela) zavisneTabele.get(i));
			cvoroviTabela.add(ct);
		}
		for (int i = 0; i < cvoroviTabela.size(); i++) {
			Tabela ti = cvoroviTabela.get(i).getTabela();
			for (int j = 0; j < cvoroviTabela.size(); j++) {

				Tabela tj = cvoroviTabela.get(j).getTabela();
				for (int p = 0; p < tj.getStraniKljuc().size(); p++) {
					if (tj != ti) {
						if (tj.getStraniKljuc().get(p)
								.getIdReferenciraneTabele().equals(ti.getId())) {
							cvoroviTabela.get(i).Dodaj(cvoroviTabela.get(j));
							break;
						}
					}
				}

			}
		}
		
		CvorSistem sistem = (CvorSistem) GlavniProzor.getInstance().getStablo()
				.getModel().getRoot();
		sistem = (CvorSistem) prodjiKrozStablo(sistem);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(GlavniProzor.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}