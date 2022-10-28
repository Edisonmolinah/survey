package model.dto;

import lombok.Data;

@Data
public class AnswerDto {

    private int numberQuestion;
    private String answerQuestion;

    public AnswerDto() {
    }

    public AnswerDto(int numberQuestion, String answerQuestion) {
        this.numberQuestion = numberQuestion;
        this.answerQuestion = answerQuestion;
    }
}
