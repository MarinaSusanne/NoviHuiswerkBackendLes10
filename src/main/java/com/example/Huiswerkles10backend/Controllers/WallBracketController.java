package com.example.Huiswerkles10backend.Controllers;

import com.example.Huiswerkles10backend.dtos.input.WallBracketInputDto;
import com.example.Huiswerkles10backend.dtos.output.WallBracketDto;
import com.example.Huiswerkles10backend.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class WallBracketController {
    
    private final WallBracketService wallBracketService;


    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
        
    }

    @GetMapping()
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        List<WallBracketDto> wallBracketOutput = wallBracketService.getAllWallBrackets();
        return ResponseEntity.ok(wallBracketOutput);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<WallBracketDto> getOneWallBracketById(@PathVariable Long id) {
        WallBracketDto wallBracketOutput = wallBracketService.getOneWallBracketById(id);
        return ResponseEntity.ok(wallBracketOutput);
    }


    @PostMapping()
    public ResponseEntity<WallBracketDto> createWallBracket(@RequestBody WallBracketDto WallBracketDto) {
        WallBracketDto wallBracketDto = wallBracketService.createWallBracket(WallBracketDto);
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + WallBracketDto.getId()).toUriString());
        return ResponseEntity.ok(wallBracketDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketDto newWallBracket) {
        wallBracketService.updateWallBracket(id, newWallBracket);
        return ResponseEntity.ok().body(newWallBracket);
    }
    
    
    
    
}
