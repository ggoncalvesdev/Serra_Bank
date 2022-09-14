package br.com.serrabank.conta.conta_poupanca;

import br.com.serrabank.conta.Conta;

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

	public static String getTIPO() {
		return TIPO;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [agencia=" + agencia + ", getSaldo()=" + getSaldo() + ", getNome()=" + getNome()
				+ ", getSenha()=" + getSenha() + ", getCpf()=" + getCpf() + "]";
	}
		

	
}
