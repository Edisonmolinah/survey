package com.robinfood.survey.service;

import com.robinfood.survey.model.dto.QuestionDto;

import java.util.List;


public interface IQuestionService {
    long createSurvey(List<QuestionDto> ListQuestionDto);
}
