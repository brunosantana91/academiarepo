package br.com.academia.persistencia.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Treino;
import br.com.academia.persistencia.DaoTreino;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoTreino")
public class DaoTreinoImpl extends DaoGenerico<Treino> implements DaoTreino {

	public List<Treino> listarTreinosPorPerfil(Perfil perfil) {
		return listarPorQuery(getClazz(), "SELECT t FROM Treino t WHERE t.perfil = ?", perfil);
	}

	public List<Treino> listarTreinosPorModalidade(Modalidade modalidade) {
		return listarPorQuery(getClazz(), "SELECT t FROM Treino t WHERE t.modalidade = ?", modalidade);
	}

	public List<Treino> listarTreinosEspecifico(Modalidade modalidade, Perfil perfil) {
		return listarPorQuery(getClazz(), "SELECT t FROM Treino t WHERE t.modalidade = ? and t.perfil = ?", modalidade, perfil);
	}

	@Override
	protected Class<Treino> getClazz() {
		return Treino.class;
	}


}
