package br.com.serrabank.conta.conta_poupanca;

import br.com.serrabank.conta.Conta;
import br.com.serrabank.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
	private static final String TIPO = "POUPANCA";

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(String nome, String senha, String cpf, double saldo, int agencia) {
		setTitular(nome);
		setSenha(senha);
		setCpf(cpf);
		setSaldo(saldo);
		setAgencia(agencia);
	}
	
	@Override
	public void depositar(double deposito) {
		if(deposito <= 0) {
			throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
		}
    			this.saldo += deposito;
	}
	
	@Override
	public void sacar(double valor) {
		if(valor > saldo) {
			throw new SaldoInsuficienteException("O valor não pode ser maior que o saldo atual\n"
												+ "Seu saldo atual é: " + saldo);
		}
			if(valor <= 0) {
				throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
			}
        		this.saldo -= valor;
	}
	
	@Override
	public void transfere(Conta destino, double valor) {
    	if(this.saldo < valor) {	
    		throw new SaldoInsuficienteException("O valor mais a tributação não pode ser maior que o saldo atual\n"
    											+ "Seu saldo atual é: " + saldo); 		
    	}
	    	if(valor <= 0) {
				throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
			}
	    		this.saldo = this.saldo - valor;
	    		destino.setSaldo(destino.getSaldo() + valor);
	}

	public String getTipo() {
		return TIPO;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [agencia=" + agencia + ", getSaldo()=" + getSaldo() + ", getNome()=" + getNome()
				+ ", getSenha()=" + getSenha() + ", getCpf()=" + getCpf() + "]";
	}

}
