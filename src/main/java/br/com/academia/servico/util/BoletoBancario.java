package br.com.academia.servico.util;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class BoletoBancario {
	
	private Datas datas;
	private Endereco enderecoBeneficiario;
	private Beneficiario beneficiario;
	private Endereco enderecoPagador;
	private Pagador pagador;
	private Banco banco;
	private Boleto boleto;
	private GeradorDeBoleto gerador;

	
	public Datas getDatas() {
		return datas;
	}
	public void setDatas(Datas datas) {
		this.datas = datas;
	}
	public Endereco getEnderecoBeneficiario() {
		return enderecoBeneficiario;
	}
	public void setEnderecoBeneficiario(Endereco enderecoBeneficiario) {
		this.enderecoBeneficiario = enderecoBeneficiario;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Endereco getEnderecoPagador() {
		return enderecoPagador;
	}
	public void setEnderecoPagador(Endereco enderecoPagador) {
		this.enderecoPagador = enderecoPagador;
	}
	public Pagador getPagador() {
		return pagador;
	}
	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public Boleto getBoleto() {
		return boleto;
	}
	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
	public GeradorDeBoleto getGerador() {
		return gerador;
	}
	public void setGerador(GeradorDeBoleto gerador) {
		this.gerador = gerador;
	}

}
