package crud.fabrike;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Kolona;
import view.GlavniProzor;
import view.Meni;

/**
 * <code>FabrikaDatoteka</code> kreira panel sa file chooser-om i tekstualnim poljem.
 * @author Zivko Stanisic
 *
 */
public class FabrikaDatoteka implements ApstraktnaFabrikaElementi {
	private JPanel panel;
	private JButton dugme;
	private JTextField text;
	
	@Override
	public Object kreirajElement(Kolona kolona) {
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel labela = new JLabel(kolona.getIme().get(Meni.JEZIK));
		text = new JTextField(30);

		dugme = new JButton();
		dugme.setText(GlavniProzor.getInstance().getResourceBundle().getString("browse"));
		dugme.setFocusable(false);

		panel.add(labela);
		panel.add(text);
		panel.add(dugme);

		return panel;

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getDugme() {
		return dugme;
	}

	public void setDugme(JButton dugme) {
		this.dugme = dugme;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}
	

}
