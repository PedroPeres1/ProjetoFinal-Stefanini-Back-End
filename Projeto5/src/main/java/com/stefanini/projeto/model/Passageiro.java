package com.stefanini.projeto.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Passageiro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_PA_NU", sequenceName = "SQ_PA_NU", allocationSize=(4))
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PA_NU")
	@Column(name = "PA_NU")
	private Long id;

	@Column(name = "PA_NOME")
	private String nome;

	@Column(name = "PA_IDADE")
	private Integer idade;

	@ManyToOne
	@com.fasterxml.jackson.annotation.JsonIgnore
	@JoinColumn(name = "ON_NU", referencedColumnName = "ON_NU")
	private Onibus onibus;

	public Passageiro() {
		super();
	}

	public Passageiro(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
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
		Passageiro other = (Passageiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}