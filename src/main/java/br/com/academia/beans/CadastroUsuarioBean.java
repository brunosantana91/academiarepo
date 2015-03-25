package br.com.academia.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.JSFUtils;
import br.com.academia.beans.util.MensagensDeNotificacao;
import br.com.academia.beans.util.UploadArquivo;
import br.com.academia.entidades.Endereco;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Usuario;
import br.com.academia.entidades.util.Permissoes;
import br.com.academia.entidades.util.UF;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.servico.ServicoPerfil;
import br.com.academia.servico.ServicoUsuario;

@Named
@Scope("view")
public class CadastroUsuarioBean {

	private Usuario usuario = new Usuario();
	private Perfil perfil = new Perfil();
	
	private List<Permissoes> permissoesDisponiveis = new ArrayList<Permissoes>();
	private List<Permissoes> permissoesSelecionadas;
	private List<UF> ufs = new ArrayList<UF>();
	private UploadArquivo uploadArquivo = new UploadArquivo();
	private JSFUtils jsfUtils = new JSFUtils();

	@Autowired
	private ServicoUsuario servicoUsuario;

	@Autowired
	private ServicoPerfil servicoPerfil;

	@PostConstruct
	private void init() {
		permissoesDisponiveis.add(Permissoes.ADMIN);
		permissoesDisponiveis.add(Permissoes.ALUNO);
		permissoesDisponiveis.add(Permissoes.INSTRUTOR);
		perfil.setEndereco(new Endereco());
	
		ufs.add(UF.AC);
		ufs.add(UF.AL);
		ufs.add(UF.AM);
		ufs.add(UF.AP);
		ufs.add(UF.BA);
		ufs.add(UF.CE);
		ufs.add(UF.DF);
		ufs.add(UF.ES);
		ufs.add(UF.GO);
		ufs.add(UF.MA);
		ufs.add(UF.MG);
		ufs.add(UF.MS);
		ufs.add(UF.MT);
		ufs.add(UF.PA);
		ufs.add(UF.PB);
		ufs.add(UF.PE);
		ufs.add(UF.PI);
		ufs.add(UF.PR);
		ufs.add(UF.RJ);
		ufs.add(UF.RN);
		ufs.add(UF.RO);
		ufs.add(UF.RR);
		ufs.add(UF.RS);
		ufs.add(UF.SC);
		ufs.add(UF.SE);
		ufs.add(UF.SP);
		ufs.add(UF.TO);
		
	}
	
	public String cadastrar() {
		preparaRegistro();
		try {
			servicoUsuario.adicionar(usuario);
		} catch (ParametroEmUsoException e) {
			MensagensDeNotificacao.criaMensagemDeNotificacaoINFO(jsfUtils.buscaComponentePorId("inputNome"), "ERRO: usuário duplicado");
			e.printStackTrace();
		}
		try {
			servicoPerfil.adicionar(perfil);
		} catch (ParametroEmUsoException e) {
			MensagensDeNotificacao.criaMensagemDeNotificacaoINFO(jsfUtils.buscaComponentePorId("inputNome"), "ERRO: perfil duplicado");
			e.printStackTrace();
		}
		if(uploadArquivo.getArquivoUpado() != null){
		uploadArquivo.gravar();
		}
		
		usuario = new Usuario();
		perfil = new Perfil();
		
		return "registerUserSuccess.xhtml#scrollHere";
	}
	
	public void postValidate() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.isValidationFailed()) {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.getExternalContext().redirect("registerUser.xhtml#scrollHere");
		}

	}

	public void fotoUpload(FileUploadEvent fileUploadEvent) {
		uploadArquivo.upload(fileUploadEvent, ".jpg",
				"C:/apache-tomcat-7.0.57/gymmy/img/usuarios/");
		MensagensDeNotificacao.criaMensagemDeNotificacaoINFO(
				jsfUtils.buscaComponentePorId("inputFotoUpload"),
				fileUploadEvent.getFile().getFileName() + " carregado");
		perfil.setFoto(uploadArquivo.getNomeArquivoUpado());

	}

	private void preparaRegistro() {
		usuario.setLogin(perfil.getEmail());
		usuario.setSenha(perfil.getRg());
		usuario.setPermissoes(getPermissoesSelecionadas());
		usuario.setPermissoes(permissoesSelecionadas);
		perfil.setUsuario(usuario);
		usuario.setAtivo(true);
	}

	public List<Permissoes> getPermissoesDisponiveis() {
		return permissoesDisponiveis;
	}

	public List<Permissoes> getPermissoesSelecionadas() {
		return permissoesSelecionadas;
	}

	public void setPermissoesSelecionadas(
			List<Permissoes> permissoesSelecionadas) {
		this.permissoesSelecionadas = permissoesSelecionadas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

}
