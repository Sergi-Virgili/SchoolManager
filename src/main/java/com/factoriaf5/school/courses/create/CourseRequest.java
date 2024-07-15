package com.factoriaf5.school.courses.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(

        @NotBlank(message = "Name must not be blank")
        String name,
        @NotBlank(message = "Description must not be blank")
        String description,
        @NotNull(message = "Trainer ID must not be null")
        Long trainerId) {
}
