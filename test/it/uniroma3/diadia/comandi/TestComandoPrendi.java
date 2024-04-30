package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
