package br.com.academia.servico.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.academia.entidades.Usuario;
import br.com.academia.entidades.util.Permissoes;
import br.com.academia.exceptions.ParametroEmUsoException;
import br.com.academia.persistencia.DaoUsuario;
import br.com.academia.seguranca.ConversorMd5;
import br.com.academia.servico.ServicoUsuario;

@Transactional(propagation=Propagation.SUPPORTS)
@Service("servicoUsuario")
public class ServicoUsuarioImpl implements ServicoUsuario{
	
	@Autowired
	private DaoUsuario dao;
	
	public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
		ConversorMd5 conversor = new ConversorMd5(senha);
		return dao.buscarUsuarioPorLoginESenha(login, conversor.getSenhaMd5());
	}

	public Usuario buscarUsuarioPorLogin(String login) {
		return null;
	}
	
	public List<Usuario> listarUsuarioPorPermissoes(Set<Permissoes> permissoes) {
		return null;
	}

	
	public Usuario buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}

	
	public List<Usuario> listar() {
		return null;
	}

	public void adicionar(Usuario usuario) throws ParametroEmUsoException{
		if(dao.buscarUsuarioPorLogin(usuario.getLogin()) == null){
		criptografaSenha(usuario);
		dao.adicionar(usuario);
		}else{
			throw new ParametroEmUsoException("usurio j existe no banco de dados");
		}
	}
	
	public void editar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	
	public void remover(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	private void criptografaSenha(Usuario usuario) {
		ConversorMd5 conversorMd5 = new ConversorMd5(usuario.getSenha());
		usuario.setSenha(conversorMd5.getSenhaMd5());
	}

	public Usuario atualizar(Usuario usuario) {
		return dao.atualizar(usuario);
	}
	
}
