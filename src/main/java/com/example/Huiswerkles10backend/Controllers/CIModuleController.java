package com.example.Huiswerkles10backend.Controllers;

import com.example.Huiswerkles10backend.dtos.input.CIModuleInputDto;
import com.example.Huiswerkles10backend.dtos.input.TelevisionInputDto;
import com.example.Huiswerkles10backend.dtos.output.CIModuleDto;
import com.example.Huiswerkles10backend.dtos.output.TelevisionDto;
import com.example.Huiswerkles10backend.services.CIModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value="/cimodule")
public class CIModuleController {

    private final CIModuleService ciModuleService;

    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping()
    public ResponseEntity<List<CIModuleDto>> getAllCIModules() {
        List<CIModuleDto> ciModuleOutput = ciModuleService.getAllCIModules();
        return ResponseEntity.ok(ciModuleOutput);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CIModuleDto> getOneCIModuleById(@PathVariable Long id) {
        CIModuleDto ciModuleOutputDto = ciModuleService.getOneCIModuleById(id);
        return ResponseEntity.ok(ciModuleOutputDto);
    }


    @PostMapping()
    public ResponseEntity<CIModuleDto> createCIModule(@RequestBody CIModuleDto dto) {
        CIModuleDto ciModuleDto = ciModuleService.createCIModule(dto);
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + CIModuleDto.getId()).toUriString());
        return ResponseEntity.ok(ciModuleDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCIModule(@PathVariable Long id) {
        ciModuleService.deleteCIModule(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<CIModuleDto> updateCIModule(@PathVariable Long id, @Valid @RequestBody CIModuleDto newCIModule) {
        ciModuleService.updateCIModule(id, newCIModule);
        return ResponseEntity.ok().body(newCIModule);
  }
}
