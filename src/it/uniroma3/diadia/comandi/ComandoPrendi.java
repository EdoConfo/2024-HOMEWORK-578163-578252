package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi extends AbstractComando {
	
	private static final String NOME = "prendi";
	
	
	public ComandoPrendi() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		//if(this.nomeAttrezzo == null) {
		if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(super.getParametro())) {
			super.getIO().mostraMessaggio("Comando incompleto, inserisci il nome dell'oggetto che vuoi prendere");
			super.setParametro(super.getIO().leggiRiga());
		}
		
		Attrezzo attrezzoDaPrendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(super.getParametro());
		if(super.getParametro() != null) {
			if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(super.getParametro())){
				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
	                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	                super.getIO().mostraMessaggio("Hai preso: " + attrezzoDaPrendere.getNome());
	            }
				else {
	            	super.getIO().mostraMessaggio("La borsa è troppo piena per prendere questo attrezzo.");
	            }
	        }
			else {
				super.getIO().mostraMessaggio("L'attrezzo '" + super.getParametro() + "' non è presente in questa stanza.");
	        }
		}
	}
}
