package model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private String typeQuestion;
    private String questionText;
    private List<TransferAnswerDto> listAnswer;
}
