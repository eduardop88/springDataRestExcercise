package com.people.training.restpagandsort.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFound extends RuntimeException {
    public EntityNotFound(Long id) {
        super(String.format("The entity with id:%d does not exists", id));
    }
}
