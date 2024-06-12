package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestComandoVai {

	private Stanza s1;
	private Stanza s2;
	private ComandoVai vai;
	private Partita p;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	ComandoVai cv = new ComandoVai();

	@Before
	public void setUp() throws Exception {
		vai = new ComandoVai();
		labirinto = Labirinto.newBuilder()
			.addStanzaIniziale("Atrio")
			.addStanza("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", "nord")
			.getLabirinto();
		p = new Partita(labirinto);
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testComandoVaiConParametroNull() {
		assertNull(cv.getParametro());
	}
	
	@Test
	public void testComandoVaiConParametroNonNull() {
		cv.setParametro("Nord");
		assertNotNull(cv.getParametro());
	}
	
	@Test
	public void testComandoVaiGetNome() {
		assertEquals(cv.getNome(), "vai");
	}
	@Test
	public void testVaiNull() {
		
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		s1.impostaStanzaAdiacente(Direzione.EST, s2);
		s2.impostaStanzaAdiacente(Direzione.OVEST, s1);
		
		vai.setParametro(Direzione.NORD.toString());
		vai.esegui(p);
		vai.setParametro(Direzione.SUD.toString());
		vai.esegui(p);
		assertEquals(p.getLabirinto().getStanzaIniziale(), p.getLabirinto().getStanzaCorrente());
	}
}


