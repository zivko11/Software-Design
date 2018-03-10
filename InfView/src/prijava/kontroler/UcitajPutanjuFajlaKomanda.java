package prijava.kontroler;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

import parsiranje.Komanda;
import parsiranje.Parser;
import prijava.ValidatorJsonPrijave;
import view.GlavniProzor;

/**
 * 
 * @author Nikola Stojanovic
 * 
 *         Komanda za ucitavanje putanje do JSON seme
 *
 */
public class UcitajPutanjuFajlaKomanda implements Komanda {

	private JFrame parent;
	private JTextField txtField;
	private JTextField userNameTxt;
	private JPasswordField passTxt;

	public UcitajPutanjuFajlaKomanda(JFrame parent, JTextField txtField, JTextField userNameTxt,
			JPasswordField passTxt) {
		super();
		this.parent = parent;
		this.txtField = txtField;
		this.userNameTxt = userNameTxt;
		this.passTxt = passTxt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see parsiranje.Komanda#izvrsi()
	 */
	@Override
	public void izvrsi() {
		ValidatorJsonPrijave vjp = new ValidatorJsonPrijave();
		if (vjp.overi(userNameTxt.getText(), new String(passTxt.getPassword()))) {
			Parser par = new Parser();
			try {
				if (txtField.getText().equals(null) || txtField.getText().equals("")) {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(),
							GlavniProzor.getInstance().getResourceBundle().getString("noFileError"),
							GlavniProzor.getInstance().getResourceBundle().getString("ErrorTitle"),
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (GlavniProzor.getInstance().getAktivniKorisnik().isPravoPristupa()) {
						String path = System.getProperty("user.dir");
						path += File.separatorChar + "seme" + File.separatorChar + "korisnici.json";
						String tekst = FileUtils.readFileToString(new File(path), "UTF-8");
						par.parsiraj(tekst);
						GlavniProzor.getInstance().setPutanjaDoFajla(path);
					} else {
						String tekst = FileUtils.readFileToString(new File(txtField.getText()), "UTF-8");
						par.parsiraj(tekst);
						GlavniProzor.getInstance().setPutanjaDoFajla(txtField.getText());
					}
					parent.setVisible(false);
					GlavniProzor.getInstance().setVisible(true);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(),
						GlavniProzor.getInstance().getResourceBundle().getString("IOException"),
						GlavniProzor.getInstance().getResourceBundle().getString("ErrorTitle"),
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
