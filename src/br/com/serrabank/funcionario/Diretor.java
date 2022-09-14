package br.com.serrabank.funcionario;

public class Diretor extends Funcionario{

	public Diretor() {
	}

	public Diretor(String nome, String senha, String cpf) {
		setNome(nome);
		trocarSenha(senha);
		setCpf(cpf);
	}
	
}
