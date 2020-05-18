package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;

/**
 * DAO pour les cercles
 * @author root
 *
 */
public class CerlcleDAO extends DAO<Cercle> {

	/**
	 * initilise la connection avec la base de donnée
	 * @param conn la connection
	 */
	public CerlcleDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Insere un cercle dans la base de données
	 */
	@Override
	public boolean create(Cercle obj) {


		try {
			/*
			Statement s;
			s = connect.createStatement();
			try {
				s.execute("create table Cercle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordX double, CordY double, Rayon double)");
				System.out.println("Created table derby");
			} catch (Exception e) {

			}finally {
				s.close();

			}*/

			PreparedStatement prepare = null;
			try {
				prepare = connect.prepareStatement("INSERT INTO Cercle (name, CordX, Cordy, Rayon) VALUES (?,?,?,?) ");
				prepare.setString(1, obj.getName());
				prepare.setDouble(2, obj.getCenter().getX());
				prepare.setDouble(3, obj.getCenter().getY());
				prepare.setDouble(4, obj.getRayon());
				prepare.executeUpdate();
			} finally {
				prepare.close();
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Exception a gerer dans CercleDAO");
		}
		return false;
	}

	/**
	 * Retourne le cercle dont le nom est "name" dans la base de données
	 */
	@Override
	public Cercle read(String name) {
		Cercle fig=null;

		PreparedStatement prepare = null;
		ResultSet result= null;

		try {

			try {
				prepare = this.connect.prepareStatement("SELECT * FROM CERCLE WHERE NAME = ?");
				prepare.setString(1, name);

				try {
					result= prepare.executeQuery();
					if(result.next()==true) {
						fig = new Cercle(result.getString("NAME"), new Point2D(result.getDouble("CORDX"), result.getDouble("CORDY")), result.getDouble("RAYON"));
					}
				}finally {
					if(result != null)
						result.close();
				}
			} finally {
				if(prepare != null)
					prepare.close();
			}

		} catch (SQLException e) {
			System.out.println("Exception a gerer dans CercleDAO");
		}


		return fig;
	}

	/**
	 * Effectue la mise a jour d'un cercle dans la base de données
	 */
	@Override
	public boolean update(Cercle obj) {

		PreparedStatement prepare = null;
		try
		{
			try {
				prepare =this.connect.prepareStatement("update Cercle set name=?,CordX=?,CordY=?,Rayon=? where name=?");
				prepare.setString(1, obj.getName());
				prepare.setDouble(2, obj.getCenter().getX());
				prepare.setDouble(3, obj.getCenter().getY());
				prepare.setDouble(4, obj.getRayon());
				prepare.setString(5, obj.getName());
				prepare.executeUpdate();
				return true;
			} finally {
				prepare.close();
			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return false;
	}

	/**
	 * Supprime un cercle de la base de données
	 */
	@Override
	public boolean delete(String name) {

		PreparedStatement prepare = null;
		try
		{
			try {
				prepare =this.connect.prepareStatement("delete from Cercle where NAME=?");
				prepare.setString(1, name);
				prepare.executeUpdate();
				return true;
			} finally {
				prepare.close();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return false;
	}


}
