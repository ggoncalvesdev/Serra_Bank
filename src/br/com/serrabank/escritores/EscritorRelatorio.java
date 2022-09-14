package br.com.serrabank.escritores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EscritorRelatorio {
	
	public static void escritorSimRendimento( double dinheiro, int dias, double rendimento) throws IOException {
		
		String path = "C:\\Users\\Notebook\\Documents\\Docs";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "arquivo.txt"));
		String linha = "";
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String agoraVai = agora.format(formatador);
		
		bw.append("------ RELATÓRIO CÁLCULO RENDIMENTO - SIMULAÇÃO ------");
		bw.newLine();
		bw.append("Data " + agoraVai);
		bw.newLine();
		bw.append( "Valor: R$ " + dinheiro);
		bw.newLine();
		bw.append("Dias acumulados: " + dias);
		bw.newLine();
		bw.append("Rendimento: R$ " + rendimento);
		bw.newLine();
		bw.append("-------------------------------------------------------");
		bw.newLine();
		bw.close();
	
	}
	
	public static void escritorTributacaoCC(double totalOperacoes) throws IOException {
		String path = "C:\\Users\\Notebook\\Documents\\Docs";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "arquivo2.txt"));
		String linha = "";
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String agoraVai = agora.format(formatador);
		
		bw.append("------ RELATÓRIO TRIBUTAÇÃO CONTA CORRENTE ------");
		bw.newLine();
		bw.append("Data " + agoraVai);
		bw.newLine();
		bw.append("Valor total cobrado: R$ " + totalOperacoes);
		bw.newLine();
		bw.append("Cobraça por saque: R$ 0,10");
		bw.newLine();
		bw.append("Cobraça por depósito: R$ 0,10");
		bw.newLine();
		bw.append("Cobraça por tranferência: R$ 0,20");
		bw.newLine();
		bw.append("--------------------------------------------------");
		bw.newLine();
		bw.close();
	}
	
}

