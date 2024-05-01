package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;

public class TestStanzaBuia {

	@Test
	public void testStanzaAlBuio() {
		StanzaBuia SB = new StanzaBuia("Stanza Buia", "lanterna");
		assertEquals(SB.getDescrizione(), "Qui c'è buio pesto!");
		
	}
	
	@Test
	public void testEsisteAttrezzo() {
		StanzaBuia Sb = new StanzaBuia("Stanza Buia", "lanterna");
		assertFalse(Sb.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testStanzaIlluminata() {
		StanzaBuia Sb = new StanzaBuia("Stanza Buia", "lanterna");
		Sb.addAttrezzo(new Attrezzo("lanterna", 1));
		String Descrizione = "Stanza Buia\nUscite: \nAttrezzi nella stanza: lanterna (1kg) ";
		assertEquals(Sb.getDescrizione(), Descrizione);
		
	}
	
	

}
