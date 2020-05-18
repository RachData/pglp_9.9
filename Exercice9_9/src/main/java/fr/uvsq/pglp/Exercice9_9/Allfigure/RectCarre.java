package fr.uvsq.pglp.Exercice9_9.Allfigure;
import fr.uvsq.pglp.Exercice9_9.exceptions.*;

/**
 * Un rectangle 
 * @author root
 *
 */
public class RectCarre extends allfigure{

	private Point2D upLeft;
	private Point2D downRight;

	/**
	 * Initilise un rectangle.
	 * @param name le nom du rectangle
	 * @param upLeft Angle gauche du rectangle
	 * @param downRight Angle droite du rectangle
	 */
	public RectCarre(String name, Point2D upLeft, Point2D downRight) throws  RectangleException
	{  
		boolean test = upLeft.getX() <= downRight.getX() && upLeft.getY() >= downRight.getY();
		if(test==false ) {
			throw new RectangleException();
		}else {
			super.name = name;
			this.upLeft = upLeft;
			this.downRight = downRight;

		}


	}


	/**
	 * deplace le rectangle.
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
	 *donne la description d'un rectangle.
	 * @return en chaine de caractere la description
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append("(rectangle=");
		str.append(upLeft.toString());
		str.append(", ");
		str.append(downRight.toString());
		str.append(")");
		return str.toString();
	}

	/***
	 * Rerourne le nom du rectangle
	 * @return nom
	 */
	public String getName() {
		return super.name;
	}

	/**
	 * retourne le point a l'angle haut gauche du rectangle
	 * @return Point
	 */
	public Point2D getUpLeft() {
		return upLeft;
	}

	/**
	 * retourne le point a l'angle bas droite du rectangle
	 * @return
	 */
	public Point2D getDownRight() {
		return downRight;
	}

}
