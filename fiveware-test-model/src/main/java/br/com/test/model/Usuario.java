package br.com.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "USUARIO")
public class Usuario extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME_CURTO", nullable = false)
	@NotEmpty
	private String nomeCurto;

	@Column(name = "NOME_COMPLETO")
	@NotEmpty
	private String nomeCompleto;

	@Column(name = "DT_NASCIMENTO")
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
    @Column(name="SEXO", nullable = false)
	private Sexo sexo;

	@Column(name = "CPF")
	private int cpf;

	@Column(name = "TELEFONE")
	private int telefone;

	@Column(name = "CELULAR")
	private int celular;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SENHA")
	private String senha;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="usuario", optional = false, cascade=CascadeType.ALL)
	private Endereco endereco;
	
	public Usuario() {
	}
	
	public Usuario(String nomeCurto, String nomeCompleto, Date dataNascimento,
			Sexo sexo, int cpf, int telefone, int celular, String email,
			String senha, Endereco endereco) {
		super();
		this.nomeCurto = nomeCurto;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
	}

	public String getNomeCurto() {
		return nomeCurto;
	}

	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
