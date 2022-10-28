package com.robinfood.survey.service;

import com.robinfood.survey.model.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ISurveyService {
    List<QuestionDto> getSurvey(long id);
}
