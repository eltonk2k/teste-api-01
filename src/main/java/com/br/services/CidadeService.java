package com.br.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.domain.Cidade;
import com.br.repository.CidadeRepository;

@Service
public class CidadeService {
	
	private CidadeRepository cidadeRepository;
	
	
	public List<Cidade> findByEstado(Long estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}
	

}
