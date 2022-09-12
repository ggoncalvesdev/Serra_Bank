package br.com.serrabank.cliente;

public class Cliente {
	
	private String titular;
	private String senha;
	private String cpf;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String senha, String cpf) {
		this.titular = nome;
		this.senha = senha;
		this.cpf = cpf;
	}

	public String getNome() {
		return titular;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}
	
}
