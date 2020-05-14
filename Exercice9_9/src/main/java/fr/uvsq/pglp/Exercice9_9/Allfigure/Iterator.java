package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * Interface pour l'iteration des groupes de figures
 * @author root
 *
 */
public interface Iterator {
	/**
	 * Verifie si on a toujours un element dans la liste gu groupe
	 * @return true or false
	 */
	public boolean HasNext();

	/**
	 * return une figure dans la liste groupe
	 * @return une figure
	 */
	public allfigure Next();

}
