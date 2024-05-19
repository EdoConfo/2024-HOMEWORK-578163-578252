package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.ambienti.*;


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

	private Partita partita;
	private IO io;

	public DiaDia(IO io, Labirinto labirinto) {
		this.io = io;
		this.partita = new Partita(labirinto);
	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			io.mostraMessaggio("Inserisci l' istruzione : ");
			istruzione = io.leggiRiga();
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
		comandoDaEseguire = factory.costruisciComando(istruzione, io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return this.partita.isFinita();
	    }
		if(this.partita.getGiocatore().getCfu() == 0)
			this.io.mostraMessaggio("Hai Perso, CFU terminati");
		
		return this.partita.isFinita();
	}
	
	/*
	 * Inizia una nuova partita
	 */
	public static void main(String[] args) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("Osso", 2)
				.addStanzaVincente("Biblioteca")
				.addStanzaBuia("Labortatorio", "Lanterna")
				.addStanzaBloccata("AulaN10", "nord", "Chiave")
				.addAttrezzo("Lanterna", 3)
				.addStanzaMagica("AulaN11")
				.addAttrezzo("Chiave", 1)
				
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				
				.addAdiacenza("Atrio", "AulaN10", "sud")
				.addAdiacenza("AulaN10", "Atrio", "nord")
				
				.addAdiacenza("Atrio", "Labortatorio", "ovest")
				.addAdiacenza("Labortatorio", "Atrio", "est")
				
				.addAdiacenza("Atrio", "AulaN11", "est")
				.addAdiacenza("AulaN11", "Atrio", "ovest")
				
				.addAdiacenza("Labortatorio", "AulaN11", "ovest")
				.addAdiacenza("AulaN11", "Labortatorio", "est")
				
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
	}
}

