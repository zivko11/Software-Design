package model;

/**
 * <code>Podsistem</code> sadrzi u sebi <code>tabele</code>,
 * takodje su podrzazumevani <code>paketi</code> i drugi <code>podsistemi</code>.
 * <code>ime</code> moze biti na vise jezika.
 * @author Zivko Stanisic
 */
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Podsistem {
	@JsonProperty("name")
	private ArrayList<String> ime;

	@JsonProperty("id")
	private String id;

	@JsonProperty("package")
	private ArrayList<Paket> paketi;
	
	@JsonProperty("subsystem")
	private ArrayList<Podsistem> podsistemi;

	@JsonProperty("tabels")
	private ArrayList<Tabela> tabele;
	
	public Podsistem() {
		ime = new ArrayList<String>();
		paketi = new ArrayList<Paket>();
		podsistemi = new ArrayList<Podsistem>();
		tabele = new ArrayList<Tabela>();
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
	 * Dodaje ime u trenutni podsistem
	 * 
	 * @param ime
	 */
	public void dodajIme(String ime) {
		this.ime.add(ime);
	}

	/**
	 * Dodavanje podsistema u trenutni podsistem.
	 * 
	 * @param podsistem
	 */
	public void dodajPodistem(Podsistem podsistem) {
		podsistemi.add(podsistem);
	}

	/**
	 * Uklanjanje podsistema iz trenutnog podsistema.
	 * 
	 * @param podistem
	 */
	public void ukloniPodsistem(Podsistem podistem) {
		podsistemi.remove(podistem);
	}

	/**
	 * Dodaje paket u podsistem.
	 * 
	 * @param paket
	 */
	public void dodajPaket(Paket paket) {
		paketi.add(paket);
	}

	/**
	 * Uklanja paket iz podsistema.
	 * 
	 * @param paket
	 */
	public void ukloniPaket(Paket paket) {
		paketi.remove(paket);
	}

	/*
	 * Dodaje tabelu u podsistem.
	 * 
	 * @param tabela
	 */
	public void dodajTabelu(Tabela tabela) {
		tabele.add(tabela);
	}

	/**
	 * Uklanja tabelu iz podsistema.
	 * 
	 * @param tabela
	 */
	public void ukloniTabelu(Tabela tabela) {
		tabele.remove(tabela);
	}

	public ArrayList<Paket> getPaketi() {
		return paketi;
	}

	public void setPaketi(ArrayList<Paket> paketi) {
		this.paketi = paketi;
	}

	public ArrayList<Tabela> getTabele() {
		return tabele;
	}

	public void setTabele(ArrayList<Tabela> tabele) {
		this.tabele = tabele;
	}

	public ArrayList<Podsistem> getPodsistemi() {
		return podsistemi;
	}

	public void setPodsistemi(ArrayList<Podsistem> podsistemi) {
		this.podsistemi = podsistemi;
	}

}