package fr.uvsq.pglp.Exercice9_9.CreationFigure;

import java.util.List;
import fr.uvsq.pglp.Exercice9_9.Allfigure.*;
import fr.uvsq.pglp.Exercice9_9.exceptions.RectangleException;

/**
 * la fabrique de figure
 * @author root
 *
 */
public class FigFactory {

	private static final String CERCLE = "CERCLE";
	private static final String RECTANGLE = "RECTANGLE";
	private static final String CARRE = "CARRE";
	private static final String TRIANGLE = "TRIANGLE";

	/**
	 * retourne une instance de la figure
	 * @param args les arguments qui servent a instancier une figure
	 * @return la figure
	 */
	public static allfigure getFigure(List<String> args) {

		allfigure fig = null;
		String typeFigure = args.get(1).toUpperCase();
		switch (typeFigure) {
		case CERCLE:
			Point2D centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			fig = new Cercle(args.get(0),centre , Double.parseDouble(args.get(4)));
			break;
		case RECTANGLE:
			centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			Point2D anglebasgauche = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			try {
				fig = new RectCarre(args.get(0), centre, anglebasgauche);
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case CARRE:
			centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			anglebasgauche = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			fig = new Cercle(args.get(0),centre , Double.parseDouble(args.get(4)));
			break;
		case TRIANGLE:
			Point2D anglebasdroit = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			anglebasgauche = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(2)));
			fig = new Cercle(args.get(0),centre , Double.parseDouble(args.get(4)));
			break;
		}

		return fig;
	}

}
