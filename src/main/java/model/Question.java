package model;

import lombok.Data;

@Data
public class Question {

    private long id;
    private String questionText;
    private String type;

    public Question() {
    }

    public Question(long id, String questionText, String type) {
        this.id = id;
        this.questionText = questionText;
        this.type = type;
    }
}
