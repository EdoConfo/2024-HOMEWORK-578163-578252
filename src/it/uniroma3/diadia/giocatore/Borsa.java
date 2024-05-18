package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> nome2attrezzo;
	private int pesoMax;
	private int pesoAttuale;

	
	/*
	 * Costruttore Borsa
	 */
	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		this.nome2attrezzo = new HashMap<>();
		this.pesoAttuale = 0;
	}
	
	
	/*
	 * Funzione per aggiungere un attrezzo nella borsa
	 * sempre se non sfora il numero di slot inventario
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.nome2attrezzo.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale = this.pesoAttuale + attrezzo.getPeso();
		return true;
	}
	
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {		
		return this.nome2attrezzo.get(nomeAttrezzo);
	}
	
	public int getPeso() {
		return this.pesoAttuale;
	}
	
	public boolean isEmpty() {
		return this.nome2attrezzo.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/*
	 * Funzione per rimuovere un oggetto dalla borsa
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	    if(this.nome2attrezzo.containsKey(nomeAttrezzo))
	    	this.pesoAttuale = this.pesoAttuale - this.nome2attrezzo.get(nomeAttrezzo).getPeso();
	    return this.nome2attrezzo.remove(nomeAttrezzo);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.nome2attrezzo.values().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziPerPeso = new LinkedList<Attrezzo>(this.nome2attrezzo.values());
		Collections.sort(attrezziPerPeso, new ComparatoreAttrezziPerPeso());
		return attrezziPerPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<>(this.nome2attrezzo.values());
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> attrezzi = new HashMap<>();
		for(Attrezzo attrezzo : this.nome2attrezzo.values()) {
			Set<Attrezzo> attrezziPeso = attrezzi.get(attrezzo.getPeso());
			if(attrezziPeso == null) {
				attrezziPeso = new HashSet<>();
				attrezzi.put(attrezzo.getPeso(), attrezziPeso);
			}
			attrezziPeso.add(attrezzo);
		}
		return attrezzi;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> attrezziPerPeso = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		attrezziPerPeso.addAll(this.nome2attrezzo.values());
		return attrezziPerPeso;
	}
}

