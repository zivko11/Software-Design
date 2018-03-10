package model;

/**
 * U tabelama (<code>Tabela</code>) se prikazuju podaci. 
 * Sacinjena je od kolona (<code>kolone</code>).
 * <code>ime</code> moze biti na vise jezika.
 * @author Zivko Stanisic
 */
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tabela {
	@JsonProperty("name")
	private ArrayList<String> ime;
	@JsonProperty("id")
	private String id;
	@JsonProperty("column")
	private ArrayList<Kolona> kolone;
	@JsonProperty("Primary_keys")
	private ArrayList<PrimarniKljuc> primarniKljuc;
	@JsonProperty("Foreign_keys")
	private ArrayList<StraniKljuc> straniKljuc;

	public Tabela() {
		ime = new ArrayList<String>();
		kolone = new ArrayList<Kolona>();
		primarniKljuc = new ArrayList<PrimarniKljuc>();
		straniKljuc = new ArrayList<StraniKljuc>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getIme() {
		return ime;
	}

	public void setIme(ArrayList<String> ime) {
		this.ime = ime;
	}

	/**
	 * Dodaje ime u trenutnu tabelu.
	 * 
	 * @param ime
	 */
	public void dodajIme(String ime) {
		this.ime.add(ime);
	}

	/**
	 * Dodaje kolonu u tabelu.
	 * 
	 * @param kolona
	 */
	public void dodajKolonu(Kolona kolona) {
		kolone.add(kolona);
	}

	/**
	 * Uklanja kolonu iz tabele.
	 * 
	 * @param kolona
	 */
	public void ukloniKolonu(Kolona kolona) {
		kolone.remove(kolona);
	}
	
	/**
	 *  Dodaje strani kljuc u tabelu.
	 * 
	 */
	public void dodajStraniKljuc(StraniKljuc sk) {
		this.straniKljuc.add(sk);
	}
	
	public ArrayList<Kolona> getKolone() {
		return kolone;
	}

	public void setKolone(ArrayList<Kolona> kolone) {
		this.kolone = kolone;
	}

	public ArrayList<PrimarniKljuc> getPrimarniKljuc() {
		return primarniKljuc;
	}

	public void setPrimarniKljuc(ArrayList<PrimarniKljuc> primarniKljuc) {
		this.primarniKljuc = primarniKljuc;
	}

	public ArrayList<StraniKljuc> getStraniKljuc() {
		return straniKljuc;
	}

	public void setStraniKljuc(ArrayList<StraniKljuc> straniKljuc) {
		this.straniKljuc = straniKljuc;
	}
}