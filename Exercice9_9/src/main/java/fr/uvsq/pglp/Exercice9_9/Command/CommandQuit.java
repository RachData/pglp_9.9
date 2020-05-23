package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.exceptions.ArgumentsException;

/**
 * La commande concrete quit
 * @author root
 *
 */
public class CommandQuit implements GenericCommands {

	private final Generic quit; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit la commande quit
	 */
	public CommandQuit(Generic quit) {
		this.quit=quit;

	}

	/**
	 * excecution de la commande Quit
	 */
	@Override
	public void apply(List<String> arg) {
		try {
			quit.quit(arg);
		} catch (ArgumentsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	}

}
