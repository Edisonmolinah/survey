package com.robinfood.survey.service.impl;

import com.robinfood.survey.model.dto.QuestionDto;
import com.robinfood.survey.model.dto.TransferAnswerDto;
import com.robinfood.survey.model.entity.Survey;
import com.robinfood.survey.repository.ISurveyRepository;
import com.robinfood.survey.service.ISurveyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ImplSurveyService implements ISurveyService {

    private final ISurveyRepository iSurveyRepository;

    @Override
    public List<QuestionDto> getSurvey(long id) {
        Survey survey = iSurveyRepository.findById(id).orElse(null);
        if (survey != null){
            return survey.getQuestions().stream().map((question -> QuestionDto.builder()
                    .questionText(question.getQuestionText())
                    .typeQuestion(question.getTypeQuestion())
                    .listAnswer(question.getTransferAnswers()
                            .stream().map(transferAnswer -> TransferAnswerDto.builder()
                                    .textAnswer(transferAnswer.getTexAnswer())
                                    .build()).collect(Collectors.toList()))
                    .build())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
