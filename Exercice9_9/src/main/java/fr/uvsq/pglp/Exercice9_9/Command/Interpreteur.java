package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.HashMap;

/**
 * L'interpreteur de command
 * @author root
 *
 */
public class Interpreteur {

	private final HashMap<String, Commands> commandMap = new HashMap<>();

	/**
	 * Enregitre une commande
	 * @param commandName le nom de la commande
	 * @param command la commande
	 */
	public void register(String commandName, Commands command) {
		commandMap.put(commandName, command);
	}
	
	/**
	 * execute une commande
	 * @param commandName le nom de la commande
	 */
	public void execute(String commandName) {
		Commands command = commandMap.get(commandName);
		try {
			if (command == null) {
				System.out.println("erreur de commande ...");
				throw new IllegalStateException("no command registered for " + commandName);
			}
			command.apply();

		} catch (IllegalStateException e) {

		}
	}

}
