package br.com.academia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

import br.com.academia.entidades.util.Permissoes;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Length(min=8, max=32) @Basic(optional=false) @Column(nullable=false, unique=true, length=32) 
	private String login;
	
	@Length(min=8, max=32) @Basic(optional=false) @Column(nullable=false, length=32) 
	private String senha;
	
	@NotNull @Basic(optional=false) @Column(nullable=false)
	private boolean ativo = false;
	
	@Size(min=1, max=3)
	@Basic(optional=false)
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass=Permissoes.class, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@CollectionTable(name="usuario_permissoes",  joinColumns=@JoinColumn(name="id_usuario", nullable=false))
	private List<Permissoes> permissoes = new ArrayList<Permissoes>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Permissoes> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Permissoes> permissoes) {
		this.permissoes = permissoes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return login;
	}

}
