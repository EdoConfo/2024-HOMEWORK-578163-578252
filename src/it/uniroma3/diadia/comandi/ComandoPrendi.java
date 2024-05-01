package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo = null;
	private IO io;
	
	public ComandoPrendi() {}
	
	public ComandoPrendi(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		if(this.nomeAttrezzo == null) {
			io.mostraMessaggio("Comando incompleto, inserisci il nome dell'oggetto che vuoi prendere");
			this.nomeAttrezzo = io.leggiRiga();
		}
		
		Attrezzo attrezzoDaPrendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		if(nomeAttrezzo != null) {
			if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
	                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	                io.mostraMessaggio("Hai preso: " + attrezzoDaPrendere.getNome());
	            }
				else {
	            	io.mostraMessaggio("La borsa è troppo piena per prendere questo attrezzo.");
	            }
	        }
			else {
	        	io.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è presente in questa stanza.");
	        }
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
