package br.com.academia.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.OpcaoMatricula;
import br.com.academia.persistencia.DaoOpcaoMatricula;
import br.com.academia.servico.ServicoOpcaoMatricula;

@Transactional(propagation=Propagation.REQUIRED)
@Service("servicoOpcaoMatricula")
public class ServicoOpcaoMatriculaImpl implements ServicoOpcaoMatricula{
	
	@Autowired
	private DaoOpcaoMatricula dao;

	public OpcaoMatricula buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}

	public List<OpcaoMatricula> listar() {
		return dao.listar();
	}

	public void adicionar(OpcaoMatricula opcaoMatricula) {
			dao.adicionar(opcaoMatricula);
		
	}

	public void editar(OpcaoMatricula opcaoMatricula) {
		  dao.editar(opcaoMatricula);
	}

	public void remover(OpcaoMatricula opcaoMatricula) {
			dao.remover(opcaoMatricula);
		
	}

	public List<OpcaoMatricula> listarOpcoesPorModalidade(Modalidade modalidade) {
		return dao.listarOpcoesPorModalidade(modalidade);
	}

	public OpcaoMatricula atualizar(OpcaoMatricula matricula) {
		return dao.atualizar(matricula);
	}

}
