package br.com.serrabank.menus;

import java.util.Scanner;

public class MenuInicial {
	static Scanner ler = new Scanner(System.in);

	public static void menuInicial() {
		
		int opcao;
		
		do {
		
			System.out.println("\n\t SERRA BANK - LOGIN \n");
			System.out.println("\n----------------------------------------------");
			System.out.println("\n--- Você é cliente ou Funcionario? ---\n");
			System.out.println("\n 1 - Sou Cliente.");
			System.out.println("\n 2 - Sou Funcionário.");
			System.out.println("\n 3 - Sair do sitema.\n ");
			System.out.println("\n----------------------------------------------\n");
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 1: //loginCliente();
					break;
				
			case 2: //loginFuncionario();
					break;		
			default: 
				System.out.println("Opção inválida!");		
			}			
		}while(opcao != 3);
	}
	
}
