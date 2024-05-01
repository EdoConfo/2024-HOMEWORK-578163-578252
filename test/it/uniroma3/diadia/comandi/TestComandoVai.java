package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;

public class TestComandoVai {
	
	ComandoVai cv = new ComandoVai();
	
	@Test
	public void testComandoVaiConParametroNull() {
		assertNull(cv.getParametro());
	}
	
	@Test
	public void testComandoVaiConParametroNonNull() {
		cv.setParametro("Nord");
		assertNotNull(cv.getParametro());
	}
	
	@Test
	public void testComandoVaiGetNome() {
		assertEquals(cv.getNome(), "vai");
	}
}
