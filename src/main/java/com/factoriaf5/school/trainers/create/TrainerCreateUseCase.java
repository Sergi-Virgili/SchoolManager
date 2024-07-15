package com.factoriaf5.school.trainers.create;

import com.factoriaf5.school.trainers.Trainer;
import com.factoriaf5.school.trainers.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerCreateUseCase {

    private final TrainerRepository trainerRepository;

    public TrainerCreateUseCase(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    public Trainer run(TrainerRequest trainerRequest) {
        if (trainerRepository.existsByName(trainerRequest.name())) {
            throw new TrainerAlreadyExists("Trainer already exists");
        }

        Trainer trainer = Trainer.builder()
                .name(trainerRequest.name())
                .build();

        return trainerRepository.save(trainer);

    }
}
