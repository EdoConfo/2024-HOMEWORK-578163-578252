package it.uniroma3.diadia.comandi;

import java.util.*;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale param.
		
		//if (nomeComando == null)
			//comando = new ComandoNonValido();
		if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		/*else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();*/
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		/*else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();*/
		//else 
			//comando = new ComandoNonValido();
		
		comando.setParametro(parametro);
		
		scannerDiParole.close();
	return comando;
	}
}
