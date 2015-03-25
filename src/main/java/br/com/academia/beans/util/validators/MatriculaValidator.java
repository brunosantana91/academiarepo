package br.com.academia.beans.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.academia.entidades.Matricula;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.servico.ServicoMatricula;

@Component
@Scope(value="view")
public class MatriculaValidator {

	@Autowired
	private ServicoMatricula servico;

	
	public void valida(Matricula matricula) throws ParametroEmUsoException{
			
		if(servico.buscarMatriculaPorPerfilEModalidade(matricula.getPerfil(), matricula.getModalidade()) != null){throw new ParametroEmUsoException("matrícula já realizada, favor verificar");}
	
}

}