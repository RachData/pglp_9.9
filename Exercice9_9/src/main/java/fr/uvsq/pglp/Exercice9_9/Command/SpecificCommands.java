package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

/**
 * Une Commande Sepecifique
 * @author root
 *
 */
public interface SpecificCommands extends Commands {
	
	/**
	 * execute la commande Specifique
	 */
	public void apply(List<String> arg);

}
