package br.com.academia.servico.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Usuario;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.persistencia.DaoPerfil;
import br.com.academia.servico.ServicoPerfil;

@Transactional(propagation=Propagation.SUPPORTS)
@Service("servicoPerfil")
public class ServicoPerfilImpl implements ServicoPerfil {

	@Autowired
	private DaoPerfil dao;

	public Perfil buscarPerfilPorUsuario(Usuario usuario) {
		return dao.buscarPerfilPorUsuario(usuario);
	}

	public List<Perfil> listarPerfisPorModalidade(Set<Modalidade> modalidades) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Perfil buscarPerfilPorEmail(String email) {
		return dao.buscarPerfilPorEmail(email);
	}
	
	public Perfil buscarPerfilPorCpf(String cpf){
		return dao.buscarPerfilPorCpf(cpf);
	}
	
	public Perfil buscarPerfilPorRg(String rg){
		return dao.buscarPerfilPorRg(rg);
	}
	
	public List<Perfil> listarPerfisPorSobrenome(String sobreNome) {
		return null;
	}
	
	public Perfil buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}
	
	
	public List<Perfil> listar() {
		return dao.listar();
	}
	

	public void adicionar(Perfil perfil) throws ParametroEmUsoException{
		if(dao.buscarPerfilPorCpf(perfil.getCpf()) == null){
		dao.adicionar(perfil);
		}else{
			throw new ParametroEmUsoException("perfil j existente no banco de dados");
		}
	}
	
	
	public void editar(Perfil perfil) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void remover(Perfil perfil) {
		// TODO Auto-generated method stub
		
	}

	public Perfil atualizar(Perfil perfil) {
		return dao.atualizar(perfil);
	}

	
}
