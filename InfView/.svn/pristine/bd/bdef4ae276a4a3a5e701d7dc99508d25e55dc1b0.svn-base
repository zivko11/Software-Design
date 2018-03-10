package parsiranje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Sistem;
import model.Tabela;
import parsiranje.fabrike.KonkretnaFabrikaCvorSistem;
import stablo.model.CvorSistem;
import stablo.model.MojModelStabla;
import view.GlavniProzor;

/**
 * <code>Parser</code> je konkretna implementacija <code>ParserInterface </code>
 * interfejsa.
 * 
 * @author Nikola Stojanovic
 *
 */
public class Parser extends Observable implements ParserInterface {
	public static ArrayList<Tabela> zavisneTabele = new ArrayList<Tabela>();

	public Parser() {
		super();
	}

	public void notifyObservers() {

	}

	/**
	 * Parsira zadani tekst i model ubacuje u stablo.
	 * 
	 * @param tekst
	 *            Tekst koji ce se parsirati
	 * @return true ako je operacija uspesna
	 */
	@Override
	public boolean parsiraj(String tekst) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Ucitavanje JSON objekta
			Sistem sistem = mapper.readValue(tekst, Sistem.class);

			// Dodavanje modela u stablo
			zavisneTabele.removeAll(zavisneTabele);
			KonkretnaFabrikaCvorSistem fabrika = new KonkretnaFabrikaCvorSistem();
			CvorSistem sistemCvor = (CvorSistem) fabrika.kreirajCvor(sistem);

			MojModelStabla mms = new MojModelStabla((TreeNode) sistemCvor);
			GlavniProzor.getInstance().getStabloKontroler().setModel(mms);
			GlavniProzor.getInstance().getStablo().dodajZavisneTabele();
			return true;

		} catch (IOException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),
					GlavniProzor.getInstance().getResourceBundle().getString("SchemaErrorTitle"),
					GlavniProzor.getInstance().getResourceBundle().getString("ErrorTitle"), JOptionPane.ERROR_MESSAGE);

			return false;
		}
	}

}