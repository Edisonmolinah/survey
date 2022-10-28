package com.robinfood.survey.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@Builder
public class SurveyDto {
    private List<QuestionDto> questionDtoList;
}
