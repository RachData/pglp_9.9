package fr.uvsq.pglp.Exercice9_9.exceptions;

public class ArgumentsException extends Exception{
	
	public ArgumentsException (String name) {
		System.out.println("Erreur de Command : \"" + name+ "\" manque d'arguments ....");
	}
}
