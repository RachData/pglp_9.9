package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * un cercle
 * @author root
 *
 */

public class Cercle2D implements allfigure{
	
	private Point2D center;
	private double rayon;

	/**
	 * Initialisation du cerle 
	 * son centre et son rayon.
	 * @param center the center
	 * @param radius the radius
	 */
	public Cercle2D(Point2D center, double radius) {
		this.center = center;
		this.rayon = radius;
	}

	
	/**
	 * retourn le rayon du cercle.
	 * 
	 * @return le rayon
	 */
	public double getRadius() {
		return rayon;
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
		str.append("Cercle(centre=");
		str.append(center.toString());
		str.append(", rayon=");
		str.append(rayon);
		str.append(')');
		return str.toString();
	}



}
