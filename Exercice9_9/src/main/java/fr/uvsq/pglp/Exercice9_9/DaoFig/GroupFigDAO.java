package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Cercle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.GroupFig;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Iterator;
import fr.uvsq.pglp.Exercice9_9.Allfigure.ItteratorFigure;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Point2D;
import fr.uvsq.pglp.Exercice9_9.Allfigure.RectCarre;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Triangle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.allfigure;

public class GroupFigDAO extends DAO<GroupFig> {

	/**
	 * initilise la connection avec la base de donnée
	 * @param conn la connection
	 */
	public GroupFigDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Insere un cercle dans la base de données
	 */
	@Override
	public boolean create(GroupFig obj) {


		try {

			/*
			Statement s;
			s = connect.createStatement();
			try {
				s.execute("create table Groupe(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE)");
				System.out.println("Created table derby");
			} catch (Exception e) {

			}finally {
				s.close();

			}*/

			PreparedStatement prepare = null;
			try {
				String name ="";
				prepare = connect.prepareStatement("INSERT INTO Groupe (name) VALUES (?) ");
				prepare.setString(1, obj.getName());
				ItteratorFigure affich = new ItteratorFigure(obj);
				Iterator grouptIter = affich.getIterator();
				while (grouptIter.HasNext()) {
					allfigure nextValue=grouptIter.Next();
					if(nextValue instanceof Cercle) {
						nextValue = (Cercle)nextValue;
						name = ((Cercle) nextValue).getName();
					}
					else
						if(nextValue instanceof RectCarre){
							nextValue = (RectCarre)nextValue;
							name = ((RectCarre) nextValue).getName();
						}
						else
							if(nextValue instanceof Triangle){
								nextValue = (Triangle)nextValue;
								name = ((Triangle) nextValue).getName();
							}

					prepare = connect.prepareStatement(
							"INSERT INTO appartient "
									+ "VALUES (?, ?)");
					prepare.setString(1, obj.getName());
					prepare.setString(2, name);
					prepare.addBatch();
				}

				prepare.executeBatch();
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
	public GroupFig read(String name) {
		GroupFig fig=null;

		PreparedStatement prepare = null;
		ResultSet result= null;

		try {

			try {
				prepare = this.connect.prepareStatement("SELECT * FROM appartient WHERE id = ?");
				prepare.setString(1, name);

				try {
					result= prepare.executeQuery();
					if(result.next()==true) {
						try {
							fig = new GroupFig(name);

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
	public boolean update(GroupFig obj) {

		PreparedStatement prepare = null;
		String name ="";
		try
		{
			try {
				prepare =this.connect.prepareStatement("update Cercle set name=?,CordUX=?,CordUY=?,CordDX=?,CordDY=? where name=?");
				prepare.setString(1, obj.getName());
				ItteratorFigure affich = new ItteratorFigure(obj);
				Iterator grouptIter = affich.getIterator();
				while (grouptIter.HasNext()) {
					allfigure nextValue=grouptIter.Next();
					if(nextValue instanceof Cercle) {
						nextValue = (Cercle)nextValue;
						name = ((Cercle) nextValue).getName();
					}
					else
						if(nextValue instanceof RectCarre){
							nextValue = (RectCarre)nextValue;
							name = ((RectCarre) nextValue).getName();
						}
						else
							if(nextValue instanceof Triangle){
								nextValue = (Triangle)nextValue;
								name = ((Triangle) nextValue).getName();
							}
				}
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
