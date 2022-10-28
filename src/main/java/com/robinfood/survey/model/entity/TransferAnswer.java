package com.robinfood.survey.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TransferAnswer {

    @Id
    @GeneratedValue()
    private int id;
    private String texAnswer;
}
