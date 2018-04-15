package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class View {
	
	private String option;
	Scanner sc; 
	
	public View() {
		this.sc = new Scanner(System.in);
	}

	public void menuBBDD() {
		
		int optionInt;
		
		System.out.println("SELECCIONAR BASE DE DATOS");
		System.out.println("1) MySQL");
		System.out.println("2) SQLite");
		System.out.println("3) PostgreSQL");
		System.out.println("4) Salir");
		
		do {
			this.option = this.sc.nextLine();
			try {
				optionInt = Integer.parseInt(option);
			} catch (Exception e) {
				//En caso de que teclemos letras dar� un error, asignamos el valor cero para que nos vuelva a preguntar
				//por un numero entre 1 y 5
				optionInt = 0;
			}
			if (optionInt<1 || optionInt>4) System.out.println("Seleccione del 1 al 4");
		} while (optionInt<1 || optionInt>4);
		
	}
	
	public void showTableRegistries(ArrayList<HashMap<String,Object>> listadosRegistros, String tabla, String dbManagement) {
		
		System.out.println("\r\r");
		hyphenatedFill(listadosRegistros.get(0).keySet().size()*23,"*");
		System.out.println("Gestor de Base de Datos: " + dbManagement);
		System.out.println("TABLA : " + tabla);
		Set<String> unRegistro = listadosRegistros.get(0).keySet();
		String[] nombreColumnasTabla = new String[unRegistro.size()];
		int indice = 0;	
		for ( String unCampo : unRegistro) {			
			System.out.printf("%-25s", unCampo + "");
			nombreColumnasTabla[indice++] = unCampo;
		}		
		System.out.println();
		String fill = hyphenatedFill(unRegistro.size()*23,"-");
		System.out.println(fill);
		for (int i = 0; i < listadosRegistros.size(); i++) {	
			for (int j = 0; j < listadosRegistros.get(i).size(); j++) {
				System.out.printf("%-25s", listadosRegistros.get(i).get(nombreColumnasTabla[j]));
			}		
			System.out.println("");
		}
		System.out.println("\r\r");
	}
	
	//Este metodo solo crea una linea de guiones para que se adapte segun las columnas que tenga la tabla
	public String hyphenatedFill(int spaces, String filler) {
		String fill = "";
		
		for (int i = 0; i < spaces; i++) {
			fill += filler;
		}
		
		
		return fill;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
