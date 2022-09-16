package br.com.serrabank.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.conta.conta_poupanca.ContaPoupanca;
import br.com.serrabank.enums.CargoEnum;
import br.com.serrabank.enums.TipoEnum;
import br.com.serrabank.funcionario.Diretor;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.funcionario.Gerente;
import br.com.serrabank.funcionario.Presidente;

public class Leitor {

//	public static Map<String, Cliente> mapaContas = new HashMap<>();
	
	public static void criadorContas(String path, Map<String, Cliente> mapaContas) throws IOException {
//		String path = ".\\arquivos";
		String linha = "";
	
		BufferedReader br = new BufferedReader(new FileReader(path + "\\" + "Clientes.txt"));		
		
			while (true)  {	     
				linha = br.readLine();
				
				if(linha != null) {
		        String[] lerlinha = linha.split(";");
	  	
		        		if(	Integer.parseInt(lerlinha[0]) == (TipoEnum.POUPANCA.ordinal())	) {
		            	Cliente poupanca = new ContaPoupanca(lerlinha[1],lerlinha[2],lerlinha[3],Double.parseDouble(lerlinha[4]),Integer.parseInt(lerlinha[5]));
		            	mapaContas.put(lerlinha[3], poupanca);
		        		}
		        		if(	Integer.parseInt(lerlinha[0]) == (TipoEnum.CORRENTE.ordinal())	) {
			            Cliente corrente = new ContaCorrente(lerlinha[1],lerlinha[2],lerlinha[3],Double.parseDouble(lerlinha[4]),Integer.parseInt(lerlinha[5]));
			            mapaContas.put(lerlinha[3], corrente);
		        		}
				}else 
					break;	
			}	
		br.close();
	}
	
	public static void criadorFuncionarios(String path) throws IOException {
		String linha = "";
		BufferedReader br = new BufferedReader(new FileReader(path + "\\" + "Funcionarios.txt"));		
		
			while (true)  {	     
				linha = br.readLine();
				
				if(linha != null) {
		        String[] lerlinha = linha.split(";");
	  	
		        		if(	Integer.parseInt(lerlinha[0]) == (CargoEnum.GERENTE.ordinal())	) {
		            	Funcionario gerente = new Gerente(lerlinha[1], lerlinha[2], lerlinha[3], Integer.parseInt(lerlinha[4]));
		            	}
		        		if(	Integer.parseInt(lerlinha[0]) == (CargoEnum.DIRETOR.ordinal())	) {
			            Funcionario diretor = new Diretor(lerlinha[1], lerlinha[2], lerlinha[3]);
			            }
		        		if(	Integer.parseInt(lerlinha[0]) == (CargoEnum.PRESIDENTE.ordinal())	) {
			            Funcionario presidente = new Presidente(lerlinha[1], lerlinha[2], lerlinha[3]);
			            }
				}else 
					break;		
			}
		br.close();
	}
}
