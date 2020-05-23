package fr.uvsq.pglp.Exercice9_9.Command;


import java.util.List;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.*;
import fr.uvsq.pglp.Exercice9_9.DaoFig.*;
import fr.uvsq.pglp.Exercice9_9.exceptions.ArgumentsException;
import fr.uvsq.pglp.Exercice9_9.exceptions.DaoException;
import fr.uvsq.pglp.Exercice9_9.exceptions.FigureExsitanteException;
import fr.uvsq.pglp.Exercice9_9.exceptions.FigureNonExsitanteException;

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
	 * @throws ArgumentsException 
	 * @throws FigureExsitanteException 
	 * @throws DaoException 
	 */
	public void getCercle(List<String> arg) throws ArgumentsException, FigureExsitanteException, DaoException {
		if(arg.size()!=5)
			throw new ArgumentsException(arg.get(0));
		CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
		Cercle cercl = cdao.read(arg.get(0));
		if(cercl == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {
				cercl = (Cercle) fig;
				cdao = DaoFactory.getCerlcleDAO();
				if(cdao.create(cercl)==false)
					throw new DaoException("Objet crée n'a pas pu etre enregistré dans la base de donnée");
			}
		}else
			throw new FigureExsitanteException(cercl.getName());

	}

	/**
	 * creer une instance de Rectangle 
	 * @param arg la liste d'arguments pour l'instanciation
	 * @throws ArgumentsException 
	 * @throws DaoException 
	 * @throws FigureExsitanteException 
	 */
	public void getRectangle(List<String> arg) throws ArgumentsException, DaoException, FigureExsitanteException {
		if(arg.size()!=6)
			throw new ArgumentsException(arg.get(0));
		RectangleDAO rdao = DaoFactory.getRectangleDAO();
		RectangleFig rect = rdao.read(arg.get(0));
		if(rect == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {
				rect = (RectangleFig) fig;
				rdao = DaoFactory.getRectangleDAO();
				if(rdao.create(rect)==false)
					throw new DaoException("Objet crée n'a pas pu etre enregistré dans la base de donnée");
			}
		}else
			throw new FigureExsitanteException(rect.getName());


	}

	/**
	 * creer une instance de Carre 
	 * @param arg la liste d'arguments pour l'instanciation
	 * @throws ArgumentsException 
	 * @throws FigureExsitanteException 
	 * @throws DaoException 
	 */
	public void getCarre(List<String> arg) throws ArgumentsException, FigureExsitanteException, DaoException {
		if(arg.size()!=6)
			throw new ArgumentsException(arg.get(0));
		CarreDAO cadao = DaoFactory.getCarreDAO();
		Carrer care = cadao.read(arg.get(0));
		if(care == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {
				care = (Carrer) fig;

				cadao = DaoFactory.getCarreDAO();
				if(cadao.create(care)==false)
					throw new DaoException("Objet crée n'a pas pu etre enregistré dans la base de donnée");
			}
		}else
			throw new FigureExsitanteException(care.getName());

	}

	/**
	 * creer une instance de Triangle 
	 * @param arg la liste d'arguments pour l'instanciation
	 * @throws ArgumentsException 
	 * @throws DaoException 
	 * @throws FigureExsitanteException 
	 */
	public void getTriangle(List<String> arg) throws ArgumentsException, DaoException, FigureExsitanteException {
		if(arg.size()!=8)
			throw new ArgumentsException(arg.get(0));
		TriangleDAO tdao = DaoFactory.getTriangleDAO();
		Triangle tr = tdao.read(arg.get(0));
		if(tr == null) {

			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {

				tr = (Triangle) fig;
				tdao = DaoFactory.getTriangleDAO();
				if(tdao.create(tr)==false)
					throw new DaoException("Objet crée n'a pas pu etre enregistré dans la base de donnée");
			}
		}else
			throw new FigureExsitanteException(tr.getName());

	}

	/**
	 * creer une instance de Groupe 
	 * @param arg la liste d'arguments pour l'instanciation
	 * @throws DaoException 
	 * @throws FigureExsitanteException 
	 */
	public void getGroupe(List<String> arg) throws DaoException, FigureExsitanteException {
		GroupFigDAO gdao = DaoFactory.getGroupeDAO();
		GroupFig gr = gdao.read(arg.get(0));
		if(gr == null) {
			Allfigure fig = FigFactory.getFigure(arg);
			ContFig.add(arg.get(0), fig);
			if(fig != null ) {

				gr = (GroupFig) fig;
				gdao = DaoFactory.getGroupeDAO();
				if(gdao.create(gr)==false)
					throw new DaoException("Objet crée n'a pas pu etre enregistré dans la base de donnée");
			}
		}else{
			gdao.update(gr);
		}

	}

	/**
	 * Deplace une figure ou un groupe de figure
	 * @param arg contient le nom de la figure a deplacer et les coordonnées 
	 * @throws FigureNonExsitanteException 
	 */
	public void move(List<String> arg) throws FigureNonExsitanteException ,ArgumentsException {
		if(arg.size()<=1)
			throw new ArgumentsException(arg.get(0));
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
						try {
							this.update(nextValue);
						} catch (DaoException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
					}

				}
			}else {
				try {
					this.update(fig);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			ContFig.add(arg.get(1), fig);
		}
		else
			throw new FigureNonExsitanteException(arg.get(1));
	}

	/**
	 * Afiche la description d'une figure ou en groupe de figure
	 * @param fig
	 * @throws FigureNonExsitanteException 
	 */
	public void affiche(String fig) throws FigureNonExsitanteException {

		Allfigure allfig = this.find(fig);
		if(allfig != null) {
			AfficheFig.affich(allfig);
		}else
			throw new FigureNonExsitanteException(fig);
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
	 * @throws DaoException 
	 */
	private void update(Allfigure fig) throws DaoException {
		switch (this.figFind) {
		case "Triangle":
			Triangle tr = (Triangle) fig;
			TriangleDAO tdao = DaoFactory.getTriangleDAO();
			if(tdao.update(tr)==false)
				throw new DaoException("Mise a jour de l'Objet non effectuer dans la base de donnée");
			break;
		case "Cercle":
			Cercle cercl = (Cercle) fig;
			CerlcleDAO cdao = DaoFactory.getCerlcleDAO();
			if(cdao.update(cercl)==false)
				throw new DaoException("Mise a jour de l'Objet non effectuer dans la base de donnée");
			break;
		case "RectangleFig":
			RectangleFig rect = (RectangleFig) fig;
			RectangleDAO rdao = DaoFactory.getRectangleDAO();
			if(rdao.update(rect)==false)
				throw new DaoException("Mise a jour de l'Objet non effectuer dans la base de donnée");
			break;
		case "GroupFig":
			GroupFig grp = (GroupFig) fig;
			GroupFigDAO gdao = DaoFactory.getGroupeDAO();
			if(gdao.update(grp)==false)
				throw new DaoException("Mise a jour de l'Objet non effectuer dans la base de donnée");
			break;
		case "Carrer":
			Carrer care = (Carrer) fig;
			CarreDAO cadao = DaoFactory.getCarreDAO();
			if(cadao.update(care)==false)
				throw new DaoException("Mise a jour de l'Objet non effectuer dans la base de donnée");
			break;
		default:
			break;
		}
	}


}
