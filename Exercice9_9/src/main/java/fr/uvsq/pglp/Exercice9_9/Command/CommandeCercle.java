package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.exceptions.ArgumentsException;

/**
 * Commande concrete pour la creation d'une figure
 * @author root
 *
 */
public class CommandeCercle implements SpecificCommands{

	private final Specific inst; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public CommandeCercle(Specific inst) {
		this.inst=inst;

	}

	/**
	 * excecution de la commande dans la liste
	 */
	@Override
	public void apply(List<String> arg){

		try {
			inst.getCercle(arg);
		} catch (Exception e) {
		}

	}



}
