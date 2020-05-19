package fr.uvsq.pglp.Exercice9_9.Allfigure;

import fr.uvsq.pglp.Exercice9_9.exceptions.RectangleException;

/**
 * Un carre
 * @author root
 *
 */
public class Carrer extends Allfigure {
	
	private Point2D upLeft;
	private Point2D downRight;

	/**
	 * Initilise un carre.
	 * @param name le nom du carre
	 * @param upLeft Angle gauche du carre
	 * @param downRight Angle droite du carre
	 */
	public Carrer(String name, Point2D upLeft, Point2D downRight) throws  RectangleException
	{  
		boolean test = upLeft.getX() == downRight.getY() && upLeft.getY() == downRight.getX();
		if(test==false ) {
			throw new RectangleException();
		}else {
			super.name = name;
			this.upLeft = upLeft;
			this.downRight = downRight;

		}


	}


	/**
	 * deplace le carre.
	 * 
	 * @param dx deplacer a x
	 * @param dy deplacer en y
	 */
	@Override
	public void move(double dx, double dy) {
		upLeft.move(dx, dy);
		downRight.move(dx, dy);
	}

	/**
	 *donne la description d'un carre.
	 * @return en chaine de caractere la description
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append("(Carre=");
		str.append(upLeft.toString());
		str.append(", ");
		str.append(downRight.toString());
		str.append(")");
		return str.toString();
	}

	/***
	 * Rerourne le nom du carre
	 * @return nom
	 */
	public String getName() {
		return super.name;
	}

	/**
	 * retourne le point a l'angle haut gauche du carre
	 * @return Point
	 */
	public Point2D getUpLeft() {
		return upLeft;
	}

	/**
	 * retourne le point a l'angle bas droite du carre
	 * @return
	 */
	public Point2D getDownRight() {
		return downRight;
	}


}
