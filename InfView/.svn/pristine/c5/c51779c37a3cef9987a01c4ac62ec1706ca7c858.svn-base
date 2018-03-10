/**
 * Paket u kome je implementirano stablo.
 */
package stablo;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;

/**
 * <code>EditorCelije</code> predstavlja skup pravila kako ce se menjati stablo u toku rada.
 * @author Zivko Stanisic
 *
 */
public class EditorCelije extends DefaultTreeCellEditor {

	/**
	 * Konstruktor sa parametrima.
	 * 
	 * @param stablo
	 * @param render
	 */
	public EditorCelije(JTree stablo, DefaultTreeCellRenderer render) {
		super(stablo, render);
		// TODO Auto-generated constructor stub
	}

	public EditorCelije(JTree stablo, DefaultTreeCellRenderer render,
			TreeCellEditor editor) {
		super(stablo, render, editor);
	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value,
			boolean isSelected, boolean expanded, boolean leaf, int row) {
		return super.getTreeCellEditorComponent(tree, value, isSelected,
				expanded, leaf, row);
	}

	@Override
	public Object getCellEditorValue() {
		return super.getCellEditorValue();
	}

	/**
	 * Ne dozvoljava izmenu stabla.
	 */
	@Override
	public boolean stopCellEditing() {
		return true;
	}

}
