package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * la connexion de la base de données
 * @author root
 *
 */
public class GetConnection {

	private static String JDBC_URL="jdbc:derby:FigureBD;create=true";
	private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	//private static final String DRIVER="derby.jdbc.EmbeddedDriver";

	public static void dropCreateTables() {
		Statement state;
		try (Connection connect = getInstanceConnexion()) {
			state = connect.createStatement();
			state.addBatch("DROP TABLE Cercle");
			state.addBatch("DROP TABLE Rectangle");
			state.addBatch("DROP TABLE Triangle");
			/*state.addBatch("DROP TABLE Groupe");
			state.addBatch("DROP TABLE appartient");
			state.addBatch("create table Cercle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordX double, CordY double, Rayon double)");
			state.addBatch("create table Rectangle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordUX double, CordUY double, CordDX double, CordDY double)");
			state.addBatch("create table Triangle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordSX double, CordSY double, CordDLX double, CordDLY double, CordDRX double, CordDRY double)");
			state.addBatch("create table Groupe(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE)");
			state.addBatch("CREATE TABLE appartient (Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,nomGrp VARCHAR(40),nomFig VARCHAR(40))");*/
			state.executeBatch();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createTables() {
		try (Connection connect = DriverManager.getConnection(JDBC_URL)) {
			Statement state = connect.createStatement();
			state.addBatch("create table Cercle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordX double, CordY double, Rayon double)");
			state.addBatch("create table Rectangle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordUX double, CordUY double, CordDX double, CordDY double)");
			state.addBatch("create table Triangle(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE, CordSX double, CordSY double, CordDLX double, CordDLY double, CordDRX double, CordDRY double)");
			state.addBatch("create table Groupe(Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,name varchar(40) NOT NULL UNIQUE)");
			state.addBatch("CREATE TABLE appartient (Id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,nomGrp VARCHAR(40) NOT NULL,nomFig VARCHAR(40) NOT NULL)");
			state.executeBatch();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}



	/**
	 * retourne la connection a la base de données
	 * @return la connexion
	 */
	public static Connection getInstanceConnexion()
	{
		try {

			//Class.forName(DRIVER);
			Connection connec =DriverManager.getConnection(JDBC_URL);
			if (connec!=null)
				return connec;
		} catch (SQLException e )
		{
			e.printStackTrace();
			System.out.println("echec de connexion");
		}
		/*catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERREUR : charger derby.jdbc.EmbeddedDriver ");

		}*/
		return null;
	}

}
