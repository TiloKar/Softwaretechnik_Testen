
public class HonorarRechner{
	
	
	public static void main (String[] args) {
		System.out.println("Ich lebe und habe: " + args[0] + "als Argument bekommen");
	}
	
	
	TextAnalyze r;
	public HonorarRechner() {
		this.r = new TextAnalyze();
	};
	//constructor injection
	public HonorarRechner(TextAnalyze r) {
		this.r=r;
	}
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
