package br.com.serrabank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.serrabank.cliente.Cliente;
import br.com.serrabank.funcionario.Funcionario;
import br.com.serrabank.io.Leitor;
import br.com.serrabank.login.Login;
import br.com.serrabank.menus.MenuInicial;

public class SistemaInterno {
		public static void main(String[] args) throws IOException {
		Map<String, Cliente> mapaContas = new HashMap<>();
		Map<String, Funcionario> mapaFuncionario = new HashMap<>(); 
	
		
		String path = ".\\arquivos";
		
		Leitor.criadorContas(path, mapaContas);
		Leitor.criadorFuncionarios(path, mapaFuncionario);
		
		MenuInicial.menuInicial(mapaContas, mapaFuncionario);
	}
}
