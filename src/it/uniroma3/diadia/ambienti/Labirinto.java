package it.uniroma3.diadia.ambienti;

public class Labirinto{
	protected Stanza stanzaCorrente;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public  Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	
	public  Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale){
		this.stanzaIniziale = stanzaIniziale;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente){
		this.stanzaVincente = stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}

