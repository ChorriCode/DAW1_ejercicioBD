package controller;

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

public void menu1(View myView) {
	String option = myView.getOption();
	
	switch (option) {
	case "1":
		ConnectionDB myConnection = new ConnectionDB("jdbc:mysql://localhost:3306/", 
												"tiendainformatica",
												"com.mysql.jdbc.Driver", 
												"root", 
												"Gratis007");
		//Cuando creé el objeto controller en Main no tenía aún creado el modelo y lo pasé null
		//ahora que tengo los datos de la conexión, puedo añadir al objeto controller el objeto modelo que me faltaba
		this.model = new Model(myConnection);
		System.out.println("option: " + this.model);
		this.model.setConnDB(myConnection);
		model.connectToBD();
		break;
	case "2":
		break;
	case "3":
		break;
	}
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
