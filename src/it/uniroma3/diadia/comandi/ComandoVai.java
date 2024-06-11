package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;

public class ComandoVai extends AbstractComando{
	
	private static final String NOME = "vai";
	private Direzione direzione;

	public ComandoVai() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(super.getParametro() == null) {
			super.getIO().mostraMessaggio("Dove vuoi andare?\n"
					         + "Devi specificare una direzione");
			super.setParametro(super.getIO().leggiRiga());
			//return;
		}
		
		try {
			direzione = Direzione.valueOf(super.getParametro().toUpperCase());
		} catch (IllegalArgumentException e) {
			super.getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		
		//System.out.print("Direzione: " + this.direzione.toString());
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			super.getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		if(prossimaStanza instanceof StanzaBloccata){
			StanzaBloccata stanzaBloccata = (StanzaBloccata) prossimaStanza;
			if(!(partita.getGiocatore().getBorsa().hasAttrezzo(stanzaBloccata.getAttrezzoSbloccante()))){
				super.getIO().mostraMessaggio(stanzaBloccata.getDescrizione(partita));
				return;
			}
			super.getIO().mostraMessaggio("Hai usato " + stanzaBloccata.getAttrezzoSbloccante() + " per sbloccare la stanza");
		}
		
		if(prossimaStanza instanceof StanzaBuia){
			StanzaBuia stanzaBuia = (StanzaBuia) prossimaStanza;
			if(!(partita.getGiocatore().getBorsa().hasAttrezzo(stanzaBuia.getAttrezzoLuminoso()))){
				super.getIO().mostraMessaggio(stanzaBuia.getDescrizione(partita));
				return;
			}
			super.getIO().mostraMessaggio("Hai usato " + stanzaBuia.getAttrezzoLuminoso() + " per illuminare la stanza");
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		
		if(!(partita.getLabirinto().getStanzaCorrente() == partita.getLabirinto().getStanzaVincente()))
			super.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		else
			super.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		//prossimaStanza = null;
		
	}
	
}
