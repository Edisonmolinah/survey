package com.robinfood.survey.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurveyCompleted {

    @Id
    @GeneratedValue()
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answerList;
}
