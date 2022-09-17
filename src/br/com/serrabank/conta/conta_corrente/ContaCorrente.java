package br.com.serrabank.conta.conta_corrente;

import java.io.IOException;

import br.com.serrabank.conta.Conta;
import br.com.serrabank.escritores.EscritorRelatorio;
import br.com.serrabank.exception.SaldoInsuficienteException;
import br.com.serrabank.funcionario.Gerente;

public class ContaCorrente extends Conta {
	private static final String TIPO = "CORRENTE";
	
	private static double tributacao;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String nome, String senha, String cpf, double saldo, int agencia) {
		setTitular(nome);
		setSenha(senha);
		setCpf(cpf);
		setSaldo(saldo);
		setAgencia(agencia);
	}
	
	@Override
	public void depositar(double deposito) throws IOException {
		
		if(deposito <= 0) {
			throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
		}
				this.saldo -= 0.10;
				tributacao += 0.10;
	    		this.saldo = this.saldo + deposito;
	    		EscritorRelatorio.escritorDeposito(deposito);
	}
	
	
	public void sacar(double valor) throws IOException {
		
		if(valor + 0.10 > saldo) {
			throw new SaldoInsuficienteException("O valor mais a tributação não pode ser maior que o saldo atual\n"
												+ "Seu saldo atual é: " + saldo);
			}
			if(valor <= 0) {
				throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
			}
				this.saldo -= 0.10;
				tributacao += tributacao + 0.10;
		        this.saldo -= valor;
		        EscritorRelatorio.escritorSaque(valor);
	}
	
	@Override
	public void transfere(Conta destino, double valor) throws IOException {
    	if(this.saldo + 0.20 < valor) {	
    		throw new SaldoInsuficienteException("O valor mais a tributação não pode ser maior que o saldo atual\n"
												+ "Seu saldo atual é: " + saldo);
    	}
	    	if(valor <= 0) {
				throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
			}
	    		tributacao += 0.20;
	    		this.saldo -= 0.20;
	    		this.saldo = this.saldo - valor;
	    		destino.setSaldo(destino.getSaldo() + valor);
	    		EscritorRelatorio.escritorTransferencia(destino, valor);
	}
	
	public void transfereGerente(Gerente destino, double valor) throws IOException {
    	if(this.saldo + 0.20 < valor) {	
    		throw new SaldoInsuficienteException("O valor mais a tributação não pode ser maior que o saldo atual\n"
												+ "Seu saldo atual é: " + saldo);    	 
    	} 
	    	if(valor <= 0) {
				throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
			}
	    		tributacao += 0.20;
	    		this.saldo -= 0.20;
	    		this.saldo = this.saldo - valor;
	    		destino.setSaldo(destino.getSaldo()+valor);
	    		EscritorRelatorio.escritorTransferenciaGerente(destino, valor);
 	}

	public String getTipo() {
		return TIPO;
	}

	public double getTributacao() {
		return tributacao;
	}

	@Override
	public String toString() {
		return "ContaCorrente:\n Saldo R$ " + getSaldo() + ", Nome " + getNome() + ", Senha" + getSenha()
				+ " Cpf " + getCpf() + ", Agencia " + agencia + "\n";
	}
}