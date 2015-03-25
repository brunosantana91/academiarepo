package br.com.academia.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.MensagensDeNotificacao;
import br.com.academia.entidades.Matricula;
import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.OpcaoMatricula;
import br.com.academia.entidades.Perfil;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.servico.ServicoMatricula;
import br.com.academia.servico.ServicoModalidade;
import br.com.academia.servico.ServicoOpcaoMatricula;
import br.com.academia.servico.ServicoPerfil;

@Named
@Scope("view")
public class MatriculaBean {
	
	@Autowired
	private ServicoModalidade servicoModalidade;

	@Autowired
	private ServicoPerfil servicoPerfil;
	
	@Autowired
	private ServicoMatricula servicoMatricula;
	
	@Autowired
	private ServicoOpcaoMatricula servicoOpcaoMatricula;

	private List<Modalidade> modalidadesDisponiveis;
	private List<Modalidade> modalidadesSelecionadas = new ArrayList<Modalidade>();
	private OpcaoMatricula opcaoEscolhida;
	private OpcaoMatricula opcaoEscolhidaTab;
	private Modalidade modalidadeEscolhida;
	private Modalidade modalidadeEscolhidaTab;
	
	private List<Perfil> alunosDisponiveis;
	private List<Perfil> alunosFiltrados;
	private List<Perfil> alunosSelecionados = new ArrayList<Perfil>();
	private Perfil alunoEscolhido;
	
	@PostConstruct
	private void init(){
		modalidadesDisponiveis = servicoModalidade.listarEager();
		alunosDisponiveis = servicoPerfil.listar();
	}
	
	public List<Modalidade> completeModalidade(String busca) {
		List<Modalidade> filtrados = new ArrayList<Modalidade>();
		if(modalidadesSelecionadas == null){modalidadesSelecionadas = new ArrayList<Modalidade>();}
		for (Modalidade mod : modalidadesDisponiveis) {
			if (mod.getNome().contains(busca) && !modalidadesSelecionadas.contains(mod)) {
				filtrados.add(mod);
				}
			}
		return filtrados;
	}
	
	//seta uma propriedade para passar como flash scope e redireciona para uma nova tab
	public void selecionarAlunosNewTab() throws IOException{
		Faces.setFlashAttribute("modalidadeEscolhida", modalidadeEscolhida);
		Faces.setFlashAttribute("opcaoEscolhida", opcaoEscolhida);
		Faces.getFlash().setRedirect(true);
		Faces.redirect("../academia/admin/matriculateTab.xhtml");
	}

	//recupera os dados passados pelo flash através de um evento preRenderView na página
	public void buscaDadosMatricula(){
		this.modalidadeEscolhida = Faces.getFlashAttribute("modalidadeEscolhida");	
		this.opcaoEscolhida = Faces.getFlashAttribute("opcaoEscolhida");	
	}
	
	public String matricular() throws IOException{
		Matricula matricula = preparaMatricula();
		
	try {
			servicoMatricula.adicionar(matricula);
		} catch (ParametroEmUsoException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			MensagensDeNotificacao.criaMensagemDeNotificacaoERROR("ERRO! matrícula duplicada, favor verificar");
			context.getExternalContext().redirect("../admin/matriculate.xhtml#scrollHere");
			e.printStackTrace();
		}
		matricula = new Matricula();
		return "matriculateSuccess.xhtml#scrollHere";
	}
	

	
	private Matricula preparaMatricula() {
		Matricula matricula = new Matricula();
		modalidadeEscolhida = servicoModalidade.atualizar(modalidadeEscolhidaTab);
		List<Matricula> matriculas = modalidadeEscolhida.getMatriculas();
		matricula.setOpcaoMatricula(opcaoEscolhidaTab);
		matricula.setModalidade(modalidadeEscolhida);
		matricula.setPerfil(alunoEscolhido);
		matriculas.add(matricula);
		//matricula = servicoMatricula.atualizar(matricula);
		modalidadeEscolhida.setMatriculas(matriculas);
		return matricula;
	}

	public List<Modalidade> getModalidadesSelecionadas() {
		return modalidadesSelecionadas;
	}

	public void setModalidadesSelecionadas(List<Modalidade> modalidadesSelecionadas) {
		this.modalidadesSelecionadas = modalidadesSelecionadas;
	}

	public Modalidade getModalidadeEscolhida() {
		return modalidadeEscolhida;
	}

	public void setModalidadeEscolhida(Modalidade modalidadeEscolhida) {
		this.modalidadeEscolhida = modalidadeEscolhida;
	}

	public List<Perfil> getAlunosSelecionados() {
		return alunosSelecionados;
	}

	public void setAlunosSelecionados(List<Perfil> alunosSelecionados) {
		this.alunosSelecionados = alunosSelecionados;
	}
	

	public List<Perfil> getAlunosDisponiveis() {
		return alunosDisponiveis;
	}
	
	public void setAlunosDisponiveis(List<Perfil> alunosDisponiveis) {
		this.alunosDisponiveis = alunosDisponiveis;
	}

	public OpcaoMatricula getOpcaoEscolhida() {
		return opcaoEscolhida;
	}

	public void setOpcaoEscolhida(OpcaoMatricula opcaoEscolhida) {
		this.opcaoEscolhida = opcaoEscolhida;
	}

	public Perfil getAlunoEscolhido() {
		return alunoEscolhido;
	}

	public void setAlunoEscolhido(Perfil alunoEscolhido) {
		this.alunoEscolhido = alunoEscolhido;
	}

	public List<Perfil> getAlunosFiltrados() {
		return alunosFiltrados;
	}

	public void setAlunosFiltrados(List<Perfil> alunosFiltrados) {
		this.alunosFiltrados = alunosFiltrados;
	}

	public OpcaoMatricula getOpcaoEscolhidaTab() {
		return opcaoEscolhidaTab;
	}

	public void setOpcaoEscolhidaTab(OpcaoMatricula opcaoEscolhidaTab) {
		this.opcaoEscolhidaTab = opcaoEscolhidaTab;
	}

	public Modalidade getModalidadeEscolhidaTab() {
		return modalidadeEscolhidaTab;
	}

	public void setModalidadeEscolhidaTab(Modalidade modalidadeEscolhidaTab) {
		this.modalidadeEscolhidaTab = modalidadeEscolhidaTab;
	}

}
