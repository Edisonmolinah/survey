package model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue()
    private long id;
    private int idQuestion;
    private String answer;

    public Answer() {
    }

    public Answer(long id, int idQuestion, String answer) {
        this.id = id;
        this.idQuestion = idQuestion;
        this.answer = answer;
    }
}
