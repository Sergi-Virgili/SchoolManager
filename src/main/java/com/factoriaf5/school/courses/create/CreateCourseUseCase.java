package com.factoriaf5.school.courses.create;

import com.factoriaf5.school.courses.Course;
import com.factoriaf5.school.courses.CourseRepository;
import com.factoriaf5.school.trainers.Trainer;
import com.factoriaf5.school.trainers.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;

    public CreateCourseUseCase(CourseRepository courseRepository, TrainerRepository trainerRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    public Course run(CourseRequest courseReq) {
        Trainer trainer = trainerRepository.findById(courseReq.trainerId())
                .orElseThrow(
                        () -> new CourseTrainerNotFound("Trainer with id: " + courseReq.trainerId() + " not found")
                );

        Course course = Course.builder()
                .name(courseReq.name())
                .description(courseReq.description())
                .trainer(trainer)
                .build();

        return courseRepository.save(course);
    }
}
