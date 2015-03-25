package br.com.academia.persistencia.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.persistencia.DaoModalidade;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoModalidade")
public class DaoModalidadeImpl extends DaoGenerico<Modalidade> implements DaoModalidade {
	
	public Modalidade buscarModalidadePorNome(String nome) {
		return buscarPorQuery(getClazz(), "SELECT m FROM Modalidade m WHERE m.nome = ?", nome);
	}

	public List<Modalidade> listarModalidadesPorPerfil(Perfil perfil){
		return listarPorQuery(getClazz(), "SELECT m FROM Modalidade m JOIN FETCH m.matriculas mt WHERE mt.perfil = ?", perfil);
	}

	public Modalidade buscarPorIdEager(Integer id) {
		return buscarPorIdEager(getClazz(), id, "matriculas");
	}
	
	public List<Modalidade> listarEager() {
		return listarEager(getClazz(), "matriculas");
		
	}
	@Override
	protected Class<Modalidade> getClazz() {
		return Modalidade.class;
	}

}
