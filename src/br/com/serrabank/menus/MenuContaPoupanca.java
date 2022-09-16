package br.com.serrabank.menus;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.login.Login;

public class MenuContaPoupanca {

	static Scanner ler = new Scanner(System.in);
	private static final PrintStream saida = System.out;

	public static void menuContaPoupanca(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {	
		int opcao;
		
		do {
			System.out.println("\n SERRA BANK - MENU CLIENTE ");
			System.out.println("------------------------------------");
			System.out.println("--- Escolha sua op��o: ---");
			System.out.println(" 1 - Movimenta��es da conta.");
			System.out.println(" 2 - Rel�torios.");
			System.out.println(" 3 - Sair.\n ");
			System.out.println("-------------------------------------\n");
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 1:
				menuMovimentacoesConta(conta, mapaContas, mapaFuncionario);
			break;
			case 2: 
				menuRelatoriosCliente(conta, mapaContas, mapaFuncionario);
			break;
			case 3:
				MenuInicial.menuInicial(mapaContas, mapaFuncionario);
				System.out.println("Voc� est� saindo do Sistema. Adeus");
			break;
			
			default: 
				System.out.println("Op��o inv�lida!");		
			}			
		}while(opcao != 3);
	}
	
	public static void menuMovimentacoesConta(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
        int opcao;

        do {
            System.out.println("\nSERRA BANK - MENU CLIENTE - MOV CONTA");
            System.out.println("-------------------------------------------------------");
            System.out.println("----------------- Escolha sua op��o: ------------------");
            System.out.println(" 1 - Saque.");
            System.out.println(" 2 - Deposito.");
            System.out.println(" 3 - Transferencia para outra conta.");
            System.out.println(" 4 - Voltar para Menu Cliente.\n");
            System.out.println("-------------------------------------------------------");
            
            opcao = ler.nextInt();

            switch(opcao) {
            case 1:
            	saque(conta, mapaContas);
            break;
            case 2:
				deposito(conta, mapaContas);
            break;
            case 3:
            	transferencia(conta, mapaContas, mapaFuncionario);
            break;
            case 4: 
            	menuContaPoupanca(conta, mapaContas, mapaFuncionario);
            break;
            default:  System.out.println("Op��o inv�lida"); 
            }
        }while(opcao != 4);
    }
	
	public static void menuRelatoriosCliente(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario)	{
		int opcao;
		
		do {
		System.out.println("\nSERRA BANK - MENU CLIENTE - RELAT�RIOS");
        System.out.println("--------------------------");
        System.out.println("--- Escolha sua op��o: ---");
        System.out.println("1 - Saldo");
        System.out.println("2 - Simular Rendimento da Poupan�a ");
        System.out.println("3 - Voltar. ");
        System.out.println("--------------------------\n");
        opcao = ler.nextInt();
		
	        switch (opcao)	{
			case 1:
				saldo(conta,mapaContas);
			break;
			case 2:
				calculaRensdimento();
			break;
			case 3:
				menuContaPoupanca(conta, mapaContas, mapaFuncionario);				
			break;
			default: System.out.println("Op��o inv�lida\n"); 
			}
		}while(opcao != 3);
	}
	
	private static void deposito(Conta conta,  Map<String, Cliente> mapaContas) {
        saida.println("Quanto deseja depositar? \n");
        double valor = ler.nextDouble();
        
        	conta.depositar(valor);
        	System.out.println("Deposito feito com sucesso");
    }

    private static void saque(Conta conta,  Map<String, Cliente> mapaContas) {
    	
        saida.println("Quanto deseja Sacar? \n");
        double valor = ler.nextDouble();
      
        if(conta.getSaldo() < valor) {
        	System.out.println("Valor Insuficiente\nSeu saldo �:" + conta.getSaldo());
        } else {
        	conta.sacar(valor);
        }
    }

	private static void saldo(Conta conta,  Map<String, Cliente> mapaContas) {
        saida.print("\nSeu saldo �: " + conta.getSaldo() + "\n");
    }

    
	private static void transferencia(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
		
        saida.print("Digite a chave do titular que deseja transferir: \n");
        String cpf = ler.next();
        saida.print("Quanto deseja transferir?  \n");
        double valor = ler.nextDouble();
      
        if(mapaContas.containsKey(cpf) == true) {     	
        	conta.transfere((Conta) mapaContas.get(cpf), valor);
        } else {
        	System.out.println("n�o foi possivel transferir");
        }   
    }

    public static void calculaRensdimento()	{
    		System.out.println("Qual valor deseja colocar na poupan�a? ");
    		double dinheiro = ler.nextDouble();
    		System.out.println("E por quanto tempo deseja deixar ele render? ");
    		int dias = ler.nextInt();
    		
    		double rendimento = (dinheiro*0.05)*dias;
    		System.out.println("\nO valor escolhido pelo cliente render� R$" + rendimento + " em " + dias + " dias.\n");
    	}

}
