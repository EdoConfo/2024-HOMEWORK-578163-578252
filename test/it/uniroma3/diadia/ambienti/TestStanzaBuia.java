package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {

	private StanzaBuia stanza;
	private Attrezzo lumino;
	private Partita partita;
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita(labirinto);
		stanza = new StanzaBuia("StanzaBuia", "lumino");
		lumino = new Attrezzo("lumino", 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(lumino);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "Qui c'è buio pesto!";
		assertEquals(e, stanza.getDescrizione(partita));
	}

    @Test
    public void testDescrizioneSenzaAttrezzoLuminoso() {
        assertEquals("Qui c'è buio pesto!", stanza.getDescrizione(partita));
    }

    @Test
    public void testDescrizioneConAttrezzoLuminoso() {
        partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("lumino", 1));
        assertEquals(stanza.getDescrizione(), stanza.getDescrizione(partita));
    }

    @Test
    public void testDescrizioneConAttrezzoNonLuminoso() {
    	partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("candela", 1));
        assertEquals("Qui c'è buio pesto!", stanza.getDescrizione(partita));
    }

    @Test
    public void testGetNomeAttrezzoLuminoso() {
        assertEquals("lumino", stanza.getAttrezzoLuminoso());
    }

    @Test
    public void testGetNomeStanza() {
        assertEquals("StanzaBuia", stanza.getClass().getSimpleName());
    }

}
