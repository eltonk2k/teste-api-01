package com.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.domain.Pessoa;
import com.br.dto.PessoaDTO;
import com.br.exceptions.DataIntegrityException;
import com.br.exceptions.ObjectNotFoundException;
import com.br.repository.EnderecoRepository;
import com.br.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	
	
	
	public Pessoa find(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	@Transactional
	public Pessoa insert(Pessoa pessoa) {
		pessoa.setId(null);
		pessoa = pessoaRepository.save(pessoa);
		enderecoRepository.saveAll(pessoa.getEnderecos());
		return pessoa;
	}

	public Pessoa update(Pessoa pessoa) {
		Pessoa newPessoa = find(pessoa.getId());
		updateData(newPessoa, pessoa);
		return pessoaRepository.save(newPessoa);
	}

	public void delete(Long id) {
		find(id);
		try {
			pessoaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa fromDTO(PessoaDTO pessoaDto) {
		return new Pessoa(pessoaDto.getId(), pessoaDto.getNome(), pessoaDto.getNascimento());
	}

	private void updateData(Pessoa newPessoa, Pessoa pessoa) {
		newPessoa.setNome(pessoa.getNome());
	}
}
