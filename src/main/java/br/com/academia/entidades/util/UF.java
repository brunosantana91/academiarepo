package br.com.academia.entidades.util;

public enum UF {

	AC("Acre"), AL("Alagoas"), AP("Amap"), AM("Amazonas"), BA("Bahia"), CE("Cear"), DF("Distrito Federal"),
	ES("Esprito Santo"), GO("Gois"), MA("Maranho"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG("Minas Gerais"),
	PA("Par"), PB("Paraba"), PR("Paran"), PE("Pernambuco"), PI("Piau"), RJ("Rio de Janeiro"), RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"), RO("Rondnia"), RR("Roraima"), SC("Santa Catarina"), SP("So Paulo"), SE("Sergipe"), TO("Tocantins");
	
	
	
	private String valor;

	private UF(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
