package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLabirinto {

	private Labirinto l = new Labirinto();

	@Test
	public void testCreazioneStanze() {
	    assertNotNull(l.getStanzaIniziale());
	    assertNotNull(l.getStanzaFinale());
	}

	@Test
	public void testStanzaCorrenteUgualeAStanzaIniziale() {
	    assertEquals(l.getStanzaIniziale(), l.getStanzaCorrente());
	}

	@Test
	public void testEsisteStanzaFinale() {
	    assertNotNull(l.getStanzaFinale());
	}
}

