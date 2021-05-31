
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class HonorarRechnerTest {
	
	@Test	//zählung der tags prüfen
	public void testPictureCount() {
		String s="ich schreibe, schreibe <picture>, oh seht "
				+ "euch dieses bild an. und da noch eins <picture>";
		TextAnalyze t = new TextAnalyze();
		assertEquals(	2,t.getPictureCount(s));	 						
	}
	@Test	//ausnahmenbehandlung für null prüfen
	public void testPictureCountExc() {
		HonorarRechner r = new HonorarRechner();
		assertThrows(IllegalArgumentException.class,()->{r.getSalery(null);}); 						
	}
	@Test  //rechnen prüfen, noch mit Dependency zur Textanalyse
	public void testCalculatorWithDep() {
		String s="ich schreibe, schreibe <picture>, oh seht "
				+ "euch dieses bild an. und da noch eins <picture>";
		TextAnalyze t = new TextAnalyze();
		HonorarRechner r = new HonorarRechner();
		assertEquals(	s.length() + 50*t.getPictureCount(s), r.getSalery(s));						
	}
	@Test	//rechnen prüfen, mit gemockter textanalyse per constructor
	public void testCalculatorMockConstructor() {
		TextAnalyze tmock = mock(TextAnalyze.class);
		when(tmock.getPictureCount("12345")).thenReturn(2);
		HonorarRechner rmock = new HonorarRechner(tmock);
		assertEquals(105, rmock.getSalery("12345"));	 						
	}
	@Test	//rechnen prüfen, mit gemockter textanalyse per setter
	public void testCalculatorMockSetter() {
		TextAnalyze tmock = mock(TextAnalyze.class);
		when(tmock.getPictureCount("12345")).thenReturn(2);
		HonorarRechner r = new HonorarRechner();
		r.setMock(tmock);
		assertEquals(105, r.getSalery("12345"));	 						
	}
	@Test	//mal den spy versuchen
	public void testCalculatorSpy() {
		String s="ich schreibe, schreibe <picture>, oh seht "
				+ "euch dieses bild an. und da noch eins <picture>";
		HonorarRechner rspy = Mockito.spy(new HonorarRechner());
		when(rspy.getSalery(s)).thenReturn(0);
		assertEquals(450,rspy.getBetterSalery(s));
		//zum vergleich:
		HonorarRechner rmock = mock(HonorarRechner.class);
		when(rmock.getSalery(s)).thenReturn(0);
		assertEquals(450,rmock.getBetterSalery(s)); //scheitert, weil mocks nicht mehr so arbeiten wie eine instanz der klasse
		//nicht explizit gemockte methoden, werfen default werte, hier 0
	}
}
