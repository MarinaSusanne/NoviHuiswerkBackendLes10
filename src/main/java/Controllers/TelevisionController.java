package Controllers;

import Exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionController {

    @GetMapping("television")
        public ResponseEntity<String> getAllTelevisions(){
            return  new ResponseEntity <> ("television", HttpStatus.OK);
        }

    @GetMapping("television/{id}")
    public ResponseEntity<String> getOneTv (@PathVariable int id){
        if (id == 5){
            throw new RecordNotFoundException("een message");
        }
        return  new ResponseEntity<> ("television" + id , HttpStatus.OK);

    }

    // als het een Array was..wat veel logischer was in deze opdracht:
    // @GetMapping ("television/{id}")
    //   public ResponseEntity <Television> getOneTelevision (@PathVariable int id){
    //   if (id>= 0 && id <= telelevision.size()) {
    //      return new ResponseEntity <> (televisions.get(id), Httpstatus.ok);
    //       }
    //      else {
    //      throw new RecordNotFoundException("ID not available");



    @PutMapping ("television/{id}")
    public ResponseEntity<String> updateTVList (@PathVariable int id, @RequestBody String name){
        return new ResponseEntity<>("television" + id, HttpStatus.NO_CONTENT);
    }



    @PostMapping("television")
    public ResponseEntity <String> addTVList (@RequestBody String television){
        return ResponseEntity.created(null).body("television");
    }



    @DeleteMapping ("Television/{id}")
    public ResponseEntity<String> deleteById (@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

}


