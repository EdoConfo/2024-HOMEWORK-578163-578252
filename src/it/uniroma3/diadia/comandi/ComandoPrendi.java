package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo = null;
	
	public ComandoPrendi() {
		this.nomeAttrezzo = null;
	}
	
	public ComandoPrendi(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		if(this.nomeAttrezzo == null) {
			IOConsole.mostraMessaggio("Comando incompleto, inserisci il nome dell'oggetto che vuoi prendere");
			this.nomeAttrezzo = IOConsole.leggiRiga();
		}
		
		if(nomeAttrezzo != null) {
			Attrezzo attrezzoDaPrendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
			IOConsole.mostraMessaggio("SESSO");
			Boolean b = partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo);
			if(b) {
				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
	                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	                IOConsole.mostraMessaggio("Hai preso: " + attrezzoDaPrendere.getNome());
	            }
				else {
	            	IOConsole.mostraMessaggio("La borsa è troppo piena per prendere questo attrezzo.");
	            }
	        }
			else {
	        	IOConsole.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è presente in questa stanza.");
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

}
