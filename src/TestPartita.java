import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPartita {

	@Test
    public void testIsFinitaSenzaCfu() {
        Partita partita = new Partita();
        partita.setCfu(0);
        assertTrue(partita.isFinita());
    }

    @Test
    public void testIsFinitaVinta() {
        Partita partita = new Partita();
        Labirinto.getStanzaFinale().addAttrezzo(new Attrezzo("Chiave", 1));
        partita.getLabirinto().setStanzaCorrente(Labirinto.getStanzaFinale());
        assertTrue(partita.isFinita());
    }

    @Test
    public void testVinta() {
        Partita partita = new Partita();
        assertFalse(partita.vinta());
        partita.getLabirinto().setStanzaCorrente(Labirinto.getStanzaFinale());
        assertTrue(partita.vinta());
    }

}
