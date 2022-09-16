package br.com.serrabank.funcionario;

import java.io.IOException;
import java.util.Map;

import br.com.serrabank.cliente.Cliente;

public abstract class Funcionario {
	private String nome;
	private String senha;
	private String cpf;
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, String senha, String cpf) {
		super();
		this.senha = senha;
		this.cpf = cpf;
	}
	
	public abstract void menuFuncionario(Funcionario funcionario, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException;

	public void trocarSenha(String senha) {
		this.senha = senha;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}	
}
