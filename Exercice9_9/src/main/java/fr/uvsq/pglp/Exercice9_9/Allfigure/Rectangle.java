package fr.uvsq.pglp.Exercice9_9.Allfigure;

public class Rectangle implements allfigure{
	
	private Point2D upLeft;
	private Point2D downRight;

	/**
	 * Initilise un rectangle.
	 * 
	 * @param upLeft Angle gauche du rectangle
	 * @param downRight Angle droite du rectangle
	 */
	public Rectangle(Point2D upLeft, Point2D downRight) {
		
		assert upLeft.getX() <= downRight.getX()
				&& upLeft.getY() >= downRight.getY();
		this.upLeft = upLeft;
		this.downRight = downRight;
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
		str.append("[");
		str.append(upLeft.toString());
		str.append(", ");
		str.append(downRight.toString());
		str.append("]");
		return str.toString();
	}
}
