package fr.uvsq.pglp.Exercice9_9;

import java.util.Scanner;

public enum DrawingApp {
	
ENVIRONNEMENT;
	
	public void run( String[] args) {
		Scanner rep = new Scanner(System.in);
		DrawingTUI saisie = new DrawingTUI();
		String text;
		while(true) {
			
			text = rep.nextLine();
			saisie.nextCommand(text);
			
		}
		

	}
	
	public static void main( String[] args ) {
		ENVIRONNEMENT.run(args);
		
	}

}
