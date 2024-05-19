package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Labirinto;

public class TestComandoPosa {
	
	ComandoPosa cp = new ComandoPosa();
	Labirinto labirinto = new Labirinto();
	
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
    public void testPosaAttrezzoNonInBorsa() {
        Partita partita = new Partita(labirinto);
        IOConsole io = new IOConsole();
        ComandoPosa comando = new ComandoPosa("martello");
        comando.setIo(io);

        comando.esegui(partita);
    }

}
