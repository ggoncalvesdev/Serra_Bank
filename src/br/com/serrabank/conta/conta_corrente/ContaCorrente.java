package br.com.serrabank.conta.conta_corrente;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.Conta;

public class ContaCorrente extends Conta {
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(Cliente cliente, int agencia) {
		super(cliente, agencia);
	}
		
	@Override
	public String toString() {
		return "ContaCorrente [getSaldo()=" + getSaldo() + ", getAgencia()=" + getAgencia() + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + "]";
	}
	
	
}
