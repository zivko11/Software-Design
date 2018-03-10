package model;

/**
 * <code>Sistem</code> predstavlja vrh hierarhije.
 * <code>podsistemi</code> su jedino sadrzani u sistemu.
 * <code>ime</code> moze biti na vise jezika.
 * @author Zivko Stanisic
 */
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sistem {
	@JsonProperty("name")
	private ArrayList<String> ime;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("subsystem")
	private ArrayList<Podsistem> podsistemi;

	public Sistem() {
		ime = new ArrayList<String>();
		podsistemi = new ArrayList<Podsistem>();
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

	public ArrayList<Podsistem> getPodsistemi() {
		return podsistemi;
	}

	public void setPodsistemi(ArrayList<Podsistem> podsistemi) {
		this.podsistemi = podsistemi;
	}
	
	/**
	 * Dodaje ime u trenutni sistem
	 * 
	 * @param ime
	 */
	public void dodajIme(String ime) {
		this.ime.add(ime);
	}

	/**
	 * Dodaje podsistem u sistem.
	 * 
	 * @param podsistem
	 */
	public void dodajPodistsem(Podsistem podsistem) {
		podsistemi.add(podsistem);
	}

	/**
	 * Uklanja podsistem iz sistema.
	 * 
	 * @param Podsistem
	 */
	public void ukloniPodsistem(Podsistem Podsistem) {
		podsistemi.remove(Podsistem);
	}

}