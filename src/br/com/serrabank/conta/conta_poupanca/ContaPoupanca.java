package br.com.serrabank.conta.conta_poupanca;

import br.com.serrabank.conta.Conta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(String nome, String cpf, double saldo, int agencia) {
		setTitular(nome);
		setCpf(cpf);
		setSaldo(saldo);
		setAgencia(agencia);
	}
		
	@Override
	public String toString() {
		return "ContaPoupan�a [getSaldo()=" + getSaldo() + ", Agencia=" + getAgencia() + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + "]";
	}
	
	
}
