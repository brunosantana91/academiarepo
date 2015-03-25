package br.com.academia.persistencia;

import java.util.List;

import br.com.academia.entidades.Usuario;
import br.com.academia.entidades.util.Permissoes;

public interface DaoUsuario extends DaoInterface<Usuario>{
	
	Usuario buscarUsuarioPorLoginESenha(String login, String senha);
	Usuario buscarUsuarioPorLogin(String login);
	List<Usuario> listarUsuarioPorPermissoes(List<Permissoes> permissoes);
}
