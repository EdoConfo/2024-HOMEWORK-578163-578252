package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;

public class TestComandoPrendi {

	ComandoPrendi cpr = new ComandoPrendi();
	
	@Test
	public void testComandoPrendiSetParametroNull() {
		assertNull(cpr.getParametro());
	}
	
	@Test
	public void testComandoPrendiSetParametroNonNull() {
		cpr.setParametro("Lanterna");
		assertNotNull(cpr.getParametro());
	}
	
	@Test
	public void testComandoPrendiGetNome() {
		assertEquals(cpr.getNome(), "prendi");
	}
	
    @Test
    public void testPrendiAttrezzoPresente() {
        Partita partita = new Partita();
        Stanza stanza = new Stanza("stanza");
        Attrezzo attrezzo = new Attrezzo("martello", 1);
        stanza.addAttrezzo(attrezzo);
        partita.getLabirinto().setStanzaCorrente(stanza);

        ComandoPrendi comando = new ComandoPrendi("martello");
        IO io = new IOConsole();
        comando.setIo(io);
        comando.esegui(partita);

        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
        assertFalse(stanza.hasAttrezzo("martello"));
    }

    @Test
    public void testPrendiAttrezzoNonPresente() {
        Partita partita = new Partita();
        Stanza stanza = new Stanza("stanza");
        partita.getLabirinto().setStanzaCorrente(stanza);

        ComandoPrendi comando = new ComandoPrendi("cacciavite");
        IO io = new IOConsole();
        comando.setIo(io);
        comando.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("cacciavite"));
        assertFalse(stanza.hasAttrezzo("cacciavite"));
    }

    @Test
    public void testPrendiBorsaPiena() {
        Partita partita = new Partita();
        Stanza stanza = new Stanza("stanza");
        Attrezzo attrezzo = new Attrezzo("martello", 1);
        stanza.addAttrezzo(attrezzo);
        partita.getLabirinto().setStanzaCorrente(stanza);

        for (int i = 0; i < 10; i++) {
            partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("attrezzo" + i, 1));
        }

        ComandoPrendi comando = new ComandoPrendi("martello");
        IO io = new IOConsole();
        comando.setIo(io);
        comando.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
        assertTrue(stanza.hasAttrezzo("martello"));
    }
}
