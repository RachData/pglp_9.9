package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.exceptions.RectangleException;

/**
 * Commande concrete pour la creation d'une figure
 * @author root
 *
 */
public class CommandeCreateFig implements SpecificCommands{

	private final InstanceFig inst; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public CommandeCreateFig(InstanceFig inst) {
		this.inst=inst;

	}

	/**
	 * excecution de la commande dans la liste
	 */
	@Override
	public void apply(List<String> arg){

		try {
			inst.getFig(arg);
		} catch (Exception e) {

		}


	}



}
