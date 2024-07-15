package com.factoriaf5.school.trainers.create;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TrainerAlreadyExists extends RuntimeException {
    public TrainerAlreadyExists(String message) {
        super(message);
    }
}
