/**Klasse für die Analyse von Autorentexten
 * 
 * @author tilok
 *
 */
public class TextAnalyze {
	/** Zählt die picture tags
	 * 
	 * @param s zeichenkette für honorarberechnung
	 * @return
	 */
	public int getPictureCount(String s) {
		return getPictureCountRek(s,0);
	}
	/**rekursive hilfsmethode zum zählen der tags
	 * 
	 * @param s noch zu prüfende rest-zeichenkette
	 * @param offset
	 * @return
	 */
	private int getPictureCountRek(String s, int offset) throws NullPointerException{
		if (s == null) throw new IllegalArgumentException("Null übergeben") ;
		int hit = s.indexOf("picture"); //könnte noch schöner als parameter durchgeschleift werden
		if (hit == -1) return offset;
		else {
			return getPictureCountRek(s.substring(hit + 7),offset + 1);
		}
	}
}
