package com.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prova.entidades.Telefone;

@Repository
@Transactional
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	
	@Query("select t from Telefone t where t.cliente.id = ?1")
	public List<Telefone> getTelefones(Long cliente_id);

}
