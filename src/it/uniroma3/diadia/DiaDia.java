package it.uniroma3.diadia;

//TODO perché gli import di diadia e di diadia.giocatore sono warning se vengono usati più volte?

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import java.util.Scanner;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO
 *         (da un'idea di Michael Kolling and David J. Barnes)
 *
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai <direzione>", "aiuto", "prendi <nomeAttrezzo>", "posa <nomeAttrezzo>", "fine"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		IOConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			IOConsole.mostraMessaggio("Inserisci l' istruzione : ");
			istruzione = IOConsole.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}


	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	 private boolean processaIstruzione(String istruzione) {
	
		 Comando comandoDaEseguire = new Comando(istruzione);

		if (istruzione.isEmpty()) {
			IOConsole.mostraMessaggio("Inserisci un'istruzione valida.");
	        return false;
	    }
		
		if(comandoDaEseguire.getParametro() == null && (comandoDaEseguire.getNome().equals("vai") || 
				comandoDaEseguire.getNome().equals("prendi") || comandoDaEseguire.getNome().equals("posa")))
			IOConsole.mostraMessaggio("Comando incompleto, inserisci di nuovo il comando");
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			if(comandoDaEseguire.getParametro()!= null)
				this.vai(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi")) {
			if(comandoDaEseguire.getParametro()!= null)
				this.prendi(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("posa")) {
			if(comandoDaEseguire.getParametro()!= null)
				this.posa(comandoDaEseguire.getParametro());
		}
		else
			IOConsole.mostraMessaggio("Comando sconosciuto, inserisci di nuovo il comando");
		if (this.partita.vinta()) {
			IOConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else {
			return false;
		}
	}

	// implementazioni dei comandi dell'utente:

	/*
	 * Funzione presa oggetto
	 */
	    private void prendi(String nomeAttrezzo) {	    	
	    	
	        if (nomeAttrezzo == null) {
	        	IOConsole.mostraMessaggio("Cosa vuoi prendere?");
	        }
	        
	        Attrezzo attrezzoDaPrendere = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

	        if (attrezzoDaPrendere != null) {
	            if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
	                this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	                IOConsole.mostraMessaggio("Hai preso: " + attrezzoDaPrendere.getNome());
	            } else {
	            	IOConsole.mostraMessaggio("La borsa è troppo piena per prendere questo attrezzo.");
	            }
	        } else {
	        	IOConsole.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è presente in questa stanza.");
	        }
	    }

	    private void posa(String nomeAttrezzo) {
	        
	        Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
	        if (attrezzoDaPosare != null) {
	            Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
	            if (stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
	                this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
	                IOConsole.mostraMessaggio("Hai posato: " + attrezzoDaPosare.getNome());
	            } else {
	            	IOConsole.mostraMessaggio("Questa stanza è troppo piena per posare l'attrezzo.");
	            }
	        } else {
	        	IOConsole.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non è presente nella borsa.");
	        }
	    }

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++)
			IOConsole.mostraMessaggio(elencoComandi[i]+" ");
		IOConsole.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		
		Stanza prossimaStanza = null;

		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);

		if (prossimaStanza == null)
			IOConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		IOConsole.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
		return;
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IOConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] args) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}
