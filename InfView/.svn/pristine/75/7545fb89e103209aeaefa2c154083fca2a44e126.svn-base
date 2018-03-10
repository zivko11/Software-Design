/**
 * Paket sa osnovnim GUI elementima.
 */
package view;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import editor.OtvaranjeEditoraAkcija;


/**
 * Klasa <code>AlatnaTraka</code> predstavlja osnovni izgled toolbara.
 * 
 * @author Stefan Pandzic
 */
@SuppressWarnings("serial")
public class AlatnaTraka extends JToolBar {

	public AlatnaTraka() {
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit schema");
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		btnEdit.setFocusable(false);
		btnEdit.addActionListener(new OtvaranjeEditoraAkcija());
		btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEdit.setEnabled(GlavniProzor.getInstance().isEditable());
		
		add(btnEdit);
	}

}