package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.HashMap;
import java.util.List;

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
	/*public void execute(String Name,List<String> arg) {
		Commands command = commandMap.get(Name);
		try {
			if (command == null) {
				System.out.println("erreur de commande ... " + Name);
				throw new IllegalStateException("no command registered for " + Name);
			}
			command.apply(arg);

		} catch (IllegalStateException e) {

		}
	}*/
	
	public Commands execute(String Name) {
		Commands command = commandMap.get(Name);
		try {
			if (command == null) {
				System.out.println("erreur de commande ... " + Name);
				throw new IllegalStateException("no command registered for " + Name);
			}
			return command;

		} catch (IllegalStateException e) {

		}
		return null;
	}
	
}
