package br.com.serrabank.funcionario;

import java.util.Map;

public class Diretor extends Funcionario{
	private static final String CARGO = "DIRETOR";

	public Diretor() {
	}

	public Diretor(String nome, String senha, String cpf) {
		setNome(nome);
		trocarSenha(senha);
		setCpf(cpf);
	}

	public static String getCargo() {
		return CARGO;
	}

	@Override
	public void menuFuncionario(Funcionario funcionario, Map<String, Funcionario> mapaFuncionario) {
		// TODO Auto-generated method stub
		
	}

}
