package br.com.serrabank.conta;

import br.com.serrabank.cliente.Cliente;

public abstract class Conta extends Cliente {
	
	private static final String TIPO = "";
	
	protected int agencia;
	protected double saldo;
	private static int numeroDeContasCadastradas = 0;
	
	public Conta() {
		numeroDeContasCadastradas ++;
	}
	
	public Conta(Cliente cliente, int agencia) {
		super(cliente.getNome(), cliente.getSenha(), cliente.getCpf());
		this.saldo = this.saldo + saldo;
		this.agencia = agencia;
		numeroDeContasCadastradas ++;	
	}
	
	public Conta(int agencia) {
		this.saldo = 0;
		this.agencia = agencia;
		numeroDeContasCadastradas ++;
	}
		
	public abstract void sacar(double valor);
	
	public abstract void depositar(double deposito);
	
	public abstract void transfere(Conta destino, double valor);
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getTipo() {
		return TIPO;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumeroDeContasCadastradas() {
		return numeroDeContasCadastradas;
	}
}
