package stablo.model;

/**
 * <code>CvorTabela</code> je cvor u stablu koji sadrzi model tabele (<code>tabela<code>).
 * @author Zivko Stanisic
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import model.Tabela;
import view.GlavniProzor;

public class CvorTabela implements SlozenCvor, TreeNode {
	private Tabela tabela;
	private ArrayList<TreeNode> clanovi;
	private String ime;

	public CvorTabela() {
		clanovi = new ArrayList<TreeNode>();

	}

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		ime = tabela.getIme().get(0);
		this.tabela = tabela;
	}

	public String getIme() {
		return ime;
	}

	@Override
	public void setIme(int oznaka) {
		if (oznaka == 0) {
			ime = tabela.getIme().get(0);
		} else if (oznaka == 1) {
			if (!GlavniProzor.getInstance().isEditable()) {
				ime = tabela.getIme().get(0);
			} else {
				ime = tabela.getIme().get(1);
			}
		} else {
			ime = tabela.getIme().get(0);
		}
	}

	@Override
	public String toString() {
		return ime;
	}

	@Override
	public void Dodaj(Object potomak) {
		if (potomak instanceof CvorTabela) {
			clanovi.add((CvorTabela) potomak);
		} else {
			JOptionPane.showMessageDialog(null,
					GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void Ukloni(Object potomak) {
		if (potomak instanceof CvorTabela) {
			int index = getIndex((TreeNode) potomak);
			if (getChildAt(index) != null) {
				clanovi.remove((TreeNode) potomak);
			} else {
				JOptionPane.showMessageDialog(null,
						GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
						GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration children() {
		return Collections.enumeration(clanovi);
	}

	@Override
	public boolean getAllowsChildren() {
		if (getChildCount() != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return clanovi.get(arg0);
	}

	@Override
	public int getChildCount() {
		return clanovi.size();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return clanovi.indexOf(arg0);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		if (getChildCount() != 0) {
			return true;
		} else {
			return false;
		}
	}

}