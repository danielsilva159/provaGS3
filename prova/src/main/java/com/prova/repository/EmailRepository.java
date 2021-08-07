package com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prova.entidades.Email;

@Repository
@Transactional
public interface EmailRepository extends JpaRepository<Email, Long>{

}
