package br.com.academia.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.academia.entidades.util.UF;

@Entity
public class Endereco {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 64)
	@Basic(optional = false)
	@Length(min = 2, max = 64)
	@NotEmpty
	private String logradouro;
	@Column(nullable = false, length = 32)
	@Basic(optional = false)
	@Length(min = 2, max = 32)
	@NotEmpty
	private String bairro;
	@Column(nullable = false, length = 8)
	@Basic(optional = false)
	@Length(min = 8, max = 8)
	@NotEmpty
	private String cep;
	@Column(nullable = false, length = 32)
	@Basic(optional = false)
	@Length(min = 2, max = 32)
	@NotEmpty
	private String cidade;
	@Column(nullable = false, length = 2)
	@Basic(optional = false)
	@Enumerated(EnumType.STRING)
	private UF uf;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco: " + logradouro +  cidade + uf;
	}
}