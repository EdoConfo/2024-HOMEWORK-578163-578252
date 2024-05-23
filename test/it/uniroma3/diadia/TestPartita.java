package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;


public class TestPartita {
	
	private Partita partita;
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
		this.partita = new Partita(this.labirinto);
	}
	
	@Test
	public void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getLabirinto().getStanzaVincente());
	}
	
	@Test
	public void testVintaSeStanzaCorrenteEVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testNonVintaSeStanzaCorrenteNonEVincente() {
		this.partita.getLabirinto().setStanzaCorrente(new Stanza("NonVincente"));
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testFinitaSeVinta() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaSeEsplicitamenteSettato() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaSeCFUFiniti() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testNonFinitaInizioPartita() {
		assertFalse(this.partita.isFinita());
	}
}