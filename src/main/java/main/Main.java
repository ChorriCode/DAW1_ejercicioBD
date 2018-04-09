package main;

import java.io.Console;

import controller.Controller;
import model.ConnectionDB;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
		View myView = new View();
		Controller myController = new Controller(null, myView);

		//Menú eleccion tipo base de datos
		myView.menuBBDD();
		myController.controlMenuBBDD(myView);
		
		

	}

}
