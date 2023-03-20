package com.example.Huiswerkles10backend.services;

import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
import com.example.Huiswerkles10backend.dtos.output.CIModuleDto;
import com.example.Huiswerkles10backend.model.CIModule;
import com.example.Huiswerkles10backend.repository.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {

    private final CIModuleRepository cimrepos;

    public CIModuleService(CIModuleRepository cimrepos) {
        this.cimrepos = cimrepos;
    }

    public List<CIModuleDto> getAllCIModules() {
        Iterable<CIModule> ciModules = cimrepos.findAll();
        List<CIModuleDto> dtos = new ArrayList<>();
        for (CIModule ci : ciModules) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public CIModuleDto getOneCIModuleById(long id) {
        Optional<CIModule> ciModule = cimrepos.findById(id);
        if(ciModule.isPresent()) {
            CIModuleDto ci = transferToDto(ciModule.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No ci-module found");
        }
    }

    public CIModuleDto createCIModule(CIModuleDto ciModuleDto) {
        cimrepos.save(transferToCIModule(ciModuleDto));
        return ciModuleDto;
    }

    public void deleteCIModule(Long id) {
        cimrepos.deleteById(id);
    }

    public void  updateCIModule(Long id, CIModuleDto ciModuleDto) {
        if(!cimrepos.existsById(id)) {
            throw new RecordNotFoundException("No ci-module found");
        }
        CIModule storedCIModule = cimrepos.findById(id).orElse(null);
        storedCIModule.setId(ciModuleDto.getId());
        storedCIModule.setType(ciModuleDto.getType());
        storedCIModule.setName(ciModuleDto.getName());
        storedCIModule.setPrice(ciModuleDto.getPrice());
        cimrepos.save(storedCIModule);
        }



    public CIModule transferToCIModule(CIModuleDto dto){
        CIModule ciModule = new CIModule();
        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    public CIModuleDto transferToDto(CIModule ciModule){
        CIModuleDto dto = new CIModuleDto();
        dto.id = ciModule.getId();
        dto.name = ciModule.getName();
        dto.type = ciModule.getType();
        dto.price = ciModule.getPrice();
        return dto;
    }



}

