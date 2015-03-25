package br.com.academia.servico.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Exercicio;
import br.com.academia.entidades.Treino;
import br.com.academia.entidades.util.DiasDaSemana;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.persistencia.DaoExercicio;
import br.com.academia.servico.ServicoExercicio;

@Transactional(propagation=Propagation.SUPPORTS)
@Service("servicoExercicio")
public class ServicoExercicioImpl implements ServicoExercicio {
	
	@Autowired
	private DaoExercicio dao;
	
	public List<Exercicio> listarExerciciosPorTreino(Treino treino) {
		return dao.listarExerciciosPorTreino(treino);
	}

	public List<Exercicio> listarExerciciosEspecificos(Treino treino, Set<DiasDaSemana> diasDaSemana) {
		return dao.listarExerciciosEspecificos(treino, diasDaSemana);
	}

	public List<Exercicio> listarExerciciosEspecificos(Treino treino, DiasDaSemana diaDaSemana) {
		return dao.listarExerciciosEspecificos(treino, diaDaSemana);
	}

	public Exercicio buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}

	public List<Exercicio> listar() {
		return dao.listar();
	}

	public void adicionar(Exercicio exercicio) throws ParametroEmUsoException {
		dao.adicionar(exercicio);
	}

	public void editar(Exercicio exercicio) {
		dao.editar(exercicio);
	}

	public void remover(Exercicio exercicio) {
		dao.remover(exercicio);		
	}

	public Exercicio atualizar(Exercicio exercicio) {	
		return dao.atualizar(exercicio);
	}

}
