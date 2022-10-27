package model;

import lombok.Data;

@Data
public class Survey {

    private long id;
    private String question;

    public Survey() {
    }

    public Survey(long id, String question) {
        this.id = id;
        this.question = question;
    }

}
