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
			optionInt = Integer.parseInt(option);
			if (optionInt<1 || optionInt>4) System.out.println("Seleccione del 1 al 5");
		} while (optionInt<1 || optionInt>4);
		
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
