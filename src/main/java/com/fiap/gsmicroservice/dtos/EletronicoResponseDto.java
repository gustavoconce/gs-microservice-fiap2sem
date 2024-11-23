package com.fiap.gsmicroservice.dtos;

import lombok.Data;

@Data
public class EletronicoResponseDto {

    private int consumo;
    private String modelo;
    private String nome;
    private int quantidade;
    private Long id;
     
}
