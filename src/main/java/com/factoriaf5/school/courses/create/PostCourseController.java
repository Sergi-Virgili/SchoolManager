package com.factoriaf5.school.courses.create;

import com.factoriaf5.school.courses.Course;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class PostCourseController {

    private final CreateCourseUseCase createCourse;

    public PostCourseController(CreateCourseUseCase createCourse) {
        this.createCourse = createCourse;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody @Validated CourseRequest courseRequest) {
        return ResponseEntity.status(201).body(createCourse.run(courseRequest));
    }

}
