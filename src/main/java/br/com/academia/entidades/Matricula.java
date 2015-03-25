package br.com.academia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="modalidade_id")
	private Modalidade modalidade;


	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;


	@ManyToOne
	@JoinColumn(name="opcao_id")
	private OpcaoMatricula opcaoMatricula;

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

	public OpcaoMatricula getOpcaoMatricula() {
		return opcaoMatricula;
	}

	public void setOpcaoMatricula(OpcaoMatricula opcaoMatricula) {
		this.opcaoMatricula = opcaoMatricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modalidade == null) ? 0 : modalidade.hashCode());
		result = prime * result
				+ ((opcaoMatricula == null) ? 0 : opcaoMatricula.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		Matricula other = (Matricula) obj;
		if (modalidade == null) {
			if (other.modalidade != null)
				return false;
		} else if (!modalidade.equals(other.modalidade))
			return false;
		if (opcaoMatricula == null) {
			if (other.opcaoMatricula != null)
				return false;
		} else if (!opcaoMatricula.equals(other.opcaoMatricula))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		return true;
	}



}
