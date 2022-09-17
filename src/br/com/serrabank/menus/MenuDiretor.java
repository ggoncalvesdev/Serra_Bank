package br.com.serrabank.menus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;

public class MenuDiretor extends MenuGerente {
	
	private static final Scanner entrada = new Scanner(System.in);
	private static final PrintStream saida = System.out;
	
	public static void menuDiretor(Funcionario funcionario, Map<String, Cliente> mapaContas,Map<String, Funcionario> mapaFuncionario) throws IOException  {
		int opcao;
		
		do {
			saida.println("\n\t SERRA BANK - MENU DIRETOR ");
			saida.println("-----------------------------------------");
			saida.println("--- Escolha sua opção: ---");
			saida.println(" 1 - Relátorios.");
			saida.println(" 2 - Sair.\n ");
			saida.println("-----------------------------------------\n");
			opcao = entrada.nextInt();
			
			switch(opcao) {
				
				case 1: 
					menuRelatoriosDiretor(funcionario, mapaContas, mapaFuncionario);
				break;
				case 2:
					MenuInicial.menuInicial(mapaContas, mapaFuncionario);
					saida.println("Você está saindo do Sistema. Adeus");
				break;
				default: 
					saida.println("Opção inválida!");		
				}			
		}while(opcao != 3);
	}

	public static void menuRelatoriosDiretor(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException 	{
		int opcao;
		
		do {
			saida.println("\n\tSERRA BANK - MENU DIRETOR - RELATÓRIOS");
	        saida.println("--------------------------------------------------------");
	        saida.println("--- Escolha sua opção: ---");
	        saida.println(" 1 - Saldo");
	        saida.println(" 2 - Relátorio de Tributação das Contas Corrente");
	        saida.println(" 3 - Simular Rendimento da Poupança ");
	        saida.println(" 4 - Relatório de número de contas por agência. ");
	        saida.println(" 5 - Relatório de contas ordenado. ");
	        saida.println(" 6 - Voltar. ");
	        saida.println("--------------------------------------------------------\n");
	        opcao = entrada.nextInt();
		
	        switch (opcao)	{
				case 1:
					relatorioSaldoAgencia(funcionario);
				break;
				case 2:
					relatorioTributacao(funcionario,mapaFuncionario);
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
					funcionario.menuFuncionario (funcionario,mapaContas, mapaFuncionario);
				break;
			default: 
				saida.println("Opção inválida\n"); 
			}
		}while(opcao != 6);
	}
	
	public static void relatorioSaldoAgencia(Funcionario funcionario) throws IOException {
		saida.println("Deseja saber o saldo de qual agência? ");
		int agencia = entrada.nextInt();
		
			System.out.println("A agência " + agencia + " possui R$" + somarSaldosAgencia (agencia) + " de saldo.");
	}
	
	public static double somarSaldosAgencia (int agencia) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(".\\arquivos\\" + "Clientes.txt"));
		BufferedReader brGerente = new BufferedReader(new FileReader(".\\arquivos\\" + "Funcionarios.txt"));
		
		double saldoAgencia = 0;
		String linha = "";
		
		while (true)  {	     
			linha = br.readLine();	
			
			if(linha != null) {
	        String[] lerlinha = linha.split(";"); 
	        
		        if(agencia == Integer.parseInt(lerlinha[5])){
		        	saldoAgencia += Integer.parseInt(lerlinha[4]);
			}
		        
			} else 
				break;
		}
		br.close();
		
		while (true)  {	     
			linha = brGerente.readLine();
			
			if(linha != null) {
				String[] lerlinha = linha.split(";");
				if(Integer.parseInt(lerlinha[0]) == 1) {
			        if(agencia == Integer.parseInt(lerlinha[5])){
			        	saldoAgencia += Integer.parseInt(lerlinha[4]);
					}
				}else
					break;
			} else 
				break;
		}
		
		brGerente.close();
		return saldoAgencia;
	
	}
	
    public static void relatorioTributacaoContaCorrente(Conta conta,  Map<String, Cliente> mapaContas) {
	   	saida.println("Gastos totais nas operações: " + ((ContaCorrente) conta).getTributacao());
	   	saida.println("O valores cobrados por operação bancária são respectivamente:");
		saida.println("R$ 0,10 (dez centavos) para saques,");
		saida.println("R$ 0,10 (dez centavos) para depósitos,");
		saida.println("e R$ 0,20 (vinte centavos) para trnasferências.\n");
	   	
	}
    
    public static void relatorioNumeroDeContasDiretor(Funcionario funcionario) throws IOException {
    	saida.println("Deseja sabar o número de contas de qual agência? ");
		int agencia = entrada.nextInt();
		
		System.out.println("A agência " + agencia + " possui " + contarContasAgDiretor(agencia) + " contas.");
	}
	
	public static int contarContasAgDiretor (int agencia) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(".\\arquivos\\" + "Clientes.txt"));
		BufferedReader brGerente = new BufferedReader(new FileReader(".\\arquivos\\" + "Funcionarios.txt"));		
		int contasAg = 0;
		String linha = "";
		
		while (true)  {	     
			linha = br.readLine();			
			if(linha != null) {
	        String[] lerlinha = linha.split(";"); 
		        if(agencia == Integer.parseInt(lerlinha[5])){
		        		contasAg++;
					}
			} else 
				break;
		}
		br.close();
		
		while (true)  {	     
			linha = brGerente.readLine();			
			if(linha != null) {
	        String[] lerlinha = linha.split(";"); 
		        if(Integer.parseInt(lerlinha[0]) == 1){
		        	if(agencia == Integer.parseInt(lerlinha[5])){
			        	contasAg++;
					}
				}else
					break;
			} else 
				break;
		}
	brGerente.close();
	return contasAg;
	}
   
    public static void relatorioNumeroDeContas(Funcionario funcionario, Map<String, Cliente> mapaContas) {
    		
    }
    
	public static void saldoAgencias(Funcionario funcionario, Map<String, Cliente> mapaContas) {
	
	}
	
	public static void relatorioInfoClientesOrdenado(Map<String, Cliente> mapaContas)   {
	    	
	    	List<Cliente> listaContas = new ArrayList<Cliente>(mapaContas.values());

	        Collections.sort(listaContas);
	        saida.println(listaContas);   		
	}    
}
