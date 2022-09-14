package br.com.serrabank.conta.conta_corrente;

import br.com.serrabank.conta.Conta;

public class ContaCorrente extends Conta {
	private static final String CARGO = "GERENTE";
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String nome, String cpf, double saldo, int agencia) {
		setTitular(nome);
		setCpf(cpf);
		setSaldo(saldo);
		setAgencia(agencia);
	}

	@Override
	public String toString() {
		return "ContaCorrente [getSaldo()=" + getSaldo() + ", getNome()=" + getNome() + ", getSenha()=" + getSenha()
				+ ", getCpf()=" + getCpf() + ", agencia=" + agencia + "]";
	}
	
	
}
