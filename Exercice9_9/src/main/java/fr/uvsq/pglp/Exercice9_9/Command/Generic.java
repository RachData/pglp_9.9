package fr.uvsq.pglp.Exercice9_9.Command;

import fr.uvsq.pglp.Exercice9_9.Continue;

/**
 * le receiver des commande Generic
 * @author root
 *
 */
public class Generic {

	/**
	 * la methode qui arrete le logiciel
	 */
	public void quit() {
		Continue.turnOff();
	}

}
