package br.com.academia.beans.util;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class MensagensDeNotificacao {
	
	public MensagensDeNotificacao(){
		
	}
	
	public static void criaMensagemDeNotificacaoERROR(UIComponent componente, String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(componente.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}
	
	
	public static void criaMensagemDeNotificacaoERROR(String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}

	public static void criaMensagemDeNotificacaoINFO(UIComponent componente, String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(componente.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}
	
	public static void criaMensagemDeNotificacaoINFO(String mensagem){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}
	

}
