package br.com.serrabank.funcionario;

import java.util.Scanner;

public class Gerente extends Funcionario {

	private int agencia;

	public Gerente() {
	}

	public Gerente(String senha, String cpf, int agencia) {
		super(senha, cpf);
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
}
