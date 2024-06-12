package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLabirinto {
	
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() {
		l = Labirinto.newBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("Atrio", "martello", 3)
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", "nord")
			.getLabirinto();
		
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(DS1);
		assertEquals(DS1, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}
	
}

