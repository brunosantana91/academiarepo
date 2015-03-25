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
import br.com.academia.servico.ServicoModalidade;

@Named(value="modalidadeEmUsoValidator")
@Scope("request")
public class ModalidadeEmUsoValidator implements Validator {
	
	private JSFUtils jsfUtils = new JSFUtils();
	@Autowired
	private ServicoModalidade servicoModalidade;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	
		if(servicoModalidade.buscarModalidadePorNome(value.toString()) != null){
			MensagensDeNotificacao.criaMensagemDeNotificacaoERROR(jsfUtils.buscaComponentePorId("inputNome"), "modalidade já cadastrada, tente outra");
		}
		
	}

}
