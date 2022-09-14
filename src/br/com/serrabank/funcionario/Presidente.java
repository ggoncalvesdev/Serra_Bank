package br.com.serrabank.funcionario;

public class Presidente extends Funcionario {

	public Presidente () {
	}
	
	public Presidente(String nome, String senha, String cpf) {
		setNome(nome);
		trocarSenha(senha);
		setCpf(cpf);
	}
	
}
