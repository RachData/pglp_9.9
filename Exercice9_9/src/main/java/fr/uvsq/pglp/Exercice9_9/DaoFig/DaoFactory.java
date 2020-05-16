package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;

/**
 * la fabrique Du DAO correspondant selon que sa soit une figure ou un groupe de figure
 * @author root
 *
 */
public class DaoFactory {

	private static final Connection conn=GetConnection.getInstanceConnexion();

	/**
	 * Retourne le DAO des cercles
	 * @return DAOCercle
	 */
	public static CerlcleDAO getCerlcleDAO(){
		return new CerlcleDAO(conn);
	}
	
	/**
	 * Retourne le DAO des Rectangles
	 * @return DAORectangle
	 */
	public static RectangleDAO getRectangleDAO(){
		return new RectangleDAO(conn);
	}
	
	/**
	 * Retourne le DAO des Triangles
	 * @return DAOTriangle
	 */
	public static TriangleDAO getTriangleDAO(){
		return new TriangleDAO(conn);
	}
	/*
	public static GroupFigDAO getCompositePerso(){
		return new GroupFigDAO(conn);
	}*/

}
