package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Cercle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.GroupFig;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Iterator;
import fr.uvsq.pglp.Exercice9_9.Allfigure.ItteratorFigure;
import fr.uvsq.pglp.Exercice9_9.Allfigure.RectCarre;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Triangle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.allfigure;

public class GroupFigDAO extends DAO<GroupFig> {

	/**
	 * initilise la connection avec la base de donnée
	 * 
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
			 * Statement s; s = connect.createStatement(); try { //s.
			 * execute("create table Groupe(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE)"
			 * ); s.
			 * addBatch("create table Groupe(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE)"
			 * ); s.
			 * addBatch("CREATE TABLE appartient (nomGrp VARCHAR(40) NOT NULL UNIQUE,nomFig VARCHAR(40)) NOT NULL UNIQUE"
			 * ); s.executeBatch(); System.out.println("Created table derby"); } catch
			 * (Exception e) {
			 * 
			 * }finally { s.close();
			 * 
			 * }
			 */
			PreparedStatement prepare = null;
			try {
				prepare = connect.prepareStatement("INSERT INTO Groupe (name) VALUES (?) ");
				prepare.setString(1, obj.getName());
				prepare.executeUpdate();
				ItteratorFigure affich = new ItteratorFigure(obj);
				Iterator grouptIter = affich.getIterator();
				prepare = connect.prepareStatement("INSERT INTO appartient (nomGrp,nomFig) VALUES (?, ?)");
				while (grouptIter.HasNext()) {
					allfigure nextValue = grouptIter.Next();

					if (obj.getName() != nextValue.getName()) {
						prepare.setString(1, obj.getName());
						prepare.setString(2, nextValue.getName());
						prepare.addBatch();
					}
				}
				prepare.executeBatch();
				return true;
			} finally {
				if (prepare != null)
					prepare.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception a gerer dans CercleDAO");
		}
		return false;
	}

	/**
	 * Retourne le cercle dont le nom est "name" dans la base de données
	 */
	@Override
	public GroupFig read(String name) {
		GroupFig grpfig = null;
		allfigure fig = null ;
		PreparedStatement prepare = null;
		ResultSet result = null;

		try {

			try {
				prepare = this.connect.prepareStatement("SELECT * FROM appartient WHERE nomGrp = ?");
				prepare.setString(1, name);
				grpfig = new GroupFig(name);
				try {
					result = prepare.executeQuery();
					while (result.next() == true) {
						try {

							fig = find(result.getString("nomFig"));
							if(fig != null)
								grpfig.add(fig);

						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				} finally {
					if (result != null)
						result.close();
				}
			} finally {
				if (prepare != null) {
					prepare.close();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception a gerer dans GroupDAO");
		}

		return grpfig;
	}

	/**
	 * Effectue la mise a jour d'un cercle dans la base de données
	 */
	@Override
	public boolean update(GroupFig obj) {

		PreparedStatement prepare = null;
		String name = "";
		try {
			try {
				prepare = this.connect
						.prepareStatement("update Cercle set name=?,CordUX=?,CordUY=?,CordDX=?,CordDY=? where name=?");
				prepare.setString(1, obj.getName());
				ItteratorFigure affich = new ItteratorFigure(obj);
				Iterator grouptIter = affich.getIterator();
				while (grouptIter.HasNext()) {
					allfigure nextValue = grouptIter.Next();
					if (nextValue instanceof Cercle) {
						nextValue = (Cercle) nextValue;
						name = ((Cercle) nextValue).getName();
					} else if (nextValue instanceof RectCarre) {
						nextValue = (RectCarre) nextValue;
						name = ((RectCarre) nextValue).getName();
					} else if (nextValue instanceof Triangle) {
						nextValue = (Triangle) nextValue;
						name = ((Triangle) nextValue).getName();
					}
				}
				prepare.setString(6, obj.getName());
				prepare.executeUpdate();
				return true;
			} finally {
				prepare.close();
			}

		} catch (SQLException e) {
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
		try {
			try {
				prepare = this.connect.prepareStatement("delete from Groupe where NAME=?");
				prepare.setString(1, name);
				prepare.executeUpdate();
				return true;
			} finally {
				prepare.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

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
		RectCarre rect = rdao.read(name);
		if (rect != null) {
			return rect;
		}


		return null;
	}

}
