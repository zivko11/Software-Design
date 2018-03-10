/**
 * Paket gde se nalazi model stabla.
 */
package stablo.model;

/**
 * <code>CvorPaket</code> je cvor u stablu koji sadrzi model paketa (<code>paket<code>).
 * @author Zivko Stanisic
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import model.Paket;
import view.GlavniProzor;

public class CvorPaket implements SlozenCvor, TreeNode {
	private Paket paket;
	private ArrayList<TreeNode> clanovi;
	private String ime;

	public CvorPaket() {
		clanovi = new ArrayList<TreeNode>();
	}

	public Paket getPaket() {
		return paket;
	}

	public void setPaket(Paket paket) {
		ime = paket.getIme().get(0);
		this.paket = paket;
	}

	public String getIme() {
		return ime;
	}

	@Override
	public void setIme(int oznaka) {
		if (oznaka == 0) {
			ime = paket.getIme().get(0);
		} else if (oznaka == 1) {
			ime = paket.getIme().get(1);
		} else {
			ime = paket.getIme().get(0);
		}
	}

	@Override
	public void Dodaj(Object potomak) {
		if (potomak instanceof CvorTabela) {
			clanovi.add((CvorTabela) potomak);
		} else if (potomak instanceof CvorPaket) {
			clanovi.add((CvorPaket) potomak);
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
				clanovi.remove((CvorTabela) potomak);
			} else {
				JOptionPane.showMessageDialog(null,
						GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
						GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (potomak instanceof CvorPaket) {
			int index = getIndex((TreeNode) potomak);
			if (getChildAt(index) != null) {
				clanovi.remove((CvorPaket) potomak);
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

	@Override
	public String toString() {
		return ime;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration children() {
		return Collections.enumeration(clanovi);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
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
		return false;
	}

}