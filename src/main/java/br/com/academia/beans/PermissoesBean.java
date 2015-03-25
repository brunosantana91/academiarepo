package br.com.academia.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.academia.entidades.util.Permissoes;

@Named
@Scope(value="session")
public class PermissoesBean {
	
	@Autowired
	private LoginBean loginBean;
	
	@PostConstruct
	private void init(){
		
	}
	
	public boolean isAdmin(List<Permissoes> permissoes){
		permissoes = loginBean.getUsuarioLogado().getPermissoes();
		if(permissoes.contains(Permissoes.ADMIN)){return true;}
		else{return false;}
		
	}
	public boolean isInstructor(List<Permissoes> permissoes){
		permissoes = loginBean.getUsuarioLogado().getPermissoes();
		if(permissoes.contains(Permissoes.INSTRUTOR)){return true;}
		else{return false;}
		
	}
	public boolean isAluno(List<Permissoes> permissoes){
		permissoes = loginBean.getUsuarioLogado().getPermissoes();
		if(permissoes.contains(Permissoes.ALUNO)){return true;}
		else{return false;}
		
	}
	

}
