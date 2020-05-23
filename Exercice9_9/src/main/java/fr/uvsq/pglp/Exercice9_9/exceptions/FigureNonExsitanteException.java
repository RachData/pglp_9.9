package fr.uvsq.pglp.Exercice9_9.exceptions;

public class FigureNonExsitanteException extends Exception{
	
	public FigureNonExsitanteException (String name) {
		System.out.println("Erreur la figure  \"" + name+ "\" n'existe pas");
	}
}
