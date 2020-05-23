package fr.uvsq.pglp.Exercice9_9.Command;

import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Continue;
import fr.uvsq.pglp.Exercice9_9.exceptions.ArgumentsException;

/**
 * le receiver des commande Generic
 * @author root
 *
 */
public class Generic {

	/**
	 * la methode qui arrete le logiciel
	 * @throws ArgumentsException 
	 */
	public void quit(List<String> arg) throws ArgumentsException {
		if(arg.size()>1)
			throw new ArgumentsException(arg.get(0));
		Continue.turnOff();
	}

}
