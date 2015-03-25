package br.com.academia.servico;

import java.util.List;
import java.util.Set;

import br.com.academia.entidades.Usuario;
import br.com.academia.entidades.util.Permissoes;

public interface ServicoUsuario extends ServicoInterface<Usuario> {
	
	Usuario buscarUsuarioPorLoginESenha(String login, String senha);
	Usuario buscarUsuarioPorLogin(String login);
	List<Usuario> listarUsuarioPorPermissoes(Set<Permissoes> permissoes);
	

}
