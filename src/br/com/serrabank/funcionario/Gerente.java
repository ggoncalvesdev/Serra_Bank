package br.com.serrabank.funcionario;

import java.util.Map;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;
import br.com.serrabank.menus.MenuGerente;

public class Gerente extends Funcionario {
	private static final String CARGO = "GERENTE";
	private int agencia;
	private double saldo;
	private static double tributacao;
	
	public Gerente() {
	}

	public Gerente(String nome, String senha, String cpf, double saldo, int agencia) {
		setNome(nome);
		trocarSenha(senha);
		setCpf(cpf);
		setSaldo(saldo);
		this.agencia = agencia;
	}
	public void sacar(double valor) {
		this.saldo -= 0.10;
		tributacao += tributacao + 0.10;
            this.saldo -= valor;
	}
	
	public void depositar(double deposito) {
		this.saldo -= 0.10;
		tributacao += 0.10;
    		this.saldo = this.saldo + deposito;
	}
	
	public void transfere(Conta destino, double valor) {
		
    	if(this.saldo + 0.20 < valor) {	
    	 System.out.println("Saldo insuficiente"); 		
    	 
    	} else {
    		tributacao += 0.20;
    		this.saldo -= 0.20;
    		this.saldo = this.saldo - valor;
    		destino.setSaldo(destino.getSaldo() + valor);
    }
}
 	
 	public void transfereGerente(Gerente destino, double valor) {
    	if(this.saldo < valor) {	
    	 System.out.println("Saldo insuficiente"); 		
    	 
    	} else {
    		tributacao += 0.20;
    		this.saldo -= 0.20;
    		this.saldo = this.saldo - valor;
    		destino.setSaldo(destino.getSaldo()+valor);
    	}
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTributacao() {
		return tributacao;
	}

	@Override
	public void menuFuncionario(Funcionario funcionario, Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) {
		MenuGerente.menuGerente(funcionario, mapaContas, mapaFuncionario);		
	}
}
