package br.com.academia.beans.util.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.academia.beans.util.JSFUtils;
import br.com.academia.beans.util.MensagensDeNotificacao;

@FacesValidator(value="ufValidator")
public class UFValidator implements Validator{
	
	
	private JSFUtils jsfUtils = new JSFUtils();

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	
		if(value == null){
			MensagensDeNotificacao.criaMensagemDeNotificacaoERROR(jsfUtils.buscaComponentePorId("inputUf"), "escolha um estado");
		}
		
	}

}


