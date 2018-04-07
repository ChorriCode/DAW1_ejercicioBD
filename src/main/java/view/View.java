package view;

import java.util.Scanner;

public class View {
	
	private String option;
	Scanner sc; 
	
	public View() {
		this.sc = new Scanner(System.in);
	}

	public void menu1() {

		System.out.println("SELECCIONAR BASE DE DATOS");
		System.out.println("1) MySQL");
		System.out.println("2) SQLite");
		System.out.println("3) PostgreSQL");
		
		this.option = this.sc.nextLine();

		
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
