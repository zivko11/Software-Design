package stablo;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import stablo.model.CvorPaket;
import stablo.model.CvorPodsistem;
import stablo.model.CvorSistem;
import stablo.model.CvorTabela;

/**
 * <code>RenderCelija</code> predstavlja prikaz slicica u zavisnosti od tipa cvora.
 * @author Zivko Stanisic
 *
 */
@SuppressWarnings("serial")
public class RenderCelije extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expended, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expended, leaf,
				row, hasFocus);

		if (value instanceof CvorSistem) {
			URL imageURL = getClass().getResource("/stablo/slike/sistem.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof CvorPodsistem) {
			URL imageURL = getClass()
					.getResource("/stablo/slike/podsistem.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof CvorPaket) {
			URL imageURL = getClass().getResource("/stablo/slike/paket.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof CvorTabela) {
			URL imageURL = getClass().getResource("/stablo/slike/tabela.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		}

		return this;
	}
}
