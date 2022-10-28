package com.robinfood.survey.controller;

import com.robinfood.survey.model.dto.QuestionDto;
import com.robinfood.survey.service.ISurveyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/survey")
@AllArgsConstructor
public class GetSurveyController {
    private final ISurveyService iSurveyService;
    private final String NOT_FOUND_SURVEY = "Not found Survey";

    @GetMapping("/{id}")
    public ResponseEntity<?> getSurvey(@PathVariable long id){
        List<QuestionDto> questionDtoList = iSurveyService.getSurvey(id);
        if (questionDtoList.size() < 1){
            return new ResponseEntity<>(NOT_FOUND_SURVEY, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionDtoList, HttpStatus.OK);
    }
}
