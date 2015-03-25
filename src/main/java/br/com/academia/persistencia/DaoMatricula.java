package br.com.academia.persistencia;

import java.util.List;

import br.com.academia.entidades.Matricula;
import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;

public interface DaoMatricula extends DaoInterface<Matricula>{
	
	List<Matricula> listarMatriculasPorModalidade(Modalidade modalidade);
	List<Matricula> listarMatriculasPorPerfil(Perfil perfil);
	Matricula buscarMatriculaPorPerfilEModalidade(Perfil perfil, Modalidade modalidade);

}
