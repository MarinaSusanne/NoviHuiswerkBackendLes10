package com.example.Huiswerkles10backend.Controllers;

import com.example.Huiswerkles10backend.Exceptions.TelevisionNameTooLongException;
import com.example.Huiswerkles10backend.dtos.input.IdInputDto;
import com.example.Huiswerkles10backend.dtos.input.TelevisionInputDto;
import com.example.Huiswerkles10backend.dtos.output.TelevisionDto;
import com.example.Huiswerkles10backend.model.Television;
import com.example.Huiswerkles10backend.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/televisions")
public class TelevisionController {

    //constructor injection (is private final!!)
    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping()
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisionOutput = televisionService.getAllTelevisions();
        return ResponseEntity.ok(televisionOutput);
    }

    //Optional hoeft niet gevuld te zijn - kan leeg zijn
    @GetMapping("/find/{id}")
    public ResponseEntity<TelevisionDto> getOneTelevisionById(@PathVariable Long id) {
        TelevisionDto tvOutputDto = televisionService.getOneTelevisionById(id);
        return ResponseEntity.ok(tvOutputDto);
    }


    @PostMapping()
    public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionDto = televisionService.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisionDto.getId()).toUriString());
        return ResponseEntity.created(uri).body(televisionDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto newtelevision) {
        TelevisionDto televisionDto = televisionService.updateTelevision(id, newtelevision);
        return ResponseEntity.ok().body(televisionDto);
    }


    @PutMapping("/{id}/remotecontroller")
    public void assignRemoteControllerToTelevision(@PathVariable ("id") Long id, @Valid @RequestBody IdInputDto input) {
        televisionService.assignRemoteControllerToTelevision(id, input.id);
    }

    @PutMapping("/{id}/cimodule")
    public void assignCIModuleToTelevision(@PathVariable ("id") Long id, @Valid @RequestBody IdInputDto input) {
        televisionService.assignCIModuleToTelevision(id, input.id);
    }

//andere manier om het te doen:
// @PutMapping("/televisions/{id}/{ciModuleId}")
//public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
//    televisionService.assignCIModuleToTelevision(id, ciModuleId);
//}




    }