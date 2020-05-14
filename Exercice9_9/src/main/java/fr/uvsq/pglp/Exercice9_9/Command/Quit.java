package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

/**
 * La commande concrete quit
 * @author root
 *
 */
public class Quit implements GenericCommands {

	private final Generic quit; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit la commande quit
	 */
	public Quit(Generic quit) {
		this.quit=quit;

	}

	/**
	 * excecution de la commande Quit
	 */
	@Override
	public void apply(List<String> arg) {
		quit.quit();

	}

}
