package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestComandoVai {

	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;
	ComandoVai cv = new ComandoVai();

	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		labirinto = new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("martello", 3)
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", "nord")
			.getLabirinto();
		p = new Partita(labirinto);
		vai.setIo(io);
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
		p.getLabirinto().setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("sud-ovest");
		vai.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("in fondo a destra");
		vai.esegui(p);
		assertNotEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
}


