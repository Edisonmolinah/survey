package model.entity;

import lombok.Data;
import model.entity.Answer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue()
    private long id;
    private String typeQuestion;
    private String questionText;
    private List<TransferAnswer> transferAnswers;

    public Question() {
    }

    public Question(long id, String typeQuestion, String questionText, List<TransferAnswer> transferAnswers) {
        this.id = id;
        this.typeQuestion = typeQuestion;
        this.questionText = questionText;
        this.transferAnswers = transferAnswers;
    }
}
