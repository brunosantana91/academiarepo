package br.com.academia.servico;

import java.util.List;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.OpcaoMatricula;

public interface ServicoOpcaoMatricula extends ServicoInterface<OpcaoMatricula> {
	
	List<OpcaoMatricula> listarOpcoesPorModalidade(Modalidade modalidade);

}
