package it.uniroma3.diadia;

public interface IO {
	
	public void mostraMessaggio(String messaggio);
	public String leggi(String frase);
	public String leggiRiga();
	public String leggiParola();
    public boolean hasNext();
}
