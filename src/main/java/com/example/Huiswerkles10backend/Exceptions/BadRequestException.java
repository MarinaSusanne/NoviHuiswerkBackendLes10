package com.example.Huiswerkles10backend.Exceptions;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {
        super("gewoon een stom request");
    }
}
