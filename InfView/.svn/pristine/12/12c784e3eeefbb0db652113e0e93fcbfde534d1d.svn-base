package prijava.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * @author Nikola Stojanovic
 * 
 *         Akcija koja instancira <code>UcitajPutanjuFajlaKomanda</code>
 *
 */
public class UcitajPutanjuFajlaAkcija implements ActionListener {

	private JFrame parent;
	private JTextField txtField;
	private JTextField userNameTxt;
	private JPasswordField passTxt;

	public UcitajPutanjuFajlaAkcija(JFrame parent, JTextField txtField, JTextField userNameTxt,
			JPasswordField passTxt) {
		super();
		this.parent = parent;
		this.txtField = txtField;
		this.userNameTxt = userNameTxt;
		this.passTxt = passTxt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UcitajPutanjuFajlaKomanda ifk = new UcitajPutanjuFajlaKomanda(parent, txtField, userNameTxt, passTxt);
		ifk.izvrsi();
	}

}
