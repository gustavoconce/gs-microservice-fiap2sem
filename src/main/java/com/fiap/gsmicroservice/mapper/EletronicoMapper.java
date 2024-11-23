package com.fiap.gsmicroservice.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.gsmicroservice.dtos.EletronicoRequestCreateDto;
import com.fiap.gsmicroservice.dtos.EletronicoRequestUptadeDto;
import com.fiap.gsmicroservice.dtos.EletronicoResponseDto;
import com.fiap.gsmicroservice.model.Eletronicos;

@Component
public class EletronicoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EletronicoResponseDto toDto(Eletronicos eletronico) {
        return modelMapper.map(eletronico, EletronicoResponseDto.class);
    }

    public Eletronicos toModel(EletronicoRequestCreateDto dto) {
        return modelMapper.map(dto, Eletronicos.class);
    }

    public Eletronicos toModel(Long id, EletronicoRequestUptadeDto dto){
        Eletronicos eletronico = modelMapper.map(dto, Eletronicos.class);
        eletronico.setId(id);
        return eletronico;
    }

}
