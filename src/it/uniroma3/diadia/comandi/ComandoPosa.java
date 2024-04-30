package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando{
	
	private String attrezzoDaPosare;
	
	public ComandoPosa() {
		
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzoDaPosare = parametro;	
	}

	@Override
	public String getParametro() {
		
		return this.attrezzoDaPosare;
	}

	@Override
	public String getNome() {
		return "posa";
	}
}
