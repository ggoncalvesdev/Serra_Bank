package br.com.serrabank.escritores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.funcionario.Gerente;

public class EscritorRelatorio {
	
		public static void escritorSimRendimento( double dinheiro, int dias, double rendimento) throws IOException {
			
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "relatórioRendimento.txt"));
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
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "tributaçãoContaCorrente.txt"));
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
		
		public static void escritorSaque(double saque) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO OPERAÇÃO BANCÁRIA - SAQUE ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append("Valor do saque: R$" + saque);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
		
		public static void escritorDeposito(double deposito) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO OPERAÇÃO BANCÁRIA - DEPÓSITO ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append("Valor do saque: R$" + deposito);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
		
		public static void escritorTransferencia(Conta destino, double valorTrans) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO OPERAÇÃO BANCÁRIA - DEPÓSITO ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append("Conta destino: " + destino.getCpf() + "; " + destino.getAgencia());
			bw.newLine();
			bw.append("Valor da Transferência: R$" + valorTrans);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
		
		public static void escritorTransferenciaGerente(Gerente destino, double valorTrans) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO OPERAÇÃO BANCÁRIA - DEPÓSITO ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append("Conta destino: " + destino.getCpf() + "; " + destino.getAgencia());
			bw.newLine();
			bw.append("Valor da Transferência: R$" + valorTrans);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
		
		public static void escritorNumeroContasAgencia(Gerente funcionario, int contasAg) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO LISTA CLIENTES ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append("Agência: " + funcionario.getAgencia());
			bw.newLine();
			bw.append("Número de contas: " + contasAg);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
		
		public static void escritorInfoClientesOrdenado(List<Cliente> listaContas) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO LISTA CLIENTES ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append((CharSequence) listaContas);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
		
		public static void escritorCapitalBanco(double capital) throws IOException {
			String path = ".\\arquivos";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\" + "operaçoesBancarias.txt"));
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraVai = agora.format(formatador);
			
			bw.append("------ RELATÓRIO LISTA CLIENTES ------");
			bw.newLine();
			bw.append("Data " + agoraVai);
			bw.newLine();
			bw.append("Capital total do banco: R$" + capital);
			bw.newLine();
			bw.append("--------------------------------------------------");
			bw.newLine();
			bw.close();
		}
}