package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	
	private static final String NOME = "aiuto";
	static final private String[] elencoComandi = {"vai <direzione>", "aiuto", "prendi <nomeAttrezzo>", "posa <nomeAttrezzo>", "fine", "guarda"};

	public ComandoAiuto() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		for(int i = 0; i < elencoComandi.length; i++)
			super.getIO().mostraMessaggio(elencoComandi[i]+ " ");
		super.getIO().mostraMessaggio("");
	}

}
