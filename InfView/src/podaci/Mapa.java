package podaci;

import java.util.ArrayList;

/**
 * <code>Mapa</code> predstavlja interfejs mape u kome se cuvaju uneti podaci.
 * @author Zivko Stanisic
 *
 */
public interface Mapa {
	
	/**
	 * Vraca iterator mape.
	 * @return
	 */
	
	public IteratorMape getIteratorMape();
	
	/**
	 * Vraca broj elemenata u mapi.
	 * @return
	 */
	public int brojElemenata();
	
	/**
	 * Dodaje novi element u mapu.
	 * @param kljuc
	 * @param element
	 */
	public void dodajElement(String kljuc, Object element);
	
	/**
	 * Uklanja element iz mape.
	 * @param kljuc
	 */
	public void ukloniElement(String kljuc);
	
	/**
	 * Uklanja sve elemente mape.
	 */
	public void ukloniSveElemente();
	
	/**
	 * Vraca sve kljuceve.
	 * @param element
	 * @return
	 */
	public ArrayList<String> kljucevi();
	
	/**
	 * Vraca trazeni element.
	 * @param kljuc
	 * @return
	 */
	public Object element(String kljuc);
	
	/**
	 * Proverava da li je mapa prazna.
	 * @return
	 */
	public boolean jePrazna();
}
