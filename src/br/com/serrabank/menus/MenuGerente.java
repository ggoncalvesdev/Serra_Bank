package br.com.serrabank.menus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;


import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.funcionario.Gerente;

public class MenuGerente {

	static Scanner ler = new Scanner(System.in);
	private static final PrintStream saida = System.out;
		
	public static void menuGerente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {	
			int opcao;
			
			do {
				System.out.println("\n SERRA BANK - MENU GERENTE ");
				System.out.println("------------------------------------");
				System.out.println("--- Escolha sua opção: ---");
				System.out.println(" 1 - Movimentações e informações da conta.");
				System.out.println(" 2 - Relátorios.");
				System.out.println(" 3 - Sair.\n ");
				System.out.println("-------------------------------------\n");
				opcao = ler.nextInt();
				
				switch(opcao) {
				
				case 1: menuMovimentacoesEInfoConta(funcionario,mapaContas, mapaFuncionario);
				break;
					
				case 2: menuRelatoriosGerente(funcionario,mapaContas, mapaFuncionario);

				break;
				
				case 3:
					MenuInicial.menuInicial(mapaContas, mapaFuncionario);
					System.out.println("Você está saindo do Sistema. Adeus");
				break;
				
				default: 
					System.out.println("Opção inválida!");		
				}			
			}while(opcao != 4);
		}
		
		public static void menuMovimentacoesEInfoConta(Funcionario funcionario, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
	        int opcao;

	        do {
	            System.out.println("\nSERRA BANK - MENU GERENTE - MOV E INFO CONTA");
	            System.out.println("-------------------------------------------------------");
	            System.out.println("----------------- Escolha sua opção: ------------------");
	            System.out.println(" 1 - Saque.");
	            System.out.println(" 2 - Deposito.");
	            System.out.println(" 3 - Transferencia para outra conta.");
	            System.out.println(" 4 - Voltar para Menu Gerente.\n");
	            System.out.println("-------------------------------------------------------");
	            opcao = ler.nextInt();


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
			System.out.println("\nSERRA BANK - MENU GERENTE - RELATÓRIOS");
	        System.out.println("--------------------------");
	        System.out.println("--- Escolha sua opção: ---");
	        System.out.println("1 - Saldo");
	        System.out.println("2 - Relátorio de Tributação das Contas Corrente");
	        System.out.println("3 - Simular Rendimento da Poupança ");
	        System.out.println("4 - Ver quantidade de contas na agência ");
	        System.out.println("5 - Voltar. ");
	        System.out.println("--------------------------\n");
	        opcao = ler.nextInt();
			
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
				
				default: System.out.println("Opção inválida\n"); 
				}
			}while(opcao != 4);
		}
		private static void deposito(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	        saida.println("Quanto deseja depositar? \n");
	        double valor = ler.nextDouble();
	        
	        	((Gerente)funcionario).depositar(valor);
	        	System.out.println("Deposito feito com sucesso");
	    }

	    private static void saque(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	    	
	        saida.println("Quanto deseja Sacar? \n");
	        double valor = ler.nextDouble();
	      
	        if(((Gerente)funcionario).getSaldo() < valor) {
	        	System.out.println("Valor Insuficiente\nSeu saldo �:" + ((Gerente)funcionario).getSaldo());
	        } else {
	        	((Gerente)funcionario).sacar(valor);
	        }
	    }

		private static void saldo(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	        saida.print("\nSeu saldo �: " + ((Gerente)funcionario).getSaldo() + "\n");
	    }

	    
		private static void transferencia(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
			
	        saida.print("Digite o cpf do titular que deseja transferir: \n");
	        String cpf = ler.next();
	        saida.print("Quanto deseja transferir?  \n");
	        double valor = ler.nextDouble();   
	        Gerente destino1 = null;
	        Conta destino2 = null;
	        
	        if(mapaFuncionario.containsKey(cpf) == true) {
	        	destino1 = ((Gerente)mapaFuncionario.get(cpf));
	        	((Gerente)funcionario).transfereGerente(destino1, valor);
	        	
	        }else if(mapaContas.containsKey(cpf) == true) {
	        	destino2 = ((Conta)mapaContas.get(cpf));
	        	((Gerente)funcionario).transfere(destino2, valor);
			}else {
	        	System.out.println("Não foi possivel transferir");
	        }   
	    }
		
		public static void relatorioNumeroDeContas(Funcionario funcionario) throws IOException {
			System.out.println("Existem " + contarContasAg ((Gerente) funcionario) + " contas na sua agência.");
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
	    		System.out.println("Qual valor deseja colocar na poupan�a? ");
	    		double dinheiro = ler.nextDouble();
	    		System.out.println("E por quanto tempo deseja deixar ele render? ");
	    		int dias = ler.nextInt();
	    		
	    		double rendimento = (dinheiro*0.05)*dias;
	    		System.out.println("\nO valor escolhido pelo cliente render� R$" + rendimento + " em " + dias + " dias.\n");
	    	}
    
	    public static void relatorioTributacao(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
	    	System.out.println("O valores cobrados por opera��o banc�ria s�o respectivamente:");
			System.out.println("R$ 0,10 (dez centavos) para saques,");
			System.out.println("R$ 0,10 (dez centavos) para dep�sitos,");
			System.out.println("e R$ 0,20 (vinte centavos) para transfer�ncias.\n");
	    	System.out.println("Gastos totais nas opera��es: " + ((Gerente)funcionario).getTributacao());
	    }
	}

