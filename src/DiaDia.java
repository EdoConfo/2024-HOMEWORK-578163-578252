

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

	static final private String[] elencoComandi = {"vai <direzione>, ", "aiuto, ", "prendi <nomeAttrezzo>, ", "posa <nomeAttrezzo>, ", "fine"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);
		do {
			System.out.println("Inserisci l' istruzione : ");
			istruzione = scannerDiLinee.nextLine();
		}while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}


	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	 private boolean processaIstruzione(String istruzione) {
	
		 Comando comandoDaEseguire = new Comando(istruzione);

		if (istruzione.isEmpty()) {
	        System.out.println("Inserisci un'istruzione valida.");
	        return false;
	    }
		
		if(comandoDaEseguire.getParametro() == null && (comandoDaEseguire.getNome().equals("vai") || 
				comandoDaEseguire.getNome().equals("prendi") || comandoDaEseguire.getNome().equals("posa")))
			System.out.println("Comando incompleto, inserisci di nuovo il comando");
		
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
			System.out.println("Comando sconosciuto, inserisci di nuovo il comando");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
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
	            System.out.println("Cosa vuoi prendere?");
	        }
	        
	        Attrezzo attrezzoDaPrendere = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

	        if (attrezzoDaPrendere != null) {
	            if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) {
	                this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	                System.out.println("Hai preso: " + attrezzoDaPrendere.getNome());
	            } else {
	                System.out.println("La borsa è troppo piena per prendere questo attrezzo.");
	            }
	        } else {
	            System.out.println("L'attrezzo '" + nomeAttrezzo + "' non è presente in questa stanza.");
	        }
	    }

	    private void posa(String nomeAttrezzo) {
	        if (nomeAttrezzo == null) {
	            System.out.println("Cosa vuoi posare?");
	        }
	        //TODO completa gli errori
	        Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
	        if (attrezzoDaPosare != null) {
	            Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
	            if (stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
	                this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
	                System.out.println("Hai posato: " + attrezzoDaPosare.getNome());
	            } else {
	                System.out.println("Questa stanza è troppo piena per posare l'attrezzo.");
	            }
	        } else {
	            System.out.println("L'attrezzo '" + nomeAttrezzo + "' non è presente nella borsa.");
	        }
	    }

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++)
			System.out.print(elencoComandi[i]+" ");
	System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		
		if(direzione==null) {
			System.out.println("Dove vuoi andare ?");
			
			//TODO capisci che succede in vai ()
		}
		
		Stanza prossimaStanza = null;

		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);

		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		System.out.println(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
		//scannerdiDirezione.close();
		return;
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] args) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}
