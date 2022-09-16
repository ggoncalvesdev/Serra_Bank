package br.com.serrabank.menus;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.login.Login;

public class MenuContaCorrente {

	static Scanner ler = new Scanner(System.in);
	private static final PrintStream saida = System.out;

	public static void menuContaCorrente(Conta conta, Map<String, Cliente> mapaContas) {	
		int opcao;
		
		do {
			System.out.println("\n SERRA BANK - MENU CLIENTE ");
			System.out.println("------------------------------------");
			System.out.println("--- Escolha sua opção: ---");
			System.out.println(" 1 - Movimentações da conta.");
			System.out.println(" 2 - Relátorios.");
			System.out.println(" 3 - Sair.\n ");
			System.out.println("-------------------------------------\n");
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 1:
				menuMovimentacoesConta(conta, mapaContas);
			break;
			case 2: 
				menuRelatoriosCliente(conta, mapaContas);
			break;
			case 3:
				Login.loginCliente(mapaContas);
				System.out.println("Você está saindo do Sistema. Adeus");
			break;
			
			default: 
				System.out.println("Opção inválida!");		
			}			
		}while(opcao != 3);
	}
	
	public static void menuMovimentacoesConta(Conta conta, Map<String, Cliente> mapaContas) {
        int opcao;

        do {
            System.out.println("\nSERRA BANK - MENU CLIENTE - MOV CONTA");
            System.out.println("-------------------------------------------------------");
            System.out.println("----------------- Escolha sua opção: ------------------");
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
            	transferencia(conta, mapaContas);
            break;
            case 4: 
            	menuContaCorrente(conta, mapaContas);
            break;
            default:  System.out.println("Opção inválida"); 
            }
        }while(opcao != 4);
    }
	
	public static void menuRelatoriosCliente(Conta conta,  Map<String, Cliente> mapaContas)	{
		int opcao;
		
		do {
		System.out.println("\nSERRA BANK - MENU CLIENTE - RELATÓRIOS");
        System.out.println("--------------------------");
        System.out.println("--- Escolha sua opção: ---");
        System.out.println("1 - Saldo");
        System.out.println("2 - Relátorio de Tributação das Contas Corrente");
//        System.out.println("3 - Simular Rendimento da Poupança ");
        System.out.println("3 - Voltar. ");
        System.out.println("--------------------------\n");
        opcao = ler.nextInt();
		
	        switch (opcao)	{
			case 1:
				saldo(conta,mapaContas);
			break;
			case 2:
				relatorioTributacao(conta,mapaContas);
			break;
			case 3:
//				calculaRendimento();
				menuContaCorrente(conta, mapaContas);				
			break;
			default: System.out.println("Opção inválida\n"); 
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
        	System.out.println("Valor Insuficiente\nSeu saldo é:" + conta.getSaldo());
        } else {
        	conta.sacar(valor);
        }
    }

	private static void saldo(Conta conta,  Map<String, Cliente> mapaContas) {
        saida.print("\nSeu saldo é: " + conta.getSaldo() + "\n");
    }

    
	private static void transferencia(Conta conta, Map<String, Cliente> mapaContas) {
		
        saida.print("Digite a chave do titular que deseja transferir: \n");
        String cpf = ler.next();
        saida.print("Quanto deseja transferir?  \n");
        double valor = ler.nextDouble();
      
        if(mapaContas.containsKey(cpf) == true) {     	
        	conta.transfere((Conta) mapaContas.get(cpf), valor);
        } else {
        	System.out.println("não foi possivel transferir");
        }   
    }

//    public static void calculaRensdimento()	{
//    		System.out.println("Qual valor deseja colocar na poupança? ");
//    		double dinheiro = ler.nextDouble();
//    		System.out.println("E por quanto tempo deseja deixar ele render? ");
//    		int dias = ler.nextInt();
//    		
//    		double rendimento = (dinheiro*0.05)*dias;
//    		System.out.println("\nO valor escolhido pelo cliente renderá R$" + rendimento + " em " + dias + " dias.\n");
//    	}
//    
    public static void relatorioTributacao(Conta conta,  Map<String, Cliente> mapaContas) {
    	System.out.println("O valores cobrados por operação bancária são respectivamente:");
		System.out.println("R$ 0,10 (dez centavos) para saques,");
		System.out.println("R$ 0,10 (dez centavos) para depósitos,");
		System.out.println("e R$ 0,20 (vinte centavos) para transferências.\n");
    	System.out.println("Gastos totais nas operações: " + ((ContaCorrente) conta).getTributacao());
    }
}
