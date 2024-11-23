package com.fiap.gsmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gsmicroservice.dtos.EletronicoRequestCreateDto;
import com.fiap.gsmicroservice.dtos.EletronicoRequestUptadeDto;
import com.fiap.gsmicroservice.dtos.EletronicoResponseDto;
import com.fiap.gsmicroservice.mapper.EletronicoMapper;
import com.fiap.gsmicroservice.repository.EletronicoRepository;
import com.fiap.gsmicroservice.service.EletronicoService;

@RestController
@RequestMapping("/eletronicos")
public class EletronicoController {

    @Autowired
    private EletronicoMapper eletronicoMapper;
    
    @Autowired
    private EletronicoService eletronicoService;

    @Autowired
    private EletronicoRepository eletronicoRepository;


    @GetMapping
    public ResponseEntity<List<EletronicoResponseDto>> list() {
        List<EletronicoResponseDto> dtos = eletronicoService.list().stream().map(e -> eletronicoMapper.toDto(e)).toList();

        return ResponseEntity.ok().body(dtos);
    }


    @GetMapping("{id}")
    public ResponseEntity<EletronicoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(eletronicoService.findById(id).map(e -> eletronicoMapper.toDto(e)).orElseThrow(() -> new RuntimeException("Id inexistente")));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findByNome(@RequestParam String nome){
        return ResponseEntity.ok().body(eletronicoRepository.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<EletronicoResponseDto> create(@RequestBody EletronicoRequestCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eletronicoMapper.toDto(eletronicoService.save(eletronicoMapper.toModel(dto))));
    }

    @PutMapping("{id}")
    public ResponseEntity<EletronicoResponseDto> uptade(@PathVariable Long id, @RequestBody EletronicoRequestUptadeDto dto) {
        if (! eletronicoService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok().body(eletronicoMapper.toDto(eletronicoService.save(eletronicoMapper.toModel(id, dto))));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! eletronicoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        eletronicoService.delete(id);
    }

}
