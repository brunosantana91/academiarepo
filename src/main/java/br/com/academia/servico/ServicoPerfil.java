package br.com.academia.servico;

import java.util.List;
import java.util.Set;

import br.com.academia.entidades.Modalidade;
import br.com.academia.entidades.Perfil;
import br.com.academia.entidades.Usuario;

public interface ServicoPerfil extends ServicoInterface<Perfil> {
	
	Perfil buscarPerfilPorUsuario(Usuario usuario);
	Perfil buscarPerfilPorEmail(String email);
	Perfil buscarPerfilPorCpf(String cpf);
	Perfil buscarPerfilPorRg(String rg);
	List<Perfil> listarPerfisPorModalidade(Set<Modalidade> modalidades);
	List<Perfil> listarPerfisPorSobrenome(String sobreNome);

}
