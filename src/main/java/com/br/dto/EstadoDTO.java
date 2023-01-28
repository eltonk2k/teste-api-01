package com.br.dto;

import java.io.Serializable;

import com.br.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeEstado;
	

	public EstadoDTO(Estado obj) {
		id = obj.getId();
		nomeEstado = obj.getNomeEstado();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeEstado() {
		return nomeEstado;
	}


	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
}
