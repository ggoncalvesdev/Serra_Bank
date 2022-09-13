package br.com.serrabank.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.serrabank.conta.Conta;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;
import br.com.serrabank.conta.conta_poupanca.ContaPoupanca;

public class Leitor {

	public static void leitor(String path) throws IOException {		
		String linha = "";	
		BufferedReader br = new BufferedReader(new FileReader(path + "\\" + "Clientes.txt"));		
		 while (true) {
	            linha = br.readLine();
	            String[] lerlinha = linha.split(";");
	            if (linha != null) {
	            	if(lerlinha[4] == "0") {
	            	Conta poupanca = new ContaPoupanca(lerlinha[0],lerlinha[1],Double.parseDouble(lerlinha[2]),Integer.parseInt(lerlinha[3]));
	//            	Inserir Mapa Contas
	            	}
	            	if(lerlinha[4] == "1") {
		            Conta corrente = new ContaCorrente(lerlinha[0],lerlinha[1],Double.parseDouble(lerlinha[2]),Integer.parseInt(lerlinha[3]));
	//	           	Inserir Mapa Contas
	            	}
	            } else 
	                break;
	        }
	        br.close();
	}
}
