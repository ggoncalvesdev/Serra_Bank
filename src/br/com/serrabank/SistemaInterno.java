package br.com.serrabank;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.conta.conta_corrente.ContaCorrente;

public class SistemaInterno {
	
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Pedro", "123456789", "123");
		ContaCorrente c1 =  new ContaCorrente(cliente1, 4098);
		
		
		System.out.println(c1);
		System.out.println(cliente1.getNome());
	}
}
