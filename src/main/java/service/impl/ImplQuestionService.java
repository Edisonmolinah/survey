package service.impl;

import lombok.AllArgsConstructor;
import model.dto.ListQuestionDto;
import model.dto.QuestionDto;
import model.dto.TransferAnswerDto;
import model.entity.Question;
import model.entity.TransferAnswer;
import org.springframework.stereotype.Service;
import repository.IQuestionRepository;
import service.IQuestionService;
import utils.QuestionType;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ImplQuestionService implements IQuestionService {

    private final IQuestionRepository iQuestionRepository;

    @Override
    public ListQuestionDto getLisQuestion(){
        List<Question> questions = iQuestionRepository.findAll();

        return new ListQuestionDto(questions);
    }


    @Override
    public int createSurvey(List<QuestionDto> newListQuestionDto) {
        for (QuestionDto questionDto: newListQuestionDto) {
            Question question = new Question();
            question.setTypeQuestion(questionDto.getTypeQuestion());
            question.setQuestionText(question.getQuestionText());
            if (questionDto.getTypeQuestion().equals(QuestionType.MULTI)){
                List<TransferAnswer>transferAnswers = new ArrayList<>();
                for ( TransferAnswerDto answerDto : questionDto.getListAnswer()) {
                    TransferAnswer transferAnswer = new TransferAnswer();
                    transferAnswer.setTexAnswer(answerDto.getTexAnswer());
                    transferAnswers.add(transferAnswer);
                }
                question.setTransferAnswers(transferAnswers);
            }
            iQuestionRepository.save(question);
        }
        return iQuestionRepository.findAll().size();
    }
}
