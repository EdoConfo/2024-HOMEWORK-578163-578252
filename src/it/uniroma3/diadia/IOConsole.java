package it.uniroma3.diadia;

import java.util.Scanner;


public class IOConsole {
	
	public static void mostraMessaggio(String msg) {
		 System.out.println(msg);
	}
	
	public static String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
