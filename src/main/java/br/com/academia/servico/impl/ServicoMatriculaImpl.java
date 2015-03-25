package br.com.academia.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.beans.util.validators.MatriculaValidator;
import br.com.academia.entidades.Matricula;
import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.persistencia.DaoMatricula;
import br.com.academia.servico.ServicoMatricula;

@Transactional(propagation=Propagation.SUPPORTS)
@Service("servicoMatricula")
public class ServicoMatriculaImpl implements ServicoMatricula{

	@Autowired
	private DaoMatricula dao;
	
	@Autowired
	private MatriculaValidator matriculaValidator;
	
	public List<Matricula> listarMatriculasPorModalidade(Modalidade modalidade) {
		return dao.listarMatriculasPorModalidade(modalidade);
	}

	public List<Matricula> listarMatriculasPorPerfil(Perfil perfil) {
		return dao.listarMatriculasPorPerfil(perfil);
	}

	public Matricula buscarMatriculaPorPerfilEModalidade(Perfil perfil, Modalidade modalidade) {
		return dao.buscarMatriculaPorPerfilEModalidade(perfil, modalidade);
	}

	public Matricula buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}
	
	public List<Matricula> listar() {
		return dao.listar();
	}
	
	public void adicionar(Matricula matricula) throws ParametroEmUsoException {
		matriculaValidator.valida(matricula);
		dao.adicionar(matricula);
	}
	
	public void editar(Matricula matricula) {
		dao.editar(matricula);
	}
	
	public void remover(Matricula matricula) {
		dao.remover(matricula);
	}
	
	public Matricula atualizar(Matricula matricula){
		return dao.atualizar(matricula);
	}
}
