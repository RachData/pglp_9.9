package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * Une figure
 * @author root
 *
 */

public abstract class allfigure {
	
	protected String name;

	/**
	 * deplace une figure
	 * 
	 * @param dx x move
	 * @param dy y move
	 */
	public abstract void move(double dx, double dy);
	
	public String getName() {
		return name;
	}
}
