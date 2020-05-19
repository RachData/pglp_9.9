package fr.uvsq.pglp.Exercice9_9.CreationFigure;

import java.util.List;
import fr.uvsq.pglp.Exercice9_9.Allfigure.*;
import fr.uvsq.pglp.Exercice9_9.DaoFig.CarreDAO;
import fr.uvsq.pglp.Exercice9_9.DaoFig.CerlcleDAO;
import fr.uvsq.pglp.Exercice9_9.DaoFig.DaoFactory;
import fr.uvsq.pglp.Exercice9_9.DaoFig.GroupFigDAO;
import fr.uvsq.pglp.Exercice9_9.DaoFig.RectangleDAO;
import fr.uvsq.pglp.Exercice9_9.DaoFig.TriangleDAO;

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
	private static final String GROUPE = "GROUPE";

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
			Point2D centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)));
			fig = new Cercle(args.get(0),centre , Double.parseDouble(args.get(4)));
			break;

		case RECTANGLE:
			centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)));//anglehautdroit
			Point2D anglebasgauche = new Point2D(Double.parseDouble(args.get(4)), Double.parseDouble(args.get(5)));
			try {
				fig = new RectangleFig(args.get(0), centre, anglebasgauche);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;

		case CARRE:
			centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)));//anglehautdroit
			anglebasgauche = new Point2D(Double.parseDouble(args.get(4)), Double.parseDouble(args.get(5)));
			try {
				fig = new Carrer(args.get(0), centre, anglebasgauche);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("figFactory");
			break;

		case TRIANGLE:
			centre = new Point2D(Double.parseDouble(args.get(2)), Double.parseDouble(args.get(3)));//sommet
			anglebasgauche = new Point2D(Double.parseDouble(args.get(4)), Double.parseDouble(args.get(5)));
			Point2D anglebasdroit = new Point2D(Double.parseDouble(args.get(6)), Double.parseDouble(args.get(7)));
			fig = new Triangle(args.get(0), centre, anglebasgauche,anglebasdroit);
			break;

		case GROUPE:
			GroupFig grp = new GroupFig(args.get(0));
			if(args.size() > 1) {
				int i=2;
				while(i<args.size()) {
					fig = find(args.get(i));
					if(fig != null)
						grp.add(fig);
					else
						System.out.println("exception a gerer dans FigFactory groupe");
					i++;
				}
				fig = grp ;
			}
			break;
		default:

		}

		return fig;
	}
	/*
	private allfigure find(allfigure nextValue) {
		
		if(nextValue instanceof Cercle) {
			String name = nextValue.getName();
			CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
			Cercle cercl = cdao.read(name);
			if (cercl != null) {
				return cercl;
			}
		}
		else
			if(nextValue instanceof RectCarre){
				String name = nextValue.getName();
				RectangleDAO rdao = DaoFactory.getRectangleDAO();
				RectCarre rect = rdao.read(name);
				if (rect != null) {
					return rect;
				}
			}
			else
				if(nextValue instanceof Triangle){
					String name = nextValue.getName();
					TriangleDAO tdao = DaoFactory.getTriangleDAO();
					Triangle tr = tdao.read(name);
					if (tr != null) {
						return tr;
					}
				}
/*	
		GroupFigDAO gdao = DaoFactory.getGroupeDAO();
		GroupFig grp = gdao.read(name);
		if (grp != null) {
			this.figFind = "GroupFig";
			return grp;
		}
*
		return null;
	}*/
	
	private static allfigure find(String name) {

		TriangleDAO tdao = DaoFactory.getTriangleDAO();
		Triangle tr = tdao.read(name);
		if (tr != null) {
			return tr;
		}

		CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
		Cercle cercl = cdao.read(name);
		if (cercl != null) {
			return cercl;
		}

		RectangleDAO rdao = DaoFactory.getRectangleDAO();
		RectangleFig rect = rdao.read(name);
		if (rect != null) {
			return rect;
		}
		
		CarreDAO cadao = DaoFactory.getCarreDAO();
		Carrer carerre = cadao.read(name);
		if (carerre != null) {
			return carerre;
		}
		
		/*GroupFigDAO gdao = DaoFactory.getGroupeDAO();
		GroupFig grp = gdao.read(name);
		if (grp != null) {
			return grp;
		}*/

		return null;
	}


}
