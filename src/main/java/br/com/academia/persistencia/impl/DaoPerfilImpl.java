package br.com.academia.persistencia.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Usuario;
import br.com.academia.persistencia.DaoPerfil;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoPerfil")
public class DaoPerfilImpl extends DaoGenerico<Perfil> implements DaoPerfil {

	public Perfil buscarPerfilPorUsuario(Usuario usuario) {
		return buscarPorQuery(getClazz(), "SELECT p FROM Perfil p WHERE p.usuario = ?", usuario);
	}

	public Perfil buscarPerfilPorEmail(String email) {
		return buscarPorQuery(getClazz(), "SELECT p FROM Perfil p WHERE p.email = ?", email);
	}
	
	public Perfil buscarPerfilPorCpf(String cpf){
		return buscarPorQuery(getClazz(), "SELECT p FROM Perfil p WHERE p.cpf = ?", cpf);
	}
	
	public Perfil buscarPerfilPorRg(String rg){
		return buscarPorQuery(getClazz(), "SELECT p FROM Perfil p WHERE p.rg = ?", rg);
	}
	
	@SuppressWarnings("unchecked")
	public List<Perfil> listarPerfisPorModalidade(Set<Modalidade> modalidades) {
		Query q = getSession().createQuery("SELECT p FROM Perfil p JOIN p.modalidadesMatriculado m WHERE m IN (:modalidadesMatriculado)");
		q.setParameterList("modalidadesMatriculado", modalidades);
		return q.list();
	}

	public List<Perfil> listarPerfisPorSobrenome(String sobreNome) {
		return listarPorQuery(getClazz(), "SELECT p FROM Perfil p WHERE p.sobreNome = ?", sobreNome);
	}
	
	

	@Override
	protected Class<Perfil> getClazz() {
		return Perfil.class;
	}

}
