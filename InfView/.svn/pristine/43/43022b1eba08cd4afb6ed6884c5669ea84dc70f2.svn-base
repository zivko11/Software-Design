/**
 * Paket u kome se cuvaju podaci o informacionim resursima.
 */
package model;

/**
 * <code>Kolona</code> predstavlja kolonu u tabeli.
 * Sadrzi <code>ime</code> sto je niz imena na razlicitim jezicima,
 * <code>primarniKljuc</code> sto predstavlja da li je kolona primarni kljuc
 * i <code>straniKljuc</code> sto predstavlja da li je kolona strani kljuc.
 * @author Zivko Stanisic
 */

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kolona {
	@JsonProperty("name")
	private ArrayList<String> ime;
	@JsonProperty("id")
	private String id;
	@JsonProperty("type")
	private String tip;
	@JsonProperty("constraints")
	private String ogranicenja;

	public Kolona() {
		ime = new ArrayList<String>();
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getOgranicenja() {
		return ogranicenja;
	}

	public void setOgranicenja(String ogranicenja) {
		this.ogranicenja = ogranicenja;
	}
	
	/**
	 * Dodaje ime u trenutnu kolonu.
	 * 
	 * @param ime
	 */
	public void dodajIme(String ime) {
		this.ime.add(ime);
	}
	
}