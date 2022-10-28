package com.robinfood.survey.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private String typeQuestion;
    private String questionText;
    private List<TransferAnswerDto> listAnswer;
}
