package br.com.serrabank.funcionario;

public abstract class Funcionario {

	private String senha;
	private String cpf;
	//private String cargo;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String senha, String cpf) {
		super();
		this.senha = senha;
		this.cpf = cpf;
	}

	public void trocarSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}
	
	
}
