package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Model {
	
	private ConnectionDB connDB;
	private Connection conn;
	
	
	public Model(ConnectionDB connDB) {
		super();
		this.connDB = connDB;
	}


	public Connection connectToBD() {
		
		this.conn = null;
		try {
			
			//Registro el driver JDBC
			Class.forName(connDB.getDriver());		
			//Abrimos una coneccion a la Base de Datos
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(connDB.getUrl()+connDB.getDbName(),connDB.getUserName(),connDB.getPassword());
			//comprueba si la coneccion es validad y asigno el valor al atributo "validConnection"
			//del objeto connDB que pertenece a la clase ConnectionDB
			connDB.setValidConnection(conn.isValid(1000)); 
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("Database connection ok...");
		
		return conn;
	}


	public ConnectionDB getConnDB() {
		return connDB;
	}


	public void setConnDB(ConnectionDB connDB) {
		this.connDB = connDB;
	}

}
