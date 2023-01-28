package com.br.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.domain.Estado;
import com.br.repository.EstadoRepository;

@Service
public class EstadoService {
	
	private EstadoRepository estadoRepository;
	
	
	public List<Estado> findAll() {
		return estadoRepository.findAllByOrderByNomeEstado();
	}

}
