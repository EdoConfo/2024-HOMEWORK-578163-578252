package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	
	protected static final int SOGLIA_MAGICA_DEFAULT = 3;
    protected int contatoreAttrezziPosati;
    protected int sogliaMagica;

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        contatoreAttrezziPosati++;
        if (contatoreAttrezziPosati > sogliaMagica)
            attrezzo = modificaAttrezzo(attrezzo);
        return super.addAttrezzo(attrezzo);
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito;
        int pesoX2 = attrezzo.getPeso() * 2;
        
        nomeInvertito = new StringBuilder(attrezzo.getNome());
        nomeInvertito = nomeInvertito.reverse();
        attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
        
        return attrezzo;
    }
}