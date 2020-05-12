package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * la connexion de la base de données
 * @author root
 *
 */
public class GetConnection {
	
	private static String JDBC_URL="jdbc:derby:FigureBD;create=true";
	private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	
	/**
	 * retourne la connection a la base de données
	 * @return
	 */
	public static Connection getInstanceConnexion()
	{
		try {
			
				Class.forName(DRIVER);
			
				Connection connec =DriverManager.getConnection(JDBC_URL);
				if (connec!=null)
				{
					System.out.println("connexion au serveur de Bd reuissi");
					return connec;
				}
		} catch (SQLException e )
		{
			System.out.println("echec de connexion");
		}
		catch (ClassNotFoundException e) 
		{
	        System.out.println(e.getMessage());
	        System.out.println("ERREUR : charger derby.jdbc.EmbeddedDriver ");
	       
	    }
		return null;
	}

}
