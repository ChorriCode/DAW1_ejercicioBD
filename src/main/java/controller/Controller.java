package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.ConnectionDB;
import model.Model;
import view.View;

public class Controller {
	
	private Model model;
	private View view;

	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
	}
	
	private int getRowCount(ResultSet resultSet) {
	    if (resultSet == null) {
	        return 0;
	    }
	    try {
	        resultSet.last();
	        return resultSet.getRow();
	    } catch (SQLException exp) {
	        exp.printStackTrace();
	    } finally {
	        try {
	            resultSet.beforeFirst();
	        } catch (SQLException exp) {
	            exp.printStackTrace();
	        }
	    }
	    return 0;
	}

public void controlMenuBBDD(View myView) {
	String option = myView.getOption();
	Connection conn;
	ConnectionDB myConnection;
	ResultSet rs;
	String tabla = "";
	
	switch (option) {
	case "1":
		myConnection = new ConnectionDB("jdbc:mysql://localhost:3306/", 
												"tiendainformatica",
												"com.mysql.jdbc.Driver", 
												"root", 
												"Gratis007");
		//Cuando creo el objeto controller en Main no tenia aun creado el modelo y lo paso null
		//ahora que tengo los datos de la conexion, puedo incluir al objeto controller el objeto modelo que me faltaba
		this.model = new Model(myConnection);
		this.model.setConnDB(myConnection);
		conn = model.connectToBD();
		tabla = "Articulos";
		rs = model.readOnBD(conn, tabla);
		listDatasTable(rs,tabla);
		break;
	case "2":
		myConnection = new ConnectionDB("jdbc:sqlite:ficheros/TiendaInformatica.db", 
				"",
				"org.sqlite.JDBC", 
				"", 
				"");
		//Cuando creo el objeto controller en Main no tenia aun creado el modelo y lo paso null
		//ahora que tengo los datos de la conexion, puedo incluir al objeto controller el objeto modelo que me faltaba
		this.model = new Model(myConnection);
		this.model.setConnDB(myConnection);	
		conn = model.connectToBD();
		tabla = "Articulos";
		rs = model.readOnBD(conn, tabla);
		listDatasTable(rs,tabla);
		break;
	case "3":
		myConnection = new ConnectionDB("jdbc:postgresql://localhost:5432/", 
				"TiendaInformatica",
				"org.postgresql.Driver", 
				"postgres", 
				"Gratis007");
		//Cuando creo el objeto controller en Main no tenia aun creado el modelo y lo paso null
		//ahora que tengo los datos de la conexion, puedo incluir al objeto controller el objeto modelo que me faltaba
		this.model = new Model(myConnection);
		this.model.setConnDB(myConnection);	
		conn = model.connectToBD();
		tabla = "Articulos";
		rs = model.readOnBD(conn, tabla);
		listDatasTable(rs,tabla);
		break;
	}
	System.out.println("Que tenga un buen día");
}
	
public void listDatasTable(ResultSet datos, String tabla){
	ArrayList<HashMap<String,Object>> registros = new ArrayList<HashMap<String,Object>>();
	
	
	try {
		ResultSetMetaData metaData = datos.getMetaData();
		if (model.getConnDB().getDriver() != "org.sqlite.JDBC" && model.getConnDB().getDriver() != "org.postgresql.Driver" && getRowCount(datos)==0) {
			System.out.println(view.hyphenatedFill("NO HAY REGISTROS".length(), ">"));
			System.out.println("NO HAY REGISTROS");
			System.out.println(view.hyphenatedFill("NO HAY REGISTROS".length(), "<"));
			model.getConn().close();
			datos.close();
			return;
		}


		while (datos.next()) {
			HashMap<String, Object> datosUnaLinea = new HashMap<String,Object>();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				datosUnaLinea.put(metaData.getColumnName(i), datos.getObject(i));
				//datosUnaLinea.put(metaData.getColumnName(i), rs.getString(i)); //Hace lo mismo pero con otro método
				//System.out.println(rs.getString(i));					
			}
		registros.add(datosUnaLinea);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	try {
		model.getConn().close(); //cerramos la conexion que aun estaba abierta
		datos.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Esta linea va a buscar el nombre del driver del gesto de BBDD y luego extrae el nombre sin los puntos y lo pasa a mayusculas
	//para cuando imprima los datos de una tablar, recordar a que BBDD pertenece.
	String dbManagement = model.getConnDB().getDriver().split("\\.")[1].toUpperCase();
	view.showTableRegistries(registros, tabla, dbManagement);
	
}

	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}	

	
}
