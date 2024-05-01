package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class TestFabbricaDiComandiFisarmonica {
	
	IO io = new IOConsole(); 

	@Test
	public void testComandoConParametroValido() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		Comando comando = fabbrica.costruisciComando("vai nord", io);
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		Comando comando = fabbrica.costruisciComando("aiuto", io);
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		Comando comando = fabbrica.costruisciComando("ForzaRoma", io);
		assertNull(comando.getParametro());
	}
	
    @Test
    public void testCostruisciComandoComandoConTroppiParametri() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        IOConsole io = new IOConsole();
        
        Comando comando = fabbrica.costruisciComando("vai nord est", io);
        assertNotNull(comando);
        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }
}
