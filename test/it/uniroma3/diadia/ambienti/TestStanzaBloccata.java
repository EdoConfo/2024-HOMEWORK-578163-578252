package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;

public class TestStanzaBloccata {

	@Test
	public void testDescrizione() {
		StanzaBloccata Sb = new StanzaBloccata("Stanza Bloccata", "nord", "chiave");
		assertEquals("Stanza bloccata nella direzione: nord\nPrendi il chiave e posalo nella stanza", Sb.getDescrizione());
	}
	
	@Test
	public void testDescrizioneBloccata() {
		StanzaBloccata Sb = new StanzaBloccata("Stanza Bloccata", "nord", "chiave");
        Sb.addAttrezzo(new Attrezzo("chiave", 1)); 
        String Descrizione = "Stanza Bloccata\nUscite: \nAttrezzi nella stanza: chiave (1kg) ";
        assertEquals(Descrizione, Sb.getDescrizione());;
	}
	
	@Test
	public void testAttrezzoSbloccantePresente() {
		StanzaBloccata Sb = new StanzaBloccata("Stanza Bloccata", "nord", "chiave");
		assertFalse(Sb.hasAttrezzo("chiave"));
	}

}
