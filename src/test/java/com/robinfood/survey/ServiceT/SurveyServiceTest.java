package com.robinfood.survey.ServiceT;

import com.robinfood.survey.model.dto.AnswerDto;
import com.robinfood.survey.model.entity.SurveyCompleted;
import com.robinfood.survey.repository.ISurveyCompletedRepository;
import com.robinfood.survey.service.impl.ImplSurveyCompletedService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SurveyServiceTest {

    @Mock
    ISurveyCompletedRepository iSurveyCompletedRepository;
    @InjectMocks
    ImplSurveyCompletedService implSurveyCompletedService;
    @Test
    public void SaveOkAnswersSurvey() {

        List<AnswerDto> answerDtoList = new ArrayList<>();

        AnswerDto answerDto = new AnswerDto();
        answerDto.setNumberQuestion(1);
        answerDto.setAnswerQuestion("edison");
        answerDtoList.add(answerDto);
        AnswerDto answerDto1 = new AnswerDto();
        answerDto1.setNumberQuestion(2);
        answerDto1.setAnswerQuestion("Molina");
        answerDtoList.add(answerDto1);

        SurveyCompleted survey = new SurveyCompleted();
        survey.setId(1);

        when(iSurveyCompletedRepository.save(any())).thenReturn(survey);

        long idSurvey = implSurveyCompletedService.createSurvey(answerDtoList);
        assertEquals(1,idSurvey);

    }
}
