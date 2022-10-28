package model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Survey {
    @Id
    @GeneratedValue()
    private long id;
    private String question;

    public Survey() {
    }

    public Survey(long id, String question) {
        this.id = id;
        this.question = question;
    }

}
