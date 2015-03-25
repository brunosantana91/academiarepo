package br.com.academia.beans;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.MensagensDeNotificacao;
import br.com.academia.entidades.Exercicio;
import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Treino;
import br.com.academia.entidades.util.DiasDaSemana;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.servico.ServicoExercicio;
import br.com.academia.servico.ServicoModalidade;
import br.com.academia.servico.ServicoTreino;

@Named
@Scope("view")
public class TreinamentosBean {
	//INIT---------------------------------------------------------	
	@Autowired
	private ServicoModalidade servicoModalidade;
	@Autowired
	private ServicoTreino servicoTreino;
	@Autowired
	private ServicoExercicio servicoExercicio;
	@Autowired
	private LoginBean loginBean;
	
	private List<Modalidade> modalidades;
	private Modalidade modalidadeEscolhida;
	private List<Treino> treinosEspecificos;
	private Treino treinoEscolhido;
	private Exercicio exercicioEditar;
	private Exercicio exercicioExcluirDomingo;
	private Exercicio exercicioExcluirSegunda;
	private Exercicio exercicioExcluirTerca;
	private Exercicio exercicioExcluirQuarta;
	private Exercicio exercicioExcluirQuinta;
	private Exercicio exercicioExcluirSexta;
	private Exercicio exercicioExcluirSabado;
	private Exercicio novoExercicio = new Exercicio();
	private String diaNovoExercicio;
	private List<Exercicio> exerciciosDomingo;
	private List<Exercicio> exerciciosSegunda;
	private List<Exercicio> exerciciosTerca;
	private List<Exercicio> exerciciosQuarta;
	private List<Exercicio> exerciciosQuinta;
	private List<Exercicio> exerciciosSexta;
	private List<Exercicio> exerciciosSabado;

	
	
	@PostConstruct
	private void init(){
		modalidades = servicoModalidade.listarModalidadesPorPerfil(loginBean.getPerfilLogado());
		}
	
	

	public String criarTreino(){
		Treino novoTreino = new Treino();
		novoTreino.setNome(modalidadeEscolhida.getNome() + new Random().nextInt());
		novoTreino.setModalidade(modalidadeEscolhida);
		novoTreino.setPerfil(loginBean.getPerfilLogado());
		try {
			servicoTreino.adicionar(novoTreino);
			novoTreino.setNome(modalidadeEscolhida.getNome() + " " + novoTreino.getId());
			servicoTreino.editar(novoTreino);
		} catch (ParametroEmUsoException e) {
			e.printStackTrace();
		}
		return "trainingPanel.xhtml?faces-redirect=true";
	}
	
