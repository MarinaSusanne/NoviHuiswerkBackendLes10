package Controllers;

import Exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("television")
        public ResponseEntity<String> getAllTelevisions(){
            return  new ResponseEntity <> ("television", HttpStatus.OK);
        }

    @GetMapping("television/{id}")
    public ResponseEntity<String> getTVWidth (@PathVariable int id){
        if (id == 5){
            throw new RecordNotFoundException("Ik snap het bijna!");
        }
        return  new ResponseEntity<> ("television" + id , HttpStatus.OK);
    }

    @PutMapping ("television/{id}")
    public ResponseEntity<String> updateTVList (@PathVariable int id, @RequestBody String name){
        return new ResponseEntity<>("television" + id, HttpStatus.NO_CONTENT);
        //moet het niet name zijn?
    }

    @PostMapping("television")
    public ResponseEntity <String> addTVList (@RequestBody String television){
        return ResponseEntity.created(null).body("television");
    }

    @DeleteMapping ("Televisio/{id}")
    public ResponseEntity<String> deleteById (@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

}

//haha

