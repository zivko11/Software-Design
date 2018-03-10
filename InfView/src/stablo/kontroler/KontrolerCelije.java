/**
 * paket za kontroler stabla.
 */
package stablo.kontroler;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.Tabela;
import stablo.Stablo;
import stablo.model.CvorTabela;
import stablo.model.MojModelStabla;
import tabele.PrioritetnatabelaPanel;
import tabele.SekundarnaTabelaPanel;
import tabele.model.TabelaModel;
import view.GlavniProzor;
import view.ProstorZaTabele;

/**
 * <code>KontrolerCelije</code> je akcija za kreiranje tabova pri interakcije sa stablom.
 * @author Zivko Stanisic
 *
 */
public class KontrolerCelije implements TreeSelectionListener {
	
	private Stablo view;
	private MojModelStabla model;
	
	public KontrolerCelije(Stablo view, MojModelStabla model) {
		this.view = view;
		this.model = model;
	}
	
	/*
	 * Prikaz taba tabele klikom na stablo.
	 */
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		
		Object root = GlavniProzor.getInstance().getStablo()
				.getLastSelectedPathComponent();
		if (root instanceof CvorTabela) {
			CvorTabela ct = (CvorTabela)root;
			
			ProstorZaTabele glavniPzt = GlavniProzor.getInstance().getProstorZaTabele();
			if(!glavniPzt.proveraDalVecPostoji(ct.getTabela().getId())) {
				TabelaModel tabelaModel = new TabelaModel(ct);
				PrioritetnatabelaPanel gornjaTabela = new PrioritetnatabelaPanel(tabelaModel);
				glavniPzt.DodajTab(ct.getTabela().getIme().get(0), gornjaTabela);
				for(int i = 0; i < ct.getChildCount(); i++) {
					CvorTabela ctChild = (CvorTabela)ct.getChildAt(i);
					TabelaModel tabelaChildModel = new TabelaModel(ctChild);
					SekundarnaTabelaPanel donjaTabela = new SekundarnaTabelaPanel(tabelaChildModel);
					gornjaTabela.getProstorZaTabele().DodajTab(ctChild.getTabela().getIme().get(0), donjaTabela);
				}
			}
		}
		
		/*
		Object root = GlavniProzor.getInstance().getStablo()
				.getLastSelectedPathComponent();
		if (root instanceof CvorTabela) {
			int count = GlavniProzor.getInstance().getProstorZaTabele()
					.getTabCount();

			if (count == 0) {
				GlavniProzor.getInstance().getProstorZaTabele().DodajTab();
				return;
			}

			for (int i = 0; i < count; i++) {
				String title = GlavniProzor.getInstance().getProstorZaTabele()
						.getTitleAt(i);

				if (title.equals(((CvorTabela) root).toString())) {
					GlavniProzor.getInstance().getProstorZaTabele()
							.setSelectedIndex(i);
					return;
				}
			}
			GlavniProzor.getInstance().getProstorZaTabele().DodajTab();
		}
		*/

	}

	public void setSelektovanTabelaCvor(CvorTabela cvorTabela) {
		TreePath tp = new TreePath(cvorTabela);
		view.setSelectionPath(tp);
		view.scrollPathToVisible(tp);
	}
	
	public boolean setSelektovanTabelaCvor(Tabela tabela) {
		CvorTabela ct = getCvorTabele(tabela);
		if(ct == null) return false;
		TreePath tp = new TreePath(ct);
		view.setSelectionPath(tp);
		view.scrollPathToVisible(tp);
		return true;
	}
	
	/**
	 * Vraca pronadjeni cvor tabele koja je prosledjena, u suprotnom vraca null.
	 * @param tabela
	 * @return
	 */
	public CvorTabela getCvorTabele(Tabela tabela) {
		
		TreeNode root = (TreeNode) model.getRoot();
		TreeNode node = null;
		@SuppressWarnings("rawtypes")
		Enumeration e = root.children();
	    while (e.hasMoreElements()) {
	      node = (TreeNode) e.nextElement();
	      if(node instanceof CvorTabela) {
	    	  CvorTabela ct = (CvorTabela) node;
		      if (ct.getTabela().getId().equals(tabela.getId())) {
		        return ct;
		      }
	      }
	    }
		return null;
	}
	
	/**
	 * Vraca listu roditeljskih cvorova u stablu, ukoliko je lista prazna vraca null.
	 * @param cvorTabela
	 * @return
	 */
	public ArrayList<CvorTabela> getSveCvoroveRoditelja(CvorTabela cvorTabela) {
		ArrayList<CvorTabela> listaRoditelja = new ArrayList<CvorTabela>();
		
	    TreeNode root = (TreeNode) model.getRoot();
	    
	    pretragaCvoraPoID(cvorTabela.getTabela().getId(), root, listaRoditelja);
	    
	    if(listaRoditelja.isEmpty()) return null;
	    
		return listaRoditelja;
	}
	
	/**
	 * Pretrazuje sve cvorove prosledjenog roditeljskog cvora i dodaje roditelja u listu na osnovu prosledjenog id-a deteta.
	 * @param id
	 * @param ParentNode
	 * @param listaRoditelja
	 */
	private void pretragaCvoraPoID(String id ,TreeNode ParentNode, ArrayList<CvorTabela> listaRoditelja) {
		TreeNode node = null;
		@SuppressWarnings("rawtypes")
		Enumeration e = ParentNode.children();
	    while (e.hasMoreElements()) {
	      node = (TreeNode) e.nextElement();
	      System.out.println(node.toString());
	      if(node instanceof CvorTabela) {
	    	  CvorTabela ct = (CvorTabela) node;
		      if (ct.getTabela().getId().equals(id)) {
		    	  dodajRoditelja(listaRoditelja, (CvorTabela)ParentNode);
		      }
	      }
	      pretragaCvoraPoID(id, node, listaRoditelja);
	    }
	}
	
	/**
	 * Ukoliko ne postoji roditelj sa istim id, dodaje ga.
	 * @param listaRoditelja
	 * @param noviRoditelj
	 */
	private void dodajRoditelja(ArrayList<CvorTabela> listaRoditelja, CvorTabela noviRoditelj) {
		for(CvorTabela t : listaRoditelja) {
			if(t.getTabela().getId().equals(noviRoditelj.getTabela().getId())) return;
		}
		
		listaRoditelja.add(noviRoditelj);
	}

	public Stablo getView() {
		return view;
	}

	public void setView(Stablo view) {
		this.view = view;
	}

	public MojModelStabla getModel() {
		return model;
	}

	public void setModel(MojModelStabla model) {
		this.model = model;
		view.setModel(model);
	}
	
}
