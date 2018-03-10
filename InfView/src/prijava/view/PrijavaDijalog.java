/**
 * Paket koji sadrzi pocetni dijalog.
 */
package prijava.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import parsiranje.OdustaniAkcija;
import prijava.kontroler.IzaberiFajlAkcija;
import prijava.kontroler.PrijavaAkcija;
import prijava.kontroler.UcitajPutanjuFajlaAkcija;
import view.GlavniProzor;

/**
 * Klasa predstavlja pocetni dijalog.
 * 
 * @author Nikola Stojanovic
 */
@SuppressWarnings("serial")
public class PrijavaDijalog extends JFrame {

	private JLabel korImeLabela = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("korisnickoIme"));
	private JLabel pswLabela = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("sifra"));
	private JLabel jsonLabela = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("JSONFile"));
	private JButton browseDugme;
	private JPanel centerPane;
	private JTextField korIme = new JTextField(30);
	private JPasswordField sifra = new JPasswordField(30);
	private JTextField putanjaDoFajlaPolje = new JTextField(30);
	private JLabel lang;
	private JRadioButton engBtn;
	private JRadioButton srbBtn;
	private JLabel dbType;
	private JButton okBtn;
	private JButton cancelBtn;
	private JRadioButton sqlBtn;
	private JRadioButton jsonBtn;
	private PrijavaAkcija prAkcija;
	private UcitajPutanjuFajlaAkcija ucitajFajlAkcija;

	public PrijavaDijalog() {
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//ikonica
		ImageIcon icon = new ImageIcon("images/db.png");
		setIconImage(icon.getImage());
		
		centerPane = new JPanel(new MigLayout());

		sqlBtn = new JRadioButton(GlavniProzor.getInstance().getResourceBundle().getString("SQLBp"));
		sqlBtn.setSelected(true);
		sqlBtn.addActionListener(new SqlSelekcija());

		jsonBtn = new JRadioButton(GlavniProzor.getInstance().getResourceBundle().getString("JSONRes"));
		jsonBtn.addActionListener(new JsonSelekcija());

		ButtonGroup dbRadioGroup = new ButtonGroup();
		dbRadioGroup.add(sqlBtn);
		dbRadioGroup.add(jsonBtn);

		lang = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("izaberiJezik"));
		engBtn = new JRadioButton(GlavniProzor.getInstance().getResourceBundle().getString("engleski"));
		engBtn.setSelected(false);
		engBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en", "US"));
				GlavniProzor.getInstance().changeLanguage();
				initComponents();
			}
		});

		srbBtn = new JRadioButton(GlavniProzor.getInstance().getResourceBundle().getString("srpski"));
		srbBtn.setSelected(true);
		srbBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				GlavniProzor.getInstance().changeLanguage();
				initComponents();
			}
		});

		// dugme za izbor json fajla
		browseDugme = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("browse"));
		browseDugme.addActionListener(new IzaberiFajlAkcija(putanjaDoFajlaPolje, this));

		ButtonGroup langBtnGroup = new ButtonGroup();
		langBtnGroup.add(engBtn);
		langBtnGroup.add(srbBtn);
		JPanel northPane = new JPanel(new MigLayout());
		dbType = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("tipBaze"));
		northPane.add(dbType);
		northPane.add(sqlBtn, "split 2");
		northPane.add(jsonBtn, "wrap");
		northPane.add(lang);

		northPane.add(engBtn, "split 2");
		northPane.add(srbBtn, "wrap");
		
		northPane.add(korImeLabela);
		northPane.add(korIme, "wrap");
		
		northPane.add(pswLabela);
		northPane.add(sifra);

		okBtn = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("OK"));
		prAkcija = new PrijavaAkcija(this, korIme, sifra);
		ucitajFajlAkcija = new UcitajPutanjuFajlaAkcija(this, putanjaDoFajlaPolje, korIme, sifra);
		okBtn.addActionListener(prAkcija);
		cancelBtn = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("odustani"));
		cancelBtn.addActionListener(new OdustaniAkcija(this));
		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPane.add(okBtn);
		btnPane.add(cancelBtn);

		add(northPane, BorderLayout.NORTH);
		add(centerPane, BorderLayout.CENTER);
		add(btnPane, BorderLayout.SOUTH);
		validate();
		pack();
	}

	public void initComponents() {
		lang.setText(GlavniProzor.getInstance().getResourceBundle().getString("izaberiJezik"));
		engBtn.setText(GlavniProzor.getInstance().getResourceBundle().getString("engleski"));
		srbBtn.setText(GlavniProzor.getInstance().getResourceBundle().getString("srpski"));
		dbType.setText(GlavniProzor.getInstance().getResourceBundle().getString("tipBaze"));
		okBtn.setText(GlavniProzor.getInstance().getResourceBundle().getString("OK"));
		cancelBtn.setText(GlavniProzor.getInstance().getResourceBundle().getString("odustani"));
		korImeLabela.setText(GlavniProzor.getInstance().getResourceBundle().getString("korisnickoIme"));
		pswLabela.setText(GlavniProzor.getInstance().getResourceBundle().getString("sifra"));
		jsonLabela.setText(GlavniProzor.getInstance().getResourceBundle().getString("JSONFile"));
		browseDugme.setText(GlavniProzor.getInstance().getResourceBundle().getString("browse"));
		sqlBtn.setText(GlavniProzor.getInstance().getResourceBundle().getString("SQLBp"));
		jsonBtn.setText(GlavniProzor.getInstance().getResourceBundle().getString("JSONFile"));
	}

	private class SqlSelekcija implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// ukoliko je izabrano sql dugme, menjamo centralni panel u skladu s tim i
			// ok dugmetu uklanjamo stari i dodajemo novi action listener
			centerPane.removeAll();
			centerPane.repaint();
			centerPane.revalidate();
			pack();
			okBtn.removeActionListener(ucitajFajlAkcija);
			okBtn.addActionListener(prAkcija);
		}

	}

	private class JsonSelekcija implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// ukoliko je izabrano json dugme, menjamo centralni panel u skladu s tim i
			// ok dugmetu uklanjamo stari i dodajemo novi action listener
			centerPane.removeAll();
			centerPane.repaint();
			centerPane.add(jsonLabela);
			centerPane.add(putanjaDoFajlaPolje);
			centerPane.add(browseDugme, "wrap");
			centerPane.revalidate();
			okBtn.removeActionListener(prAkcija);
			okBtn.addActionListener(ucitajFajlAkcija);
			pack();
		}

	}
}
