package crud.fabrike;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import model.Kolona;
import view.Meni;

/**
 * <code>FabrikaSelekcija</code> kreira panel sa selekcijom datuma.
 * @author Zivko Stanisic
 *
 */
public class FabrikaSelekcija implements ApstraktnaFabrikaElementi {
	private JSpinner timeSpinner;
	private JSpinner dateSpinner;

	@Override
	public Object kreirajElement(Kolona kolona) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel labela = new JLabel(kolona.getIme().get(Meni.JEZIK));
		panel.add(labela);

		timeSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		panel.add(timeSpinner);

		dateSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd");
		dateSpinner.setEditor(dateEditor);
		panel.add(dateSpinner);

		return panel;

	}

	public JSpinner getTime() {
		return timeSpinner;
	}

	public void setTime(JSpinner timeSpinner) {
		this.timeSpinner = timeSpinner;
	}

	public JSpinner getDate() {
		return dateSpinner;
	}

	public void setDate(JSpinner dateSpinner) {
		this.dateSpinner = dateSpinner;
	}

}
