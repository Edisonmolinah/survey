package com.robinfood.survey.controller;

import com.robinfood.survey.model.dto.AnswerDto;
import com.robinfood.survey.service.ISurveyCompletedService;
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
public class SaveSurveyController {

    private final ISurveyCompletedService iSurveyCompletedService;
    private final String STRING_SAVE_RESPONSE = "Successful process responses with id: ";

    @PostMapping("/save")
    public ResponseEntity<?> saveSurvey(@RequestBody List<AnswerDto> answerDtoList){
        return new ResponseEntity<>(STRING_SAVE_RESPONSE + iSurveyCompletedService.createSurvey(answerDtoList),
                HttpStatus.CREATED);
    }
}
