package com.br.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.domain.Pessoa;
import com.br.dto.PessoaDTO;
import com.br.services.PessoaService;

import io.swagger.annotations.Api;

@Api(tags = "Pessoas Endpoint")
@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {
	
	PessoaService pessoaService;
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pessoa> find(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.find(id);
		return ResponseEntity.ok().body(pessoa);
	}

	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PessoaDTO pessoaDto) {
		Pessoa obj = pessoaService.fromDTO(pessoaDto);
		obj = pessoaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody PessoaDTO pessoaDto, @PathVariable Long id) {
		Pessoa obj = pessoaService.fromDTO(pessoaDto);
		obj.setId(id);
		obj = pessoaService.update(obj);
		return ResponseEntity.noContent().build();
	}

	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();		
	}
}
