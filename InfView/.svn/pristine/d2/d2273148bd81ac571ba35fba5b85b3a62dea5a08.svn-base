package crud.fabrike;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Meni;
import model.Kolona;

/**
 * <code>FabrikaTekst</code> kreira panel sa labelom imena 
 * informacionog resursa i tekstualnog polja.
 * @author Zivko Stanisic
 *
 */
public class FabrikaTekst implements ApstraktnaFabrikaElementi {
	private JTextField text;
	
	@Override
	public Object kreirajElement(Kolona kolona) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel labela = new JLabel();
		if(Meni.JEZIK == 0) {
			labela.setText(kolona.getIme().get(Meni.JEZIK));
		}else {
			labela.setText(kolona.getIme().get(0));
		}
		JTextField text = new JTextField(20);
		text.setMaximumSize(text.getPreferredSize());
		this.text = text;
		panel.add(labela);
		panel.add(text);

		return panel;

	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

}
