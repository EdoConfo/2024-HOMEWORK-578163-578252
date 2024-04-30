package it.uniroma3.diadia.test.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class TestGiocatore {

    private Giocatore g = new Giocatore();

    @Test
    public void testCreazioneGiocatore() {
        assertNotNull(g);
    }

    @Test
    public void testCfuUgualiACfuIniziali() {
        assertEquals(20, g.getCfu());
    }

    @Test
    public void testGetCfu() {
        g.setCfu(15);
        assertEquals(15, g.getCfu());
    }
}

