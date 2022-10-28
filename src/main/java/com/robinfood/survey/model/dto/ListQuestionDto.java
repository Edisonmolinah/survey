package com.robinfood.survey.model.dto;

import com.robinfood.survey.model.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListQuestionDto {
    private List<Question> questions;
}
