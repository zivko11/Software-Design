package stablo.model;

/**
 * <code>MojModelStabla</code> predstavlja model stabla, tj. sadrzi sve cvorove koji preslikavaju modele.
 * @author Zivko Stanisic
 */

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

@SuppressWarnings("serial")
public class MojModelStabla extends DefaultTreeModel {

	/**
	 * Konstruktor sa parametrima.
	 * 
	 * @param root
	 */
	public MojModelStabla(TreeNode root) {
		super(root);
		setAsksAllowsChildren(true);
	}

}