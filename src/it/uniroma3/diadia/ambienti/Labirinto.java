package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.*;

public class Labirinto{
	protected Stanza stanzaCorrente;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
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
	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Stanza ultimaAggiunta;
		private Map<String, Stanza> nome2stanza;
		
		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.nome2stanza = new HashMap<>();
		}
		
		public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
			Stanza iniziale = new Stanza(nomeStanzaIniziale);
			this.labirinto.setStanzaIniziale(iniziale);
			this.labirinto.setStanzaCorrente(iniziale);
			this.aggiungiAMappaEAggiornaUltima(iniziale);
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
			Stanza vincente = new Stanza(nomeStanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.aggiungiAMappaEAggiornaUltima(vincente);
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
			Stanza stanzaPartenza = this.nome2stanza.get(partenza);
			Stanza stanzaAdiacente = this.nome2stanza.get(adiacente);
			stanzaPartenza.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()), stanzaAdiacente);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nomeStanza, String nome, int peso) {
			Attrezzo a = new Attrezzo(nome, peso);
			this.ultimaAggiunta.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome, attrezzoPerVedere);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String presentaz, String ciboPreferito, Attrezzo attrezzoCustodito) {
			Cane c = new Cane(nome, presentaz, ciboPreferito, attrezzoCustodito);
			if(this.ultimaAggiunta == null)
				return this;
			this.ultimaAggiunta.setPersonaggio(c);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentaz, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentaz, attrezzo);
			if(this.ultimaAggiunta == null)
				return this;
			this.ultimaAggiunta.setPersonaggio(m);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome, String presentaz) {
			Strega s = new Strega(nome, presentaz);
			if(this.ultimaAggiunta == null)
				return this;
			this.ultimaAggiunta.setPersonaggio(s);
			return this;
		}
		
		public Labirinto getLabirinto(){
			return this.labirinto;
		}
		
		private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}
		

	}
}

