package com.fiap.gsmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.gsmicroservice.model.Eletronicos;
import com.fiap.gsmicroservice.repository.EletronicoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EletronicoService {

    private final EletronicoRepository eletronicoRepository;

    public List<Eletronicos> list() {
        return eletronicoRepository.findAll();
    }

    public Optional<Eletronicos> findById(Long id) {
        return eletronicoRepository.findById(id);
    }

    public Optional<Eletronicos> findByNome(String nome) {
        return eletronicoRepository.findByNome(nome);
    }

    public Eletronicos save(Eletronicos eletronico) {
        return eletronicoRepository.save(eletronico);
    }

    public boolean existsById(Long id){
        return eletronicoRepository.existsById(id);
    }

    public void delete (Long id) {
        eletronicoRepository.deleteById(id);
    }

}
