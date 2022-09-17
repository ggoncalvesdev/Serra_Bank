package br.com.serrabank.menus;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.io.Leitor;
import br.com.serrabank.login.Login;

public class MenuInicial {
	static Scanner ler = new Scanner(System.in);

	public static void menuInicial(Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
		
		int opcao;
		
		do {
		
		    Leitor.leitorBanner(".//arquivos/banner.txt");

			System.out.println("----------------------------------------------");
			System.out.println("--- Você é cliente ou Funcionario? ---\n");
			System.out.println("1 - Sou Cliente.");
			System.out.println("2 - Sou Funcionário.");
			System.out.println("3 - Sair do sistema.\n ");
			System.out.println("----------------------------------------------\n");
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 1: Login.loginCliente(mapaContas, mapaFuncionario);
					break;
				
			case 2: Login.loginFuncionario(mapaContas,mapaFuncionario);
					break;
					
			case 3: System.out.println("Fechando programa.\nVolte Sempre!");
					System.exit(0);
			default: 
				System.out.println("Opção inválida!");		
			}			
		}while(opcao != 3);
	}
	
}
