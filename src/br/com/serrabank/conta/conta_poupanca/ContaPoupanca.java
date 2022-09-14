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
		return "ContaPoupanca [agencia=" + agencia + ", getSaldo()=" + getSaldo() + ", getNome()=" + getNome()
				+ ", getSenha()=" + getSenha() + ", getCpf()=" + getCpf() + "]";
	}
		

	
}
