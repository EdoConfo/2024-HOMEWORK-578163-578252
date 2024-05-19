package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;

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
		if(prossimaStanza instanceof StanzaBloccata){
			StanzaBloccata stanzaBloccata = (StanzaBloccata) prossimaStanza;
			if(!(partita.getGiocatore().getBorsa().hasAttrezzo(stanzaBloccata.getAttrezzoSbloccante()))){
				this.io.mostraMessaggio(stanzaBloccata.getDescrizione(partita));
				return;
			}
			this.io.mostraMessaggio("Hai usato " + stanzaBloccata.getAttrezzoSbloccante() + " per sbloccare la stanza");
		}
		
		if(prossimaStanza instanceof StanzaBuia){
			StanzaBuia stanzaBuia = (StanzaBuia) prossimaStanza;
			if(!(partita.getGiocatore().getBorsa().hasAttrezzo(stanzaBuia.getAttrezzoLuminoso()))){
				this.io.mostraMessaggio(stanzaBuia.getDescrizione(partita));
				return;
			}
			this.io.mostraMessaggio("Hai usato " + stanzaBuia.getAttrezzoLuminoso() + " per illuminare la stanza");
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		
		if(!(partita.getLabirinto().getStanzaCorrente() == partita.getLabirinto().getStanzaVincente()))
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		else
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		//prossimaStanza = null;
		
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
