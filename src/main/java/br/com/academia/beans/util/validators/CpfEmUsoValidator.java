package br.com.academia.beans.util.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.beans.util.JSFUtils;
import br.com.academia.beans.util.MensagensDeNotificacao;
import br.com.academia.servico.ServicoPerfil;

@Named(value="cpfEmUsoValidator")
@Scope("request")
public class CpfEmUsoValidator implements Validator{
	

	private JSFUtils jsfUtils = new JSFUtils();
	@Autowired
	private ServicoPerfil servicoPerfil;

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(servicoPerfil.buscarPerfilPorCpf(value.toString()) != null){
			MensagensDeNotificacao.criaMensagemDeNotificacaoERROR(jsfUtils.buscaComponentePorId("inputCpf"), "CPF j� cadastrado, tente outro");
		}
		
	}

}
