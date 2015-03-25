package br.com.academia.persistencia;

import java.util.List;
import java.util.Set;

import br.com.academia.entidades.Exercicio;
import br.com.academia.entidades.Treino;
import br.com.academia.entidades.util.DiasDaSemana;

public interface DaoExercicio extends DaoInterface<Exercicio> {
	
	List<Exercicio> listarExerciciosPorTreino(Treino treino);
	List<Exercicio> listarExerciciosEspecificos(Treino treino, Set<DiasDaSemana> diasDaSemana);
	List<Exercicio> listarExerciciosEspecificos(Treino treino, DiasDaSemana diaDaSemana);
	
}