package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;

public class CerlcleDAO extends DAO<Cercle> {


	public CerlcleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Cercle obj) {
		try {
			
			Statement s;
	        s = connect.createStatement();
			try {
		        s.execute("create table Cercle(name varchar(40), CordX double, CordY double, Rayon double, PRIMARY KEY (name))");
		        System.out.println("Created table derby");
			} catch (Exception e) {

			}
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Cercle (name, CordX, Cordy, Rayon) VALUES (?,?,?,?) ");
			prepare.setString(1, obj.getName());
			prepare.setDouble(2, obj.getCenter().getX());
			prepare.setDouble(3, obj.getCenter().getY());
			prepare.setDouble(4, obj.getRayon());
			int nbrtuple =prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public Cercle read(String name) {
		Cercle fig=null;
		Point2D centre=null;
		try {
			PreparedStatement prepare = this.connect.prepareStatement("SELECT * FROM CERCLE WHERE NAME = ?");
			prepare.setString(1, name);
			ResultSet result= prepare.executeQuery();
			if(result.next()==true) {
				fig = new Cercle(result.getString("NAME"), new Point2D(result.getDouble("CORDX"), result.getDouble("CORDY")), result.getDouble("RAYON"));
			}

		}catch (Exception e) {
			
		}
		
		return fig;
	}

	@Override
	public boolean update(Cercle obj) {
		try
		{
			PreparedStatement prepare =this.connect.prepareStatement("update Cercle set name=?,CordX=?,CordY=?,Rayon=? where name=?");
			prepare.setString(1, obj.getName());
			prepare.setDouble(2, obj.getCenter().getX());
			prepare.setDouble(3, obj.getCenter().getY());
			prepare.setDouble(4, obj.getRayon());
			prepare.setString(5, obj.getName());
			prepare.executeUpdate();
			return true;
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean delete(Cercle obj) {
		try
		{
			PreparedStatement prepare =this.connect.prepareStatement("delete from Cercle where NAME=?");
			prepare.setString(1, obj.getName());
			prepare.executeUpdate();
			return true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return false;
	}


}