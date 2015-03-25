package br.com.academia.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.ToggleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.JSFUtils;
import br.com.academia.beans.util.MensagensDeNotificacao;
import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.OpcaoMatricula;
import br.com.academia.entidades.util.DiasDaSemana;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.servico.ServicoModalidade;
import br.com.academia.servico.ServicoOpcaoMatricula;

@Named
@Scope("view")
public class CadastroModalidadeBean {

	private Modalidade modalidade = new Modalidade();

	private OpcaoMatricula opcao1 = new OpcaoMatricula();
	private OpcaoMatricula opcao2 = new OpcaoMatricula();
	private OpcaoMatricula opcao3 = new OpcaoMatricula();
	private List<OpcaoMatricula> opcoes = new ArrayList<OpcaoMatricula>();

	private List<DiasDaSemana> diasDaSemana = new ArrayList<DiasDaSemana>();

	private boolean disableMaisOpcoes = true;
	private boolean disableMaisOpcoes2 = true;

	private JSFUtils jsfUtils = new JSFUtils();

	@Autowired
	private ServicoModalidade servicoModalidade;

	@Autowired
	private ServicoOpcaoMatricula servicoOpcaoMatricula;

	@PostConstruct
	private void init() {
		diasDaSemana.add(DiasDaSemana.DOMINGO);
		diasDaSemana.add(DiasDaSemana.SEGUNDAFEIRA);
		diasDaSemana.add(DiasDaSemana.TERCAFEIRA);
		diasDaSemana.add(DiasDaSemana.QUARTAFEIRA);
		diasDaSemana.add(DiasDaSemana.QUINTAFEIRA);
		diasDaSemana.add(DiasDaSemana.SEXTAFEIRA);
		diasDaSemana.add(DiasDaSemana.SABADO);

	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String cadastrar() throws ParametroEmUsoException {

		try {
			servicoModalidade.adicionar(modalidade);
		} catch (ParametroEmUsoException e) {
			MensagensDeNotificacao.criaMensagemDeNotificacaoINFO(
					jsfUtils.buscaComponentePorId("inputNome"),
					"Modalidade já cadastrada, tente outra");
			e.printStackTrace();
		}

		preparaOpcoesMatricula();

		modalidade = new Modalidade();
		opcao1 = new OpcaoMatricula();
		opcao2 = new OpcaoMatricula();
		opcao3 = new OpcaoMatricula();

		return "registerModalitySuccess.xhtml#scrollHere";
	}


	/*
	 * private void preparaRegistroModalidadeDias3() { if(disableMaisOpcoes2 ==
	 * false){ modalidadeDias3.setModalidade(modalidade);
	 * modalidadeDias3.setDiasSemana(diasSelecionados3); precos.put(modalidade,
	 * modalidadeDias3); } } private void preparaRegistroModalidadeDias2() {
	 * if(disableMaisOpcoes == false){
	 * modalidadeDias2.setModalidade(modalidade);
	 * modalidadeDias2.setDiasSemana(diasSelecionados2); precos.put(modalidade,
	 * modalidadeDias2); } }
	 * 
	 * private void preparaRegistroModalidadeDias() {
	 * modalidadeDias.setModalidade(modalidade);
	 * modalidadeDias.setDiasSemana(diasSelecionados); precos.put(modalidade,
	 * modalidadeDias); }
	 */

	public void postValidate() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.isValidationFailed()) {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.getExternalContext().redirect(
					"registerModality.xhtml#scrollHere");
		}

	}

	public boolean isPanelMaisOpcoes2Collapsed() {
		if (disableMaisOpcoes2 == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPanelMaisOpcoesCollapsed() {
		if (disableMaisOpcoes == true) {
			return true;
		} else {
			return false;
		}
	}

	public void onPanelMaisOpcoes2Toggle(ToggleEvent event) {
		if (disableMaisOpcoes2 == true) {
			disableMaisOpcoes2 = false;
		} else if (disableMaisOpcoes2 == false) {
			disableMaisOpcoes2 = true;
		}
	}

	public void onPanelMaisOpcoesToggle(ToggleEvent event) {
		if (disableMaisOpcoes == true) {
			disableMaisOpcoes = false;
		} else if (disableMaisOpcoes == false) {
			disableMaisOpcoes = true;
		}
	}

	private void preparaOpcoesMatricula() throws ParametroEmUsoException {
		opcao1.setModalidade(modalidade);
		opcoes.add(opcao1);
		servicoOpcaoMatricula.adicionar(opcao1);
		
		if(disableMaisOpcoes == false){
		opcao2.setModalidade(modalidade);
		opcoes.add(opcao2);
		servicoOpcaoMatricula.adicionar(opcao2);
		}
		
		if(disableMaisOpcoes2 == false){
		opcao3.setModalidade(modalidade);
		opcoes.add(opcao3);
		servicoOpcaoMatricula.adicionar(opcao3);
		}

		modalidade.setOpcoesMatricula(opcoes);
		servicoModalidade.editar(modalidade);
	}

	public List<DiasDaSemana> getDiasDaSemana() {
		return diasDaSemana;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public boolean isDisableMaisOpcoes2() {
		return disableMaisOpcoes2;
	}

	public void setDisableMaisOpcoes2(boolean disableMaisOpcoes2) {
		this.disableMaisOpcoes2 = disableMaisOpcoes2;
	}

	public OpcaoMatricula getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(OpcaoMatricula opcao1) {
		this.opcao1 = opcao1;
	}

	public OpcaoMatricula getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(OpcaoMatricula opcao2) {
		this.opcao2 = opcao2;
	}

	public OpcaoMatricula getOpcao3() {
		return opcao3;
	}

	public void setOpcao3(OpcaoMatricula opcao3) {
		this.opcao3 = opcao3;
	}

	public List<OpcaoMatricula> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<OpcaoMatricula> opcoes) {
		this.opcoes = opcoes;
	}

	public boolean isDisableMaisOpcoes() {
		return disableMaisOpcoes;
	}

	public void setDisableMaisOpcoes(boolean disableMaisOpcoes) {
		this.disableMaisOpcoes = disableMaisOpcoes;
	}

}
