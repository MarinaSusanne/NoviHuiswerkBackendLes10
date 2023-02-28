package com.example.Huiswerkles10backend.Controllers;

import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
import com.example.Huiswerkles10backend.Exceptions.TelevisionNameTooLongException;
import com.example.Huiswerkles10backend.model.Television;
import com.example.Huiswerkles10backend.repository.TelevisionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/televisions")
public class TelevisionControllerBonus {

    @Autowired
    TelevisionRepository repos;


    @GetMapping()
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(repos.findAll());
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Television> findTvByName(@PathVariable String name) {
        Optional<Television> optionalTv = repos.findByName(name);
        if(optionalTv.isPresent())
            return ResponseEntity.ok(optionalTv.get());
        else return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Television> addOneTelevision(@RequestBody Television t) {
        //bonus bonus max 20 letters
        if (t.name.length() > 20) {
            throw new TelevisionNameTooLongException("Television is too long");
        } else {
            repos.save(t);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + t.getId()).toUriString());
            return ResponseEntity.created(uri).body(t);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        repos.deleteById(id);
        // Return een 204 status
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteTvByName(@PathVariable String name) {
        repos.deleteByNameContaining(name);
        return ResponseEntity.noContent().build();
    }
}


//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateTvList(@PathVariable Long id, @RequestBody String Television) {
//        if (repos.isEmpty() || id > repos. ()){
//            throw new RecordNotFoundException("Record met id " + id + "niet gevonden ");
//        } else{
//            repos.set(id, name2);
//            return ResponseEntity.noContent().build();
//        }
//    }
