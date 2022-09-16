package br.com.serrabank.funcionario;

import java.util.Map;

import br.com.serrabank.menus.MenuGerente;

public class Gerente extends Funcionario {
	private static final String CARGO = "GERENTE";
	private int agencia;

	public Gerente() {
	}

	public Gerente(String nome, String senha, String cpf, int agencia) {
		setNome(nome);
		trocarSenha(senha);
		setCpf(cpf);
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public static String getCargo() {
		return CARGO;
	}

	@Override
	public void menuFuncionario(Funcionario funcionario, Map<String, Funcionario> mapaFuncionario) {
		MenuGerente.menuGerente(funcionario, mapaFuncionario);
		
	}
}
