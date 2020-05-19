package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * Un point
 * @author root
 *
 */

public class Point2D  extends Allfigure{

	private double x;
	private double y;

	/**
	 * Initialize from 2 coordinates.
	 * 
	 * @param x x coordonner
	 * @param y y coordonner
	 */
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * retourne la coordonnée X.
	 * 
	 * @return X coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * retourne la coordonnée Y.
	 *
	 * @return Y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * deplace le point
	 * @param dx
	 * @param dy
	 */
	@Override
	public void move(double dx, double dy) {

		x += dx;
		y += dy;

	}


	/**
	 * donne la description d'un Point.
	 * 
	 * @return en chaine de caractere la description
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append('(');
		str.append(x);
		str.append(", ");
		str.append(y);
		str.append(')');
		return str.toString();
	}



}
