package com.example.Huiswerkles10backend.services;

import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
import com.example.Huiswerkles10backend.dtos.input.RemoteControllerInputDto;
import com.example.Huiswerkles10backend.dtos.output.RemoteControllerDto;
import com.example.Huiswerkles10backend.model.RemoteController;
import com.example.Huiswerkles10backend.repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository rcrepos;

    public RemoteControllerService(RemoteControllerRepository rcrepos) {
        this.rcrepos = rcrepos;
    }

    public List<RemoteControllerDto> getAllRemoteControllers() {
        List<RemoteControllerDto> dtos = new ArrayList<>();
        List<RemoteController> remoteControllers = rcrepos.findAll();
        for (RemoteController rc : remoteControllers) {
            dtos.add(transferToDto(rc));
        }
        return dtos;
    }

    public RemoteControllerDto getOneRemoteControllerById(long id) {
        Optional<RemoteController> remoteController = rcrepos.findById(id);
        if(remoteController.isPresent()) {
            return transferToDto(remoteController.get());
        } else {
            throw new RecordNotFoundException("No remotecontroller found");
        }
    }

    public RemoteControllerDto createRemoteController(RemoteControllerDto remoteControllerDto) {
        RemoteController rc =  transferToRemoteController(remoteControllerDto);
        rcrepos.save(rc);
        //hieronder een aanpassing gedaan tov van uitwerkingen, daarstond  'return remoteControllerDto;' Wat is juist?
        return transferToDto(rc);
    }

    public void deleteRemoteController(@RequestBody Long id) {
        rcrepos.deleteById(id);
    }

    public void updateRemoteController(Long id, RemoteControllerDto remoteControllerDto) {
        if(!rcrepos.existsById(id)) {
            throw new RecordNotFoundException("No remotecontroller found");
        }
        RemoteController storedRemoteController = rcrepos.findById(id).orElse(null);
        storedRemoteController.setId(remoteControllerDto.getId());
        storedRemoteController.setCompatibleWith(remoteControllerDto.getCompatibleWith());
        storedRemoteController.setBatteryType(remoteControllerDto.getBatteryType());
        storedRemoteController.setName(remoteControllerDto.getName());
        storedRemoteController.setPrice(remoteControllerDto.getPrice());
        storedRemoteController.setBrand(remoteControllerDto.getBrand());
        storedRemoteController.setOriginalStock(remoteControllerDto.getOriginalStock());
        rcrepos.save(storedRemoteController);
    }



    public RemoteControllerDto transferToDto(RemoteController remoteController){
        RemoteControllerDto dto = new RemoteControllerDto();
        dto.id = remoteController.getId();
        dto.compatibleWith = remoteController.getCompatibleWith();
        dto.batteryType = remoteController.getBatteryType();
        dto.name = remoteController.getName();
        dto.brand = remoteController.getBrand();
        dto.price = remoteController.getPrice();
        dto.originalStock = remoteController.getOriginalStock();

        return dto;
    }

    public RemoteController transferToRemoteController(RemoteControllerDto dto){
        RemoteController remoteController = new RemoteController();
        remoteController.setId(dto.getId());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setName(dto.getName());
        remoteController.setBrand(dto.getBrand());
        remoteController.setPrice(dto.getPrice());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }


}
