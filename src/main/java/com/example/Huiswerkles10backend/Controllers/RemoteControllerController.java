package com.example.Huiswerkles10backend.Controllers;


import com.example.Huiswerkles10backend.dtos.input.RemoteControllerInputDto;
import com.example.Huiswerkles10backend.dtos.output.RemoteControllerDto;
import com.example.Huiswerkles10backend.dtos.output.RemoteControllerDto;
import com.example.Huiswerkles10backend.services.RemoteControllerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value="/remotecontroller")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping()
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers() {
        List<RemoteControllerDto> remoteControllerOutput = remoteControllerService.getAllRemoteControllers();
        return ResponseEntity.ok(remoteControllerOutput);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RemoteControllerDto> getOneRemoteControllerById(@PathVariable Long id) {
        RemoteControllerDto remoteControllerOutputDto = remoteControllerService.getOneRemoteControllerById(id);
        return ResponseEntity.ok(remoteControllerOutputDto);
    }


    @PostMapping()
    public ResponseEntity<RemoteControllerDto> createRemoteController(@RequestBody RemoteControllerDto remoteControllerDto) {
        RemoteControllerDto remoteControlDto = remoteControllerService.createRemoteController(remoteControllerDto);
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + RemoteControllerDto.getId()).toUriString());
        return ResponseEntity.ok(remoteControlDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable Long id, @Valid @RequestBody RemoteControllerDto newRemoteController) {
       remoteControllerService.updateRemoteController(id, newRemoteController);
        return ResponseEntity.ok().body(newRemoteController);
    }
}

