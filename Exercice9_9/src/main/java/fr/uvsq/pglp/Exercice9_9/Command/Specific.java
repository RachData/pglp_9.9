package fr.uvsq.pglp.Exercice9_9.Command;


import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.*;
import fr.uvsq.pglp.Exercice9_9.DaoFig.*;

/**
 * Les commandes Specific
 * @author root
 *
 */
public class Specific {
	String figFind = "";
	/**
	 * creer une instance de Cercle 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getCercle(List<String> arg) {
		CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
		Cercle cercl = cdao.read(arg.get(0));
		if(cercl == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {
				cercl = (Cercle) fig;
				cdao = DaoFactory.getCerlcleDAO();
				if(cdao.create(cercl)==false)
					System.out.println("Ecpetions a gerer dans specific getcercle");
			}
		}else
			System.out.println("Ecpetions a gerer dans specific getcercle figure existant " + arg.toString());

	}

	/**
	 * creer une instance de Rectangle 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getRectangle(List<String> arg) {
		RectangleDAO rdao = DaoFactory.getRectangleDAO();
		RectangleFig rect = rdao.read(arg.get(0));
		if(rect == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {
				rect = (RectangleFig) fig;
				rdao = DaoFactory.getRectangleDAO();
				if(rdao.create(rect)==false)
					System.out.println("Ecpetions a gerer dans specific getRectangle");
			}else
				System.out.println("Ecpetions a gerer dans specific getRectangle figure existant");
		}


	}

	/**
	 * creer une instance de Carre 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getCarre(List<String> arg) {
		CarreDAO cadao = DaoFactory.getCarreDAO();
		Carrer care = cadao.read(arg.get(0));
		if(care == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {
				care = (Carrer) fig;

				cadao = DaoFactory.getCarreDAO();
				if(cadao.create(care)==false)
					System.out.println("Ecpetions a gerer dans specific getcarrer");
			}else
				System.out.println("Ecpetions a gerer dans specific getcarrer figure existant");
		}


	}

	/**
	 * creer une instance de Triangle 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getTriangle(List<String> arg) {
		TriangleDAO tdao = DaoFactory.getTriangleDAO();
		Triangle tr = tdao.read(arg.get(0));
		if(tr == null) {

			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {

				tr = (Triangle) fig;
				tdao = DaoFactory.getTriangleDAO();
				if(tdao.create(tr)==false)
					System.out.println("Ecpetions a gerer dans specific getTriangle");
			}else
				System.out.println("Ecpetions a gerer dans specific getTriangle figure existant");
		}

	}

	/**
	 * creer une instance de Groupe 
	 * @param arg la liste d'arguments pour l'instanciation
	 */
	public void getGroupe(List<String> arg) {
		GroupFigDAO gdao = DaoFactory.getGroupeDAO();
		GroupFig gr = gdao.read(arg.get(0));
		if(gr == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {

				gr = (GroupFig) fig;
				gdao = DaoFactory.getGroupeDAO();
				if(gdao.create(gr)==false)
					System.out.println("Ecpetions a gerer dans specific getGroupe");
			}else
				System.out.println("Ecpetions a gerer dans specific getGroupe figure existant");
		}else
			System.out.println("Ecpetions a gerer dans specific getGroupe figure existant");

	}

	/**
	 * Deplace une figure ou un groupe de figure
	 * @param arg
	 */
	public void move(List<String> arg) {

		Allfigure fig = this.find(arg.get(1));
		if(fig != null) {
			fig.move(Double.parseDouble(arg.get(2)), Double.parseDouble(arg.get(3)));
			if(fig instanceof GroupFig) {
				fig=(GroupFig)fig;
				ItteratorFigure affich = new ItteratorFigure(fig);
				Iterator grouptIter = affich.getIterator();
				while (grouptIter.HasNext()) {
					Allfigure nextValue=grouptIter.Next();
					if(!fig.getName().contentEquals(nextValue.getName())) {
						if(nextValue instanceof Cercle) {
							this.figFind="Cercle";
						}
						else if(nextValue instanceof RectangleFig) {
							this.figFind="RectangleFig";
						}
						else if(nextValue instanceof Carrer)
							this.figFind="Carrer";
						else if(nextValue instanceof Triangle) {
							this.figFind="Triangle";
						}
						this.update(nextValue);
					}

				}
			}else {
				this.update(fig);
			}
			ContFig.add(arg.get(1), fig);
		}
		else
			System.out.println("Exception a gerrer MOve");
	}

	/**
	 * Afiche la description d'une figure ou en groupe de figure
	 * @param fig
	 */
	public void affiche(String fig) {

		Allfigure allfig = this.find(fig);
		if(allfig != null) {
			AfficheFig.affich(allfig);
		}
		else {
			System.out.println("Exeception a gerer figure non exixtant");
		}
	}

	/**
	 * recherche le nom d'une figure
	 * @param name
	 * @return
	 */
	private Allfigure find(String name) {

		TriangleDAO tdao = DaoFactory.getTriangleDAO();
		Triangle tr = tdao.read(name);
		if (tr != null) {
			this.figFind = "Triangle";
			return tr;
		}

		CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
		Cercle cercl = cdao.read(name);
		if (cercl != null) {
			this.figFind = "Cercle";
			return cercl;
		}

		RectangleDAO rdao = DaoFactory.getRectangleDAO();
		RectangleFig rect = rdao.read(name);
		if (rect != null) {
			this.figFind = "RectangleFig";
			return rect;
		}

		CarreDAO cadao = DaoFactory.getCarreDAO();
		Carrer carerre = cadao.read(name);
		if (carerre != null) {
			this.figFind = "Carrer";
			return carerre;
		}

		GroupFigDAO gdao = DaoFactory.getGroupeDAO();
		GroupFig grp = gdao.read(name);
		if (grp != null) {
			this.figFind = "GroupFig";
			return grp;
		}
		return null;
	}

	/**
	 * Effectue la Mise a jour d'une figure
	 * @param fig
	 */
	private void update(Allfigure fig) {
		switch (this.figFind) {
		case "Triangle":
			Triangle tr = (Triangle) fig;
			TriangleDAO tdao = DaoFactory.getTriangleDAO();
			tdao.update(tr);
			break;
		case "Cercle":
			Cercle cercl = (Cercle) fig;
			CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
			cdao.update(cercl);
			break;
		case "RectangleFig":
			RectangleFig rect = (RectangleFig) fig;
			RectangleDAO rdao = DaoFactory.getRectangleDAO();
			rdao.update(rect);
			break;
		case "GroupFig":
			GroupFig grp = (GroupFig) fig;
			GroupFigDAO gdao = DaoFactory.getGroupeDAO();
			gdao.update(grp);
			break;
		case "Carrer":
			Carrer care = (Carrer) fig;
			CarreDAO cadao = DaoFactory.getCarreDAO();
			cadao.update(care);
			break;
		default:
			break;
		}
	}


}
