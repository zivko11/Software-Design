package podaci;

import java.util.Enumeration;

/**
 * <code>IteratorMapeSaPodacima</code> je iterator koji prolazi kroz mapu sa
 * podacima.
 * 
 * @author Zivko Stanisic
 *
 */
public class IteratorMapeSaPodacima implements IteratorMape {
	private Enumeration<Object> vrednosti;

	public IteratorMapeSaPodacima(Enumeration<Object> vrednosti) {
		this.vrednosti = vrednosti;
	}

	@Override
	public boolean imaSledeceg() {
		return vrednosti.hasMoreElements();
	}

	@Override
	public Object sledeci() {
		return vrednosti.nextElement();
	}

}
