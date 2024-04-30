package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestPartita {

	Partita p = new Partita();
	Stanza s = new Stanza("Stanza");
	Attrezzo a = new Attrezzo("spada", 15);
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaFinale().getNome());
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals("Atrio", p.getLabirinto().getStanzaIniziale().getNome());
	}
	
	@Test
	public void testIsPersa() {
		p.getGiocatore().setCfu(0);
		assertEquals(0, p.getGiocatore().getCfu());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}
}

