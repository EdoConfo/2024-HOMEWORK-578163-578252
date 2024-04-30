package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;

	public ComandoVai(String direzione) {
	this.direzione = direzione;
	}
	
	/**
	* esecuzione del comando
	*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione == null) {
			IOConsole.mostraMessaggio("Dove vuoi andare?"
					                + "Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			IOConsole.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		IOConsole.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1); 
	}
	
	/**
	* set parametro del comando
	*/
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
