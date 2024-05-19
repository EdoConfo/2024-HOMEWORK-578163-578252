package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;

public class TestStanzaBloccata {

	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	@Before
	public void setUp() throws Exception {
		sb = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
		s = new Stanza("Stanzetta");
		a = new Attrezzo("grimaldello", 1);
		sb.impostaStanzaAdiacente("ovest", s);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("ovest"));
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}

}
