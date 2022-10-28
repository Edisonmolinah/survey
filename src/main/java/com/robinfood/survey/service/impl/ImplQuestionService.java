package com.robinfood.survey.service.impl;

import com.robinfood.survey.model.dto.QuestionDto;
import com.robinfood.survey.model.entity.Question;
import com.robinfood.survey.model.entity.Survey;
import com.robinfood.survey.model.entity.TransferAnswer;
import com.robinfood.survey.repository.ISurveyRepository;
import com.robinfood.survey.service.IQuestionService;
import com.robinfood.survey.utils.QuestionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ImplQuestionService implements IQuestionService {

    private final ISurveyRepository iSurveyRepository;

    @Override
    public long createSurvey(List<QuestionDto> newListQuestionDto) {

        List<Question> listQuestion = newListQuestionDto.stream().map((questionDto) -> {
            Question question = new Question();
            question.setTypeQuestion(questionDto.getTypeQuestion());
            question.setQuestionText(questionDto.getQuestionText());
            if (questionDto.getTypeQuestion().equals(QuestionType.MULTI.toString())) {
                List<TransferAnswer> transferAnswers = questionDto.getListAnswer().stream()
                        .map((textAnswer) -> TransferAnswer.builder()
                                .texAnswer(textAnswer.getTextAnswer())
                                .build())
                        .collect(Collectors.toList());

                question.setTransferAnswers(transferAnswers);
            }
            return question;

        }).collect(Collectors.toList());
        Survey survey = Survey.builder().questions(listQuestion).build();
        survey = iSurveyRepository.save(survey);
        return survey.getId();
    }
}
