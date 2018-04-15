package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import controller.Controller;
import view.View;

public class Main {


	public static void main(String[] args) {
/*		View myView = new View();
		Controller myController = new Controller(null, myView);


		//Menu eleccion tipo base de datos
		myView.menuBBDD();
		myController.controlMenuBBDD(myView);*/

		
		
		
try {
			
			//Registro el driver JDBC
			Class.forName("org.sqlite.JDBC");		
			//Abrimos una coneccion a la Base de Datos
			System.out.println("Connecting to database...");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:ficheros/TiendaInformatica.db");
			//comprueba si la coneccion es validad y asigno el valor al atributo "validConnection"
			//del objeto connDB que pertenece a la clase ConnectionDB
			
			System.out.println("Database connection ok...");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	
		
		
		
	
	}

}
