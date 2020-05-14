package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * un cercle
 * @author root
 *
 */

public class Cercle implements allfigure{
	private String name;
	private Point2D center;
	private double rayon;

	/**
	 * Initialisation du cerle 
	 * son centre et son rayon.
	 * @param center the center
	 * @param radius the radius
	 */
	public Cercle(String name, Point2D center, double radius) {
		this.name = name;
		this.center = center;
		this.rayon = radius;
	}


	/**
	 * deplace le centee du cercle
	 */

	@Override
	public void move(double dx, double dy) {

		center.move(dx, dy);
	}


	/**
	 * donne la description d'un cercle.
	 * @return en chaine de caractere la description
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append("(centre=");
		str.append(center.toString());
		str.append(", rayon=");
		str.append(rayon);
		str.append(')');
		return str.toString();
	}

	public String getName() {
		return name;
	}


	/**
	 * retourn le rayon du cercle.
	 * 
	 * @return le rayon
	 */
	public double getRayon() {
		return rayon;
	}

	/**
	 * retourne le centre d'un rayon
	 * @return
	 */

	public Point2D getCenter() {
		return center;
	}


}
