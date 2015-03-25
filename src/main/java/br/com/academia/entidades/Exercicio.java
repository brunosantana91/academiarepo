package br.com.academia.entidades;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import br.com.academia.entidades.util.DiasDaSemana;

@Entity
public class Exercicio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Length(min=2, max=32) @Basic(optional=false) @Column(nullable=false, length=32)
	private String nome;
	
	@Length(min=2, max=64) @Basic(optional=false) @Column(nullable=false, length=64)
	private String descricao;
	
	@ManyToOne @JoinColumn(name="treino_id", foreignKey = @ForeignKey(name="fk_treino_exercicio"))
	private Treino treino;
	
	@Enumerated(EnumType.STRING)
	private DiasDaSemana dia;
	
/*	@Size(max=7)
	@Basic(optional=true)
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass=DiasDaSemana.class, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@CollectionTable(name="exercicio_dias",  joinColumns=@JoinColumn(name="exercicio_id", nullable=false))
	private Set<DiasDaSemana> diasSemana = new LinkedHashSet<DiasDaSemana>();*/
	
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Treino getTreino() {
		return treino;
	}
	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	public DiasDaSemana getDia() {
		return dia;
	}
	public void setDia(DiasDaSemana dia) {
		this.dia = dia;
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
		Exercicio other = (Exercicio) obj;
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
