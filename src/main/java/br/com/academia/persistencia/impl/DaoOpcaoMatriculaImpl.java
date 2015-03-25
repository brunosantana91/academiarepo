package br.com.academia.persistencia.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.OpcaoMatricula;
import br.com.academia.persistencia.DaoOpcaoMatricula;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoOpcaoMatricula")
public class DaoOpcaoMatriculaImpl extends DaoGenerico<OpcaoMatricula> implements DaoOpcaoMatricula {

	@SuppressWarnings("unchecked")
	public List<OpcaoMatricula> listarOpcoesPorModalidade(Modalidade modalidade) {
		return listarPorQuery(getClazz(), "SELECT op FROM OpcaoMatricula op WHERE op.modalidade = ?", modalidade);
	}

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return OpcaoMatricula.class;
	}

}
