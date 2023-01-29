package com.br.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.br.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=3, max=120, message="O tamanho deve ser entre 3 e 120 caracteres")
	private String nome;
	private String nascimento;
	
	public PessoaDTO() {
	}
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.nascimento = pessoa.getNascimento();
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


	public String getNascimento() {
		return nascimento;
	}


	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

}
