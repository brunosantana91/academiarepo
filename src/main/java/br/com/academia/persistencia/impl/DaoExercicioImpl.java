package br.com.academia.persistencia.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Exercicio;
import br.com.academia.entidades.Treino;
import br.com.academia.entidades.util.DiasDaSemana;
import br.com.academia.persistencia.DaoExercicio;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoExercicio")
public class DaoExercicioImpl extends DaoGenerico<Exercicio> implements DaoExercicio {

	public List<Exercicio> listarExerciciosPorTreino(Treino treino) {
		return listarPorQuery(getClazz(), "SELECT e FROM Exercicio e WHERE e.treino = ?", treino);
	}

	
	@SuppressWarnings("unchecked")
	public List<Exercicio> listarExerciciosEspecificos(Treino treino, Set<DiasDaSemana> diasDaSemana) {
		Query q = getSession().createQuery("SELECT e FROM Exercicio e JOIN e.dia d WHERE d IN (:diasDaSemana) AND e.treino = :treino");
		q.setParameterList("diasDaSemana", diasDaSemana);
		q.setParameter("treino", treino);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Exercicio> listarExerciciosEspecificos(Treino treino, DiasDaSemana diaDaSemana) {
		Query q = getSession().createQuery("SELECT e FROM Exercicio e WHERE e.treino = :treino AND e.dia = :diaDaSemana");
		q.setParameter("treino", treino);
		q.setParameter("diaDaSemana", diaDaSemana);
		return q.list();
	}

	@Override
	protected Class<Exercicio> getClazz() {
		return Exercicio.class;
	}



}
