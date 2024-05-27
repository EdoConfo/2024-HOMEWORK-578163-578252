package it.uniroma3.diadia;

import java.util.Scanner;


public class IOConsole implements IO{
	
	public IOConsole() {}
	
	Scanner scannerDiLinee = new Scanner(System.in);
	
	@Override
	public void mostraMessaggio(String messaggio) {
		 System.out.println(messaggio);
	}
	
	@Override
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
	
}

