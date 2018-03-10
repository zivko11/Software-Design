package stablo.model;

/**
 * <code>SlozeniCvor</code> prestavlja interfejs za dodavanje i uklanjanje cvorova iz stabla.
 * @author Zivko Stanisic
 *
 */

public interface SlozenCvor {
	/**
	 * Dodaj cvor potomka.
	 * 
	 * @param potomak
	 */
	public void Dodaj(Object potomak);

	/**
	 * Ukloni cvor potomka.
	 * 
	 * @param potomak
	 */
	public void Ukloni(Object potomak);
	
	/**
	 * Promeni ime cvora u odnosu na jezik.
	 * @param oznaka
	 */
	public void setIme(int oznaka);
}
