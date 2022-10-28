package com.robinfood.survey.controllerT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinfood.survey.model.dto.QuestionDto;
import com.robinfood.survey.model.dto.TransferAnswerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class CreateNewSurveyController {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createANewSurvey() throws Exception {

        List<QuestionDto> questionDtoList = new ArrayList<>();
        QuestionDto questionDto = new QuestionDto();
        questionDto.setTypeQuestion("SINGLE");
        questionDto.setQuestionText("what should we improve?");
        questionDtoList.add(questionDto);

        QuestionDto questionDto1 = new QuestionDto();
        questionDto1.setQuestionText("What score do you give to the service?");
        questionDto1.setTypeQuestion("MULTI");

        List<TransferAnswerDto> transferAnswerDtos = new ArrayList<>();
        TransferAnswerDto transferAnswerDto = new TransferAnswerDto();
        transferAnswerDto.setTextAnswer("Bad");
        transferAnswerDto.setTextAnswer("Regular");
        transferAnswerDto.setTextAnswer("Okay");
        transferAnswerDto.setTextAnswer("Very Good");
        transferAnswerDto.setTextAnswer("Excellent");
        questionDto1.setListAnswer(transferAnswerDtos);

        MvcResult resultGetQuestionnaire = mvc.perform(
                        MockMvcRequestBuilders.post("/survey")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(questionDtoList)))
                .andExpect(status().isCreated())
                .andReturn();
        String resultado = resultGetQuestionnaire.getResponse().getContentAsString();
        Assertions.assertEquals("Added Questions id = 1", resultado);
    }
}

