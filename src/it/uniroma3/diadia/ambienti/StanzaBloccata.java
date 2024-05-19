package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.*;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		/*
		if(direzione.equals(this.direzioneBloccata)) {
			if(!super.hasAttrezzo(attrezzoSbloccante)) {
				return this;
			}
		}
		*/
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione(Partita partita) {
		if(!(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoSbloccante)))
			return "Stanza bloccata nella direzione: "+ direzioneBloccata + "\n"
				 + "Prendi " + attrezzoSbloccante + " e posalo nella stanza";
		return super.getDescrizione();
	}
	
	public String getAttrezzoSbloccante() {
		return this.attrezzoSbloccante;
	}
}