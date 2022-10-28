package com.robinfood.survey.ServiceT;

import com.robinfood.survey.model.dto.QuestionDto;
import com.robinfood.survey.model.entity.Question;
import com.robinfood.survey.model.entity.Survey;
import com.robinfood.survey.repository.ISurveyRepository;
import com.robinfood.survey.service.impl.ImplSurveyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @Mock
    ISurveyRepository surveyRepository;
    @InjectMocks
    ImplSurveyService surveyService;

    @Test
    public void SaveSurveyOK() {

        List<QuestionDto> questionDtoList = new ArrayList<>();

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionText("Nombre");
        questionDto.setTypeQuestion("SINGLE");
        questionDtoList.add(questionDto);

        QuestionDto questionDto1 = new QuestionDto();
        questionDto1.setQuestionText("Apellido");
        questionDto1.setTypeQuestion("SINGLE");
        questionDtoList.add(questionDto1);

        List<Question> questionList = new ArrayList<>();
        Question question = new Question(1L,"SINGLE","Nombre", new ArrayList<>());
        Question question1 = new Question(2L,"SINGLE","Apellido",new ArrayList<>());
        questionList.add(question);
        questionList.add(question1);

        Survey survey = new Survey(1L,questionList);

        when(surveyRepository.findById(1L)).thenReturn(Optional.of(survey));

        List<QuestionDto> questionsTotal = surveyService.getSurvey(1L);
        assertEquals(2, questionsTotal.size());
    }
}