	public void criarExercicio(){

		DiasDaSemana diaEscolhido = DiasDaSemana.valueOf(diaNovoExercicio);
		novoExercicio.setTreino(treinoEscolhido);
		novoExercicio.setDia(diaEscolhido);
		try {
			servicoExercicio.adicionar(novoExercicio);
		} catch (ParametroEmUsoException e) {
			MensagensDeNotificacao.criaMensagemDeNotificacaoERROR("Algo de errado aconteceu, por favor tente novamente");
			e.printStackTrace();
		}
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Novo exerccio adicionado com sucesso");
	
		novoExercicio = new Exercicio();
	}
	
/*	public void onRowSelectExcluirDomingo(SelectEvent event){
		exercicioExcluirDomingo = (Exercicio) event.getObject();
	}
	*/
	//excluir ex dia especifico---------------------------------------------------------------------
	public void excluirExercicioDomingo(){
		servicoExercicio.remover(exercicioExcluirDomingo);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	public void excluirExercicioSegunda(){
		servicoExercicio.remover(exercicioExcluirSegunda);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	public void excluirExercicioTerca(){
		servicoExercicio.remover(exercicioExcluirTerca);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	public void excluirExercicioQuarta(){
		servicoExercicio.remover(exercicioExcluirQuarta);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	public void excluirExercicioQuinta(){
		servicoExercicio.remover(exercicioExcluirQuinta);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	public void excluirExercicioSexta(){
		servicoExercicio.remover(exercicioExcluirSexta);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	public void excluirExercicioSabado(){
		servicoExercicio.remover(exercicioExcluirSabado);
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Exerccio excludo");
	}
	
	
	
	public void limparCampos(){
		novoExercicio.setNome("");
		novoExercicio.setDescricao("");
	}
	
	//EVENTS--------------------------------------------------------------------------
	public void onChangeModalidade(ValueChangeEvent event){
		Object oldValue = event.getOldValue();
	    Object newValue = event.getNewValue();
	    
		 if(newValue != null && !newValue.equals(oldValue)) {
		modalidadeEscolhida = (Modalidade) event.getNewValue();
		 }
		 if(treinosEspecificos == null || treinosEspecificos.isEmpty() || !modalidadeEscolhida.equals(oldValue)){treinosEspecificos = servicoTreino.listarTreinosEspecifico(modalidadeEscolhida, loginBean.getPerfilLogado());}
	}
	
	
    public void onCellEditNomeTreino(CellEditEvent event) throws IOException {
    	FacesContext context = FacesContext.getCurrentInstance();
    	//busca atravs do evento a rowKey, nesse caso passei o objeto inteiro como rowKey, foi a unica maneira de saber qual bean estava editando
    	DataTable dataTable = (DataTable) event.getSource();
    	treinoEscolhido = (Treino) dataTable.getRowData();
    	Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        if(newValue == ""){
        
        	servicoTreino.remover(treinoEscolhido);
        	 MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Treino: " + oldValue + " excludo");
        	 context.getExternalContext().getFlash().setKeepMessages(true);
 			context.getExternalContext().redirect("trainingPanel.xhtml");
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
      
        	treinoEscolhido.setNome((String) newValue);
        	servicoTreino.editar(treinoEscolhido);
            MensagensDeNotificacao.criaMensagemDeNotificacaoINFO("Treino: " + oldValue + " editado para: " + newValue);
            
        }
        
    }
    
    public void onCellEditExercicio(CellEditEvent event) throws IOException {
    
    	DataTable dataTable = (DataTable) event.getSource();
    	exercicioEditar = (Exercicio) dataTable.getRowData();
    	Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        if(newValue != null && !newValue.equals(oldValue)) {
        	servicoExercicio.editar(exercicioEditar);
        }
    }
    
    public void onRowToggle(ToggleEvent event){
    	DataTable dataTable = (DataTable) event.getSource();
    	treinoEscolhido = (Treino) dataTable.getRowData();
    	getExerciciosTodosOsDias();
    }
    


    private void getExerciciosTodosOsDias(){
    	exerciciosDomingo = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.DOMINGO);
    	exerciciosSegunda = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.SEGUNDAFEIRA);
    	exerciciosTerca = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.TERCAFEIRA);
    	exerciciosQuarta = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.QUARTAFEIRA);
    	exerciciosQuinta = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.QUINTAFEIRA);
    	exerciciosSexta = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.SEXTAFEIRA);
    	exerciciosSabado = servicoExercicio.listarExerciciosEspecificos(treinoEscolhido, DiasDaSemana.SABADO);
    }


    //FLASH-----------------------------------------------------------------------------------
    public void maximizarTreinoNewTab() throws IOException{
		Faces.setFlashAttribute("treinoEscolhido", treinoEscolhido);
		Faces.getFlash().setRedirect(true);
		Faces.redirect("../academia/public/maximizeTrainingTab.xhtml");
    }
    
	public void buscaDadosTreinoMaximizado(){
		this.treinoEscolhido = Faces.getFlashAttribute("treinoEscolhido");		
	}
    
