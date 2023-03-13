//package com.example.Huiswerkles10backend.Controllers;
//
//import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class TelevisionControllerTestingLes1 {
//
//
//
//    @GetMapping("testing")
//        public ResponseEntity<Object> getAllTelevisions(){
//            return  new ResponseEntity <> ("television", HttpStatus.OK);
//        }
//
//    @GetMapping("testing/{id}")
//    public ResponseEntity<Object> getOneTv (@PathVariable int id){
//        if (id == 5){
//            throw new RecordNotFoundException("id is 5");
//        }
//        return  new ResponseEntity<> ("television with id " + id , HttpStatus.OK);
//
//    }
//
//    @PutMapping ("testing/{id}")
//    public ResponseEntity<Object> updateTVList (@PathVariable int id, @RequestBody String television){
//        return ResponseEntity.noContent().build();
//    }
//
//
//
//    @PostMapping("testing")
//    public ResponseEntity <Object> addTVList (@RequestBody String television){
//        return ResponseEntity.created(null).body("television");
//    }
//
//
//
//    @DeleteMapping ("testing/{id}")
//    public ResponseEntity<Object> deleteById (@PathVariable int id){
//        return ResponseEntity.noContent().build();
//    }
//
//}
//
//
