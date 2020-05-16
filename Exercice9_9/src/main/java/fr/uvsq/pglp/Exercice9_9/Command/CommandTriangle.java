package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

public class CommandTriangle implements Commands{
	
	
	private final Specific inst; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public CommandTriangle(Specific inst) {
		this.inst=inst;

	}

	/**
	 * excecution de la commande dans la liste
	 */
	@Override
	public void apply(List<String> arg){

		try {
			inst.getTriangle(arg);
		} catch (Exception e) {
			System.out.println("exception a gerer dans commandeCreateFig");
		}

	}


	

}
