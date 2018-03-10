package stablo.model;

/**
 * <code>CvorSistem</code> je cvor u stablu koji sadrzi model sistema (<code>sistem<code>).
 * @author Zivko Stanisic
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import model.Sistem;
import view.GlavniProzor;

public class CvorSistem implements SlozenCvor, TreeNode {
	private Sistem sistem;
	private ArrayList<TreeNode> clanovi;
	private String ime;

	public CvorSistem() {
		clanovi = new ArrayList<TreeNode>();
	}

	public Sistem getSistem() {
		return sistem;
	}

	public void setSistem(Sistem sistem) {
		ime = sistem.getIme().get(0);
		this.sistem = sistem;
	}

	public String getIme() {
		return ime;
	}

	@Override
	public void setIme(int oznaka) {
		if (oznaka == 0) {
			ime = sistem.getIme().get(0);
		} else if (oznaka == 1) {
			ime = sistem.getIme().get(1);
		} else {
			ime = sistem.getIme().get(0);
		}
	}

	@Override
	public void Dodaj(Object potomak) {
		if (potomak instanceof CvorPodsistem) {
			clanovi.add((CvorPodsistem) potomak);
		} else {
			JOptionPane.showMessageDialog(null,
					GlavniProzor.getInstance().getResourceBundle().getString("parsDosloDoGreske"),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void Ukloni(Object potomak) {
		if (potomak instanceof CvorPodsistem) {
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