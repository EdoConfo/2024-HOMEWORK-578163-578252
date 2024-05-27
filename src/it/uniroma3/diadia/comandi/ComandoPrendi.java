package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi extends AbstractComando {
	
	private static final String NOME = "prendi";
	
	public ComandoPrendi() {
		super.setNome(NOME);
	}
/*
	@Override
	public void esegui(Partita partita) {
		//if(this.nomeAttrezzo == null) {
		if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(super.getParametro())) {
			super.getIO().mostraMessaggio("Comando incompleto, inserisci il nome dell'oggetto che vuoi prendere");
			this.nomeAttrezzo = io.leggiRiga();
		}
		
		Attrezzo attrezzoDaPrendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(super.getParametro());
		if(nomeAttrezzo != null) {
			if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
	                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	                io.mostraMessaggio("Hai preso: " + attrezzoDaPrendere.getNome());
	            }
				else {
	            	super.getIO().mostraMessaggio("La borsa è troppo piena per prendere questo attrezzo.");
	            }
	        }
			else {
	        	io.mostraMessaggio("L'attrezzo '" + super.getParametro() + "' non è presente in questa stanza.");
	        }
		}
		}
	}
*/
	@Override
	public void esegui(Partita partita) {
		if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(super.getParametro())) {
			super.getIO().mostraMessaggio("Attrezzo " + super.getParametro() + " non presente nella stanza");
			return;
		}
		Attrezzo attrezzoDaPrendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(super.getParametro());
		boolean attrezzoPreso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
		if (!attrezzoPreso) {
			super.getIO().mostraMessaggio("Non c'è più spazio per nuovi attrezzi nella borsa");
			return;
		}
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
		super.getIO().mostraMessaggio("Attrezzo " + super.getParametro() + " preso!");
	}
}
