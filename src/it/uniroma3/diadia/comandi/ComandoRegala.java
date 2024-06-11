package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	
	private IO io;

	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
		partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
