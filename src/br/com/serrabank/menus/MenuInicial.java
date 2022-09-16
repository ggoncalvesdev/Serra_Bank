package br.com.serrabank.menus;

import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.login.Login;

public class MenuInicial {
	static Scanner ler = new Scanner(System.in);

	public static void menuInicial(Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
		
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
			
			case 1: Login.loginCliente(mapaContas);
					break;
				
			case 2: Login.loginFuncionario(mapaFuncionario);
					break;		
			default: 
				System.out.println("Opção inválida!");		
			}			
		}while(opcao != 3);
	}
	
}
