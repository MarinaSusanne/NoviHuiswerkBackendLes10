package com.example.Huiswerkles10backend.Controllers;

import com.example.Huiswerkles10backend.Exceptions.BadRequestException;
import com.example.Huiswerkles10backend.Exceptions.RecordNotFoundException;
import com.example.Huiswerkles10backend.Exceptions.TelevisionNameTooLongException;
import com.example.Huiswerkles10backend.Exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity <Object> exception (RecordNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    //exception.getMessage() kan ook "dit is een tekst"
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> exceptions (IndexOutOfBoundsException exception){
        return new ResponseEntity<>("dit is staat niet in de database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TelevisionNameTooLongException.class)
    public ResponseEntity<String> exception(TelevisionNameTooLongException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<String> exception(UsernameNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> exception(BadRequestException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
