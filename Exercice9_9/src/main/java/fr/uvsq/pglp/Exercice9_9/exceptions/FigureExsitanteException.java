package fr.uvsq.pglp.Exercice9_9.exceptions;

public class FigureExsitanteException extends Exception{
	
	public FigureExsitanteException (String name) {
		System.out.println("Erreur Creation : la figure \"" + name+ "\" existe deja");
	}
}
