package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai <direzione>", "aiuto", "prendi <nomeAttrezzo>", "posa <nomeAttrezzo>", "fine", "guarda"};

	@Override
	public void esegui(Partita partita) {
		for(int i = 0; i < elencoComandi.length; i++)
			IOConsole.mostraMessaggio(elencoComandi[i]+ " ");
		IOConsole.mostraMessaggio("");
	}
	/**
	* set parametro del comando
	*/
	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return "aiuto";
	}
}
