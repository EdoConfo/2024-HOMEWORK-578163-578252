package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

public class TestComandoPosa {
	
	ComandoPosa cp = new ComandoPosa();
	
	@Test
	public void testComandoPosaConParametroNull() {
		assertNull(cp.getParametro());
	}
	
	@Test
	public void testGetNomeComandoPosa() {
		assertEquals(cp.getNome(), "posa");
	}
	
	@Test
	public void testComandoPosaConParametroNonNull() {
		cp.setParametro("osso");
		assertNotNull(cp.getParametro());
	}
	
	@Test
    public void testPosaAttrezzo() {
        Partita partita = new Partita();
        IOConsole io = new IOConsole();
        ComandoPosa comando = new ComandoPosa("martello");
        comando.setIo(io);
        Attrezzo martello = new Attrezzo("martello", 1);
        
        partita.getGiocatore().getBorsa().addAttrezzo(martello);
        comando.esegui(partita);
        assertNull(partita.getGiocatore().getBorsa().getAttrezzo("martello"));
        assertNotNull(partita.getLabirinto().getStanzaCorrente().getAttrezzo("martello"));
    }

    @Test
    public void testPosaAttrezzoNonInBorsa() {
        Partita partita = new Partita();
        IOConsole io = new IOConsole();
        ComandoPosa comando = new ComandoPosa("martello");
        comando.setIo(io);

        comando.esegui(partita);
    }

    @Test
    public void testPosaStanzaPiena() {
        Partita partita = new Partita();
        IOConsole io = new IOConsole();
        ComandoPosa comando = new ComandoPosa("martello");
        comando.setIo(io);

        for (int i = 0; i < 10; i++) {
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("attrezzo" + i, 1));
        }

        Attrezzo martello = new Attrezzo("martello", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(martello);

        comando.esegui(partita);
    }
}
