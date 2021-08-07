package com.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prova.entidades.Cliente;
import com.prova.entidades.Telefone;


@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
}
