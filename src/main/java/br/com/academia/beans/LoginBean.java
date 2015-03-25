package br.com.academia.beans;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.JSFUtils;
import br.com.academia.beans.util.MensagensDeNotificacao;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Usuario;
import br.com.academia.servico.ServicoPerfil;
import br.com.academia.servico.ServicoUsuario;

@Named
@Scope(value="session")
public class LoginBean {

	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@Autowired
	private ServicoPerfil servicoPerfil;

	private Usuario usuarioLogado;
	
	private Perfil perfilLogado;

	private String login;
	private String senha;

	private JSFUtils jsfUtils = new JSFUtils();

	public String fazerLogin() {
		usuarioLogado = null;
		usuarioLogado = servicoUsuario.buscarUsuarioPorLoginESenha(login, senha);
		if (usuarioLogado == null) {
			mensagemErroLogin();
			return "/index.xhtml?faces-redirect=true";
		} else {
			perfilLogado = servicoPerfil.buscarPerfilPorUsuario(usuarioLogado);
			return "/public/home.xhtml?faces-redirect=true";
		}
	}

	private void mensagemErroLogin() {
		MensagensDeNotificacao.criaMensagemDeNotificacaoERROR(jsfUtils.buscaComponentePorId("inputLogin"), "login/senha inválidos");
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public void limparCampos(){
		login = "";
		senha = "";
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ServicoUsuario getServicoUsuario() {
		return servicoUsuario;
	}

	public void setServicoUsuario(ServicoUsuario servicoUsuario) {
		this.servicoUsuario = servicoUsuario;
	}

	public Perfil getPerfilLogado() {
		return perfilLogado;
	}

	public void setPerfilLogado(Perfil perfilLogado) {
		this.perfilLogado = perfilLogado;
	}
}
