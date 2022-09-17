package br.com.serrabank.menus;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.escritores.EscritorRelatorio;
import br.com.serrabank.exception.SaldoInsuficienteException;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.funcionario.Gerente;

public class MenuContaCorrente {

	private static final Scanner entrada = new Scanner(System.in);
	private static final PrintStream saida = System.out;

	public static void menuContaCorrente(Conta conta, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {	
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
	            	menuContaCorrente(conta, mapaContas, mapaFuncionario);
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
	        saida.println("--- Escolha sua opãoo: ---");
	        saida.println("1 - Saldo");
	        saida.println("2 - Relátorio de Tributação das Contas Corrente");
	        saida.println("3 - Voltar. ");
	        saida.println("--------------------------\n");
	        opcao = entrada.nextInt();
		
		        switch (opcao)	{
				case 1:
					saldo(conta,mapaContas);
				break;
				case 2:
					relatorioTributacao(conta,mapaContas);
				break;
				case 3:
					menuContaCorrente(conta, mapaContas, mapaFuncionario);				
				break;
				default: System.out.println("Opção inválida\n"); 
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

	private static void transferencia(Conta conta,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
		saida.print("Digite o cpf do titular que deseja transferir: \n");
        String cpf = entrada.next();
        saida.print("Quanto deseja transferir?  \n");
        double valor = entrada.nextDouble();   
	       
        	Gerente destino1 = null;
	        Conta destino2 = null;
	        
	        	try {	
	        		if(mapaFuncionario.containsKey(cpf) == true) {
	        			destino1 = ((Gerente)mapaFuncionario.get(cpf));
	        			((ContaCorrente)conta).transfereGerente(destino1, valor);
	        			saida.println("Transferencia feita com sucesso");
	        			
		        		}else if(mapaContas.containsKey(cpf) == true) {
		        			destino2 = ((Conta)mapaContas.get(cpf));
		        			conta.transfere(destino2, valor);;
		        			saida.println("Transferencia feita com sucesso");
		        			
		        		}else {
		        			saida.println("Não foi possivel transferir");
		        		}   
	        	
	        	} catch(IllegalArgumentException e){
	        		saida.println("Você executou uma operação ilegal: " + e.getMessage());
				} catch (SaldoInsuficienteException e) {
					saida.println("Seu saldo é insuficiente para essa operação\n" + e.getMessage());
			}
    }
    
    public static void relatorioTributacao(Conta conta,  Map<String, Cliente> mapaContas) throws IOException {
    	saida.println("O valores cobrados por operação bancária são respectivamente:");
		saida.println("R$ 0,10 (dez centavos) para saques,");
		saida.println("R$ 0,10 (dez centavos) para depósitos,");
		saida.println("e R$ 0,20 (vinte centavos) para transfer�ncias.\n");
    	saida.println("Gastos totais nas operações: " + ((ContaCorrente) conta).getTributacao());
    	EscritorRelatorio.escritorTributacaoCC(((ContaCorrente) conta).getTributacao());
    }
}
