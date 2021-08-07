package com.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prova.entidades.Endereco;
import com.prova.entidades.Telefone;

@Repository
@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	@Query("select t from Endereco t where t.cliente.id = ?1")
	public List<Endereco> getEnderecos(Long cliente_id);


}
