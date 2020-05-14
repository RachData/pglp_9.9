package fr.uvsq.pglp.Exercice9_9.Allfigure;

/**
 * un triangle
 * @author root
 *
 */

public class Triangle implements allfigure{

	private String name;
	private Point2D downLeft;
	private Point2D downRight;
	private Point2D sommet;

	/**
	 * Initailise un triangle
	 * @param name Le nom du Triangle
	 * @param sommet Le sommet du triaangle
	 * @param downLeft le point a l'angle bas gauche du triangle
	 * @param downRight le point a l'angle bas droit du triangle
	 */
	public Triangle(String name, Point2D sommet, Point2D downLeft, Point2D downRight) {
		this.name = name;
		this.sommet=sommet;
		this.downLeft = downLeft;
		this.downRight = downRight;
	}


	/**
	 * deplace le triangle
	 * 
	 * @param dx deplacer a x
	 * @param dy deplacer en y
	 */
	@Override
	public void move(double dx, double dy) {
		sommet.move(dx, dy);
		downLeft.move(dx, dy);
		downRight.move(dx, dy);
	}

	/**
	 *donne la description d'un cercle.
	 * @return en chaine de caractere la description
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append("(triangle=");
		str.append(downLeft.toString());
		str.append(", ");
		str.append(downRight.toString());
		str.append(")");
		return str.toString();
	}

	/**
	 * Retourne le nom du triangle
	 * @return le Nom
	 */
	public String getName() {
		return name;
	}

	/**
	 * retourne le point bas gauche du triangle
	 * @return Un point
	 */
	public Point2D getDownLeft() {
		return downLeft;
	}

	/**
	 * retourne le point bas droite du triangle
	 * @return Un point
	 */
	public Point2D getDownRight() {
		return downRight;
	}

	/**
	 * retourne le sommet du triangle
	 * @return Un point
	 */
	public Point2D getSommet() {
		return sommet;
	}
}
