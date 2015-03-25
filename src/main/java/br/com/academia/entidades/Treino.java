package br.com.academia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;



@Entity
public class Treino implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Length(max=32) @Basic(optional=false) @Column(nullable=false, unique=false, length=32)
	private String nome;
	
	@OneToMany(mappedBy="treino", fetch=FetchType.EAGER, orphanRemoval=true)
	private List<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	@OneToOne @JoinColumn(name="modalidade_id", foreignKey = @ForeignKey(name="fk_modalidade_treino"))
	private Modalidade modalidade;
	
	@ManyToOne @JoinColumn(name="perfil_id", foreignKey = @ForeignKey(name="fk_perfil_treino"))
	private Perfil perfil;
	
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

	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
		Treino other = (Treino) obj;
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

