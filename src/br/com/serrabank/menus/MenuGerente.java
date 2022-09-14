package br.com.serrabank.menus;

import java.util.Scanner;

public class MenuGerente {

	static Scanner ler = new Scanner(System.in);
		
	public static void menuGerente() {	
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
				
				case 1: menuMovimentacoesEInfoConta();
				break;
					
				case 2: menuRelatoriosGerente();
				break;
				
				case 3:
					System.out.println("Você está saindo do Sistema. Adeus");
				break;
				
				default: 
					System.out.println("Opção inválida!");		
				}			
			}while(opcao != 3);
		}
		
		public static void menuMovimentacoesEInfoConta() {
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
	       //     	saque();
	            break;
	            case 2:
	      //      	deposito();
	            break;
	            case 3:
	      //      	tranfereciaOutraConta();
	            break;
	            case 4: menuGerente();
	            break;
	            default:  System.out.println("Opção inválida"); 
	            }
	        }while(opcao != 4);
	    }
		
		public static void menuRelatoriosGerente()	{
			int opcao;
			
			do {
			System.out.println("\nSERRA BANK - MENU GERENTE - RELATÓRIOS");
	        System.out.println("--------------------------");
	        System.out.println("--- Escolha sua opção: ---");
	        System.out.println("1 - Saldo");
	        System.out.println("2 - Relátorio de Tributação das Contas Corrente");
	        System.out.println("3 - Simular Rendimento da Poupança ");
	        System.out.println("4 - Voltar. ");
	        System.out.println("--------------------------\n");
	        opcao = ler.nextInt();
			
		        switch (opcao)	{
				case 1:
					//SaldoAgência, perguntar professor
				break;
				
				case 2:
					System.out.println("O valores cobrados por operação bancária são respectivamente:");
					System.out.println("R$ 0,10 (dez centavos) para saques,");
					System.out.println("R$ 0,10 (dez centavos) para depósitos,");
					System.out.println("e R$ 0,20 (vinte centavos) para trnasferências.\n");
				break;
				
				case 3:
					calculaRendimento();
				break;
				
				case 4:
					menuGerente();
				break;
				
				default: System.out.println("Opção inválida\n"); 
				}
			}while(opcao != 4);
		}

	        public static void calculaRendimento()	{
	    		System.out.println("Qual valor deseja colocar na poupança? ");
	    		double dinheiro = ler.nextDouble();
	    		System.out.println("E por quanto tempo deseja deixar ele render? ");
	    		int dias = ler.nextInt();
	    		
	    		double rendimento = (dinheiro*0.05)*dias;
	    		System.out.println("\nO valor escolhido pelo cliente renderá R$" + rendimento + " em " + dias + " dias.\n");
	    	}
	}

