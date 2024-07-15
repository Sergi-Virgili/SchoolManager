package com.factoriaf5.school.trainers.create;

import com.factoriaf5.school.trainers.Trainer;
import com.factoriaf5.school.trainers.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainerCreateUseCaseTest {

    @Mock
    private TrainerRepository trainerRepository;

    @Test
    void when_pass_a_trainer_request_then_create_it() {

        Trainer expectedTrainer = Trainer.builder()
                .id(1L)
                .name("trainer name")
                .build();

        TrainerRequest request = new TrainerRequest(expectedTrainer.getName());
        TrainerCreateUseCase useCase = new TrainerCreateUseCase(trainerRepository);

        Mockito.when(trainerRepository.save(any(Trainer.class))).thenReturn(expectedTrainer);

        Trainer trainerResult = useCase.run(request);

        assertEquals(expectedTrainer, trainerResult);
        verify(trainerRepository).existsByName(request.name());
        verify(trainerRepository, times(1)).save(any(Trainer.class));
    }

    @Test
    void when_trainer_exists_by_name_then_throws_error() {

        TrainerRequest request = new TrainerRequest("trainer name");
        TrainerCreateUseCase useCase = new TrainerCreateUseCase(trainerRepository);

        Mockito.when(trainerRepository.existsByName(request.name())).thenReturn(true);

        Exception ex = assertThrows(TrainerAlreadyExists.class, () -> {
            useCase.run(request);
        });

        assertEquals("Trainer already exists", ex.getMessage());

        verify(trainerRepository).existsByName(request.name());
        verify(trainerRepository, never()).save(any(Trainer.class));

    }

}