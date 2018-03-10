package model;

/**
 * Paket sadrzi <code>tabele</code>, <code>ime</code> moze biti na raznim jezicima.
 * @author Zivko Stanisic
 */
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paket {
	@JsonProperty("name")
	private ArrayList<String> ime;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("table")
	private ArrayList<Tabela> tabele;

	@JsonProperty("package")
	private ArrayList<Paket> podpaketi;
	
	public Paket() {
		ime = new ArrayList<String>();
		tabele = new ArrayList<Tabela>();
		podpaketi = new ArrayList<Paket>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Paket> getPodpaketi() {
		return podpaketi;
	}

	public void setPodpaketi(ArrayList<Paket> podpaketi) {
		this.podpaketi = podpaketi;
	}

	public ArrayList<String> getIme() {
		return ime;
	}

	public void setIme(ArrayList<String> ime) {
		this.ime = ime;
	}

	public ArrayList<Tabela> getTabele() {
		return tabele;
	}

	public void setTabele(ArrayList<Tabela> tabele) {
		this.tabele = tabele;
	}

	/**
	 * Dodavanje nove tabele u paket.
	 * 
	 * @param tabela
	 */
	public void dodajTabelu(Tabela tabela) {
		tabele.add(tabela);
	}

	/**
	 * Uklanjanje postojece tabele iz paketa.
	 * 
	 * @param tabela
	 */
	public void ukloniTabelu(Tabela tabela) {
		tabele.remove(tabela);
	}
	
	/**
	 * Dodaje ime u trenutni paket
	 * 
	 * @param ime
	 */
	public void dodajIme(String ime) {
		this.ime.add(ime);
	}

}