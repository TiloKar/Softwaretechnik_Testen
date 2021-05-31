/**Klasse f�r die Analyse von Autorentexten
 * 
 * @author tilok
 *
 */
public class TextAnalyze {
	/** Z�hlt die picture tags
	 * 
	 * @param s zeichenkette f�r honorarberechnung
	 * @return
	 */
	public int getPictureCount(String s) {
		return getPictureCountRek(s,0);
	}
	/**rekursive hilfsmethode zum z�hlen der tags
	 * 
	 * @param s noch zu pr�fende rest-zeichenkette
	 * @param offset
	 * @return
	 */
	private int getPictureCountRek(String s, int offset) throws NullPointerException{
		if (s == null) throw new IllegalArgumentException("Null �bergeben") ;
		int hit = s.indexOf("picture"); //k�nnte noch sch�ner als parameter durchgeschleift werden
		if (hit == -1) return offset;
		else {
			return getPictureCountRek(s.substring(hit + 7),offset + 1);
		}
	}
}
