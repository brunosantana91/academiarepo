package br.com.academia.entidades.util;

public enum DiasDaSemana {
	
	DOMINGO("DOMINGO"), 
	SEGUNDAFEIRA("SEGUNDA-FEIRA"), 
	TERCAFEIRA("TERÇA-FEIRA"), 
	QUARTAFEIRA("QUARTA-FEIRA"), 
	QUINTAFEIRA("QUINTA-FEIRA"), 
	SEXTAFEIRA("SEXTA-FEIRA"), 
	SABADO("SÁBADO");
	
	private final String valor;
	
	 DiasDaSemana(String valor){
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
