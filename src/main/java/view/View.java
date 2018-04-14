package view;

import java.io.Console;
import java.util.Scanner;

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
				//En caso de que teclemos letras dará un error, asignamos el valor cero para que nos vuelva a preguntar
				//por un numero entre 1 y 5
				optionInt = 0;
			}
			if (optionInt<1 || optionInt>4) System.out.println("Seleccione del 1 al 4");
		} while (optionInt<1 || optionInt>4);
		
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
