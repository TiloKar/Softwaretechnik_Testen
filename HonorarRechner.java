/**Klasse für die automatische gehaltsberechnung von autorentexten
 * 
 * @author tilok
 * 
 * Spielklasse für Modul Softwaretechnik im SS21
 *
 */
public class HonorarRechner{
	/** Die Main zu Testzwecken des ant-files
	 * 
	 * @param args
	 */
	public static void main (String[] args) {	
		System.out.println("Ich lebe und habe: " + args[0] + "als Argument bekommen");
	}
	TextAnalyze r; //Klassenvariable Strategie der textanalyse
	/**
	 *  Konstruktor leer, nutzt default Textanalyse
	 */
	public HonorarRechner() {
		this.r = new TextAnalyze();
	};
	/**
	 * Konstruktor für test injection einer gemockten textanalyse
	 * @param r
	 */
	public HonorarRechner(TextAnalyze r) {
		this.r=r;
	}
	/**setter injektion einer gemockten textanalyse
	 * 
	 * @param r  neue Analysestrategie
	 */
	//auch mal als setter injection zum testen
	public void setMock(TextAnalyze r){
		this.r=r;
	}
	/**
	 * 
	 * @param text zeichenkette für honorarberechnung
	 * @return honorar nach hinterlegter formel
	 */
	public int getSalery(String text) {
		//if (text==null) return 0;  //für Exception bei testfall null ausgeklammert
		return r.getPictureCount(text) * 50 + text.length();
	}
	/**  ruft getSalery auf, Fallbeispiel um this.getSalery später mit spy selektiv zu mocken	
	 * 
	 * @param text zeichenkette für honorarberechnung
	 * @return honorar nach hinterlegter formel + offset
	 */
	public int getBetterSalery(String text) {
		//if (text==null) return 0;  //für Exception bei testfall null ausgeklammert
		return this.getSalery(text) + 450;
	}


}
