package com.factoriaf5.school.courses.create;

import com.factoriaf5.school.trainers.Trainer;
import com.factoriaf5.school.trainers.TrainerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PostCourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    TrainerRepository trainerRepository;

    @Test
    void createCourse() throws Exception {

        trainerRepository.save(new Trainer());

        CourseRequest courseRequest = new CourseRequest("name", "the description", 1L);
        String jsonRequest = objectMapper.writeValueAsString(courseRequest);

        mockMvc.perform(post("/api/courses")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.description").value("the description"))
                .andExpect(jsonPath("$.trainer.id").value(1));

    }
}