	//GETTERS & SETTERS-------------------------------------------------------------------
	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}

	public Modalidade getModalidadeEscolhida() {
		return modalidadeEscolhida;
	}

	public void setModalidadeEscolhida(Modalidade modalidadeEscolhida) {
		this.modalidadeEscolhida = modalidadeEscolhida;
	}

	public List<Treino> getTreinosEspecificos() {
		return treinosEspecificos;
	}

	public void setTreinosEspecificos(List<Treino> treinosEspecificos) {
		this.treinosEspecificos = treinosEspecificos;
	}

	public Treino getTreinoEscolhido() {
		return treinoEscolhido;
	}

	public void setTreinoEscolhido(Treino treinoEscolhido) {
		this.treinoEscolhido = treinoEscolhido;
	}


	public void setExerciciosEspecificos(List<Exercicio> exerciciosEspecificos) {
		this.exerciciosDomingo = exerciciosEspecificos;
	}

	public List<Exercicio> getExerciciosEspecificos() {
		return exerciciosDomingo;
	}

	public List<Exercicio> getExerciciosDomingo() {
			return exerciciosDomingo;
	}

	public void setExerciciosDomingo(List<Exercicio> exerciciosDomingo) {
		this.exerciciosDomingo = exerciciosDomingo;
	}

	public List<Exercicio> getExerciciosSegunda() {
		return exerciciosSegunda;
	}
	

	public void setExerciciosSegunda(List<Exercicio> exerciciosSegunda) {
		this.exerciciosSegunda = exerciciosSegunda;
	}

	public List<Exercicio> getExerciciosTerca() {
		return exerciciosTerca;
	}

	public void setExerciciosTerca(List<Exercicio> exerciciosTerca) {
		this.exerciciosTerca = exerciciosTerca;
	}

	public List<Exercicio> getExerciciosQuarta() {
		return exerciciosQuarta;
	}
	

	public void setExerciciosQuarta(List<Exercicio> exerciciosQuarta) {
		this.exerciciosQuarta = exerciciosQuarta;
	}

	public List<Exercicio> getExerciciosQuinta() {
		return exerciciosQuinta;
	}

	public void setExerciciosQuinta(List<Exercicio> exerciciosQuinta) {
		this.exerciciosQuinta = exerciciosQuinta;
	}

	public List<Exercicio> getExerciciosSexta() {
		return exerciciosSexta;
	}

	public void setExerciciosSexta(List<Exercicio> exerciciosSexta) {
		this.exerciciosSexta = exerciciosSexta;
	}

	public List<Exercicio> getExerciciosSabado() {
		return exerciciosSabado;
	}

	public void setExerciciosSabado(List<Exercicio> exerciciosSabado) {
		this.exerciciosSabado = exerciciosSabado;
	}

	public Exercicio getExercicioEditar() {
		return exercicioEditar;
	}

	public void setExercicioEditar(Exercicio exercicioEditar) {
		this.exercicioEditar = exercicioEditar;
	}



	public Exercicio getNovoExercicio() {
		return novoExercicio;
	}



	public void setNovoExercicio(Exercicio novoExercicio) {
		this.novoExercicio = novoExercicio;
	}



	public String getDiaNovoExercicio() {
		return diaNovoExercicio;
	}



	public void setDiaNovoExercicio(String diaNovoExercicio) {
		this.diaNovoExercicio = diaNovoExercicio;
	}



	public Exercicio getExercicioExcluirDomingo() {
		return exercicioExcluirDomingo;
	}



	public void setExercicioExcluirDomingo(Exercicio exercicioExcluirDomingo) {
		this.exercicioExcluirDomingo = exercicioExcluirDomingo;
	}



	public Exercicio getExercicioExcluirSegunda() {
		return exercicioExcluirSegunda;
	}



	public void setExercicioExcluirSegunda(Exercicio exercicioExcluirSegunda) {
		this.exercicioExcluirSegunda = exercicioExcluirSegunda;
	}



	public Exercicio getExercicioExcluirTerca() {
		return exercicioExcluirTerca;
	}



	public void setExercicioExcluirTerca(Exercicio exercicioExcluirTerca) {
		this.exercicioExcluirTerca = exercicioExcluirTerca;
	}



	public Exercicio getExercicioExcluirQuarta() {
		return exercicioExcluirQuarta;
	}



	public void setExercicioExcluirQuarta(Exercicio exercicioExcluirQuarta) {
		this.exercicioExcluirQuarta = exercicioExcluirQuarta;
	}



	public Exercicio getExercicioExcluirQuinta() {
		return exercicioExcluirQuinta;
	}



	public void setExercicioExcluirQuinta(Exercicio exercicioExcluirQuinta) {
		this.exercicioExcluirQuinta = exercicioExcluirQuinta;
	}



	public Exercicio getExercicioExcluirSexta() {
		return exercicioExcluirSexta;
	}



	public void setExercicioExcluirSexta(Exercicio exercicioExcluirSexta) {
		this.exercicioExcluirSexta = exercicioExcluirSexta;
	}



	public Exercicio getExercicioExcluirSabado() {
		return exercicioExcluirSabado;
	}



	public void setExercicioExcluirSabado(Exercicio exercicioExcluirSabado) {
		this.exercicioExcluirSabado = exercicioExcluirSabado;
	}




}
