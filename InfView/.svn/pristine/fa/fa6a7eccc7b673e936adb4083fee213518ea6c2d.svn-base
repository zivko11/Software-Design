/**
 * Paket koji sadrzi model korisnika.
 */
package korisnik.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Klasa koja opisuje model korisnika.
 * 
 * @author Nikola Stojanovic
 *
 */
public class Korisnik {

	@JsonProperty("label")
	private String oznaka;
	@JsonProperty("userName")
	private String korisnickoIme;
	@JsonProperty("password")
	private String sifra;
	@JsonProperty("access")
	private boolean pravoPristupa;

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public boolean isPravoPristupa() {
		return pravoPristupa;
	}

	public void setPravoPristupa(boolean pravoPristupa) {
		this.pravoPristupa = pravoPristupa;
	}

	public Korisnik(String oznaka, String korisnickoIme, String sifra, boolean pravoPristupa) {
		super();
		this.oznaka = oznaka;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.pravoPristupa = pravoPristupa;
	}

	public Korisnik() {
		super();
	}

}
