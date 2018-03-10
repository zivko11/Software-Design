package podaci;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * <code>MapaSaPodacima</code> je mapa gde se cuvaju uneti podaci.
 * 
 * @author Zivko Stanisic
 *
 */
public class MapaSaPodacima implements Mapa {
	private ArrayList<Object> elementi;
	private ArrayList<String> kljucevi;
	private String imeTabele;

	public MapaSaPodacima(String imeTabele) {
		elementi = new ArrayList<Object>();
		this.setImeTabele(imeTabele);
		kljucevi = new ArrayList<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IteratorMape getIteratorMape() {
		return new IteratorMapeSaPodacima((Enumeration<Object>) elementi);
	}

	@Override
	public int brojElemenata() {
		return elementi.size();
	}

	@Override
	public void dodajElement(String kljuc, Object element) {
		if (!kljucevi.contains(kljuc)) {
			elementi.add(element);
			kljucevi.add(kljuc);
		}
	}

	@Override
	public void ukloniElement(String kljuc) {
		int index = kljucevi.indexOf(kljuc);
		elementi.remove(index);
		kljucevi.remove(kljuc);
	}

	@Override
	public void ukloniSveElemente() {
		elementi.clear();
		kljucevi.clear();

	}

	public String getImeTabele() {
		return imeTabele;
	}

	public void setImeTabele(String imeTabele) {
		this.imeTabele = imeTabele;
	}

	@Override
	public ArrayList<String> kljucevi() {
		return kljucevi;
	}

	@Override
	public Object element(String kljuc) {
		if (kljucevi.contains(kljuc)) {
			int index = kljucevi.indexOf(kljuc);
			return elementi.get(index);
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see podaci.Mapa#jePrazna()
	 */
	@Override
	public boolean jePrazna() {
		return elementi.isEmpty();
	}

}
