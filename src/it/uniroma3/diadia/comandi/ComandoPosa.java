package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo = null;
	private IO io;
	
	public ComandoPosa() {}
	
	public ComandoPosa(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(this.nomeAttrezzo == null) {
			io.mostraMessaggio("Comando incompleto, inserisci il nome dell'oggetto che vuoi posare");
			this.nomeAttrezzo = io.leggiRiga();
		}
        
		Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
        if(nomeAttrezzo != null) {
        	if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
        		if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) {
        			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
        			io.mostraMessaggio("Hai posato: " + attrezzoDaPosare.getNome());
        		}
        		else {
            	io.mostraMessaggio("Questa stanza è troppo piena per posare l'attrezzo.");
        		}
        	}
        	else {
        		io.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è presente nella borsa.");
        	}
        }
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
