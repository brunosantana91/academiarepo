package br.com.academia.persistencia;

import java.util.List;
import java.util.Set;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Usuario;

public interface DaoPerfil extends DaoInterface<Perfil> {
	
	Perfil buscarPerfilPorUsuario(Usuario usuario);
	Perfil buscarPerfilPorEmail(String email);
	Perfil buscarPerfilPorCpf(String cpf);
	Perfil buscarPerfilPorRg(String rg);
	List<Perfil> listarPerfisPorModalidade(Set<Modalidade> modalidades);
	List<Perfil> listarPerfisPorSobrenome(String sobreNome);
}
