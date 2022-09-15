package br.com.serrabank.login;

import java.io.PrintStream;
import java.util.Scanner;

import br.com.serrabank.conta.Conta;
import br.com.serrabank.io.Leitor;
import br.com.serrabank.menus.MenuCliente;

public class Login {
	
	private static final Scanner entrada = new Scanner(System.in);
    private static final PrintStream saida = System.out;

	public static void login() {
		
		do {
			saida.print("Digite seu login: ");
			String login = entrada.nextLine();
			saida.print("Digite sua senha: ");
			String senha = entrada.nextLine();
			
			if(Leitor.mapaContas.containsKey(login) && Leitor.mapaContas.get(login).getSenha().equals(senha)) {
				MenuCliente mc = new MenuCliente();
				mc.menuCliente((Conta) Leitor.mapaContas.get(login));
				break;
			} else {
				System.out.println("Login ou senha inválidos.");
				
			}
			
		} while (true);			 	
	}
}
