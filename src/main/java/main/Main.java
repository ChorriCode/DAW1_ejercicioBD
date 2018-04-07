package main;

import controller.Controller;
import model.ConnectionDB;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
		View myView = new View();
		Controller myController = new Controller(null, myView);
		myView.menu1();
		myController.menu1(myView);
		
		

	}

}
