package controller;

import lombok.AllArgsConstructor;
import model.dto.QuestionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IQuestionService;

import java.util.List;

@RestController
@RequestMapping("/survey")
@AllArgsConstructor
public class SurveyController {
    public final String ADDED_QUESTIONS = "Added Questions";
    private final IQuestionService iQuestionService;

    @PostMapping
    public ResponseEntity<?> createSurvey(@RequestBody List<QuestionDto> newListQuestionDto){
        int questionCounter = iQuestionService.createSurvey(newListQuestionDto);
        return new ResponseEntity<>(questionCounter + ADDED_QUESTIONS, HttpStatus.CREATED);
    }

}
