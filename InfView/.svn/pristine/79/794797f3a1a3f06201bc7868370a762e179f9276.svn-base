package prijava.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import prijava.Prijava;
import prijava.ValidatorPrijave;

/**
 * @author Nikola Stojanovic
 * 
 *         Akcija koja instancira klasu <code>PrijavaKomanda</code>
 */
public class PrijavaAkcija implements ActionListener {

	private JFrame parent;
	private JTextField korImeArea;
	private JTextField sifraField;

	public PrijavaAkcija(JFrame parent, JTextField korImeArea, JTextField sifraField) {
		super();
		this.parent = parent;
		this.korImeArea = korImeArea;
		this.sifraField = sifraField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PrijavaKomanda pk = new PrijavaKomanda(parent,
				new ValidatorPrijave(new Prijava(korImeArea.getText(), sifraField.getText())));
		pk.izvrsi();
	}

}