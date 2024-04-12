import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanza {

	@Test
    public void testGetNome() {
        Stanza stanza = new Stanza("Atrio");
        assertEquals("Atrio", stanza.getNome());
    }

    @Test
    public void testAddAttrezzo() {
        Stanza stanza = new Stanza("Atrio");
        Attrezzo attrezzo = new Attrezzo("Libro", 2);
        assertTrue(stanza.addAttrezzo(attrezzo));
        assertEquals(attrezzo, stanza.getAttrezzo("Libro"));
    }

    @Test
    public void testHasAttrezzo() {
        Stanza stanza = new Stanza("Atrio");
        Attrezzo attrezzo = new Attrezzo("Penna", 1);
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("Penna"));
    }

}
