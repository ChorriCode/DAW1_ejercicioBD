package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import controller.Controller;
import view.View;

public class Main {


	public static void main(String[] args) {
		View myView = new View();
		Controller myController = new Controller(null, myView);


		//Menu eleccion tipo base de datos
		myView.menuBBDD();
		myController.controlMenuBBDD(myView);

		
		

		
		
		
		
	
	}

}
