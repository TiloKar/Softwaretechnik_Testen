
public class HonorarRechner{
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
	 * @param text zeichenkette f�r honorarberechnung
	 * @return honorar nach hinterlegter formel
	 */
	public int getSalery(String text) {
		//if (text==null) return 0;  //f�r Exception bei testfall null ausgeklammert
		return r.getPictureCount(text) * 50 + text.length();
	}
	/**  ruft getSalery auf, Fallbeispiel um this.getSalery sp�ter mit spy selektiv zu mocken	
	 * 
	 * @param text zeichenkette f�r honorarberechnung
	 * @return honorar nach hinterlegter formel + offset
	 */
	public int getBetterSalery(String text) {
		//if (text==null) return 0;  //f�r Exception bei testfall null ausgeklammert
		return this.getSalery(text) + 450;
	}


}
