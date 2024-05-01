package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;
	private IO io;

	public ComandoVai() {}
	
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
			this.io.mostraMessaggio("Dove vuoi andare?\n"
					         + "Devi specificare una direzione");
			this.direzione = this.io.leggiRiga();
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		
		if(!(partita.getLabirinto().getStanzaCorrente() == partita.getLabirinto().getStanzaFinale()))
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		else
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
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
		return "vai";
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
