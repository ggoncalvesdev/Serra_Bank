package br.com.serrabank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.io.Leitor;
import br.com.serrabank.login.Login;

public class SistemaInterno {
	
	public static void main(String[] args) throws IOException {
		Map<String, Cliente> mapaContas = new HashMap<>();
		 
		String path = ".\\arquivos";
		
		Leitor.criadorContas(path, mapaContas);
		Leitor.criadorFuncionarios(path);
		
		Login.loginCliente(mapaContas);
	}
}
