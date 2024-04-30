package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
