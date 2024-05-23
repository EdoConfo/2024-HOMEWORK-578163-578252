package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	public AbstractComando costruisciComando(String istruzione, IO io){
		
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;
		
		io.leggi(istruzione);
		if (io.hasNext())
			nomeComando = io.leggiParola();//prima parola: nome del comando
		if (io.hasNext())
			parametro = io.leggiParola();//seconda parola: eventuale parametro
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		
		try {
			nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
			// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
			nomeClasse.append( nomeComando.substring(1) ) ;
			// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
			comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
		} catch (Exception e) {
			comando = new ComandoNonValido();
		}
		
		comando.setIO(io);
		comando.setParametro(parametro);
		
		return comando;
	}
}
