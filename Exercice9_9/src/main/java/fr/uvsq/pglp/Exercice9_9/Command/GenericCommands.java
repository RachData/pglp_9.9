package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

/**
 * Une commande generic
 * @author root
 *
 */

public interface GenericCommands extends Commands{
	/**
	 * execute le commande generic
	 */
	public void apply(List<String> arg);

}
