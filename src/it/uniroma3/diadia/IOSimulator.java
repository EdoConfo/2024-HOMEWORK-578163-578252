package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
	private String[] righeDaLeggere;
	private int indiceRigheDaLeggere;
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	private String[] paroleDaLeggere;
    private int indiceParoleDaLeggere;
	
	public IOSimulator(String[] righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigheDaLeggere = 0;
		this.messaggiProdotti = new String[100];
		this.indiceMessaggiProdotti = 0;
		this.indiceMessaggiMostrati = 0;
		this.paroleDaLeggere = null;
        this.indiceParoleDaLeggere = 0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti[this.indiceMessaggiProdotti] = messaggio;
		this.indiceMessaggiProdotti++;
	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere[this.indiceRigheDaLeggere];
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	@Override
    public String leggiParola() {
        if (this.paroleDaLeggere != null && this.indiceParoleDaLeggere < this.paroleDaLeggere.length) {
            String parolaLetta = this.paroleDaLeggere[this.indiceParoleDaLeggere];
            this.indiceParoleDaLeggere++;
            return parolaLetta;
        } else if (this.indiceRigheDaLeggere < this.righeDaLeggere.length) {
            leggiRiga(); // Legge la prossima riga e divide in parole
            return leggiParola();
        } else {
            return null;
        }
    }
	
	@Override
	public String leggi(String input) {
		String output = input;
		return output;
	}
    
    @Override
    public boolean hasNext() {
        if (this.paroleDaLeggere != null && this.indiceParoleDaLeggere < this.paroleDaLeggere.length) {
            return true;
        } else {
            return this.indiceRigheDaLeggere < this.righeDaLeggere.length;
        }
    }
	
	//NON OVERRIDE
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}

}
