package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private static final String NOME = "saluta";
	private static final String MESSAGGIO_CHI = "Chi devo salutare?";

	public ComandoSaluta() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio() == null)
			super.getIO().mostraMessaggio(MESSAGGIO_CHI);
		else 
			super.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
	}

}