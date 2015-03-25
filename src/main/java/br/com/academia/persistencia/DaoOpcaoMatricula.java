package br.com.academia.persistencia;

import java.util.List;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.OpcaoMatricula;

public interface DaoOpcaoMatricula extends DaoInterface<OpcaoMatricula> {

	List<OpcaoMatricula> listarOpcoesPorModalidade(Modalidade modalidade);

}
