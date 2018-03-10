/**
 * U ovom paketu su implementirane farbrike za kreiranje GUI elemenata za CRUD operacije.
 */
package crud.fabrike;

import model.Kolona;

/**
 * <code>ApstraktnaFabrikaElementi</code> kreira panele sa GUI elementima.
 * @author Zivko Stanisic
 *
 */
public interface ApstraktnaFabrikaElementi {
	/**
	 * Kreira GUI element u dijalogu.
	 * 
	 * @param kolona
	 */
	public Object kreirajElement(Kolona kolona);
}
