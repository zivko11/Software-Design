package model;

/**
 * <code>PrimarniKljuc</code> moze da bude deo kolone.
 * Sluzi da se identifikuje slog iz tabele.
 * Cine ga <code>imeKolone</code> sto predstavlja koju kolonu oznacava
 * i <code>imeTabele</code> sto oznacava u kojoj tabeli se nalazi.
 * @author Zivko Stanisic
 */
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimarniKljuc {
	@JsonProperty("Id")
	private String id;
	@JsonProperty("Column_name")
	private ArrayList<String> imeKolone;
	@JsonProperty("Table_name")
	private ArrayList<String> imeTabele;

	public PrimarniKljuc() {
		imeKolone = new ArrayList<String>();
		imeTabele = new ArrayList<String>();
	}
	
	public void dodajImeKolone(String ime) {
		this.imeKolone.add(ime);
	}
	
	public void dodajImeTabele(String ime) {
		this.imeTabele.add(ime);
	}

	public ArrayList<String> getImeKolone() {
		return imeKolone;
	}

	public void setImeKolone(ArrayList<String> imeKolone) {
		this.imeKolone = imeKolone;
	}

	public ArrayList<String> getImeTabele() {
		return imeTabele;
	}

	public void setImeTabele(ArrayList<String> imeTabele) {
		this.imeTabele = imeTabele;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}