package br.com.serrabank.conta.conta_corrente;

import br.com.serrabank.conta.Conta;

public class ContaCorrente extends Conta {
	private static final String TIPO = "CORRENTE";
	
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

	public static String getTipo() {
		return TIPO;
	}

	@Override
	public String toString() {
		return "ContaCorrente [getSaldo()=" + getSaldo() + ", getNome()=" + getNome() + ", getSenha()=" + getSenha()
				+ ", getCpf()=" + getCpf() + ", agencia=" + agencia + "]";
	}
	
	
}
