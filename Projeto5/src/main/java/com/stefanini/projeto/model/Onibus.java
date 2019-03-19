package com.stefanini.projeto.model;

import java.io.Serializable;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.stefanini.projeto.enums.SituacaoEnum;

@Entity
public class Onibus implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_ON_NU", sequenceName = "SQ_ON_NU", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ON_NU")
	@Column(name = "ON_NU")
	private Long id;

	@Column(name = "ON_NO",length=20)
	private String nome;

	@Column(name = "ON_SIT")
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;

	@OneToMany(mappedBy = "onibus")
	private List<Passageiro> passageiro;

	public Onibus() {
		super();
	}

	public Onibus(Long id, String nome, SituacaoEnum situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	
	public List<Passageiro> getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(List<Passageiro> passageiro) {
		this.passageiro = passageiro;
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
		Onibus other = (Onibus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}