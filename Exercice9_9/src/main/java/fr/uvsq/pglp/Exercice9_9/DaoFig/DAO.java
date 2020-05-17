package fr.uvsq.pglp.Exercice9_9.DaoFig;


import java.sql.Connection;


/**
 * Un DAO
 * @author root
 *
 * @param <T> le type du DAO
 */
public abstract class DAO<T> {

	protected Connection connect;

	/**
	 * initialise la connection avec la base de données
	 * @param conn
	 */
	public DAO(Connection conn){
		this.connect = conn;
	}


	/*
	 * CRUD:
	 *  - Create
	 *  - Read
	 *  - Update
	 *  - Delete 
	 */
	public abstract boolean create(T obj);
	public abstract T read(String name);
	public abstract boolean update(T obj);
	public abstract boolean delete(String name);

}
