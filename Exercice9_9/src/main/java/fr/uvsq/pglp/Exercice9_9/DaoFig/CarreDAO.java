package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Carrer;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Point2D;
import fr.uvsq.pglp.Exercice9_9.exceptions.RectangleException;

public class CarreDAO extends DAO<Carrer> {
	

	/**
	 * initilise la connection avec la base de donnée
	 * @param conn la connection
	 */
	public CarreDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Insere un cercle dans la base de données
	 */
	@Override
	public boolean create(Carrer obj) {


		try {
			/*

			Statement s;
			s = connect.createStatement();
			try {
				s.execute("create table Carre(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordUX double, CordUY double, CordDX double, CordDY double)");
				System.out.println("Created table derby");
			} catch (Exception e) {

			}finally {
				s.close();

			}*/

			PreparedStatement prepare = null;
			try {
				prepare = connect.prepareStatement("INSERT INTO Carre (name, CordUX, CordUy,CordDX, CordDy) VALUES (?,?,?,?,?) ");
				prepare.setString(1, obj.getName());
				prepare.setDouble(2, obj.getUpLeft().getX());
				prepare.setDouble(3, obj.getUpLeft().getY());
				prepare.setDouble(4, obj.getDownRight().getX());
				prepare.setDouble(5, obj.getDownRight().getY());
				prepare.executeUpdate();
				return true;
			} finally {
				prepare.close();
			}

		} catch (SQLException e) {
			
		}
		return false;
	}

	/**
	 * Retourne le cercle dont le nom est "name" dans la base de données
	 */
	@Override
	public Carrer read(String name) {
		Carrer fig=null;

		PreparedStatement prepare = null;
		ResultSet result= null;

		try {

			try {
				prepare = this.connect.prepareStatement("SELECT * FROM Carre WHERE NAME = ?");
				prepare.setString(1, name);

				try {
					result= prepare.executeQuery();
					if(result.next()==true) {

						fig = new Carrer(result.getString("NAME"), new Point2D(result.getDouble("CORDUX"), result.getDouble("CORDUY")), new Point2D(result.getDouble("CORDDX"), result.getDouble("CORDDY")));

					}
				} catch (RectangleException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
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
	public boolean update(Carrer obj) {

		PreparedStatement prepare = null;
		try
		{
			try {
				prepare =this.connect.prepareStatement("update Carre set name=?,CordUX=?,CordUY=?,CordDX=?,CordDY=? where name=?");
				prepare.setString(1, obj.getName());
				prepare.setDouble(2, obj.getUpLeft().getX());
				prepare.setDouble(3, obj.getUpLeft().getY());
				prepare.setDouble(4, obj.getDownRight().getX());
				prepare.setDouble(5, obj.getDownRight().getY());
				prepare.setString(6, obj.getName());
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
				prepare =this.connect.prepareStatement("delete from Carre where NAME=?");
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
