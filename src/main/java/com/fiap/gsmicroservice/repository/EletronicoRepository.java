package com.fiap.gsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.gsmicroservice.model.Eletronicos;

@Repository
public interface EletronicoRepository extends JpaRepository<Eletronicos, Long> {
    <T> T findByNome(String nome);
}
