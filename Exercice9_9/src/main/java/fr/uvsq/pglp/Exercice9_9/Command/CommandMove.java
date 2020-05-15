package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

/**
 * Commande concrete pour deplaccer une figure ou un groupe de figure
 * @author root
 *
 */
public class CommandMove implements SpecificCommands{
	
	private final Specific fig; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public CommandMove(Specific fig) {
		this.fig=fig;

	}

	/**
	 * excecution de la commande dans la liste
	 */
	@Override
	public void apply(List<String> arg){

		try {
			fig.move(arg);;
		} catch (Exception e) {

		}


	}

}
