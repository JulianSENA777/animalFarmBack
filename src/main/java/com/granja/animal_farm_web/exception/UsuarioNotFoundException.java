package com.granja.animal_farm_web.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}

