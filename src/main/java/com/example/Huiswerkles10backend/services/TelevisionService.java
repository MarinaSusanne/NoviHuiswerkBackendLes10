package com.example.Huiswerkles10backend.services;

import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
import com.example.Huiswerkles10backend.dtos.input.TelevisionInputDto;
import com.example.Huiswerkles10backend.dtos.output.TelevisionDto;
import com.example.Huiswerkles10backend.model.Television;
import com.example.Huiswerkles10backend.repository.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    //constructor injection
    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }


    //aanpassen naar getTelevison methode. CRUD repository geeft een iterable

    public List<TelevisionDto> getAllTelevisions() {
        Iterable<Television> televisions = repos.findAll();
        List<TelevisionDto> televisionsOutputDtos = new ArrayList<>();
        for (Television t : televisions) {
            TelevisionDto tdto = new TelevisionDto();
            tdto.setId(t.getId());
            tdto.setBrand(t.getBrand());
            tdto.setName(t.getName());
            tdto.setType(t.getType());
            tdto.setPrice(t.getPrice());
            tdto.setAvailableSize(t.getAvailableSize());
            tdto.setRefreshRate(t.getRefreshRate());
            tdto.setScreenType(t.getScreenType());
            tdto.setScreenQuality(t.getScreenQuality());
            tdto.setSmartTv(t.getSmartTv());
            tdto.setWifi(t.getWifi());
            tdto.setVoiceControl(t.getVoiceControl());
            tdto.setHdr(t.getHdr());
            tdto.setBluetooth(t.getBluetooth());
            tdto.setAmbiLight(t.getAmbiLight());
            tdto.setOriginalStock(t.getOriginalStock());
            tdto.setSold(t.getSold());
            televisionsOutputDtos.add(tdto);
        }
        return televisionsOutputDtos;
    }

    public TelevisionDto getOneTelevisionById(Long id) {
        Television t = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("television not found"));
        TelevisionDto tdto = new TelevisionDto();
        tdto.setId(t.getId());
        tdto.setBrand(t.getBrand());
        tdto.setName(t.getName());
        tdto.setType(t.getType());
        tdto.setPrice(t.getPrice());
        tdto.setAvailableSize(t.getAvailableSize());
        tdto.setRefreshRate(t.getRefreshRate());
        tdto.setScreenType(t.getScreenType());
        tdto.setScreenQuality(t.getScreenQuality());
        tdto.setSmartTv(t.getSmartTv());
        tdto.setWifi(t.getWifi());
        tdto.setVoiceControl(t.getVoiceControl());
        tdto.setHdr(t.getHdr());
        tdto.setBluetooth(t.getBluetooth());
        tdto.setAmbiLight(t.getAmbiLight());
        tdto.setOriginalStock(t.getOriginalStock());
        tdto.setSold(t.getSold());
        return tdto;
    }


    public TelevisionDto createTelevision(TelevisionInputDto dto) {
        // omzetten van input naar entity in een methode
        // entity opslaan in repository
        // entity omzettennaar output Dto
        // output dto terug ggooien
        Television tv = transferDtoToEntity(dto);
        repos.save(tv);
        return transferEntityToDto(tv);
    }


    public void deleteTelevision(@RequestBody Long id) {
        repos.deleteById(id);
    }


    public TelevisionDto updateTelevision(Long id, TelevisionInputDto newTelevision) {
        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            Television television1 = televisionOptional.get();
            television1.setBrand(newTelevision.getBrand());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());
            Television returnTelevision = repos.save(television1);
            return transferEntityToDto(returnTelevision);
        }
        else {
          throw new RecordNotFoundException("geen televisie gevonden");
        }
    }



    //methode omzetting van entity Television naar OutputDto
    public TelevisionDto transferEntityToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setId(television.getId());
        dto.setBrand(television.getBrand());
        dto.setType(television.getType());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }


    public Television transferDtoToEntity(TelevisionInputDto dto) {
        Television television = new Television();
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        return television;
    }
}
