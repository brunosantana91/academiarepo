package br.com.academia.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne @JoinColumn(name="perfil_id", foreignKey = @ForeignKey(name="fk_perfil_pagamento"))
	private Perfil perfil;
	
	@OneToOne @JoinColumn(name="modalidade_id", foreignKey = @ForeignKey(name="fk_modalidade_pagamento"))
	private Modalidade modalidade;
	
	@NotNull @Basic(optional=false) @Column(nullable=false)
	private double valor;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataVencimento;
	
	@NotNull @Basic(optional=false) @Column(nullable=false)
	private boolean pago = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pagamento [perfil=" + perfil + ", modalidade=" + modalidade
				+ ", valor=" + valor + "]";
	}
	
	
}
