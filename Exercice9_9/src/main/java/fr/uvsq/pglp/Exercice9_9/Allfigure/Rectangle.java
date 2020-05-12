package fr.uvsq.pglp.Exercice9_9.Allfigure;
import fr.uvsq.pglp.Exercice9_9.exceptions.*;

public class Rectangle implements allfigure{
	
	private String name;
	private Point2D upLeft;
	private Point2D downRight;

	/**
	 * Initilise un rectangle.
	 * @param name le nom du rectangle
	 * @param upLeft Angle gauche du rectangle
	 * @param downRight Angle droite du rectangle
	 */
	public Rectangle(String name, Point2D upLeft, Point2D downRight) throws  RectangleException
	 {  
		boolean test = upLeft.getX() <= downRight.getX() && upLeft.getY() >= downRight.getY();
		if(test==false ) {
			throw new RectangleException();
		}else {
			this.name = name;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point2D getUpLeft() {
		return upLeft;
	}

}
