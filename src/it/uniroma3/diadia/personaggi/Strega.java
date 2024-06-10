package it.uniroma3.diadia.personaggi;

import java.util.TreeSet;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzePerNumeroAttrezzi;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	private static final String MESSAGGIO_SPOSTATO = "Ti ho spostato";
	private static final String RISATA = "GNEHEHEHEH";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		TreeSet<Stanza> stanzePerNumeroAttrezzi = new TreeSet<Stanza>(new ComparatoreStanzePerNumeroAttrezzi());
		for(Direzione direzione : partita.getLabirinto().getStanzaCorrente().getDirezioni())
			stanzePerNumeroAttrezzi.add(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione));
		if(super.haSalutato())
			partita.getLabirinto().setStanzaCorrente(stanzePerNumeroAttrezzi.first());
		else
			partita.getLabirinto().setStanzaCorrente(stanzePerNumeroAttrezzi.last());
		return MESSAGGIO_SPOSTATO;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		return RISATA;
	}

}