package br.com.serrabank.menus;
	
	import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.funcionario.Funcionario;


public class MenuPresidente extends MenuDiretor{
	private static final Scanner entrada = new Scanner(System.in);
	
	public static void menuPresidente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
			int opcao;
			
			do {
				System.out.println("\n\t SERRA BANK - MENU DIRETOR ");
				System.out.println("-----------------------------------------");
				System.out.println("--- Escolha sua opção: ---");
				System.out.println(" 1 - Relátorios.");
				System.out.println(" 2 - Sair.\n ");
				System.out.println("-----------------------------------------\n");
				opcao = entrada.nextInt();
				
				switch(opcao) {
				
				case 1: menuRelatoriosPresidente(funcionario, mapaContas, mapaFuncionario);
				break;
				
				case 2:
					System.out.println("Você está saindo do Sistema. Adeus");
				break;
				
				default: 
					System.out.println("Opção inválida!");		
				}			
			}while(opcao != 3);
		}

		public static void menuRelatoriosPresidente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException	{

			int opcao;
			
			do {
			System.out.println("\n\tSERRA BANK - MENU DIRETOR - RELATÓRIOS");
	        System.out.println("--------------------------------------------------------");
	        System.out.println("--- Escolha sua opção: ---");
	        System.out.println(" 1 - Saldo");
	        System.out.println(" 2 - Relátorio de Tributação das Contas Corrente");
	        System.out.println(" 3 - Simular Rendimento da Poupança ");
	        System.out.println(" 4 - Relatório de número de contas por agência. ");
	        System.out.println(" 5 - Relatório de contas ordenado. ");
	        System.out.println(" 6 - Relatório valor total armazenado no Banco  ");
	        System.out.println(" 7 - Voltar. ");
	        System.out.println("--------------------------------------------------------\n");
	        opcao = entrada.nextInt();
			
		        switch (opcao)	{
				case 1:
				//	saldoAgencias(funcionario,mapaFuncionario);
				break;
				
				case 2:
					relatorioTributacao(funcionario,mapaFuncionario);
				break;
				
				case 3:
					calculaRensdimento();
				break;
				
				case 4:
					relatorioNumeroDeContas(funcionario, mapaContas);
				break;
				case 5:
					relatorioInfoClientesOrdenado(mapaContas);
				break;
				case 6:
					relatorioCapitalTotalBanco();
				break;
				case 7:
					funcionario.menuFuncionario (funcionario,mapaContas, mapaFuncionario);
				break;
				
				default: System.out.println("Opção inválida\n"); 
				}
			}while(opcao != 7);
		}
		public static void saldoAgencias() {
			
			
		}
		  public static void relatorioTributacaoContaCorrente(Conta conta,  Map<String, Cliente> mapaContas) {
			   
			   	
			   	System.out.println("Gastos totais nas opera��es: " + ((ContaCorrente) conta).getTributacao());
			   	System.out.println("O valores cobrados por operação bancária são respectivamente:");
				System.out.println("R$ 0,10 (dez centavos) para saques,");
				System.out.println("R$ 0,10 (dez centavos) para depósitos,");
				System.out.println("e R$ 0,20 (vinte centavos) para trnasferências.\n");
			   	
			    }
		    
		    public static void relatorioNumeroDeContas(Funcionario funcionario, Map<String, Cliente> mapaContas) {
	
		    }
			    public static void relatorioInfoClientesOrdenado(Map<String, Cliente> mapaContas)   {
			    	
			    	List<Cliente> listaContas = new ArrayList<Cliente>(mapaContas.values());

			        Collections.sort(listaContas);
			        System.out.println(listaContas);
		
			    }
			public static void relatorioCapitalTotalBanco() {     
	}
}
	
