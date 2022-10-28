package service;

import model.dto.ListQuestionDto;
import model.dto.QuestionDto;

import java.util.List;

public interface IQuestionService {
    ListQuestionDto getLisQuestion();

    int createSurvey(List<QuestionDto> ListQuestionDto);
}
