package br.com.academia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


@Entity
public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Basic(optional=false)
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario_id", unique=true, foreignKey = @ForeignKey(name="fk_usuario_perfil"))
	private Usuario usuario;
	
	@Length(min=2, max=32) @Basic(optional=false) @Column(nullable=false, length=32)
	private String nome;
	
	@Length(min=2, max=32) @Basic(optional=false) @Column(nullable=false, length=32)
	private String sobreNome;
	
	@Length(max=11) @Basic(optional=true) @Column(nullable=true, unique=true, length=11)
	private String cpf;
	
	@Length(max=9) @Basic(optional=true) @Column(nullable=true, unique=true, length=9)
	private String rg;
	
	@Length(max=10) @Basic(optional=true) @Column(nullable=true, length=10)
	private String telefone;
	
	@Length(max=11) @Basic(optional=true) @Column(nullable=true, length=11)
	private String celular;
	
	@Basic(optional=false)
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id", unique=true, foreignKey = @ForeignKey(name="fk_endereco_perfil"))
	private Endereco endereco;

	@Email @Length(max=32) @Basic(optional=true) @Column(nullable=true, unique=true, length=32)
	private String email;
	
	@Basic(optional=true) @Column(nullable=true, unique=true, length=64)
	private String foto;
	
	@NotNull @Basic(optional=false) @Column(nullable=false)
	private double altura;
	
	@NotNull @Basic(optional=false) @Column(nullable=false)
	private double peso;
	
	@OneToMany(mappedBy="perfil")
	private List<Treino> treinos = new ArrayList<Treino>();
	
	@NotNull @Temporal(TemporalType.DATE)
	private Calendar dataNascimento = Calendar.getInstance();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		Perfil other = (Perfil) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return nome +" "+ sobreNome;
	}

}
