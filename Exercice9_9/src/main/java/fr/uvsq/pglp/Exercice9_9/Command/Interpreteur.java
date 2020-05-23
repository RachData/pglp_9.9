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
	public Commands execute(String Name) {
		Commands command = commandMap.get(Name);
		return command;

	}
	
}
