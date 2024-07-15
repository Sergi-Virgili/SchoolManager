package com.factoriaf5.school.courses.create;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseTrainerNotFound extends RuntimeException {
    public CourseTrainerNotFound(String message) {
        super(message);
    }
}
