package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoLuminoso;

	public StanzaBuia(String nome, String nomeAttrezzoLuminoso) {
		super(nome);
		this.nomeAttrezzoLuminoso = nomeAttrezzoLuminoso;
	}

	@Override
	public String getDescrizione(Partita partita) {
		if(!(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzoLuminoso)))
			return "Qui c'è buio pesto!";
		return super.getDescrizione();
	}
	
	public String getAttrezzoLuminoso() {
		return this.nomeAttrezzoLuminoso;
	}

}