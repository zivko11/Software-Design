package validator;

import java.util.Observable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * <code>ValidatorSintakse</code> predstavlja konkretnu implementaciju
 * <code>SyntaxValidatorInterface</code> interfejsa.
 * 
 * @author Nikola Stojanovic
 */
public class ValidatorSintakse extends Observable implements SyntaxValidatorInterface {

	/**
	 * Proverava da li je prosledjeni tekst u skladu sa JSON sintaksom.
	 * 
	 * @param tekst
	 *            string cija ispravnost ce se proveriti
	 * @return true ili false, u zavisnosti od ispravnosti prosledjenog teksta
	 */
	@SuppressWarnings("unused")
	public boolean overi(String tekst) {
		JSONTokener tokener = new JSONTokener(tekst);
		try {
			JSONObject o = new JSONObject(tokener);
		} catch (JSONException e) {
			try {
				JSONArray ar = new JSONArray(tokener);
			} catch (JSONException e1) {
				e1.printStackTrace();
				return false;
			}
			e.printStackTrace();
		}
		return true;

	}

	public void notifyObservers() {
		// TODO: implement
	}

}