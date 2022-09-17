package br.com.serrabank.menus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.funcionario.Gerente;

public class MenuGerente {

	private static final Scanner entrada = new Scanner(System.in);
	private static final PrintStream saida = System.out;
		
	public static void menuGerente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {	
			int opcao;
			
			do {
				saida.println("\n SERRA BANK - MENU GERENTE ");
				saida.println("------------------------------------");
				saida.println("--- Escolha sua opção: ---");
				saida.println(" 1 - Movimentações e informações da conta.");
				saida.println(" 2 - Relátorios.");
				saida.println(" 3 - Sair.\n ");
				saida.println("-------------------------------------\n");
				opcao = entrada.nextInt();
				
				switch(opcao) {
					case 1: 
						menuMovimentacoesEInfoConta(funcionario,mapaContas, mapaFuncionario);
					break;					
					case 2: 
						menuRelatoriosGerente(funcionario,mapaContas, mapaFuncionario);
					break;				
					case 3:
						MenuInicial.menuInicial(mapaContas, mapaFuncionario);
						saida.println("Você está saindo do Sistema. Adeus");
					break;				
					default: 
						saida.println("Opção inválida!");		
				}			
			}while(opcao != 4);
		}
		
		public static void menuMovimentacoesEInfoConta(Funcionario funcionario, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
	        int opcao;

	        do {
	            saida.println("\nSERRA BANK - MENU GERENTE - MOV E INFO CONTA");
	            saida.println("-------------------------------------------------------");
	            saida.println("----------------- Escolha sua opção: ------------------");
	            saida.println(" 1 - Saque.");
	            saida.println(" 2 - Deposito.");
	            saida.println(" 3 - Transferencia para outra conta.");
	            saida.println(" 4 - Voltar para Menu Gerente.\n");
	            saida.println("-------------------------------------------------------");
	            opcao = entrada.nextInt();

	            switch(opcao) {
		            case 1:
		            	saque(funcionario,mapaFuncionario);
		            break;
		            case 2:
		            	deposito(funcionario, mapaFuncionario);
		            break;
		            case 3:
		            	transferencia(funcionario,mapaContas,mapaFuncionario);
		            break;
		            case 4: funcionario.menuFuncionario(funcionario,mapaContas, mapaFuncionario);
		            break;
		            default:  System.out.println("Opção inválida"); 
		            }
	        }while(opcao != 4);
	    }
		
		public static void menuRelatoriosGerente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException	{
			int opcao;
			
			do {
				saida.println("\nSERRA BANK - MENU GERENTE - RELATÓRIOS");
		        saida.println("--------------------------");
		        saida.println("--- Escolha sua opção: ---");
		        saida.println("1 - Saldo");
		        saida.println("2 - Relátorio de Tributação das Contas Corrente");
		        saida.println("3 - Simular Rendimento da Poupança ");
		        saida.println("4 - Ver quantidade de contas na agência ");
		        saida.println("5 - Voltar. ");
		        saida.println("--------------------------\n");
		        opcao = entrada.nextInt();
			
		        switch (opcao)	{
					case 1:
						saldo(funcionario,mapaFuncionario);
					break;
					case 2:
						relatorioTributacao(funcionario,mapaFuncionario);
					break;				
					case 3:
						calculaRensdimento();
					break;				
					case 4:
						relatorioNumeroDeContas(funcionario);
					break;				
					case 5:
						funcionario.menuFuncionario (funcionario,mapaContas, mapaFuncionario);
					break;				
					default: saida.println("Opção inválida\n"); 
				}
			}while(opcao != 4);
		}
		
		private static void deposito(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	       saida.println("Quanto deseja depositar?\n");
	       double valor = entrada.nextDouble();
	        
	        	((Gerente)funcionario).depositar(valor);
	        	saida.println("Deposito feito com sucesso");
	    }

	    private static void saque(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	    	
	        saida.println("Quanto deseja Sacar?\n");
	        double valor = entrada.nextDouble();
	      
		        if(((Gerente)funcionario).getSaldo() < valor) {
		        	saida.println("Valor Insuficiente\nSeu saldo é:" + ((Gerente)funcionario).getSaldo());
		        } else {
		        	((Gerente)funcionario).sacar(valor);
		    }
	    }

		private static void saldo(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	        saida.print("\nSeu saldo é: " + ((Gerente)funcionario).getSaldo() + "\n");
	    }

		private static void transferencia(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
	        saida.print("Digite o cpf do titular que deseja transferir:\n");
	        String cpf = entrada.next();
	        saida.print("Quanto deseja transferir?\n");
	        
		        double valor = entrada.nextDouble();   
		        Gerente destino1 = null;
		        Conta destino2 = null;
		        
			        if(mapaFuncionario.containsKey(cpf) == true) {
			        	destino1 = ((Gerente)mapaFuncionario.get(cpf));
			        	((Gerente)funcionario).transfereGerente(destino1, valor);
			        	
			        }else if(mapaContas.containsKey(cpf) == true) {
			        	destino2 = ((Conta)mapaContas.get(cpf));
			        	((Gerente)funcionario).transfere(destino2, valor);
					}else {
			        	saida.println("Não foi possivel transferir");
			   }   
	    }
		
		public static void relatorioNumeroDeContas(Funcionario funcionario) throws IOException {
			saida.println("Existem " + contarContasAg ((Gerente) funcionario) + " contas na sua agência.");
		}
		
		public static int contarContasAg (Gerente gerente) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(".\\arquivos\\" + "Clientes.txt"));
			
			int contasAg = 0;
			String linha = "";
			
			while (true)  {	     
				linha = br.readLine();
				
				if(linha != null) {
		        String[] lerlinha = linha.split(";"); 
			        if(gerente.getAgencia() == Integer.parseInt(lerlinha[5])){
			        	contasAg++;
					}
				} else 
					break;
			}
		br.close();
		return contasAg;
		}

	    public static void calculaRensdimento()	{
	    	saida.println("Qual valor deseja colocar na poupança? ");
	    	double dinheiro = entrada.nextDouble();
	    	saida.println("E por quanto tempo deseja deixar ele render? ");
	    	int dias = entrada.nextInt();
	    		
	    		double rendimento = (dinheiro*0.05)*dias;
	    		saida.println("\nO valor escolhido pelo cliente renderá R$" + rendimento + " em " + dias + " dias.\n");
	    	}
    
	    public static void relatorioTributacao(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	    	saida.println("O valores cobrados por operação bancária são respectivamente:");
			saida.println("R$ 0,10 (dez centavos) para saques,");
			saida.println("R$ 0,10 (dez centavos) para depósitos,");
			saida.println("e R$ 0,20 (vinte centavos) para transferencias.\n");
	    	saida.println("Gastos totais nas operações: " + ((Gerente)funcionario).getTributacao());
	    }
	}