package br.com.serrabank.conta.conta_corrente;

import br.com.serrabank.conta.Conta;
import br.com.serrabank.funcionario.Gerente;

public class ContaCorrente extends Conta {
	private static final String TIPO = "CORRENTE";
	
	private static double tributacao;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String nome, String senha, String cpf, double saldo, int agencia) {
		setTitular(nome);
		setSenha(senha);
		setCpf(cpf);
		setSaldo(saldo);
		setAgencia(agencia);
	}
	
	@Override
	public void sacar(double valor) {
		this.saldo -= 0.10;
		tributacao += tributacao + 0.10;
            this.saldo -= valor;
	}
	
	@Override
	public void depositar(double deposito) {
		this.saldo -= 0.10;
		tributacao += 0.10;
    		this.saldo = this.saldo + deposito;
	}
	
	@Override
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

	public String getTipo() {
		return TIPO;
	}

	public double getTributacao() {
		return tributacao;
	}

	@Override
	public String toString() {
		return "ContaCorrente [getSaldo()=" + getSaldo() + ", getNome()=" + getNome() + ", getSenha()=" + getSenha()
				+ ", getCpf()=" + getCpf() + ", agencia=" + agencia + "]";
	}
}

