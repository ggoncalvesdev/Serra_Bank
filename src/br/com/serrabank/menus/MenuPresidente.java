package br.com.serrabank.menus;
	
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======
import java.util.Scanner;

>>>>>>> 40198f6712431541d9dc690e0e30e0f11cda7397
import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.funcionario.Gerente;


public class MenuPresidente extends MenuDiretor{
	private static final Scanner entrada = new Scanner(System.in);
	
	public static void menuPresidente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
			int opcao;
			
			do {
				System.out.println("\n\t SERRA BANK - MENU PRESIDENTE ");
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
					MenuInicial.menuInicial(mapaContas, mapaFuncionario);
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
			System.out.println("\n\tSERRA BANK - MENU PRESIDENTE - RELATÓRIOS");
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
					relatorioSaldoAgencia(funcionario);
				break;
				
				case 2:
					relatorioTributacaoPresidente(funcionario,mapaFuncionario);
				break;
				
				case 3:
					calculaRensdimento();
				break;
				
				case 4:
					relatorioNumeroDeContasDiretor(funcionario);
				break;
				case 5:
					relatorioInfoClientesOrdenado(mapaContas);
				break;
				case 6:
					relatorioCapitalTotalBanco(opcao);
				break;
				case 7:
					funcionario.menuFuncionario (funcionario,mapaContas, mapaFuncionario);
				break;
				
				default: System.out.println("Opção inválida\n"); 
				}
			}while(opcao != 7);
		
		 
	}
		public static void relatorioCapitalTotalBanco (int agencia) throws IOException {
			
			BufferedReader br = new BufferedReader(new FileReader(".\\arquivos\\" + "Clientes.txt"));
			BufferedReader brGerente = new BufferedReader(new FileReader(".\\arquivos\\" + "Funcionarios.txt"));
			double saldoAgencia = 0;
			String linha= "";
			
			while (true)  {	     
				linha = br.readLine();			
				if(linha != null) {
		        String[] lerlinha = linha.split(";"); 
			        	saldoAgencia += Integer.parseInt(lerlinha[4]);
			        	
				}else
					break;
				
			}
			br.close();
			while (true)  {
	            linha = brGerente.readLine();
	            if(linha != null) {
	            String[] lerlinha = linha.split(";"); 
	                if(Integer.parseInt(lerlinha[0]) == 1){
	                    if(agencia == Integer.parseInt(lerlinha[5])){
	                    	saldoAgencia += Integer.parseInt(lerlinha[4]);
	                    }
	                }else
	                    break;
	            } else 
	                break;
	        }
	    brGerente.close();
	    System.out.println("O saldo do seu banco é: R$" + saldoAgencia);
			
		}
		  public static void relatorioTributacaoPresidente(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
		    	System.out.println("O valores cobrados por opera��o banc�ria s�o respectivamente:");
				System.out.println("R$ 0,10 (dez centavos) para saques,");
				System.out.println("R$ 0,10 (dez centavos) para dep�sitos,");
				System.out.println("e R$ 0,20 (vinte centavos) para transfer�ncias.\n");
		    	
}
}

	
