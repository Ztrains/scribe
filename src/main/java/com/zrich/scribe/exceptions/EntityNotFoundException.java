package com.zrich.scribe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    private final String message;

    public EntityNotFoundException(String message) {
        this.message = message;
    }
}
