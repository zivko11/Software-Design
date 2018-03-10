/**
 * Paket koji sadrzi dijalog za pretragu.
 */
package pretraga.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import parsiranje.OdustaniAkcija;
import pretraga.kontroler.PretraziAkcija;
import view.GlavniProzor;

/**
 * 
 * @author Nikola Stojanovic
 *
 *         Dijalog za pretragu podataka.
 */
@SuppressWarnings("serial")
public class PretragaDijalog extends JFrame {

	private JTextField minNum;
	private JTextField maxNum;
	private JTextField exactNum;
	private JFormattedTextField poljeDatum;
	private JTextField phraseTxt;
	private JCheckBox odBr;
	private JCheckBox doBr;
	private JCheckBox ukljuciBr;
	private JCheckBox ukljuciTxt;
	private JCheckBox ukljuciDate;
	private JRadioButton tacnaVrBtn;
	private JRadioButton rasponBtn;

	public PretragaDijalog() {
		setLayout(new BorderLayout());
		// setPreferredSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ikonica
		ImageIcon icon = new ImageIcon("images/db.png");
		setIconImage(icon.getImage());

		JPanel centerPane = new JPanel(new MigLayout());
		JPanel numPane = new JPanel(new MigLayout("fillx"));
		JPanel phrasePane = new JPanel(new MigLayout());
		JPanel datePane = new JPanel(new MigLayout());
		JLabel tacnaVrednost = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("tacnaVrednost") + ":");
		ukljuciBr = new JCheckBox(GlavniProzor.getInstance().getResourceBundle().getString("brPretragaOn"));
		ukljuciTxt = new JCheckBox(GlavniProzor.getInstance().getResourceBundle().getString("txtPretragaOn"));
		ukljuciDate = new JCheckBox(GlavniProzor.getInstance().getResourceBundle().getString("datePretragaOn"));
		odBr = new JCheckBox(GlavniProzor.getInstance().getResourceBundle().getString("od"));
		doBr = new JCheckBox(GlavniProzor.getInstance().getResourceBundle().getString("do"));
		tacnaVrBtn = new JRadioButton(GlavniProzor.getInstance().getResourceBundle().getString("tacnaVrednost"));
		rasponBtn = new JRadioButton(GlavniProzor.getInstance().getResourceBundle().getString("raspon"));
		rasponBtn.setSelected(true);
		ButtonGroup numGroup = new ButtonGroup();
		numGroup.add(tacnaVrBtn);
		numGroup.add(rasponBtn);
		minNum = new JTextField(12);
		maxNum = new JTextField(12);
		exactNum = new JTextField(12);
		DateFormat df = new SimpleDateFormat("DD/mm/yyyy");
		poljeDatum = new JFormattedTextField(df);
		poljeDatum.setColumns(12);
		phraseTxt = new JTextField(20);

		numPane.setBorder(BorderFactory
				.createTitledBorder(GlavniProzor.getInstance().getResourceBundle().getString("brPretraga")));
		numPane.add(rasponBtn);
		numPane.add(tacnaVrBtn, "wrap");
		numPane.add(odBr, "right");
		numPane.add(minNum, "wrap");
		numPane.add(doBr, "right");
		numPane.add(maxNum, "wrap");
		numPane.add(tacnaVrednost, "right");
		numPane.add(exactNum);

		phrasePane.setBorder(BorderFactory
				.createTitledBorder(GlavniProzor.getInstance().getResourceBundle().getString("txtPretraga")));
		phrasePane.add(phraseTxt, "wrap");

		datePane.setBorder(BorderFactory
				.createTitledBorder(GlavniProzor.getInstance().getResourceBundle().getString("datePretraga")));
		datePane.add(poljeDatum, "wrap");

		centerPane.add(ukljuciBr, "wrap");
		centerPane.add(numPane, "wrap");
		centerPane.add(ukljuciTxt, "wrap");
		centerPane.add(phrasePane, "wrap");
		centerPane.add(ukljuciDate, "wrap");
		centerPane.add(datePane, "wrap");
		JPanel southPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton srcBtn = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("pretraga"));
		JButton cancelBtn = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("odustani"));
		srcBtn.addActionListener(new PretraziAkcija());
		cancelBtn.addActionListener(new OdustaniAkcija(this));
		southPane.add(srcBtn);
		southPane.add(cancelBtn);

		add(centerPane, BorderLayout.CENTER);
		add(southPane, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable ex) {

		}

		Locale.setDefault(new Locale("sr", "RS"));
		PretragaDijalog pd = new PretragaDijalog();
		pd.setVisible(true);
	}
}
