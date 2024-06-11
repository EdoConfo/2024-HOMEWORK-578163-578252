package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private String ciboPreferito;
	private Attrezzo attrezzoCustodito;
	private boolean regaloPosato = false;

	public Cane(String nome, String presentaz, String ciboPreferito, Attrezzo regalo) {
		super(nome, presentaz);
		this.ciboPreferito = ciboPreferito;
		this.attrezzoCustodito = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() -1);
		return "Il cane ci ha morso";
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		if(regalo.getNome().equals(ciboPreferito)) {
			if(!this.regaloPosato){
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzoCustodito);
				this.regaloPosato = true;
			}
			return "Il cane accetta il cibo e lascia cadere un attrezzo";
		} else {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(regalo);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() -1);
			return "Il cane non accetta il tuo regalo e ti morde";
		}
	}

}