package br.com.academia.servico;

import java.util.List;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;

public interface ServicoModalidade extends ServicoInterface<Modalidade> {
	
	Modalidade buscarModalidadePorNome(String nome);
	List<Modalidade> listarModalidadesPorPerfil(Perfil perfil);
	Modalidade buscarPorIdEager(Integer id);
	List<Modalidade> listarEager();
}
