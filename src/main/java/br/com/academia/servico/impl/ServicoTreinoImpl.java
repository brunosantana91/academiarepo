package br.com.academia.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Treino;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.persistencia.DaoTreino;
import br.com.academia.servico.ServicoTreino;

@Transactional(propagation=Propagation.SUPPORTS)
@Service("servicoTreino")
public class ServicoTreinoImpl implements ServicoTreino {

	@Autowired
	private DaoTreino dao;
	
	public List<Treino> listarTreinosPorPerfil(Perfil perfil) {
		return dao.listarTreinosPorPerfil(perfil);
	}
	
	public List<Treino> listarTreinosPorModalidade(Modalidade modalidade) {
		return dao.listarTreinosPorModalidade(modalidade);
	}
	
	public List<Treino> listarTreinosEspecifico(Modalidade modalidade, Perfil perfil) {
		return dao.listarTreinosEspecifico(modalidade, perfil);
	}

	public Treino buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}

	public List<Treino> listar() {
		return dao.listar();
	}

	public void adicionar(Treino treino) throws ParametroEmUsoException {
		dao.adicionar(treino);
	}

	public void editar(Treino treino) {
		dao.editar(treino);
	}

	public void remover(Treino treino) {
		dao.remover(treino);
	}

	public Treino atualizar(Treino treino) {
		return dao.atualizar(treino);
	}

}
