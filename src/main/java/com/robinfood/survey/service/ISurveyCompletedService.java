package com.robinfood.survey.service;

import com.robinfood.survey.model.dto.AnswerDto;

import java.util.List;


public interface ISurveyCompletedService {
    long createSurvey(List<AnswerDto> answerDtoList);
}
