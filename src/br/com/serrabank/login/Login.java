package br.com.serrabank.login;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.enums.TipoEnum;
import br.com.serrabank.menus.MenuContaCorrente;
import br.com.serrabank.menus.MenuContaPoupanca;

public class Login {
	
	private static final Scanner entrada = new Scanner(System.in);
    private static final PrintStream saida = System.out;

	public static void loginCliente(Map<String, Cliente> mapaContas) {
		
		do {
			saida.print("Digite seu login: ");
			String login = entrada.nextLine();
			saida.print("Digite sua senha: ");
			String senha = entrada.nextLine();
			
			if(mapaContas.containsKey(login) && mapaContas.get(login).getSenha().equals(senha)) {
				Conta usuarioLogado = (Conta) mapaContas.get(login);
				
				if(usuarioLogado.getTipo() == TipoEnum.CORRENTE.name()) {
					MenuContaCorrente.menuContaCorrente(usuarioLogado, mapaContas);
					break;
				} 
					if(usuarioLogado.getTipo() == TipoEnum.POUPANCA.name()) {
						MenuContaPoupanca.menuContaPoupanca(usuarioLogado, mapaContas);
						break;
					}
			
			} else {
				System.out.println("Login ou senha inválidos.");
			}	
		} while (true);			 	
	}
}
