package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Model {
	
	private ConnectionDB connDB;
	private Connection conn;
	
	
	public Model(ConnectionDB connDB) {
		super();
		this.connDB = connDB;
	}

	//Método que conecta con la base de datos seleccionada.
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
			System.out.println("Database connection ok...");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	
		return conn;
	}

	// ************* C R U D -- INSERT   READ   UPDATE   DELETE **************
	
	public void createoOnBD() {
		
	}
	
	public ResultSet readOnBD(Connection conn, String tabla) {
		String sql = "select * from " + tabla;
		ResultSet myResulSet = null ;
		try {
			Statement myStatement = conn.createStatement();
			myResulSet = myStatement.executeQuery(sql);
		} catch (SQLException e) {;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myResulSet;
	}
	
	public void updateOnBD() {
		
	}
	
	public void  deleteOnBD() {
		
	}

	public ConnectionDB getConnDB() {
		return connDB;
	}


	public void setConnDB(ConnectionDB connDB) {
		this.connDB = connDB;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
