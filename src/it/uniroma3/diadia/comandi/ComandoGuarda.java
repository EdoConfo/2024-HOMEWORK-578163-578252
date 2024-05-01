package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IO io;

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Stanza corrente: " + partita.getLabirinto().getStanzaCorrente().toString());
		io.mostraMessaggio("Informazioni partita: " + partita.getGiocatore().toString());
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
