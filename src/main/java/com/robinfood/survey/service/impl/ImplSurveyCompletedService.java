package com.robinfood.survey.service.impl;

import com.robinfood.survey.model.dto.AnswerDto;
import com.robinfood.survey.model.entity.Answer;
import com.robinfood.survey.model.entity.SurveyCompleted;
import com.robinfood.survey.repository.ISurveyCompletedRepository;
import com.robinfood.survey.service.ISurveyCompletedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ImplSurveyCompletedService implements ISurveyCompletedService {

    private final ISurveyCompletedRepository iSurveyCompletedRepository;

    @Override
    public long createSurvey(List<AnswerDto> answerDtoList) {
        List<Answer> answerList = answerDtoList.stream().map(answerDto -> Answer.builder()
                .answer(answerDto.getAnswerQuestion())
                .idQuestion(answerDto.getNumberQuestion())
                .build()).collect(Collectors.toList());

        SurveyCompleted surveyCompleted = SurveyCompleted.builder().answerList(answerList).build();
        surveyCompleted = iSurveyCompletedRepository.save(surveyCompleted);
        return surveyCompleted.getId();
    }
}
