package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

/**
 * les Commands
 * @author root
 *
 */
public interface Commands {
	/**
	 * execute une commande
	 */
	public void apply(List<String> arg);
}
