package br.com.academia.persistencia.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Usuario;
import br.com.academia.entidades.util.Permissoes;
import br.com.academia.persistencia.DaoUsuario;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoUsuario")
public class DaoUsuarioImpl extends DaoGenerico<Usuario> implements DaoUsuario {
	
	@SuppressWarnings("unchecked")
	public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
		return buscarPorQuery(getClazz(), "SELECT u FROM Usuario u WHERE u.login = ? AND u.senha = ?", login, senha);
	}

	@SuppressWarnings("unchecked")
	public Usuario buscarUsuarioPorLogin(String login) {
		return buscarPorQuery(getClazz(), "SELECT u FROM Usuario u WHERE u.login = ?", login);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarioPorPermissoes(List<Permissoes> permissoes) {
		Query q = getSession().createQuery("SELECT u FROM Usuario u JOIN u.permissoes p WHERE p IN (:permissoes)");
		q.setParameterList("permissoes", permissoes);
		return q.list();
	}

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return Usuario.class;
	}

}
