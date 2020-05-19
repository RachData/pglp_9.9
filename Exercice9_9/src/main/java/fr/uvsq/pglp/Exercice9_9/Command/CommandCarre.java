package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

public class CommandCarre implements Commands {
	
	private final Specific inst; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public CommandCarre(Specific inst) {
		this.inst=inst;

	}

	/**
	 * excecution de la commande dans la liste
	 */
	@Override
	public void apply(List<String> arg){

		try {
			inst.getCarre(arg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception a gerer dans commandeCreateFig");
		}

	}

}
