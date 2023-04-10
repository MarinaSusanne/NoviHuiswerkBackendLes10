package com.example.Huiswerkles10backend.services;

import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
import com.example.Huiswerkles10backend.dtos.output.WallBracketDto;
import com.example.Huiswerkles10backend.model.WallBracket;
import com.example.Huiswerkles10backend.repository.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wbrepos;


    public WallBracketService(WallBracketRepository wbrepos) {
        this.wbrepos = wbrepos;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        Iterable<WallBracket> wallBracketList = wbrepos.findAll();
        List<WallBracketDto> dtos = new ArrayList<>();
        for (WallBracket wb : wallBracketList) {
            dtos.add(transferToDto(wb));
        }
        return dtos;
    }

    public WallBracketDto getOneWallBracketById(long id) {
        Optional<WallBracket> wallBracket = wbrepos.findById(id);
        if(wallBracket.isPresent()) {
            WallBracketDto dto = transferToDto(wallBracket.get());
            return dto;
        } else {
            throw new RecordNotFoundException("No wallbracket found");
        }
    }

    public WallBracketDto createWallBracket(WallBracketDto wallBracketDto) {
        WallBracket wallBracket = transferToWallBracket(wallBracketDto);
        wbrepos.save(wallBracket);
        return transferToDto(wallBracket);
    }

    public void deleteWallBracket(@RequestBody Long id) {
        wbrepos.deleteById(id);
    }

    public void updateWallBracket(Long id, WallBracketDto wallBracketDto) {
        if(!wbrepos.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found");
        }
        WallBracket storedWallBracket = wbrepos.findById(id).orElse(null);
        storedWallBracket.setId(wallBracketDto.getId());
        storedWallBracket.setSize(wallBracketDto.getSize());
        storedWallBracket.setAdjustable(wallBracketDto.getAdjustable());
        storedWallBracket.setName(wallBracketDto.getName());
        storedWallBracket.setPrice(wallBracketDto.getPrice());
        wbrepos.save(storedWallBracket);
    }



    public WallBracketDto transferToDto(WallBracket wallBracket){
        var dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }

    public WallBracket transferToWallBracket(WallBracketDto wallBracketDto){
        var wallBracket = new WallBracket();
        wallBracket.setId(wallBracketDto.getId());
        wallBracket.setName(wallBracketDto.getName());
        wallBracket.setSize(wallBracketDto.getSize());
        wallBracket.setAdjustable(wallBracketDto.getAdjustable());
        wallBracket.setPrice(wallBracketDto.getPrice());

        return wallBracket;
    }


}
