package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPosa extends AbstractComando{
	
	private static final String NOME = "posa";
	private String nomeAttrezzo = null;
	
	public ComandoPosa() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		this.nomeAttrezzo = super.getParametro();
		if(this.nomeAttrezzo == null) {
			super.getIO().mostraMessaggio("Comando incompleto, inserisci il nome dell'oggetto che vuoi posare");
			this.nomeAttrezzo = super.getIO().leggiRiga();
		}
        
		Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
        if(this.nomeAttrezzo != null) {
        	if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
        		if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
        			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
        			super.getIO().mostraMessaggio("Hai posato: " + attrezzoDaPosare.getNome());
        		}
        		else {
        			super.getIO().mostraMessaggio("Questa stanza è troppo piena per posare l'attrezzo.");
        		}
        	}
        	else {
        		super.getIO().mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è presente nella borsa.");
        	}
        }
	}

}
