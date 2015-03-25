package br.com.academia.persistencia.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Matricula;
import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.persistencia.DaoMatricula;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoMatricula")
public class DaoMatriculaImpl extends DaoGenerico<Matricula> implements DaoMatricula{

	@SuppressWarnings("unchecked")
	public List<Matricula> listarMatriculasPorModalidade(Modalidade modalidade) {
		return listarPorQuery(getClazz(), "SELECT mt FROM Matricula mt WHERE mt.modalidade = ?", modalidade);
	}

	@SuppressWarnings("unchecked")
	public List<Matricula> listarMatriculasPorPerfil(Perfil perfil) {
		return listarPorQuery(getClazz(), "SELECT mt FROM Matricula mt WHERE mt.perfil = ?", perfil);
	}

	@SuppressWarnings("unchecked")
	public Matricula buscarMatriculaPorPerfilEModalidade(Perfil perfil, Modalidade modalidade) {
		return buscarPorQuery(getClazz(), "SELECT mt FROM Matricula mt WHERE mt.perfil = ? AND mt.modalidade = ?", perfil, modalidade);
	}

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return Matricula.class;
	}


}
