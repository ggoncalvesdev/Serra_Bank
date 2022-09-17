package br.com.serrabank.menus;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.escritores.EscritorRelatorio;
import br.com.serrabank.exception.SaldoInsuficienteException;
import br.com.serrabank.funcionario.Funcionario;

public class MenuContaPoupanca {

	private static final Scanner entrada = new Scanner(System.in);
	private static final PrintStream saida = System.out;

	public static void menuContaPoupanca(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {	
		int opcao;
		
		do {
			saida.println("\n SERRA BANK - MENU CLIENTE ");
			saida.println("------------------------------------");
			saida.println("--- Escolha sua opção: ---");
			saida.println(" 1 - Movimentações da conta.");
			saida.println(" 2 - Relátorios.");
			saida.println(" 3 - Sair.\n ");
			saida.println("-------------------------------------\n");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			
			case 1:
				menuMovimentacoesConta(conta, mapaContas, mapaFuncionario);
			break;
			case 2: 
				menuRelatoriosCliente(conta, mapaContas, mapaFuncionario);
			break;
			case 3:
				MenuInicial.menuInicial(mapaContas, mapaFuncionario);
				saida.println("Você está saindo do Sistema. Adeus");
			break;
			
			default: 
				saida.println("Opção inválida!");		
			}			
		}while(opcao != 3);
	}
	
	public static void menuMovimentacoesConta(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
        int opcao;

        do {
            saida.println("\nSERRA BANK - MENU CLIENTE - MOV CONTA");
            saida.println("-------------------------------------------------------");
            saida.println("----------------- Escolha sua opção: ------------------");
            saida.println(" 1 - Saque.");
            saida.println(" 2 - Deposito.");
            saida.println(" 3 - Transferencia para outra conta.");
            saida.println(" 4 - Voltar para Menu Cliente.\n");
            saida.println("-------------------------------------------------------");
            
            opcao = entrada.nextInt();

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
            default:  
            	saida.println("Opção inválida"); 
            }
        }while(opcao != 4);
    }
	
	public static void menuRelatoriosCliente(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException	{
		int opcao;
		
		do {
			saida.println("\nSERRA BANK - MENU CLIENTE - RELATÓRIOS");
	        saida.println("--------------------------");
	        saida.println("--- Escolha sua opção: ---");
	        saida.println("1 - Saldo");
	        saida.println("2 - Simular Rendimento da Poupança ");
	        saida.println("3 - Voltar. ");
	        saida.println("--------------------------\n");
	        opcao = entrada.nextInt();
		
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
			default: 
				saida.println("Opção inválida\n"); 
			}
		}while(opcao != 3);
	}
	
	private static void deposito(Conta conta,  Map<String, Cliente> mapaContas) throws IOException {
        saida.println("Quanto deseja depositar? \n");
        double valor = entrada.nextDouble();
        
	        try {
	    		conta.depositar(valor);
	    		saida.println("Deposito feito com sucesso");
				
			} catch (IllegalArgumentException e) {
				saida.println("Você executou uma operação ilegal: " + e.getMessage());
		}
    }

    private static void saque(Conta conta,  Map<String, Cliente> mapaContas) throws IOException {
        saida.println("Quanto deseja Sacar? \n");
        double valor = entrada.nextDouble();
      
	        try {
	    		conta.sacar(valor);	
				saida.println("Saque feito com sucesso");
				
	        } catch(IllegalArgumentException e){
        		saida.println("Você executou uma operação ilegal: " + e.getMessage());	
	    	} catch (SaldoInsuficienteException e) {
				saida.println("Seu saldo é insuficiente para essa operação\n" + e.getMessage());
	    	}
    }

    private static void saldo(Conta conta,  Map<String, Cliente> mapaContas) {
        saida.print("\nSeu saldo é: " + conta.getSaldo() + "\n");
    }

	private static void transferencia(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
		saida.print("Digite o cpf do titular que deseja transferir: \n");
        String cpf = entrada.next();
        saida.print("Quanto deseja transferir?  \n");
        double valor = entrada.nextDouble();
        
        	try {
        		if(mapaContas.containsKey(cpf) == true) {     	
        			conta.transfere((Conta) mapaContas.get(cpf), valor);
        			saida.println("Transferencia feita com sucesso");

        		} else {
        			System.out.println("não foi possivel transferir");
        		}  
        		
        	} catch(IllegalArgumentException e){
        		saida.println("Você executou uma operação ilegal: " + e.getMessage());	
			} catch (SaldoInsuficienteException e) {
				saida.println("Seu saldo é insuficiente para essa operação\n" + e.getMessage());
		}
	}

    public static void calculaRensdimento() throws IOException	{
    	saida.println("Qual valor deseja colocar na poupança? ");
    	double dinheiro = entrada.nextDouble();
    	saida.println("E por quanto tempo deseja deixar ele render? ");
    	int dias = entrada.nextInt();
    		
    	double rendimento = (dinheiro*0.05)*dias;
    	saida.println("\nO valor escolhido pelo cliente renderá R$" + rendimento + " em " + dias + " dias.\n");
    	EscritorRelatorio.escritorSimRendimento(dinheiro, dias, rendimento);
    }
}
