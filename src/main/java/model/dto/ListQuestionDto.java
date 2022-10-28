package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.entity.Question;

import java.util.List;

@Data
@AllArgsConstructor
public class ListQuestionDto {
    private List<Question> questions;
}
