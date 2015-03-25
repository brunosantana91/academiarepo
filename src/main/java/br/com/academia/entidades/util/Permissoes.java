package br.com.academia.entidades.util;

public enum Permissoes {
	
	ADMIN("Admin"),
	INSTRUTOR("Instrutor"),
	ALUNO("Aluno");
	
	private String valor;

	private Permissoes(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
