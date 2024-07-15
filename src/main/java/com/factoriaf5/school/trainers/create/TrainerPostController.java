package com.factoriaf5.school.trainers.create;

import com.factoriaf5.school.trainers.Trainer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainers")
public class TrainerPostController {

        private final TrainerCreateUseCase createTrainer;

        public TrainerPostController(TrainerCreateUseCase createTrainer) {
            this.createTrainer = createTrainer;
        }

        @PostMapping
        public ResponseEntity<Trainer> createTrainer(@RequestBody @Valid TrainerRequest trainerRequest) {
            return ResponseEntity.status(201).body(createTrainer.run(trainerRequest));
        }
}
