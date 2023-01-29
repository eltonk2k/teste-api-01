package com.br.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.br.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=3, max=120, message="O tamanho deve ser entre 3 e 120 caracteres")
	private String nomeCidade;
	
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nomeCidade = obj.getNomeCidade();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeCidade() {
		return nomeCidade;
	}


	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}


}
