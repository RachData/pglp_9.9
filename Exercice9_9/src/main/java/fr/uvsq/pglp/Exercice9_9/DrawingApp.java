package fr.uvsq.pglp.Exercice9_9;

import java.util.Scanner;

import fr.uvsq.pglp.Exercice9_9.Command.Commands;
import fr.uvsq.pglp.Exercice9_9.exceptions.CommandException;
import fr.uvsq.pglp.Exercice9_9.exceptions.SaisieException;

public enum DrawingApp {

	ENVIRONNEMENT;

	public void run( String[] args){
		//Scanner rep = new Scanner(System.in);
		Scanner rep = new Scanner(System.in, "UTF-8");
		DrawingTUI saisie = new DrawingTUI();
		String text;
		Commands command ;
		while(Continue.isOn()) {
			System.out.print("DwAp> ");
			try {
				text = rep.nextLine();
				command = saisie.nextCommand(text);
				if (command != null) {
					command.apply(Dico.stringsplit(text));
					saisie.affich();
				}else
					throw new CommandException(Dico.stringsplit(text).get(Dico.gettypeString()));
			}catch (SaisieException e) {
				// TODO: handle exception
			}catch (CommandException e) {
				// TODO: handle exception
			}

		}

		rep.close();
	}

	public static void main( String[] args ) {

		ENVIRONNEMENT.run(args);


	}

}
