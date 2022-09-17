package br.com.serrabank.menus;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.io.Leitor;
import br.com.serrabank.login.Login;

public class MenuInicial {
	
	private static final Scanner ler = new Scanner(System.in);
	private static final PrintStream saida = System.out;

	public static void menuInicial(Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
		int opcao;
		
		do {

		    Leitor.leitorBanner(".\\arquivos\\banner.txt");

			saida.println("----------------------------------------------");
			saida.println("--- Você é cliente ou Funcionario? ---\n");
			saida.println("1 - Sou Cliente.");
			saida.println("2 - Sou Funcionário.");
			saida.println("3 - Sair do sistema.\n ");
			saida.println("----------------------------------------------\n");
			opcao = ler.nextInt();
			
			switch(opcao) {
			
				case 1: 
					Login.loginCliente(mapaContas, mapaFuncionario);
						break;
				case 2:
					Login.loginFuncionario(mapaContas,mapaFuncionario);
						break;	
				case 3: 
					saida.println("Fechando programa.\nVolte Sempre!");
						System.exit(0);
				default: 
					saida.println("Opção inválida!");		
			}
			
		}while(opcao != 3);
	}
}
