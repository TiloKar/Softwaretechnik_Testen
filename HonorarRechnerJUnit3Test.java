import junit.framework.TestCase;

public class HonorarRechnerJUnit3Test extends TestCase {

	public void testPictureCount() {
		String s="ich schreibe, schreibe <picture>, oh seht "
				+ "euch dieses bild an. und da noch eins <picture>";
		TextAnalyze t = new TextAnalyze();
		assertEquals(	2,t.getPictureCount(s));	 						
	}
	
	public void testCalculatorWithDep() {
		String s="ich schreibe, schreibe <picture>, oh seht "
				+ "euch dieses bild an. und da noch eins <picture>";
		TextAnalyze t = new TextAnalyze();
		HonorarRechner r = new HonorarRechner();
		assertEquals(	s.length() + 50*t.getPictureCount(s), r.getSalery(s));						
	}
}
