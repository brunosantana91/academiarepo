package br.com.academia.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import br.com.academia.entidades.util.DiasDaSemana;

@Entity @Table(name="opcaomatricula")
public class OpcaoMatricula implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="modalidade_id")
	private Modalidade modalidade;
	
	private Double preco;
	
	@Size(max=7)
	@Basic(optional=true)
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass=DiasDaSemana.class, fetch=FetchType.EAGER)
	@CollectionTable(name="opcao_dias",  joinColumns=@JoinColumn(name="opcao_id", nullable=false))
	private List<DiasDaSemana> diasSemana;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<DiasDaSemana> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<DiasDaSemana> diasSemana) {
		this.diasSemana = diasSemana;
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
		OpcaoMatricula other = (OpcaoMatricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return preco+ " " + diasSemana;
	}

	

	
}
