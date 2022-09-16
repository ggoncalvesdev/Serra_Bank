package br.com.serrabank.exception;

public class SaldoInsuficienteException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}

}
