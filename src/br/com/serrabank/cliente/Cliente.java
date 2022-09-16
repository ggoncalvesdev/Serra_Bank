package br.com.serrabank.cliente;

public class Cliente {
	private static final String CARGO = "CLIENTE";
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
	

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCpf(String cpf) {
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

	public static String getCargo() {
		return CARGO;
	}

}
