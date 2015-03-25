package br.com.academia.persistencia;

import java.util.List;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Treino;

public interface DaoTreino extends DaoInterface<Treino> {
	
	List<Treino> listarTreinosPorPerfil(Perfil perfil);
	List<Treino> listarTreinosPorModalidade(Modalidade modalidade);
	List<Treino> listarTreinosEspecifico(Modalidade modalidade, Perfil perfil);
	
}
