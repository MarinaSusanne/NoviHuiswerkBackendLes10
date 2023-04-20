package com.example.Huiswerkles10backend.Exceptions;

public class TelevisionNameTooLongException extends RuntimeException {
    public TelevisionNameTooLongException(){
        super();
    }

    public TelevisionNameTooLongException (String message){
        super(message);
    }
}
