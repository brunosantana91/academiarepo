package br.com.academia.entidades.util;

public enum DiasDaSemana {
	
	DOMINGO("DOMINGO"), 
	SEGUNDAFEIRA("SEGUNDA-FEIRA"), 
	TERCAFEIRA("TERA-FEIRA"), 
	QUARTAFEIRA("QUARTA-FEIRA"), 
	QUINTAFEIRA("QUINTA-FEIRA"), 
	SEXTAFEIRA("SEXTA-FEIRA"), 
	SABADO("SBADO");
	
	private final String valor;
	
	 DiasDaSemana(String valor){
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
