package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.ArrayList;
import java.util.List;

public class TestStanza {

	Stanza s1 = new Stanza("s1");
	Stanza s2 = new Stanza("s2");

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}

	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}
	
    @Test
    public void testAddAttrezzo() {
        List<Attrezzo> attrezzi = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            attrezzi.add(new Attrezzo("a" + (i + 1), 5));
        }
        for (Attrezzo attrezzo : attrezzi) {
            assertTrue(s1.addAttrezzo(attrezzo));
        }
        assertFalse(s1.addAttrezzo(new Attrezzo("a11", 5)));
    }
    
    @Test
    public void testRimuoviOggetto() {
        Stanza s = new Stanza("s");
        Attrezzo a = new Attrezzo("Penna", 2);
        s.addAttrezzo(a);
        s.removeAttrezzo(a);
        assertEquals(0, s.getNumeroAttrezzi());
    }
}

