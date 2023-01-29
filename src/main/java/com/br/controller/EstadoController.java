package com.br.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.domain.Cidade;
import com.br.domain.Estado;
import com.br.dto.CidadeDTO;
import com.br.dto.EstadoDTO;
import com.br.services.CidadeService;
import com.br.services.EstadoService;

import io.swagger.annotations.Api;


@Api(tags = "Estados Endpoint")
@RestController
@RequestMapping(path = "/estados")
public class EstadoController {

	private EstadoService estadoService;
	
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> listEstados = estadoService.findAll();
		List<EstadoDTO> listEstadosDto = listEstados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listEstadosDto);
	}
	
	
	@GetMapping(path="/{estadoId}/cidades")
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Long estadoId) {
		List<Cidade> listCidades = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listCidadesDto = listCidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listCidadesDto);
	}
}
