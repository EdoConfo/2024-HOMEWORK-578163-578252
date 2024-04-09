


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private static final int CFU_INIZIALI = 20;
	
	private Labirinto labirinto;
	private boolean finita;
	private int cfu;
	
	public Partita(){
		Labirinto.creaStanze();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return getLabirinto().getStanzaCorrente()== Labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}
	
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
