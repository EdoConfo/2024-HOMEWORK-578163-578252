package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.*;

public class TestBorsa {
	
	private Borsa b = new Borsa();
	
	@Test
	public void testGetAttrezzoConBorsaVuota() {
		assertNull(b.getAttrezzo("biscotto"));
	}

	@Test
	public void testPesoInizializzatoCorrettamente() {
	    assertEquals(10, b.getPesoMax());
	}

	@Test
	public void testRemoveAttrezzo() {
	    Attrezzo attrezzo = new Attrezzo("biscotto", 5);
	    b.addAttrezzo(attrezzo);
	    
	    assertNotNull(b.getAttrezzo("biscotto"));
	    
	    Attrezzo attrezzoRimosso = b.removeAttrezzo("biscotto");
	    assertNull(b.getAttrezzo("biscotto"));
	    assertEquals(attrezzo, attrezzoRimosso);
	}
}
