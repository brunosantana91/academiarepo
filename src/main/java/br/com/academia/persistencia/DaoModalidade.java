package br.com.academia.persistencia;

import java.util.List;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;

public interface DaoModalidade extends DaoInterface<Modalidade> {
	
	Modalidade buscarModalidadePorNome(String nome);
	List<Modalidade> listarModalidadesPorPerfil(Perfil perfil);
	Modalidade buscarPorIdEager(Integer id);
	List<Modalidade> listarEager();
	}
