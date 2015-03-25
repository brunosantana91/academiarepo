package br.com.academia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

@Entity
public class Modalidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Length(min=4, max=32) @Basic(optional=false) @Column(nullable=false, length=32)
	private String nome;
	
	@OneToMany(mappedBy="modalidade", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<OpcaoMatricula> opcoesMatricula = new ArrayList<OpcaoMatricula>();

	@OneToMany(mappedBy="modalidade", fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Matricula> matriculas = new ArrayList<Matricula>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<OpcaoMatricula> getOpcoesMatricula() {
		return opcoesMatricula;
	}
	public void setOpcoesMatricula(List<OpcaoMatricula> opcoesMatricula) {
		this.opcoesMatricula = opcoesMatricula;
	}
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Modalidade other = (Modalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return nome;
	}


}
