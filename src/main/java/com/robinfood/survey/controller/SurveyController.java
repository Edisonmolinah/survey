package com.robinfood.survey.controller;

import com.robinfood.survey.model.dto.QuestionDto;
import com.robinfood.survey.service.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/survey")
@AllArgsConstructor
public class SurveyController {
    public final String ADDED_QUESTIONS = "Added Questions id = ";
    private final IQuestionService iQuestionService;
    @PostMapping
    public ResponseEntity<?> createSurvey(@RequestBody List<QuestionDto> newListQuestionDto){
        long id = iQuestionService.createSurvey(newListQuestionDto);
        return new ResponseEntity<>(ADDED_QUESTIONS + id, HttpStatus.CREATED);
    }
}
