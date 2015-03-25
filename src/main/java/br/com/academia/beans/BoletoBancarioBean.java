package br.com.academia.beans;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;

import br.com.academia.servico.util.BoletoBancario;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bancos;
import br.com.caelum.stella.boleto.bancos.Itau;
import br.com.caelum.stella.boleto.bancos.Santander;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;

@Named
@Scope("request")
public class BoletoBancarioBean {

	private BoletoBancario boletoBancario = new BoletoBancario();
	
	public void gerarBoleto() throws IOException{
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		//datas do boleto
		boletoBancario.setDatas(Datas.novasDatas().comDocumento(1, 5, 2015).comProcessamento(1, 5, 2015).comVencimento(2, 5, 2015));
		//endereo do beneficiario
		boletoBancario.setEnderecoBeneficiario(Endereco.novoEndereco().comLogradouro("Rua testando boleto stella caelum").comBairro("GYMMy bairro").comCep("11234-030").comCep("GYMMy cidade").comUf("SP"));
		//beneficiario
		boletoBancario.setBeneficiario(Beneficiario.novoBeneficiario().comNomeBeneficiario("GYMMy").comAgencia("0001").comDigitoAgencia("1").comCodigoBeneficiario("500000").comDigitoCodigoBeneficiario("4").comNumeroConvenio("1234567").comCarteira("18").comEndereco(boletoBancario.getEnderecoBeneficiario()).comNossoNumero("123456789012"));
		//endereo do pagador
		boletoBancario.setEnderecoPagador(Endereco.novoEndereco().comLogradouro("Rua pagador testando boleto stella caelum").comBairro("Pagador bairro").comCep("12345-123").comCep("boletos city").comUf("SP"));
		//pagador
		boletoBancario.setPagador(Pagador.novoPagador().comNome("Fulano da Silva").comDocumento("123.456.789-12").comEndereco(boletoBancario.getEnderecoPagador()));
		
		//banco
		boletoBancario.setBanco(new BancoDoBrasil());
		
		
		

		
		Boleto boleto = Boleto.novoBoleto().comBanco(boletoBancario.getBanco()).comDatas(boletoBancario.getDatas()).comBeneficiario(boletoBancario.getBeneficiario()).comPagador(boletoBancario.getPagador()).comValorBoleto("100.0").comNumeroDoDocumento("1234").comInstrucoes("Pagvel em qualquer agncia bancria", "Aps vencimento acrscimo de 1000 reais").comLocaisDePagamento("Rua Santander 1", "Caixa Economica 2");
		
		GeradorDeBoletoHTML gerador = new GeradorDeBoletoHTML(boleto);
		HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
		gerador.geraPDF(response.getOutputStream());
		fc.responseComplete();
		

		
	}
}
