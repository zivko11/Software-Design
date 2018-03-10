package prijava.kontroler;

import java.awt.Window;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import parsiranje.Komanda;
import view.GlavniProzor;

/**
 * Komanda za izbor fajla pomocu <code>JFileChooser</code> klase
 * 
 * @author Nikola Stojanovic
 *
 */
public class IzaberiFajlKomanda implements Komanda {

	private JTextField fileField;
	private Window parent;

	public IzaberiFajlKomanda(JTextField fileField, Window parent) {
		this.fileField = fileField;
		this.parent = parent;
	}

	@Override
	public void izvrsi() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				GlavniProzor.getInstance().getResourceBundle().getString("JSONSchema"), "json");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		int retVal = fileChooser.showOpenDialog(parent);
		if (retVal == JFileChooser.APPROVE_OPTION)
			fileField.setText(fileChooser.getSelectedFile().getAbsolutePath());
	}

}
