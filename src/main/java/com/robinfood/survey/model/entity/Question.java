package com.robinfood.survey.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue()
    private long id;
    private String typeQuestion;
    private String questionText;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TransferAnswer> transferAnswers;

}
