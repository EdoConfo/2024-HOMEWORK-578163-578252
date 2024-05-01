package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFabbricaDiComandiFisarmonica {

	@Test
	public void testComandoConParametroValido() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		IO io = new IO(); 
		Comando comando = fabbrica.costruisciComando("vai nord", io);
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		IO io = new IO();
		Comando comando = fabbrica.costruisciComando("aiuto", io);
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		IO io = new IO();
		Comando comando = fabbrica.costruisciComando("ForzaRoma", io);
		assertNull(comando.getParametro());
	}
}
