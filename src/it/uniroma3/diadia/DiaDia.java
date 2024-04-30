package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.*;

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
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			IOConsole.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			IOConsole.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}
	
	/*
	 * Inizia una nuova partita
	 */
	public static void main(String[] args) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}

