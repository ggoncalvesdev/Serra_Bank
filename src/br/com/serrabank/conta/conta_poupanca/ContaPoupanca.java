package br.com.serrabank.conta.conta_poupanca;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(Cliente cliente, int agencia) {
		super(cliente, agencia);
	}
		
	@Override
	public String toString() {
		return "ContaPoupança [getSaldo()=" + getSaldo() + ", Agencia=" + getAgencia() + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + "]";
	}
	
	
}
