package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Point2D;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Triangle;

public class TriangleDAO extends DAO<Triangle>{
	
	/**
	 * initilise la connection avec la base de donnée
	 * @param conn la connection
	 */
	public TriangleDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Insere un cercle dans la base de données
	 */
	@Override
	public boolean create(Triangle obj) {


		try {

			Statement s;
			s = connect.createStatement();
			try {
				s.execute("create table Triangle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordSX double, CordSY double, CordDLX double, CordDLY double, CordDRX double, CordDRY double)");
				System.out.println("Created table derby");
			} catch (Exception e) {

			}finally {
				s.close();

			}

			PreparedStatement prepare = null;
			try {
				prepare = connect.prepareStatement("INSERT INTO Cercle (name, CordUX, CordUy,CordDX, CordDy) VALUES (?,?,?,?,?,?,?) ");
				prepare.setString(1, obj.getName());
				prepare.setDouble(2, obj.getSommet().getX());
				prepare.setDouble(2, obj.getSommet().getY());
				prepare.setDouble(2, obj.getDownLeft().getX());
				prepare.setDouble(3, obj.getDownLeft().getY());
				prepare.setDouble(4, obj.getDownRight().getX());
				prepare.setDouble(5, obj.getDownRight().getY());
				prepare.executeUpdate();
				return true;
			} finally {
				prepare.close();
			}
			
		} catch (SQLException e) {
			System.out.println("Exception a gerer dans CercleDAO");
		}
		return false;
	}

	/**
	 * Retourne le cercle dont le nom est "name" dans la base de données
	 */
	@Override
	public Triangle read(String name) {
		Triangle fig=null;

		PreparedStatement prepare = null;
		ResultSet result= null;
		
		try {
			
			try {
				prepare = this.connect.prepareStatement("SELECT * FROM CERCLE WHERE NAME = ?");
				prepare.setString(1, name);
				
				try {
					result= prepare.executeQuery();
					if(result.next()==true) {
						try {
							fig = new Triangle(result.getString("NAME"), new Point2D(result.getDouble("CORDSX"), result.getDouble("CORDSY")), new Point2D(result.getDouble("CORDDLX"), result.getDouble("CORDDLY")), new Point2D(result.getDouble("CORDDRX"), result.getDouble("CORDDRY")));
						} catch (Exception e) {
						}
					}
				}finally {
					if(result != null)
						result.close();
				}
			} finally {
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
	public boolean update(Triangle obj) {

		PreparedStatement prepare = null;
		try
		{
			try {
				prepare =this.connect.prepareStatement("update Cercle set name=?,CordSX=?,CordSY=?,CordDLX=?,CordDRY=?,CordDRX=?,CordDRY=? where name=?");
				prepare.setString(1, obj.getName());
				prepare.setDouble(2, obj.getSommet().getX());
				prepare.setDouble(3, obj.getSommet().getY());
				prepare.setDouble(4, obj.getDownLeft().getX());
				prepare.setDouble(5, obj.getDownLeft().getY());
				prepare.setDouble(6, obj.getDownRight().getX());
				prepare.setDouble(7, obj.getDownRight().getY());
				prepare.setString(8, obj.getName());
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
	public boolean delete(Triangle obj) {

		PreparedStatement prepare = null;
		try
		{
			try {
				prepare =this.connect.prepareStatement("delete from Cercle where NAME=?");
				prepare.setString(1, obj.getName());
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
