package fr.uvsq.pglp.Exercice9_9.exceptions;

public class CommandException extends Exception{
	
	public CommandException (String name) {
		System.out.println("Erreur de Command : la commande \"" + name+ "\" n'existe pas");
	}

}
