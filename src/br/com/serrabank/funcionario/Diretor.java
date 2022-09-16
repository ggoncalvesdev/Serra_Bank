package br.com.serrabank.funcionario;

import java.util.Map;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.menus.MenuDiretor;
import br.com.serrabank.menus.MenuGerente;

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
	public void menuFuncionario(Funcionario funcionario, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
		MenuDiretor.menuDiretor(funcionario, mapaContas, mapaFuncionario);
	}
	

}
