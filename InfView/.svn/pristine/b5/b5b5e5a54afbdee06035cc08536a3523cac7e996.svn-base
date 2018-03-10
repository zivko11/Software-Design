package view;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import editor.SacuvajSemuAkcija;
import net.miginfocom.swing.MigLayout;
import parsiranje.OdustaniAkcija;
import parsiranje.Parser;
import validator.ValidatorSintakse;

/**
 * Klasa <code>Editor</code> opisuje editor seme. Sastoji se od polja za unos
 * tekstualnog opisa seme, parsera i validatora sintakse
 * 
 * @author Nikola Stojanovic
 */

@SuppressWarnings("serial")
public class Editor extends JDialog {

	private Parser parser; // ova polje je mozda visak ovde?
	private TekstEditor tekstEditor;
	private ValidatorSintakse validatorSintakse; // ovo polje je mozda visak ovde?

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public TekstEditor getTekstEditor() {
		return tekstEditor;
	}

	public void setTekstEditor(TekstEditor tekstEditor) {
		this.tekstEditor = tekstEditor;
	}

	public ValidatorSintakse getValidatorSintakse() {
		return validatorSintakse;
	}

	public void setValidatorSintakse(ValidatorSintakse validatorSintakse) {
		this.validatorSintakse = validatorSintakse;
	}

	public Editor() {
		setModal(true);

		JPanel cp = new JPanel(new MigLayout());
		validatorSintakse = new ValidatorSintakse();
		this.parser = new Parser();
		this.validatorSintakse = new ValidatorSintakse();
		tekstEditor = new TekstEditor(40, 100);
		tekstEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
		tekstEditor.setCodeFoldingEnabled(true);
		this.setLayout(new MigLayout("fill"));
		
		//ikonica
		ImageIcon icon = new ImageIcon("images/db.png");
		setIconImage(icon.getImage());

		// cita tekst iz fajla i upisuje ga u tekst editor
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(GlavniProzor.getInstance().getPutanjaDoFajla()), "UTF-8"))) {
			String text = null;
			while ((text = br.readLine()) != null) {
				tekstEditor.append(text + "\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		RTextScrollPane sp = new RTextScrollPane(tekstEditor);
		cp.add(sp);

		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new SacuvajSemuAkcija(this));
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new OdustaniAkcija(this));
		btnPane.add(saveBtn);
		btnPane.add(cancelBtn);
		add(sp, "span, dock north");
		add(btnPane, "span, dock south");
		setTitle("JSON Schema editor");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
}