package fr.uvsq.pglp.Exercice9_9.DaoFig;

import java.io.Serializable;
import java.sql.Connection;

public abstract class DAO<T> implements Serializable {
	
	protected Connection connect;
	   
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
	public abstract boolean delete(T obj);

}
