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
		
	public void sacar(double valor) {
            this.saldo -= valor;
	}
	
	public void depositar(double deposito) {
    		this.saldo = this.saldo + deposito;
	}
	
	 public void transfere(Conta destino, double valor) {
		
	    	if(this.saldo < valor) {	
	    	 System.out.println("Saldo insuficiente"); 		
	    	 
	    	} else {
	    		this.saldo = this.saldo - valor;
	    		destino.saldo = destino.saldo + valor;
	    }
    }
	
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
