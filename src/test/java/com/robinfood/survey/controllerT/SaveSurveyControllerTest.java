package com.robinfood.survey.controllerT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinfood.survey.model.dto.AnswerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class SaveSurveyControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    private final String STRING_SAVE_RESPONSE = "Successful process responses with id: ";

    @Test
    public void SaveSurveyControllerOK() throws Exception {
        List<AnswerDto> answerDtoList = new ArrayList<>();
        AnswerDto answerDto = new AnswerDto();
        answerDto.setNumberQuestion(1);
        answerDto.setAnswerQuestion("test save Survey OK");
        answerDtoList.add(answerDto);

        mvc.perform(
                        MockMvcRequestBuilders.post("/survey/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(answerDtoList)))
                .andExpect(status().isCreated())
                .andReturn();
    }
}
