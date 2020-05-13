package fr.uvsq.pglp.Exercice9_9.Command;

/**
 * La commande concrete quit
 * @author root
 *
 */
public class Quit implements GenericCommands {
	
private final Generic quit; 
	/**
	 * initialise le receiver pour la command quit
	 * @param quit
	 */
	public Quit(Generic quit) {
		this.quit=quit;
		
	}
	
	/**
	 * excecution de la commande Quit
	 */
	@Override
	public void apply() {
		quit.quit();
		
	}

}
