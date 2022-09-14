package br.com.serrabank.funcionario;

public class Presidente extends Funcionario {
	private static final String CARGO = "PRESIDENTE";

	public Presidente () {
	}
	
	public Presidente(String nome, String senha, String cpf) {
		setNome(nome);
		trocarSenha(senha);
		setCpf(cpf);
	}

	public static String getCargo() {
		return CARGO;
	}
	
}
