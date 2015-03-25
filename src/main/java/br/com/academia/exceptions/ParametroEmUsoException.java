package br.com.academia.exceptions;

public class ParametroEmUsoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ParametroEmUsoException(String mensagem){
		System.out.println("Lanada exception :::...:::.ParametroEmUsoException.:::...:::");
		System.out.println(mensagem);
	}
	

}
