package br.com.academia.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.persistencia.DaoModalidade;
import br.com.academia.servico.ServicoModalidade;

@Transactional(propagation=Propagation.SUPPORTS)
@Service("servicoModalidade")
public class ServicoModalidadeImpl implements ServicoModalidade {
	
	@Autowired
	private DaoModalidade dao;

	public Modalidade buscarModalidadePorNome(String nome) {
		return dao.buscarModalidadePorNome(nome);
	}

	public List<Modalidade> listarModalidadesPorPerfil(Perfil perfil) {
		return dao.listarModalidadesPorPerfil(perfil);
	}
	
	public Modalidade buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}
	
	public Modalidade buscarPorIdEager(Integer id) {
		return dao.buscarPorIdEager(id);
	}
	
	public List<Modalidade> listar() {
		return dao.listar();
	}
	
	public List<Modalidade> listarEager() {
		return dao.listarEager();
	}

	public void adicionar(Modalidade modalidade) {
		dao.adicionar(modalidade);
	}

	public void editar(Modalidade modalidade) {
		dao.editar(modalidade);
	}

	public void remover(Modalidade modalidade) {
		dao.remover(modalidade);
	}

	public Modalidade atualizar(Modalidade modalidade) {
		return dao.atualizar(modalidade);
	}



	





}
