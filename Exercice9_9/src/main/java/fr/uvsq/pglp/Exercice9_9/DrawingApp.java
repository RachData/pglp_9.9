package fr.uvsq.pglp.Exercice9_9;

import java.util.Scanner;

import fr.uvsq.pglp.Exercice9_9.Command.Commands;

public enum DrawingApp {

	ENVIRONNEMENT;

	public void run( String[] args) {
		Scanner rep = new Scanner(System.in);
		DrawingTUI saisie = new DrawingTUI();
		String text;
		Commands command ;
		//Continue con = new Continue();
		while(Continue.isOn()) {

			text = rep.nextLine();
			command = saisie.nextCommand(text);
			if (command != null) {
				command.apply(Dico.stringsplit(text));
				if(Dico.gettypeString()==1)
					saisie.affich();
			}else {
				System.out.println("Exception a gerer dans run de drawing App");
			}
			

		}

		rep.close();
	}

	public static void main( String[] args ) {
		ENVIRONNEMENT.run(args);

	}

}
