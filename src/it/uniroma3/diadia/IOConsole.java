package it.uniroma3.diadia;

import java.util.Scanner;


public class IOConsole {
	
	/*
	 * Unico metodo di stampa
	 */
	public static void mostraMessaggio(String msg) {
		 System.out.println(msg);
	}
	
	/*
	 * Unico metodo di lettura
	 */
	public static String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}

