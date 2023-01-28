package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
